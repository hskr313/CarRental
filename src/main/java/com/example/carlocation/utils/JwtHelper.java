package com.example.carlocation.utils;

import com.example.carlocation.config.JwtConfig;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtHelper {

    private final JwtConfig config;

    private final JwtParser parser;

    private final JwtBuilder builder;

    public JwtHelper(JwtConfig config) {
        this.config = config;
        this.parser = Jwts.parserBuilder().setSigningKey(config.getKey()).build();
        this.builder = Jwts.builder().signWith(config.getKey());
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public boolean isExpire(String token) {
        Date expirationDate = getExpirationDateFromToken(token);

        return expirationDate.before(new Date());
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
        final Claims claims = getClaimsFormToken(token);

        return claimResolver.apply(claims);
    }

    private Claims getClaimsFormToken(String token) {
        Jws<Claims> jws = parser.parseClaimsJws(token);
        return jws.getBody();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String tokenUsername = getUsernameFromToken(token);

        return tokenUsername.equals(userDetails.getUsername()) && !isExpire(token);
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return generateToken(claims, userDetails.getUsername());
    }

    private String generateToken(Map<String, Object> claims, String subject) {
        SecretKey key = config.getKey();

        return builder
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + config.getExpiration() * 1000L))
                .compact();
    }
}
