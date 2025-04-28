package org.aibles.demo_graphQL.service.impl;

import java.util.List;
import org.aibles.demo_graphQL.dto.request.PromotionRequest;
import org.aibles.demo_graphQL.dto.response.PromotionResponse;
import org.aibles.demo_graphQL.entity.PromotionEntity;
import org.aibles.demo_graphQL.exception.ResourceNotFoundException;
import org.aibles.demo_graphQL.repository.PromotionRepository;
import org.aibles.demo_graphQL.service.PromotionService;
import org.springframework.transaction.annotation.Transactional;

public class PromotionServiceImpl implements PromotionService {

  private final PromotionRepository repository;

  public PromotionServiceImpl(PromotionRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<PromotionResponse> getAll() {
    return PromotionResponse.fromEntities(repository.findAll());
  }

  @Override
  @Transactional(readOnly = true)
  public PromotionResponse getById(String id) {
    PromotionEntity promotion = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Promotion", "id", id));
    return PromotionResponse.fromEntity(promotion);
  }

  @Override
  @Transactional
  public PromotionResponse create(PromotionRequest request) {
    return PromotionResponse.fromEntity(
        repository.save(PromotionEntity.fromRequest(request)));
  }

  @Override
  @Transactional
  public PromotionResponse update(String id, PromotionRequest request) {
    PromotionEntity promotion = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Promotion", "id", id));
    
    promotion.setCode(request.getCode());
    promotion.setDescription(request.getDescription());
    promotion.setExpiredDate(request.getExpiredDate());
    promotion.setGiveAwayDay(request.getGiveAwayDay());
    promotion.setDiscountPercent(request.getDiscountPercent());
    promotion.setArchivedMiles(request.getArchivedMiles());
    promotion.setPlusMiles(request.getPlusMiles());
    promotion.setQuantity(request.getQuantity());
    
    return PromotionResponse.fromEntity(repository.save(promotion));
  }

  @Override
  @Transactional
  public void delete(String id) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("Promotion", "id", id);
    }
    repository.deleteById(id);
  }
}