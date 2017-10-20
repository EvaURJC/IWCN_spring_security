package com.iwcn.master;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.iwcn.master.configuration.DatabaseLoader;

@SpringBootApplication
public class Ejercicio3y3ThymeleafSpringBootApp extends WebMvcConfigurerAdapter{

		// Local ingles
		@Bean
		public LocaleResolver localeResolver() {
			SessionLocaleResolver slr = new SessionLocaleResolver();
			slr.setDefaultLocale(Locale.ENGLISH);
			return slr;
		}
		
		// Nuevo local basado en  lang
		@Bean
		public LocaleChangeInterceptor localeChangeInterceptor() {
			LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
			lci.setParamName("lang");
			return lci;
		}
		
		@Override
		public void addInterceptors (InterceptorRegistry registry) {
			registry.addInterceptor(localeChangeInterceptor());
		}
		
		@Bean
		public MessageSource messageSource() {
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setBasename("message");
			return messageSource;
		}
		
		@Bean
		public DatabaseLoader database () {
			return new DatabaseLoader();
		}

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio3y3ThymeleafSpringBootApp.class, args);
    }

}
