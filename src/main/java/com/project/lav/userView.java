package com.project.lav;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;


@Route("userView")
public class userView extends AppLayout {
    Button logout = new Button("Logout");

    public userView(){
        //add button listener to logout but figure out what layout to use first ig
        //probably using tabs to status page then back to home, so start w a home tab
        //then add logout button and static
        //UI.getCurrent().getPage.setLocation("login");
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Dashboard");
        title.getStyle().set("font-size", "var(--lumo-font-size-1)").set("margin", "0");

        Tabs tabs = new Tabs(new Tab("Dashboard"), new Tab("Resources"), new Tab("Update Status"), new Tab("Preferences"));

        addToDrawer(tabs);
        addToNavbar(toggle, title);
    }
}
