package com.project.lav.application.data.components;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.button.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.accordion.*;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.component.checkbox.*;
import com.vaadin.flow.component.ClickEvent;
//import com.vaadin.flow.component.orderedlayout.FlexComponent.*;
import com.vaadin.flow.component.UI;

public class MenuPanel extends Div {
    private Icon openMenu = new Icon(VaadinIcon.ANGLE_RIGHT);
    private Icon closeMenu = new Icon(VaadinIcon.ANGLE_LEFT);
    private Button darkThemeToggle;
    VerticalLayout menuList;
    VerticalLayout checkList;
    VerticalLayout preferenceList;
    VerticalLayout loginList;
    VerticalLayout homeList;
    VerticalLayout databaseList;
    private Hr divider;
    private Accordion taskList;
    private Button resizeBtn;
    private H2 menuTitle;
    private H2 listTitle;
    private H2 preferenceTitle;

    public MenuPanel() {
        menuList = new VerticalLayout();
        menuList.setPadding(false);
        menuList.setSpacing(true);
        menuList.setSizeFull();
        menuList.getStyle().set("padding-left", "10px").set("overflow", "hidden");

        addClassNames("menu", "panel");

        //addMenuTitle();
        addCheckList();
        addPreferences();

        add(menuList);
    }

    private void addMenuTitle() {
        resizeBtn = new Button("", this::resizePanel);
        resizeBtn.setIcon(closeMenu);
        resizeBtn.setClassName("menubtn");
        resizeBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY, 
                                   ButtonVariant.LUMO_SMALL);
        menuTitle = new H2("Menu");
        menuTitle.addClassName("menu-title");

        // HorizontalLayout title = new HorizontalLayout(menuTitle, resizeBtn);
        // title.setAlignItems(Alignment.CENTER);
        // title.setPadding(true);
        // title.setSpacing(true);
        // title.getStyle().set("height", "fit-content").set("width", "100%");

        divider = new Hr();
        divider.setWidthFull();
        divider.getStyle().set("margin", "1px");
        
        add(menuTitle, resizeBtn, divider);
    }

    private void addCheckList() {
        checkList = new VerticalLayout();
        taskList = new Accordion();
        // taskList.getStyle().set("transition", "ease 0.5s");
        taskList.setWidthFull();
        listTitle = new H2("Tasks");
        listTitle.setClassName("menu-title");

        Checkbox loginTask1 = new Checkbox("Sign In As Guest");
        Checkbox loginTask2 = new Checkbox("Sign In As Employee");
        Checkbox loginTask3 = new Checkbox("Sign In As Admin");
        loginList = new VerticalLayout(loginTask1, loginTask2, loginTask3);
        loginList.setSpacing(false);
        loginList.setPadding(false);
        taskList.add("Login Screen", loginList);
        // AccordionPanel loginPanel = taskList.add("Login Screen", loginList);
        // loginPanel.addThemeVariants(DetailsVariant.FILLED);
        // loginPanel.setWidthFull();

        Checkbox homeTask1 = new Checkbox("This Is Task 1");
        Checkbox homeTask2 = new Checkbox("This Is Task 2");
        Checkbox homeTask3 = new Checkbox("This Is Task 3");
        homeList = new VerticalLayout(homeTask1, homeTask2, homeTask3);
        homeList.setSpacing(false);
        homeList.setPadding(false);
        taskList.add("Home Screen", homeList);
        // AccordionPanel homePanel = taskList.add("Home Screen", homeList);
        // homePanel.addThemeVariants(DetailsVariant.FILLED);
        // homePanel.setWidthFull();

        Checkbox databaseTask1 = new Checkbox("This is Task 1");
        Checkbox databaseTask2 = new Checkbox("This is Task 2");
        Checkbox databaseTask3 = new Checkbox("This is Task 3");
        databaseList = new VerticalLayout(databaseTask1, databaseTask2, databaseTask3);
        databaseList.setSpacing(false);
        databaseList.setPadding(false);
        taskList.add("Database", databaseList);
        // AccordionPanel databasePanel = taskList.add("Database", databaseList);
        // databasePanel.addThemeVariants(DetailsVariant.FILLED);
        // databasePanel.setWidthFull();

        divider = new Hr();
        divider.setWidthFull();
        divider.getStyle().set("margin", "1px");

        checkList.add(listTitle, taskList);
        checkList.setPadding(false);
        checkList.setWidthFull();
        menuList.add(checkList, divider);
    }

    private void addPreferences() {
        preferenceList = new VerticalLayout();
        preferenceTitle = new H2("Preferences");
        preferenceTitle.setClassName("menu-title");

        darkThemeToggle = new Button("Toggle dark theme", click -> {
            ThemeList themeList = UI.getCurrent().getElement().getThemeList();

            if (themeList.contains(Lumo.DARK)) {
                themeList.remove(Lumo.DARK);
            } else {
                themeList.add(Lumo.DARK);
            }
        });

        preferenceList.add(preferenceTitle, darkThemeToggle);

        divider = new Hr();
        divider.setWidthFull();
        divider.getStyle().set("margin", "1px");

        menuList.add(preferenceList, divider);
    }

    private void resizePanel(ClickEvent<Button> event) {
        if (event.getSource().getIcon().equals(closeMenu)) {
            getStyle().set("width", "40px");
            menuList.getStyle().set("display", "none");
            event.getSource().setIcon(openMenu);
            menuTitle.removeClassName("menu-title");
            menuTitle.setClassName("menuTitle-close");
        }
        else {
            getStyle().set("width", "15vw");
            menuList.getStyle().set("display", "block");
            event.getSource().setIcon(closeMenu);
            menuTitle.removeClassName("menuTitle-close");
            menuTitle.setClassName("menu-title");
        }
    }
}
