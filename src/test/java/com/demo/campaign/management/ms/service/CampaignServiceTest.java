
package com.demo.campaign.management.ms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.campaign.management.ms.exception.ResourceNotFoundException;
import com.demo.campaign.management.ms.model.Campaign;
import com.demo.campaign.management.ms.model.Category;
import com.demo.campaign.management.ms.model.Channel;
import com.demo.campaign.management.ms.model.State;
import com.demo.campaign.management.ms.repo.CampaignRepository;
import com.demo.campaign.management.ms.service.CampaignService;

@SpringBootTest
public class CampaignServiceTest {

	@Autowired
	private CampaignService campaignService;

	@Autowired
	State state;

	@Autowired
	Channel channel;

	@Autowired
	Category category;

	@MockBean
	private CampaignRepository campaignRepository;

	@BeforeEach
	void setUp() throws Exception {
		state.setStateValue("active");
		channel.setChannelValue("sms");
		category.setCategoryValue("gaming");
		List<Object> campaign = List.of(1, "shah", "22-07-2021", "30-07-2021", state, channel, 100, category);
		// Mockito.when(campaignRepository.findById(1)).thenReturn(campaign);

	}

	@Test
	public void getAllCampaignServiceTest() {

		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Campaign campaign = new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory);
		List<Campaign> campaignList = new ArrayList<Campaign>();
		campaignList.add(campaign);
		Mockito.when(campaignRepository.findAll()).thenReturn(campaignList);
		List<Campaign> campaignAllList = campaignService.getAllCampaign();
		assertEquals(campaignAllList, campaignList);
		// assertEquals("shah", campaignAllList.get(0).getName());
		// model.stream().filter(s->s.getName().equals("shah")).map(Campaign::getName));

	}

	@Test
	public void getCampaignServiceByIdTest() throws ResourceNotFoundException {

		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Campaign campaign = new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory);
		long id = 1;
		Mockito.when(campaignRepository.findById(id)).thenReturn(Optional.ofNullable(campaign));
		Optional<Campaign> campaign1 = campaignService.getCampaignById(id);
		assertEquals(1, campaign1.get().getId());

	}

	@Test
	public void createCampaignServiceTest() throws ResourceNotFoundException {

		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Campaign campaign = new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory);
		Mockito.when(campaignRepository.save(campaign)).thenReturn(campaign);
		Campaign campaign1 = campaignService.createNewCampaign(campaign);
		assertEquals(campaign1, campaign);

	}

	@Test
	public void updateCampaignServiceTest() throws ResourceNotFoundException {

		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Optional<Campaign> campaign = Optional.of(new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory));
		Campaign campaign2 = new Campaign(1, "kumar", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory);
		long id=1;
		Mockito.when(campaignRepository.findById(id)).thenReturn(campaign);
		Optional<Campaign> campaign1 = campaignService.updateNewCampaign(campaign2, id);
		assertEquals(campaign1, campaign);

	}
	
	@Test
	public void deleteAllCampaignServiceTest() throws ResourceNotFoundException {

		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Optional<Campaign> campaign = Optional.of(new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory));
		campaignService.DeleteNewAllCampaign();
		verify(campaignRepository,times(1)).deleteAll();

	}
	@Test
	public void deleteCampaignServiceByIdTest() throws ResourceNotFoundException {

		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Optional<Campaign> campaign = Optional.of(new Campaign(3, "raj", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory));
		long id=3;
		campaignService.deleteNewCampaign(id);
		verify(campaignRepository,times(1)).deleteById(id);

	}
}
