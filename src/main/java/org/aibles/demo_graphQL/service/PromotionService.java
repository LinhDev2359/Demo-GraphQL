package org.aibles.demo_graphQL.service;

import java.util.List;
import org.aibles.demo_graphQL.dto.request.PromotionRequest;
import org.aibles.demo_graphQL.dto.response.PromotionResponse;

public interface PromotionService {

  List<PromotionResponse> getAll();
  PromotionResponse getById(String id);
  PromotionResponse create(PromotionRequest request);
  PromotionResponse update(String id, PromotionRequest request);
  void delete(String id);

}
