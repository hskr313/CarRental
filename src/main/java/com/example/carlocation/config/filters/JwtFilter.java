//package com.example.carlocation.config.filters;
//
//import com.example.carlocation.utils.JwtHelper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final JwtHelper jwtHelper;
//    private final UserDetailsService detailsService;
//
//    @Autowired
//    public JwtFilter(
//            JwtHelper jwtHelper,
//            UserDetailsService detailsService
//    ) {
//        this.jwtHelper = jwtHelper;
//        this.detailsService = detailsService;
//    }
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain
//    ) throws ServletException, IOException {
//        String requestTokenHeader = request.getHeader("Authorization");
//
//        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//            String token = requestTokenHeader.substring(7);
//            if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                String username = jwtHelper.getUsernameFromToken(token);
//                UserDetails userDetails = detailsService.loadUserByUsername(username);
//                if (jwtHelper.validateToken(token, userDetails)) {
//                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                    SecurityContextHolder.getContext().setAuthentication(auth);
//                }
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//}
