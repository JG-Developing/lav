package com.project.lav.application.views;

import com.project.lav.application.data.components.ResourcePanel;
import com.vaadin.flow.router.*;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.component.html.*;


@Route(value = "adminViewTest", layout = adminView.class)
@PageTitle("Test For View")
public class PanelTest extends Div {
    private ResourcePanel resources = new ResourcePanel();

    public PanelTest() {
        add(resources);
    }
}
