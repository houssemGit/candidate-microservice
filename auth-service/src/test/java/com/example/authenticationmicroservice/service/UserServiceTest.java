package com.example.authenticationmicroservice.service;



import com.example.authenticationmicroservice.Entity.User;
import com.example.authenticationmicroservice.Repository.UserRepository;
import com.example.authenticationmicroservice.Service.Impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {

    @Mock
    private UserRepository   userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;


    private UserServiceImpl userService;



    private User user;

    @BeforeEach
    public void setup(){
        user = User.builder()
                .id(123L)
                .username("test")
                .password("test")
                .email("test@gmail.com")
                .build();

        userService = new UserServiceImpl(userRepository , null ,null);


    }

    // JUnit test for save user method
    @DisplayName("JUnit test for save user method")
    @Test
    public void givenUserObject_whenSaveUser_thenReturnUserObject(){
         when(userRepository.save(user)).thenReturn(user);

        // Run the test
        final User result = userService.saveUser(user);

        // Verify the results
        assertThat(result).isEqualTo(user);
    }



    @DisplayName("JUnit test for getAllEmployees method (negative scenario)")
    @Test
    public void givenEmptyEmployeesList_whenGetAllEmployees_thenReturnEmptyEmployeesList(){
        // Setup

        final List<User> expectedResult = new ArrayList<>()  ;
        expectedResult.add(user);

        // Configure CandidatureRepository.findAll(...).
         when(userRepository.findAll()).thenReturn(expectedResult);

        // Run the test
        final List<User> result = userService.getUsers();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDeleteUser() {
        // Setup
        // Run the test
        userService.delete(123L);

        // Verify the results
        verify(userRepository).deleteById(123L);
    }

}
