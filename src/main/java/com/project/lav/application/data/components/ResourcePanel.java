package com.project.lav.application.data.components;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.*;
import com.vaadin.flow.component.tabs.*;

public class ResourcePanel extends Div {
    
    private Div vulnNavTabs;
    public VulnInfo vulnInfo = new VulnInfo();
    private Icon expandIcon = new Icon(VaadinIcon.ANGLE_UP);
    private Icon collapseIcon = new Icon(VaadinIcon.ANGLE_DOWN);
    private H2 panelTitle;
    private Button resizeBtn;
    private Tab sqlInjection;
    private Tab crossSiteScripting;
    private Tab vuln3;

    public ResourcePanel() {
        addClassNames("resources", "panel");
        addPanelTitle();
        addNavTabs();
        addResizeButton();
        addVulnInfo();
    }

    private void addPanelTitle() {
        panelTitle = new H2("Resources:");
        panelTitle.addClassName("panel-title");

        add(panelTitle);
    }

    private void addNavTabs() {
        sqlInjection = new Tab("SQL Injection");
        crossSiteScripting = new Tab("Cross Site Scripting");
        vuln3 = new Tab("Vulnerability 3");
        Tabs vulnNav = new Tabs(sqlInjection, crossSiteScripting, vuln3);

        vulnNav.addSelectedChangeListener(event -> 
                setVulnInfo(event.getSelectedTab()));

        vulnNavTabs = new Div(vulnNav);
        vulnNavTabs.addClassNames("vuln-nav-tabs");

        setVulnInfo(vulnNav.getSelectedTab());

        add(vulnNavTabs);
    }

    private void addResizeButton() {
        resizeBtn = new Button("Expand", this::resizePanel);
        resizeBtn.addClassName("panelbtn");
        resizeBtn.setIcon(expandIcon);
        resizeBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY, 
                                   ButtonVariant.LUMO_SMALL);
        resizeBtn.setIconAfterText(true);

        add(resizeBtn);
    }

    private void addVulnInfo() {
        vulnInfo = new VulnInfo();
        vulnInfo.setClassName("info");

        add(vulnInfo);
    }

    private void resizePanel(ClickEvent<Button> event) {
        if (event.getSource().getText().equals("Expand")) {
            getStyle().set("height", "200px");
            vulnInfo.getStyle().set("height", "160px");
            vulnInfo.getStyle().set("border-style", "solid");
            event.getSource().setText("Collapse");
            event.getSource().setIcon(collapseIcon);
        } else {
            getStyle().set("height", "40px");
            vulnInfo.getStyle().set("height", "0px");
            vulnInfo.getStyle().set("border-style", "hidden");
            event.getSource().setText("Expand");
            event.getSource().setIcon(expandIcon);
        }    
    }

    private void setVulnInfo(Tab tab) {
        vulnInfo.removeAll();

        if (tab.equals(sqlInjection)) {
            vulnInfo.setNewVuln(tab.getLabel());
        } else if (tab.equals(crossSiteScripting)) {
            vulnInfo.setNewVuln(tab.getLabel());
        } else {
            vulnInfo.setNewVuln(tab.getLabel());
        }
    }

}
