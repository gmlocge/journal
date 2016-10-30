package by.gmlocge.web.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Created by dima on 03.11.2014.
 */
public class PGDPWebApplicationInitializer implements WebApplicationInitializer {
    public static XmlWebApplicationContext webApplicationContext;

    @Override
    public void onStartup(ServletContext container) {
        webApplicationContext = new XmlWebApplicationContext();
        Servlet springDispather = new DispatcherServlet(webApplicationContext);
        ServletRegistration.Dynamic registration = container.addServlet("journal", springDispather);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }

}
