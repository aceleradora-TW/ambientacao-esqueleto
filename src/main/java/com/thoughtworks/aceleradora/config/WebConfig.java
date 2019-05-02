package com.thoughtworks.aceleradora.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        final VersionResourceResolver versionResolver = new VersionResourceResolver();
//        versionResolver.addFixedVersionStrategy("test_version", "/**");

        VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
                .addVersionStrategy(new ContentVersionStrategy(),"/**");

        registry.addResourceHandler("/**", "/assets/**")
                .addResourceLocations("classpath:/static/assets/", "classpath:/static/")
                .setCachePeriod(60*60*24*365)
                .resourceChain(true)
                .addResolver(versionResourceResolver);

//        registry.addResourceHandler(
//                "/**",
//                "/assets/**"
//        )
//        .addResourceLocations(
//            "classpath:/static/assets/",
//                "classpath:/static/"
//        );


//        registry.addResourceHandler(
//                "/**",
//                "/assets/**",
//                "/assets/**/*.js",
//                "/assets/**/*.css")
//        .addResourceLocations(
//                "classpath:/static/assets/",
//                "classpath:/static/assets/js/",
//                "classpath:/static/assets/css")
//        .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
//        .resourceChain(false)
//        .addResolver(versionResolver);



    }

}