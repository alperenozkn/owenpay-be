package com.pentavex.owenpay.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import swaggergen.controller.UserApi;
import swaggergen.model.CreateUserRequest;
import swaggergen.model.CreateUserResponse;
import swaggergen.model.GetUserResponse;

import com.pentavex.owenpay.domain.User;
import com.pentavex.owenpay.service.UserService;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody final CreateUserRequest request) {

        User newUser = new User(request.getUsername(), request.getPassword());

        userService.saveOrUpdateUserForm(newUser);

        CreateUserResponse response = new CreateUserResponse();
        response.setMessage(request.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<GetUserResponse> getUsers(){
        GetUserResponse response = new GetUserResponse();
        response.setUsernames("{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
