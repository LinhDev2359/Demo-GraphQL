package org.aibles.demo_graphQL.repository;

import org.aibles.demo_graphQL.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends
    JpaRepository<PromotionEntity, String> {

}