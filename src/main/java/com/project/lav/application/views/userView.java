package com.project.lav.application.views;

import com.project.lav.application.data.components.ResourcePanel;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.Route;


@Route(value = "userView", layout = MainLayout.class)
public class userView extends Div {
    private ResourcePanel resources = new ResourcePanel();
    public userView() {
        add(resources);
    }
}
