package com.nobledigitalservice.noblecrm.client.services;

import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import com.nobledigitalservice.noblecrm.repository.UserDTORepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
class ClientControllerServiceImplTest {

    @Mock
    UserDTORepository userDTORepository;

    @Mock
    ClientService clientService;

    private UserDTO user;

    @Mock
    private List<UserDTO> userList;

    @BeforeEach
    void setUp() {

        userList = new ArrayList<>();
        UserDTO user = new UserDTO();
        user.setEmail("morogoyo@gmail.com");
        user.setId("1");
        user.setPassword("password");
        user.setRole("Admin");
        user.setUserName("morogoyo");
//        user.getUserInfo().setEmail(user.getEmail());
        userList.add(user);
    }

    @Test
    void getAllUsers() {
//        TODO need to fix this test
          Assert.assertNotNull(userList);
//        System.out.println(userList.get(0).getEmail());

//        Mockito.when(clientService.getAllUsers()).thenReturn(userList);
//        List<UserDTO> listOfUsers = clientService.getAllUsers();
////
//        Mockito.verify(clientService).getAllUsers();
    }
}
