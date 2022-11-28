package com.project.lav.application.data.components;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.tabs.*;

public class VulnNavigation extends Div {
    private Tab sqlInjection;
    private Tab crossSiteScripting;
    private Tab vuln3;
    //private VulnInfo vulnInfo;

    public VulnNavigation() {
        addClassNames("vuln-nav-tabs");
        sqlInjection = new Tab("SQL Injection");
        sqlInjection.addClassNames("vulnLink", "vuln-button");
        crossSiteScripting = new Tab("Cross Site Scripting");
        crossSiteScripting.addClassNames("vulnLink", "vuln-button");
        vuln3 = new Tab("Vulnerability 3");
        vuln3.addClassNames("vulnLink", "vuln-button");

        Tabs vulnNav = new Tabs(sqlInjection, crossSiteScripting, vuln3);
        vulnNav.addThemeVariants(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS);

        //vulnNav.addThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS);

        //add(vulnNav);

        //vulnNav.addSelectedChangeListener(event -> setContent(event.getSelectedTab()));
    }

    // private void setContent(Tab tab) {
    //     vulnInfo.removeAll();

    //     if (tab.equals(sqlInjection)) {
    //         vulnInfo = new VulnInfo("SQL Injection");
    //     } else if (tab.equals(crossSiteScripting)) {
    //         vulnInfo = new VulnInfo("Cross Site Scripting");
    //     } else {
    //         vulnInfo = new VulnInfo();
    //     }
    // }

}
