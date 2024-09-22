package CarRentalWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "CarRentalWeb.model")
@EnableJpaRepositories(basePackages = "CarRentalWeb.repository")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}