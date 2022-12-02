package com.project.lav.application.views;

import com.project.lav.application.data.service.AuthService;
import com.project.lav.application.data.service.AuthService.AuthServiceException;
import com.project.lav.application.data.components.ResourcePanel;
import com.project.lav.application.views.MainLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.*;
import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.component.Composite;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.login.LoginOverlay;

@Route(value="", layout = MainLayout.class)
@PageTitle("Testing")
public class LoginView extends Div {

    private LoginForm loginForm = new LoginForm();
    private ResourcePanel resource = new ResourcePanel();

    public LoginView(AuthService authService) {
        getStyle().set("display", "flex").set("justify-content", "center")
        .set("padding", "var(--lumo-space-l)").set("overflow", "hidden");

        //setSizeFull();

        add(loginForm, resource);

        loginForm.addLoginListener(event -> {
            try {
                authService.authenticate(event.getUsername(), event.getPassword());
                if ("admin".equals(event.getUsername())){
                    UI.getCurrent().navigate("adminView");
                }
                else if("guest".equals(event.getUsername()) && "".equals(event.getPassword())){
                    //UI.getCurrent().navigate("guestView");
                }
                else {
                    UI.getCurrent().navigate("status");
                }
            }
            catch (AuthServiceException e){
            }
        });
    }
}
