package com.ecommerce.deals.LimitedTimeDeals.repository;

import com.ecommerce.deals.LimitedTimeDeals.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Integer> {
}
