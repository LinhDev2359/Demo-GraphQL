package org.aibles.demo_graphQL.configuration;

import org.aibles.demo_graphQL.repository.PromotionRepository;
import org.aibles.demo_graphQL.service.PromotionService;
import org.aibles.demo_graphQL.service.impl.PromotionServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.demo_graphQL.repository"})
@ComponentScan(basePackages = {"org.aibles.demo_graphQL.repository"})
@EnableJpaAuditing
@EntityScan(basePackages = "org.aibles.demo_graphQL.entity")
public class PromorionConfiguration {

  @Bean
  public PromotionService promotionService(PromotionRepository repository) {
    return new PromotionServiceImpl(repository);
  }

}
