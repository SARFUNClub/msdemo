package com.kpit.kmsdemo.OndutyService;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@ComponentScan("package com.kpit.kmsdemo.OndutyService")
public class ApplicationConfiguration  extends WebMvcConfigurationSupport   {

//	@Bean
//    public Docket candidateApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.kpit.kmsdemo.api"))
//                .paths(PathSelectors.ant("/*.*"))
//                .build()
//                .apiInfo(metaData());
//    }
	
	@Bean
    public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)  
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());
    }	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	        .addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");
	    registry
	        .addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfo(
                "KPIT DT Microservices Demo",
                "Public Onduty Service Details API - is a RESTful API that provides Public Onduty Service details of KPIT MSF Demo. Below is a list of available REST API calls for Public Onduty Service details, ",
                "1.0",
                "Terms of service",
                new Contact("Author", "http://www.kpit.com/", "rajesh.nivargikar@kpit.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", 
                new ArrayList<>());
        
    }
}
