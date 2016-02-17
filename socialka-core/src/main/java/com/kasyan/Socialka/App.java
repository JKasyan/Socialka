package com.kasyan.Socialka;

import com.kasyan.Socialka.config.DataSource;
import com.kasyan.Socialka.config.SecurityConfig;
import com.kasyan.Socialka.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Victoriya on 17.02.16.
 */
public class App extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{WebConfig.class, DataSource.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
