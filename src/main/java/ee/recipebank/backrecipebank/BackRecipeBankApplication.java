package ee.recipebank.backrecipebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackRecipeBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackRecipeBankApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){return new RestTemplate();}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://retseptipank.eu","http://192.168.1.221:8081").
						allowedMethods("GET","POST","DELETE","PUT","OPTIONS");
			}
		};
	}
}



