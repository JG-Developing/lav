package com.project.lav.application.data.service;

import com.project.lav.application.data.entity.user;
import com.project.lav.application.data.repository.userRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//import com.vaadin.flow.component.Component;

@Service
@Qualifier("AuthService")
public class AuthService {
    public class AuthServiceException extends Exception {}
    private final userRepository userRepository;

    public AuthService(userRepository userRepository){
        this.userRepository = userRepository;
    }

    public void authenticate(String username, String password) throws AuthServiceException {
        user user = userRepository.getByUsername(username);
        if(user != null && user.checkPassword(password)){
            UI.getCurrent().navigate("userView");
        }
        //create new user if not found
        else if (user == null) {
            userRepository.save(new user(username, password));
            UI.getCurrent().navigate("userView");
            Notification.show("New user created");
        }
        else {
            throw new AuthServiceException();
        }
    }
}
