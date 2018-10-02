//package com.kpit.kmsdemo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig   {
//
//	//implements WebMvcConfigurer
//	
//	@Bean
//    public Docket api() { 
//        return new Docket(DocumentationType.SWAGGER_2)  
//          .select()                                  
//          .apis(RequestHandlerSelectors.any())              
//          .paths(PathSelectors.any())
//          .build();                                           
//    }
//	
//	    
//    //@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}
//    
////    private ApiInfo metaData() {
////        ApiInfo apiInfo = new ApiInfo(
////                "Microservices Framework Demo",
////                "Hybrid Designed platform Spring Config server with GIT Repo",
////                "1.0",
////                "Terms of service",
////                new Contact("Microservice Demo", "http://www.kpit.com/", "rajesh.nivargikar@kpit.com"),
////               "Apache License Version 2.0",
////                "https://www.apache.org/licenses/LICENSE-2.0", null);
////        return apiInfo;
////    }
//}
//
