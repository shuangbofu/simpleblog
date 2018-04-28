package cn.shuangbofu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class SiteApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SiteApplication.class, args);
	}
}
