package com.toughguy.sinograin;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan(basePackages = {"com.toughguy.sinograin.filter"})
public class SinograinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinograinApplication.class, args);
	}
	//-- 自己的应用的服务器设置
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	    factory.setPort(80);
	    factory.setContextPath("/grain");
	    factory.setSessionTimeout(60, TimeUnit.MINUTES);
	    return factory;
	}
}
