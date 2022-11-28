package com.project.lav.application.views;

import com.project.lav.application.data.components.MenuPanel;
import com.project.lav.application.data.components.ResourcePanel;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
//import com.vaadin.flow.component.checkbox.*

@Route(value = "adminView")
@PageTitle("Home | Admin")
public class adminView extends AppLayout {
    private Button logout = new Button("Logout");
    private Div resourcePanel = new ResourcePanel();
    private MenuPanel menu = new MenuPanel();

    public adminView(){
        getStyle().set("overflow-x", "hidden");
        menu.removeClassName("panel");
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Dashboard");
        title.getStyle().set("font-size", "var(--lumo-font-size-1)").set("margin", "0");

        // Tab dashboard = new Tab("Dashboard");
        // Tab resources = new Tab("Resources");
        // Tab status = new Tab("Update Status");
        // Tab preferences = new Tab("Preferences");
        // Tab database = new Tab("Database");

        // Tabs tabs = new Tabs(dashboard, resources, status, preferences, database);

        // Div preferencesContent = new Div();

        /* Dark Option Button moved to MenuPanel.java component */

        // preferencesContent.add(new VerticalLayout());

        // tabs.setOrientation(Tabs.Orientation.VERTICAL);

        // addToDrawer(tabs);
        addToDrawer(menu);
        addToNavbar(toggle, title);
    }
}
