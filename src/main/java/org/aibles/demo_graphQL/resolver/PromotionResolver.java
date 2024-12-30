package org.aibles.demo_graphQL.resolver;

import java.util.List;
import org.aibles.demo_graphQL.dto.request.PromotionRequest;
import org.aibles.demo_graphQL.dto.response.PromotionResponse;
import org.aibles.demo_graphQL.service.PromotionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PromotionResolver {

  private final PromotionService promotionService;

  public PromotionResolver(PromotionService promotionService) {
    this.promotionService = promotionService;
  }

  @QueryMapping
  public List<PromotionResponse> getAll() {
    return promotionService.getAll();
  }

  @QueryMapping
  public PromotionResponse getById(@Argument String id) {
    return promotionService.getById(id);
  }

  @MutationMapping
  public PromotionResponse create(@Argument PromotionRequest request) {
    return promotionService.create(request);
  }

  @MutationMapping
  public PromotionResponse update(@Argument String id, @Argument PromotionRequest request) {
    return promotionService.update(id, request);
  }

  @MutationMapping
  public void delete(@Argument String id) {
    promotionService.delete(id);
  }
}
