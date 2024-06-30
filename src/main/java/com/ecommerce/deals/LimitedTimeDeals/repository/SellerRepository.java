package com.ecommerce.deals.LimitedTimeDeals.repository;

import com.ecommerce.deals.LimitedTimeDeals.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
