package com.project.lav.application.views.tests;

import com.project.lav.application.views.statusView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import java.util.HashMap;
import java.util.Map;


@Route("userViewTest")
public class UserViewTest extends AppLayout {
    Button logout = new Button("Logout");

    public UserViewTest(){
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Dashboard");
        title.getStyle().set("font-size", "var(--lumo-font-size-1)").set("margin", "0");

        Tab tasks = new Tab("Tasks");
        Tab dashboard = new Tab("Dashboard");
        Tab resources = new Tab("Resources");
        Tab status = new Tab("Update Status");
        Tab preferences = new Tab("Preferences");

        Map<Tab, Class> tabsMap = new HashMap<>();
        tabsMap.put(status, statusView.class);
        //tabsMap.put(resources, resourcesView.class);
        tabsMap.put(preferences, preferencesView.class);


        Tabs tabs = new Tabs(tasks, dashboard, resources, status, preferences);

        tabs.addSelectedChangeListener(event -> {
            UI.getCurrent().navigate(tabsMap.get(event.getSelectedTab()));
        });

        CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
        checkboxGroup.setLabel("To Do");
        checkboxGroup.setItems("Login as user", "Login as admin", "Login as another user", "Access database");
        checkboxGroup.select("Login as user");
        checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        tasks.add(checkboxGroup);

        tabs.setOrientation(Tabs.Orientation.VERTICAL);

        Button logout = new Button("Logout");
        logout.addClickListener(onClick -> {
            UI.getCurrent().navigate("login");
        });

        addToDrawer(logout);
        addToDrawer(tabs);
        addToNavbar(toggle, title);
        setPrimarySection(Section.DRAWER);
    }
}

