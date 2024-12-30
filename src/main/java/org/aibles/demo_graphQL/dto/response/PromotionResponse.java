package org.aibles.demo_graphQL.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.aibles.demo_graphQL.entity.PromotionEntity;

public class PromotionResponse {

  private String id;
  private String code;
  private String description;
  private LocalDateTime expiredDate;
  private LocalDateTime giveAwayDay;
  private Integer discountPercent;
  private Long archivedMiles;
  private Long plusMiles;
  private Long quantity;

  public PromotionResponse() {
  }

  public PromotionResponse(String id, String code, String description, LocalDateTime expiredDate,
      LocalDateTime giveAwayDay, Integer discountPercent, Long archivedMiles, Long plusMiles,
      Long quantity) {
    this.id = id;
    this.code = code;
    this.description = description;
    this.expiredDate = expiredDate;
    this.giveAwayDay = giveAwayDay;
    this.discountPercent = discountPercent;
    this.archivedMiles = archivedMiles;
    this.plusMiles = plusMiles;
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getExpiredDate() {
    return expiredDate;
  }

  public void setExpiredDate(LocalDateTime expiredDate) {
    this.expiredDate = expiredDate;
  }

  public LocalDateTime getGiveAwayDay() {
    return giveAwayDay;
  }

  public void setGiveAwayDay(LocalDateTime giveAwayDay) {
    this.giveAwayDay = giveAwayDay;
  }

  public Integer getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(Integer discountPercent) {
    this.discountPercent = discountPercent;
  }

  public Long getArchivedMiles() {
    return archivedMiles;
  }

  public void setArchivedMiles(Long archivedMiles) {
    this.archivedMiles = archivedMiles;
  }

  public Long getPlusMiles() {
    return plusMiles;
  }

  public void setPlusMiles(Long plusMiles) {
    this.plusMiles = plusMiles;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public static PromotionResponse convertDatabaseToEntity(PromotionEntity entity) {
    PromotionResponse response = new PromotionResponse();
    response.setId(entity.getId());
    response.setCode(entity.getCode());
    response.setDescription(entity.getDescription());
    response.setExpiredDate(entity.getExpiredDate());
    response.setGiveAwayDay(entity.getGiveAwayDay());
    response.setDiscountPercent(entity.getDiscountPercent());
    response.setArchivedMiles(entity.getArchivedMiles());
    response.setPlusMiles(entity.getPlusMiles());
    response.setQuantity(entity.getQuantity());
    return response;
  }

  public static List<PromotionResponse> convertDatabaseToEntity(
      List<PromotionEntity> databaseEntityList) {
    List<PromotionResponse> promotions = new ArrayList<>();
    for (PromotionEntity databaseEntity : databaseEntityList) {
      PromotionResponse promotion = convertDatabaseToEntity(databaseEntity);
      promotions.add(promotion);
    }
    return promotions;
  }
}
