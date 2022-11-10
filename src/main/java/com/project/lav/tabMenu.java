package com.project.lav;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class tabMenu extends Div {
    public tabMenu() {
        Tab status = new Tab("Status");
        Tab profile = new Tab("Profile");
        Tabs tabs = new Tabs(status, profile);
        add(tabs);
    }
}
