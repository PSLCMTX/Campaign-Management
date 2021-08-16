package com.demo.campaign.management.ms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.campaign.management.ms.exception.ResourceNotFoundException;
import com.demo.campaign.management.ms.model.Campaign;
import com.demo.campaign.management.ms.service.CampaignService;

@RestController
public class CampaignController {

	@Autowired
	private CampaignService campaignService;

	/**
	 * This method will return all campaign
	 * 
	 * @return
	 */
	@GetMapping("/campaign")
	public List<Campaign> listOfCampaign() {
		return campaignService.getAllCampaign();

	}
/**
 * This method will return campaign based on ID
 * @param cgid
 * @return
 * @throws ResourceNotFoundException
 */
	@GetMapping("/campaign/{id}")
	public Optional<Campaign> getlistofCampaignId(@PathVariable(value = "id") Long cgid) throws ResourceNotFoundException {
		return campaignService.getCampaignById(cgid);

	}
	/**
	 * This method will create new campaign
	 * @param campaign
	 * @return
	 */

	@PostMapping("/campaign")
	public Campaign createCampaign(@RequestBody Campaign campaign) {

		return campaignService.createNewCampaign(campaign);

	}
	/**
	 * This method will update the campaign based on ID
	 * @param campaignDetail
	 * @param cgid
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@PutMapping("campaign/{cgid}")
	public Optional<Campaign> updateCampaign(@RequestBody Campaign campaignDetail, @PathVariable long cgid)
			throws ResourceNotFoundException {
		return campaignService.updateNewCampaign(campaignDetail, cgid);

	}
	/**
	 * this method will delete the campaign based on ID
	 * @param cgid
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@DeleteMapping("campaign/{cgid}")
	public Campaign deleteCampaign(@PathVariable long cgid) throws ResourceNotFoundException {

		return campaignService.deleteNewCampaign(cgid);

	}
	/**
	 * this method will delete all the campaign
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@DeleteMapping("/campaign")
	public Campaign deleteAllCampaign() throws ResourceNotFoundException {
		return campaignService.DeleteNewAllCampaign();

	}

}
