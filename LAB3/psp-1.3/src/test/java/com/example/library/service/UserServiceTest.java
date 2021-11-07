package com.example.library.service;

import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserService userService;

    @Test
    void addUser() {
        var User = new User();
        when(userRepositoryMock.save(Mockito.any(User.class))).thenReturn(User);
        var user = new User(1,"Name", "LastName", "+37060806977", "email@gmail.com", "Adress", "Password123123!");
        userService.addUser(user);
        verify(userRepositoryMock).save(Mockito.any(User.class));
    }

    @Test
    void getAllUsers() {
        var user1 = new User(1, "Name1", "LastName1", "+37060806977", "email@gmail.com", "Address1", "Password123@");
        var user2 = new User(2, "Name2", "LastName2", "+37060806978", "email2@gmail.com", "Address2", "Password123@");
        var userList = List.of(user1, user2);
        when(userRepositoryMock.findAll()).thenReturn(userList);
        var users = userService.getAllUsers();
        assertEquals(2, users.size());
        assertEquals("Name1", users.get(0).getName());
        assertEquals("NameName", users.get(1).getName());
    }

    @Test
    void updateUser(){
        var newUser = new User(1, "Vardenis", "Pavardenis", "+37060806987", "vardenis@gmail.com", "Adress", "Asdfgasd1234123@");
        when(userRepositoryMock.findById(1L)).thenReturn(java.util.Optional.of(newUser));
        when(userRepositoryMock.save(Mockito.any(User.class))).thenReturn(newUser);
        var user = new User(2, "Vardenis2", "Pavardenis", "+37060806986", "vardenis2@gmail.com", "Adress2", "Aasdsadasd123@");
        userService.updateUser(user);
        verify(userRepositoryMock).save(Mockito.any(User.class));
        assertEquals(1, newUser.getId());
        assertEquals(user.getName(), newUser.getName());
        assertEquals(user.getLastName(), newUser.getLastName());
        assertEquals(user.getPhoneNumber(), newUser.getPhoneNumber());
        assertEquals(user.getEmail(), newUser.getEmail());
        assertEquals(user.getAddress(), newUser.getAddress());
        assertEquals(user.getPassword(), newUser.getPassword());
    }

    @Test
    void getUserById() {
        var user = new User(1, "Name1", "LastName1", "+37060806977", "email@gmail.com", "Adress", "Password123123!");
        when(userRepositoryMock.findById(1L)).thenReturn(java.util.Optional.of(user));
        assertNotNull(userService.getUserById(1));
        assertNull(userService.getUserById(2));
    }

    @Test
    void deleteById() {
        userService.deleteById(1L);
        verify(userRepositoryMock).deleteById(Mockito.anyLong());
    }
}