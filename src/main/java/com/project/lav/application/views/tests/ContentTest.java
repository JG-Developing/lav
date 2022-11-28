package com.project.lav.application.views.tests;

import com.project.lav.application.data.components.ResourcePanel;
import com.project.lav.application.views.MainLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.*;
import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.component.Composite;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.login.LoginOverlay;

@Route(value="testing", layout = MainLayout.class)
@PageTitle("Testing")
public class ContentTest extends Div {

    private LoginForm loginForm = new LoginForm();
    private ResourcePanel resource = new ResourcePanel();

    public ContentTest() {
        getStyle().set("display", "flex").set("justify-content", "center")
        .set("padding", "var(--lumo-space-l)").set("overflow", "hidden");

        //setSizeFull();

        loginForm.setAction("login");

        add(loginForm, resource);
    }
}
