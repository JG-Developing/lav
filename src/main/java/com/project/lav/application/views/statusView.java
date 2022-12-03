package com.project.lav.application.views;

import com.project.lav.application.data.components.ResourcePanel;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;


@Route (value = "status", layout=MainLayout.class)
@PageTitle("LAV | Status Update")
public class statusView extends VerticalLayout {
    private ResourcePanel resource = new ResourcePanel();
    public statusView(){
        getStyle().set("display", "flex").set("justify-content", "center");
        TextField statusText = new TextField();
        Button post = new Button("Post");
        add(new Label("Update Status"));
        add(statusText);
        add(post, resource);


        post.addClickListener(buttonClickEvent -> {
            UI.getCurrent().getPage().executeJs(statusText.getValue());
        });

    }

}