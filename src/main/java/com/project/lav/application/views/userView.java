package com.project.lav.application.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.*;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.tabs.*;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.*;
import com.vaadin.flow.theme.lumo.Lumo;
//import com.vaadin.flow.component.checkbox.Checkbox;
//import com.vaadin.flow.theme.Theme;
//import com.project.lav.application.data.components.MenuPanel;


@Route(value = "userView")
@PageTitle("Home | User")
public class userView extends AppLayout {
    Button logout = new Button("Logout");

    public userView(){
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Dashboard");
        title.getStyle().set("font-size", "var(--lumo-font-size-1)").set("margin", "0");

        Tab tasks = new Tab("Tasks");
        Tab dashboard = new Tab("Dashboard");
        Tab resources = new Tab("Resources");
        Tab status = new Tab("Update Status");
        Tab preferences = new Tab("Preferences");

        Tabs tabs = new Tabs(tasks, dashboard, resources, status, preferences);

        Div preferencesContent = new Div();

        CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
        checkboxGroup.setLabel("To Do");
        checkboxGroup.setItems("Login as user", "Login as admin", "Login as another user", "Access database");
        checkboxGroup.select("Login as user");
        checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        tasks.add(checkboxGroup);

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
