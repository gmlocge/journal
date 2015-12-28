package by.gmlocge.web.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class DataAddonsToSeesionListener implements HttpSessionListener {
    private Logger logger = LoggerFactory.getLogger(DataAddonsToSeesionListener.class);


    @Override
    public void sessionCreated(HttpSessionEvent event) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

    }

}