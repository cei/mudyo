package cei.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cei.mudyo.web"})
public class MudyoConfiguration extends WebMvcConfigurerAdapter {
	private static final Logger log = LoggerFactory.getLogger("--- Mudyo Configuration ---");
	
	private static final String TEMPLATE_PATH = "classpath:cei/mudyo/templates/";

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer config = new FreeMarkerConfigurer();
		config.setTemplateLoaderPath(TEMPLATE_PATH);

		log.info("Freemarker template path: {}", TEMPLATE_PATH);

		//22. Sep. 2012 by hellozkyz
		//Jar 파일안에 Freemarker Template 를 호출 할때
		config.setPreferFileSystemAccess(false);

		return config;
	}

	@Bean
	public ViewResolver viewResolverByFreemarker() {
		log.info("Freemarker ViewResolver Bean");
		
		FreeMarkerViewResolver view = new FreeMarkerViewResolver();
		view.setCache(true);
		view.setContentType("text/html; charset=utf-8");
		view.setSuffix(".ftl");
		view.setOrder(1);
		return view;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("favicon.ico registration!");
		registry.addResourceHandler("/favicon.ico").addResourceLocations("/img/favicon.ico");
	}
}