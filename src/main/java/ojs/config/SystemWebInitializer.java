package ojs.config;

import ojs.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

public class SystemWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class[]{RootConfig.class};

    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }


    @Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setMultipartConfig(

                new MultipartConfigElement("/tmp",
                        1024 * 1024 * 5,
                        1024 * 1024 * 5 * 5,
                        1024 * 1024));

    }

}