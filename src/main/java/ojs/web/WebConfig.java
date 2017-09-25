package ojs.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;


@Configuration
@EnableWebMvc
@ComponentScan({"ojs.web"})
@EnableScheduling
public class WebConfig extends WebMvcConfigurerAdapter {


//
//	 @Bean
//	  public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//	    viewResolver.setTemplateEngine(templateEngine);
//	    return viewResolver;
//	  }
//	  @Bean
//	  public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
//	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//	    templateEngine.setTemplateResolver(templateResolver);
//		  //templateEngine.addDialect(new Layout);
//	    return templateEngine;
//	  }
//
//	  @Bean
//	  public TemplateResolver templateResolver() {
//	    TemplateResolver templateResolver = new ServletContextTemplateResolver();
//	    templateResolver.setPrefix("/WEB-INF/views/");
//	    templateResolver.setSuffix(".html");
//	    templateResolver.setTemplateMode("HTML5");
//	    return templateResolver;
//	  }
	
	/*@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/WEB-INF/views/");
		resourceViewResolver.setSuffix(".jsp");
		return resourceViewResolver;
	}
	*/
	
/*	 private ApplicationContext applicationContext;

	  public void setApplicationContext(ApplicationContext applicationContext) {
	    this.applicationContext = applicationContext;
	  }
	
	@Bean
	public ApplicationContext applicationContext()
	{
		return applicationContext;
	}*/
	
	
	/*public void contextInitialized(ServletContextEvent sce) {
        TemplateEngine engine = templateEngine(sce.getServletContext());
     //   TemplateEngineUtil.storeTemplateEngine(sce.getServletContext(), engine);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

	
	@Bean
	  public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(templateEngine);
	    viewResolver.setOrder(1);
	    return viewResolver;
	  }
	  

	  @Bean
	  public TemplateEngine templateEngine(ServletContext servletContext) {
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.setEnableSpringELCompiler(true);
	    engine.setTemplateResolver(templateResolver(servletContext));
	    return engine;
	  }

	  public ITemplateResolver templateResolver(ServletContext servletContext) {
	 //   SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	   ServletContextTemplateResolver resolver=new ServletContextTemplateResolver(servletContext);
		//  resolver.setApplicationContext(applicationContext());
	    resolver.setPrefix("/WEB-INF/views/");
	//    resolver.setSuffix(".html");
	    resolver.setTemplateMode("HTML5");
	    return resolver;
	  }
	
	*/



	/**
	 * Configure TilesConfigurer.
	 */

	/**
	 * Configure TilesConfigurer.
	 */


	/**
	 * Configure TilesConfigurer.
	 */

@Bean
public TilesConfigurer tilesConfigurer()
{
	TilesConfigurer tilesConfigurer=new TilesConfigurer();
	tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
	tilesConfigurer.setCheckRefresh(true);
	return tilesConfigurer;
}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer)
	{
		defaultServletHandlerConfigurer.enable();
	}
	
/*	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		
	}*/

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("file:///Users/habuma/messages");
		messageSource.setCacheSeconds(10);
		return messageSource;
	}
	
	  @Bean
	  public MultipartResolver multipartResolver() throws IOException {
	    return new StandardServletMultipartResolver();
	  }
}
