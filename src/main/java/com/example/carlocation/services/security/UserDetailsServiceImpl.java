//package com.example.carlocation.services.security;
//
//import com.example.carlocation.models.entities.security.SecurityUser;
//import com.example.carlocation.repositories.UserRepository;
//import com.example.carlocation.services.CrudServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserDetailsServiceImpl extends CrudServiceImpl<UserRepository, SecurityUser, Long> implements UserSevice {
//
//    private final PasswordEncoder passwordEncoder;
//    public UserDetailsServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
//        super(repository);
//        this.passwordEncoder = passwordEncoder;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UserDetails> opt = this.repository.findByUsername(username);
//        return opt.orElseThrow(() -> new UsernameNotFoundException("User with username(" + username + ") doesn't exist"));
//    }
//
//    @Override
//    public SecurityUser addUser(SecurityUser user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return this.repository.save(user);
//    }
//}
