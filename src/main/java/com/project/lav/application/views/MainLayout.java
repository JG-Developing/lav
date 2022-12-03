package com.project.lav.application.views;

import com.project.lav.application.data.components.MenuPanel;
import com.vaadin.flow.component.applayout.*;
import com.vaadin.flow.component.html.*;
//import com.vaadin.flow.component.button.Button;

public class MainLayout extends AppLayout {
    //private Button logout = new Button("Logout");
    private MenuPanel menu = new MenuPanel();

    public MainLayout(){
        getStyle().set("overflow", "hidden");
        menu.removeClassName("panel");
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Dashboard");
        title.getStyle().set("font-size", "var(--lumo-font-size-1)").set("margin", "0");

        addToDrawer(menu);
        addToNavbar(toggle, title);
    }
}
