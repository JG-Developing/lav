package com.project.lav.application.views;

import com.project.lav.application.data.components.MenuPanel;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
//import com.vaadin.flow.component.button.Button;

@Route(value = "adminView")
@PageTitle("Home | Admin")
public class adminView extends AppLayout {
    //private Button logout = new Button("Logout");
    private MenuPanel menu = new MenuPanel();

    public adminView(){
        getStyle().set("overflow-x", "hidden");
        menu.removeClassName("panel");
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Dashboard");
        title.getStyle().set("font-size", "var(--lumo-font-size-1)").set("margin", "0");

        addToDrawer(menu);
        addToNavbar(toggle, title);
    }
}
