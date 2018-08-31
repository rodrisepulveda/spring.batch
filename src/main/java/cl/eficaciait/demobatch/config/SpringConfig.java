package cl.eficaciait.demobatch.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = { "cl.eficaciait.demobatch" })
public class SpringConfig {

	@Bean
	public PropertyPlaceholderConfigurer configProperties() {

		PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();

		placeholderConfigurer.setLocations(new ClassPathResource("base-datos.properties"));

		return placeholderConfigurer;

	}
}
