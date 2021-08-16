package com.demo.campaign.management.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.campaign.management.ms.exception.ResourceNotFoundException;
import com.demo.campaign.management.ms.model.Campaign;
import com.demo.campaign.management.ms.repo.CampaignRepository;
import com.demo.campaign.management.ms.util.Constant;
/**
 * This is the service class for campaign management 
 * @author manish_kumar
 *
 */
@Service
public class CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;

	public List<Campaign>  getAllCampaign() {
	    return campaignRepository.findAll();
	
	
	}

	public Optional<Campaign> getCampaignById(Long cgid) throws ResourceNotFoundException {
		Optional<Campaign> campaign =campaignRepository.findById(cgid);
		if(!campaign.isPresent())
				throw new ResourceNotFoundException(Constant.CAMPAIGN_NOT_FOUND_FOR_THIS_ID + " " + cgid);
				
				return campaign;
		

	}

	public Campaign createNewCampaign(Campaign campaign) {
		return campaignRepository.save(campaign);
		

	}
	public Optional<Campaign> updateNewCampaign( Campaign campaignDetail ,Long cgid) throws ResourceNotFoundException {
		Optional<Campaign> campaign = campaignRepository.findById(cgid);
		if(campaign.isPresent()) {
		
		campaign.get().setId(campaignDetail.getId());
		campaign.get().setName(campaignDetail.getName());
		campaign.get().setStart_date(campaignDetail.getStart_date());
		campaign.get().setEnd_date(campaignDetail.getEnd_date());
		campaign.get().setState(campaignDetail.getState());
		campaign.get().setChannel(campaignDetail.getChannel());
		campaign.get().setPrice(campaignDetail.getPrice());
		campaign.get().setCateogry(campaignDetail.getCateogry());
		 campaignRepository.save(campaign.get());
		return campaign;
		}
		else {
		 throw new ResourceNotFoundException(Constant.CAMPAIGN_NOT_FOUND_FOR_THIS_ID + " " + cgid);
	}
		
	}
	public Campaign deleteNewCampaign(Long cgid)  {
		Optional<Campaign> campaign = campaignRepository.findById(cgid);
			campaignRepository.deleteById(cgid);
		  return null;
		
		
	}
	public Campaign DeleteNewAllCampaign() {
		campaignRepository.deleteAll();
		return null;
		
	}

}
