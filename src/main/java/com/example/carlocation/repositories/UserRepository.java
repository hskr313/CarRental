//package com.example.carlocation.repositories;
//
//import com.example.carlocation.models.entities.security.SecurityUser;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends JpaRepository<SecurityUser, Integer> {
//
//    @Query(value = "SELECT u FROM SecurityUser u WHERE u.username = :username")
//    Optional<UserDetails> findByUsername(@Param("username") String username);
//}
