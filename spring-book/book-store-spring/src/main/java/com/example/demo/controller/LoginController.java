package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.user.AppUser;
import com.example.demo.security.jwt.JwtProvider;
import com.example.demo.security.user_principle.UserPrinciple;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    ICustomerService customerService;

    @PostMapping(value = "public/login")
    public ResponseEntity<?> login(@RequestBody AppUser appUser){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setMessage("Đăng nhập thành công");
        jwtResponse.setRoles(userPrinciple.getAuthorities());
        jwtResponse.setToken(token);
        Optional<Customer> customer = customerService.findCustomerByUserName(appUser.getUsername());
        jwtResponse.setCustomer(customer.get());
        jwtResponse.setErrorStatus(false);
        return ResponseEntity.ok(jwtResponse);
    }
}
