package org.aston;

import org.aston.config.RootConfig;
import org.aston.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Application implements WebApplicationInitializer {

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext){
    AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
    rootConfig.register(RootConfig.class);
    servletContext.addListener(new ContextLoaderListener(rootConfig));

    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(WebConfig.class);

    ServletRegistration.Dynamic servlet = servletContext.addServlet("servlet", new DispatcherServlet(appContext));
    servlet.addMapping("/welcome");


    }
}
