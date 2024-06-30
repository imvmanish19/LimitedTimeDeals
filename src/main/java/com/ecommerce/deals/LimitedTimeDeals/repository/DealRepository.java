package com.ecommerce.deals.LimitedTimeDeals.repository;

import com.ecommerce.deals.LimitedTimeDeals.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface DealRepository extends JpaRepository<Deal, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Deal d SET d.claimedQuantity = :claimQuantity WHERE d.dealId = :dealId")
    void updateClaimedQuantity(@Param("dealId") int dealId, @Param("claimQuantity") int claimQuantity);

    @Modifying
    @Transactional
    @Query("UPDATE Deal d SET d.endTime = :endTime WHERE d.dealId = :dealId")
    void updateEndTime(@Param("dealId") int dealId, @Param("endTime") LocalDateTime endTime);
}
