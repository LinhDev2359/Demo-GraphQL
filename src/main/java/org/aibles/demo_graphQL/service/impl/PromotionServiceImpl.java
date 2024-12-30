package org.aibles.demo_graphQL.service.impl;

import java.util.List;
import org.aibles.demo_graphQL.dto.request.PromotionRequest;
import org.aibles.demo_graphQL.dto.response.PromotionResponse;
import org.aibles.demo_graphQL.entity.PromotionEntity;
import org.aibles.demo_graphQL.repository.PromotionRepository;
import org.aibles.demo_graphQL.service.PromotionService;

public class PromotionServiceImpl implements PromotionService {

  private final PromotionRepository repository;

  public PromotionServiceImpl(PromotionRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<PromotionResponse> getAll() {
    return PromotionResponse.convertDatabaseToEntity(repository.findAll());
  }

  @Override
  public PromotionResponse getById(String id) {
    PromotionEntity promotion = repository.findById(id).orElseThrow(() -> {
      return new RuntimeException("Id không tồn tại");
    });
    return PromotionResponse.convertDatabaseToEntity(promotion);
  }

  @Override
  public PromotionResponse create(PromotionRequest request) {
    return PromotionResponse.convertDatabaseToEntity(
        repository.save(PromotionEntity.convertDatabaseToEntity(request)));
  }

  @Override
  public PromotionResponse update(String id, PromotionRequest request) {
    PromotionEntity promotion = repository.findById(id).orElseThrow(() -> {
      return new RuntimeException("Id không tồn tại");
    });
    promotion.setCode(request.getCode());
    promotion.setDescription(request.getDescription());
    promotion.setExpiredDate(request.getExpiredDate());
    promotion.setGiveAwayDay(request.getGiveAwayDay());
    promotion.setDiscountPercent(request.getDiscountPercent());
    promotion.setArchivedMiles(request.getArchivedMiles());
    promotion.setPlusMiles(request.getPlusMiles());
    promotion.setQuantity(request.getQuantity());
    return PromotionResponse.convertDatabaseToEntity(repository.save(promotion));
  }

  @Override
  public void delete(String id) {
    repository.findById(id).orElseThrow(() -> {
      return new RuntimeException("Id không tồn tại");
    });
    repository.deleteById(id);
  }
}
