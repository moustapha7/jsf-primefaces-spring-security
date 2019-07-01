package com.codenotfound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringPrimeFacesApplication implements CommandLineRunner {
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  public static void main(String[] args) {
    SpringApplication.run(SpringPrimeFacesApplication.class, args);

  }
  @Bean
  public BCryptPasswordEncoder getBCPE() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void run(String... args) throws Exception {
    String p = passwordEncoder.encode("passer");
    System.out.println("password "+p);
  }
}
