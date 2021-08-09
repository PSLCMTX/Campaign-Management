package com.demo.campaign_management_ms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.campaign_management_ms.model.Campaign;
/**
 * This is the repository for campaign management
 * @author manish_kumar
 *
 */
@Repository
public interface CampaignRepository extends MongoRepository<Campaign,Long> {

}
