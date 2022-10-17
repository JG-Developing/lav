package com.project.lav;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

import javax.swing.*;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.constraints.Email;
import java.awt.*;
import java.util.Collection;

@Route("")
public class loginView extends VerticalLayout {

    private userRepository repository;
    private TextField username = new TextField("username");
    private TextField password = new TextField("password");
    private EmailField email = new EmailField("email");

    private Binder<user> binder = new Binder<>(user.class);

    public loginView(userRepository repository){
        this.repository = repository;
        add(getForm());
    }

    private Component getForm(){
        var layout = new HorizontalLayout();
        layout.setAlignItems(Alignment.BASELINE);
        //Menu menu = new Menu();
        //MenuBar mb = new MenuBar();

        var loginButton = new Button("Login");
        loginButton.addClickShortcut(Key.ENTER);
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(username, password, email, loginButton);


        binder.bindInstanceFields(this);

        loginButton.addClickListener(click -> {
                try {
                    var user = new user();
                    binder.writeBean(user);
                    repository.save(user);
                    binder.readBean(new user());
                } catch (ValidationException e){
                    //
                }
        });

        return layout;
    }

}
