package org.andersenlab.lesson8;

import static org.andersenlab.lesson8.user.Role.ADMIN;
import static org.andersenlab.lesson8.user.Role.MANAGER;

import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.andersenlab.lesson8.auth.AuthenticationResponse;
import org.andersenlab.lesson8.auth.AuthenticationService;
import org.andersenlab.lesson8.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@ConfigurationPropertiesScan
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(
      AuthenticationService service
  ) {
    return args -> {
      var admin = new RegisterRequest(
          "Admin",
          "Admin",
          "admin@mail.com",
          "password",
          ADMIN
      );

      var manager = new RegisterRequest(
          "Manager",
          "Manager",
          "manager@mail.com",
          "password",
          MANAGER
      );

      Stream.of(admin, manager)
          .map(service::register)
          .map(AuthenticationResponse::accessToken)
          .forEach(this::logToken);
    };
  }

  private void logToken(String token) {
    log.info("Token: {}", token);
  }

}
