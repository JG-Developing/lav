package com.project.lav.application.views;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.*;
import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.component.Composite;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.login.LoginOverlay;

@Route(value="testing", layout = MainPage.class)
@PageTitle("Testing")
public class ContentTest extends Div {

    private LoginForm loginForm = new LoginForm();

    public ContentTest() {
        getStyle().set("display", "flex").set("justify-content", "center")
        .set("padding", "var(--lumo-space-l)");

        setSizeFull();

        loginForm.setAction("login");

        add(loginForm);
    }
}
