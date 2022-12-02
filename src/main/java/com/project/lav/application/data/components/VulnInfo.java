package com.project.lav.application.data.components;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.*;

public class VulnInfo extends Div {

    private H3 topic = new H3();
    private Paragraph desc = new Paragraph();
    private Anchor externalLink1;
    private Anchor externalLink2;
    private VerticalLayout vulnContent;
    private HorizontalLayout vulnLinks;

    public VulnInfo() {
        topic.getStyle().set("margin-top", "0px").set("margin-bottom", "0px");
        desc.getStyle().set("margin-bottom", "0px");
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
        setTopic("Vulnerability Information Section");
        setDescription("Select one of the above tabs to find out more information about that particular vulnerability. External links to examples and OWASP pages for each vulnerability will be available as well.");
        vulnContent = new VerticalLayout(topic, desc);
        vulnContent.setSpacing(false);
        add(vulnContent);
    }

    private void createVulnContent(String vulnerability) {
        setTopic(vulnerability);
        if (vulnerability.equals("SQL Injection")) {
            setDescription("This vulnerability occurs when a web page has an input field which retrieves information from a database, thereby letting a malicious attacker input SQL Database code to obtain private information or to even completely destroy the database.");
            externalLink1 = new Anchor("https://owasp.org/www-community/attacks/SQL_Injection", "OWASP Page");
            externalLink2 = new Anchor("https://www.w3schools.com/sql/sql_injection.asp", "W3 Page With Examples");
        }
        else if (vulnerability.equals("JavaScript Injection")) {
            setDescription("This vulnerability occurs when a website could have user submitted forms or URL parameters that can be manipulated. Doing so can allow a malicious attacker to inject their own JavaScript directly into the from or URL which can cause private information to be taken or malicious scripts to be run on the web page.");
            externalLink1 = new Anchor("https://owasp.org/www-community/attacks/xss/", "OWASP XSS Page");
            externalLink2 = new Anchor("https://portswigger.net/web-security/cross-site-scripting", "PortSwigger XSS");
        }
        else if (vulnerability.equals("Directory Traversal")) {
            setDescription("This vulnerability occurs when a malicious attacker is able to use the URL of a page to access files or information stored on the web server that is normally out of reach. This includes inputing file paths inside the URL as if declaring a directory location.");
            externalLink1 = new Anchor("https://owasp.org/www-community/attacks/Path_Traversal", "OWASP Page");
            externalLink2 = new Anchor("https://portswigger.net/web-security/file-path-traversal", "PortSwigger Directory Traversal");
        }
        else {
            createVulnContent();
        }
        externalLink1.setTarget("_blank");
        externalLink2.setTarget("_blank");
        vulnLinks = new HorizontalLayout(externalLink1, externalLink2);
        vulnContent = new VerticalLayout(topic, desc, vulnLinks);
        vulnContent.setSpacing(false);
        add(vulnContent);
    }
}
