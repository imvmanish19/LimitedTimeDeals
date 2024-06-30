package com.ecommerce.deals.LimitedTimeDeals.repository;

import com.ecommerce.deals.LimitedTimeDeals.model.DealClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealClaimRepository extends JpaRepository<DealClaim, Integer> {

    @Query("SELECT dc FROM DealClaim dc WHERE dc.deal.dealId = :dealId AND dc.userProfile.userId = :userId")
    Optional<DealClaim> findByDealIdAndUserId(@Param("dealId") int dealId, @Param("userId") int userId);
}
