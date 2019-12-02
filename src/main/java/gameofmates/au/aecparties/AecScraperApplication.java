package gameofmates.au.aecparties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AEC Scraper application.
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
public class AecScraperApplication {
	public static void main(String[] args) {
		SpringApplication.run(AecScraperApplication.class, args);
	}
}
