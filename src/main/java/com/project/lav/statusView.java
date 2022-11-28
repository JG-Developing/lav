package com.project.lav;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;


@Route ("status")
public class statusView extends VerticalLayout {
    public statusView(){
        TextField statusText = new TextField();
        Button post = new Button("Post");
        add(new Label("Update Status"));
        add(statusText);
        add(post);


        post.addClickListener(buttonClickEvent -> {
            UI.getCurrent().getPage().executeJs(statusText.getValue());
        });

    }

}