package com.project.lav.application.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
//import com.vaadin.flow.component.checkbox.*


@Route(value = "adminView")
@PageTitle("Home | Admin")
public class adminView extends AppLayout {
    Button logout = new Button("Logout");

    public adminView(){
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Dashboard");
        title.getStyle().set("font-size", "var(--lumo-font-size-1)").set("margin", "0");

        Tab dashboard = new Tab("Dashboard");
        Tab resources = new Tab("Resources");
        Tab status = new Tab("Update Status");
        Tab preferences = new Tab("Preferences");
        Tab database = new Tab("Database");

        Tabs tabs = new Tabs(dashboard, resources, status, preferences, database);

        Div preferencesContent = new Div();

        Button darkThemeToggle = new Button("Toggle dark theme", click -> {
            ThemeList themeList = UI.getCurrent().getElement().getThemeList();

            if (themeList.contains(Lumo.DARK)) {
                themeList.remove(Lumo.DARK);
            } else {
                themeList.add(Lumo.DARK);
            }
        });

        preferencesContent.add(new VerticalLayout());

        tabs.setOrientation(Tabs.Orientation.VERTICAL);

        addToDrawer(tabs);
        addToNavbar(toggle, title);
    }
}
