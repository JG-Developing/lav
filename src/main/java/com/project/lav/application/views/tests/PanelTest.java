package com.project.lav.application.views.tests;

import com.project.lav.application.data.components.ResourcePanel;
import com.project.lav.application.views.MainLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.component.html.*;


@Route(value = "adminViewTest", layout = MainLayout.class)
@PageTitle("Test For View")
public class PanelTest extends Div implements RouterLayout {
    private ResourcePanel resources = new ResourcePanel();

    public PanelTest() {
        add(resources);
    }
}
