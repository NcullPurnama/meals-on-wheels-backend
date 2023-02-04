package com.project.MerryMeal.controller;

import com.project.MerryMeal.dto.UserDto;
import com.project.MerryMeal.entity.User;
import com.project.MerryMeal.exception.ResourceNotFoundException;
import com.project.MerryMeal.repository.UserRepository;
import com.project.MerryMeal.security.CurrentUser;
import com.project.MerryMeal.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    public UserDto getLoginUser(Authentication authentication) {
      User user = userRepository.findByEmail(authentication.getName()).get();

      if (user == null) {
        throw new ResourceNotFoundException("User", "Email", authentication.getName());
      }
      return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getAddress(), user.getPhone(), user.getRole());// add more
    }
}