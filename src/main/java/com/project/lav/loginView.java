package com.project.lav;

import com.project.lav.AuthService.AuthServiceException;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;

//for styling
//@CSSImport(".styles/views/login/login-view.css");
@Route("login")
public class loginView extends Composite<LoginOverlay> {
    public loginView(AuthService authService){
        LoginOverlay layout = getContent();
        layout.setOpened(true);
        layout.setForgotPasswordButtonVisible(false);
        layout.setTitle("LAV");
        layout.setDescription("A new way of learning vulnerabilities");

        layout.addLoginListener(event -> {
            //show different view for admin login
            try {
                authService.authenticate(event.getUsername(), event.getPassword());
                if ("admin".equals(event.getUsername())){
                    UI.getCurrent().navigate("adminView");
                }
                else if("guest".equals(event.getUsername()) && "".equals(event.getPassword())){
                    //UI.getCurrent().navigate("guestView");
                }
                else {
                    UI.getCurrent().navigate("userView");
                }
            }
            catch (AuthServiceException e){
            }

        });
    }

}
