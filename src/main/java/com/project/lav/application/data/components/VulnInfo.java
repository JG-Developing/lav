package com.project.lav.application.data.components;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.*;

public class VulnInfo extends Div {

    private H3 topic = new H3();
    private Paragraph desc = new Paragraph();

    public VulnInfo() {
        createVulnContent();
    }
    
    public void setNewVuln(String vulnerability) {
        createVulnContent(vulnerability);
    }

    private void setTopic(String topic) {
        this.topic.setText(topic);
    }

    private void setDescription(String desc) {
        this.desc.setText(desc);
    }

    public String getTopic() {
        return this.topic.getText();
    }

    public String getDescription() {
        return this.desc.getText();
    }

    private void createVulnContent() {
        setTopic("Vulnerabilty Title");
        setDescription("This is just sample description for a soon to be implemented vulnerability (NOT YET IMPLEMENTED)");
        VerticalLayout vulnContent = new VerticalLayout(topic, desc);
        add(vulnContent);
    }

    private void createVulnContent(String vulnerability) {
        setTopic(vulnerability);
        setDescription("This is the description or explanation for the " + 
                        getTopic() + " vulnerability.");
        VerticalLayout vulnContent = new VerticalLayout(topic, desc);
        add(vulnContent);
    }
    
}
