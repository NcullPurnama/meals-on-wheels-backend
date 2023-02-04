package com.project.MerryMeal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.MerryMeal.entity.Campaign;


@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long>{

	@Query(value = "SELECT * FROM campaign_tb WHERE status = 1", nativeQuery = true)
	public List<Campaign> findByStatusTrue();
	@Query(value = "SELECT * FROM campaign_tb WHERE status = 2", nativeQuery = true)
	public List<Campaign> findByStatusFalse();
}
