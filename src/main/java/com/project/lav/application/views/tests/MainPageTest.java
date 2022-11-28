package com.project.lav.application.views.tests;

import com.project.lav.application.data.components.ResourcePanel;
import com.project.lav.application.data.components.MenuPanel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.Component;

@Tag("main-page")
@JsModule("./src/main-page.ts")
public class MainPageTest extends LitTemplate implements RouterLayout {
    @Id("heading")
    private Div heading;
    @Id("sideMenu")
    private MenuPanel sideMenu;
    @Id("resourcePanel")
    private ResourcePanel resourcePanel;

    public MainPageTest() {
        createHeader();
        createSideMenu();
        createResourcePanel();
    }

    private void createHeader() {
        H1 logo = new H1("This is a test");
        logo.addClassNames("logo-test");

        setHeader(logo);
    }

    private void createSideMenu() {
        sideMenu = new MenuPanel();
    }

    private void createResourcePanel() {
        resourcePanel = new ResourcePanel();
    }

    private void setHeader(Component... content) {
        this.heading.removeAll();
        this.heading.add(content);
    }

    public void setSideMenu(Component... content) {
        this.sideMenu.removeAll();
        this.sideMenu.add(content);
    }

    public void setResourcePanel(Component... content) {
        this.resourcePanel.removeAll();
        this.resourcePanel.add(content);
    }
}
