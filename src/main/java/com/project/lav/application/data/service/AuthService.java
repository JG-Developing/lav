package com.project.lav.application.data.service;

import com.project.lav.application.data.entity.User;
import com.project.lav.application.data.repository.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//import com.vaadin.flow.component.Component;

@Service
@Qualifier("AuthService")
public class AuthService {
    public class AuthServiceException extends Exception {}
    private final UserRepository UserRepository;

    public AuthService(UserRepository UserRepository){
        this.UserRepository = UserRepository;
    }

    public void authenticate(String username, String password) throws AuthServiceException {
        User user = UserRepository.getByUsername(username);
        if(user != null && user.checkPassword(password)){
            UI.getCurrent().navigate("userView");
        }
        //create new user if not found
        else if (user == null) {
            UserRepository.save(new User(username, password, "Guest"));
            UI.getCurrent().navigate("userView");
            Notification.show("New user created");
        }
        else {
            throw new AuthServiceException();
        }
    }
}
