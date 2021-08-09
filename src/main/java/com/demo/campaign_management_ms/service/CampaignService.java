package com.demo.campaign_management_ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.campaign_management_ms.exception.ResourceNotFoundException;
import com.demo.campaign_management_ms.model.Campaign;
import com.demo.campaign_management_ms.repo.CampaignRepository;
import com.demo.campaign_management_ms.util.Constant;
/**
 * This is the service class for campaign management 
 * @author manish_kumar
 *
 */
@Service
public class CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;

	public List<Campaign> getAllCampaign() {
		List<Campaign> campaign = campaignRepository.findAll();
		return campaign;
	}

	public Campaign getCampaignById(Long cgid) throws ResourceNotFoundException {
		Campaign campaign = campaignRepository.findById(cgid)
				.orElseThrow(() -> new ResourceNotFoundException(Constant.CAMPAIGN_NOT_FOUND_FOR_THIS_ID + cgid));
		return campaign;

	}

	public Campaign createNewCampaign(Campaign campaign) {
		Campaign _campaign = campaignRepository.save(campaign);
		return _campaign;

	}
	public Campaign updateNewCampaign( Campaign campaignDetail ,Long cgid) throws ResourceNotFoundException {
		Campaign campaign = campaignRepository.findById(cgid)
				.orElseThrow(() -> new ResourceNotFoundException(Constant.CAMPAIGN_NOT_FOUND_FOR_THIS_ID + cgid));
		campaign.setId(campaignDetail.getId());
		campaign.setName(campaignDetail.getName());
		campaign.setStart_date(campaignDetail.getStart_date());
		campaign.setEnd_date(campaignDetail.getEnd_date());
		campaign.setState(campaignDetail.getState());
		campaign.setChannel(campaignDetail.getChannel());
		campaign.setPrice(campaignDetail.getPrice());
		campaign.setCateogry(campaignDetail.getCateogry());
		Campaign updateCampaign = campaignRepository.save(campaign);
		return updateCampaign;
		
	}
	public Campaign deleteNewCampaign(Long cgid) throws ResourceNotFoundException {
		Campaign campaign = campaignRepository.findById(cgid)
				.orElseThrow(() -> new ResourceNotFoundException(Constant.CAMPAIGN_NOT_FOUND_FOR_THIS_ID + cgid));
		  campaignRepository.deleteById(cgid);
		  return null;
		
		
	}
	public Campaign  DeleteNewAllCampaign() {
		campaignRepository.deleteAll();
		return null;
		
	}

}
