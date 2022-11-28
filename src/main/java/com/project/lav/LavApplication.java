package com.project.lav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;

@SpringBootApplication
@Theme("lav-theme")
public class LavApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(LavApplication.class, args);
		
	}

}
