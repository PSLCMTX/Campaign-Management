package com.demo.campaign.management.ms.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.campaign.management.ms.controller.CampaignController;
import com.demo.campaign.management.ms.model.Campaign;
import com.demo.campaign.management.ms.model.Category;
import com.demo.campaign.management.ms.model.Channel;
import com.demo.campaign.management.ms.model.State;
import com.demo.campaign.management.ms.repo.CampaignRepository;
import com.demo.campaign.management.ms.service.CampaignService;

@WebMvcTest(CampaignController.class)
public class CampaignControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CampaignService campaignService;
	@MockBean
	private CampaignRepository Campaignrepository;
	
	@Autowired
	State state;

	@Autowired
	Channel channel;

	@Autowired
	Category category;

	@BeforeEach
	void setup() {
		state.setStateValue("active");
		channel.setChannelValue("sms");
		category.setCategoryValue("gaming");
		List<Object> campaign = List.of(1, "shah", "22-07-2021", "30-07-2021", state, channel, 100, category);
		

	}

	@Test
	void listOfAllCampaignTest() throws Exception {
		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Campaign campaign = new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory);
		List<Campaign> campaignList = new ArrayList<Campaign>();
		campaignList.add(campaign);
		
		Mockito.when(campaignService.getAllCampaign()).thenReturn(campaignList);
		mockMvc.perform(MockMvcRequestBuilders.get("/campaign").
				contentType(MediaType.APPLICATION_JSON).content("{\r\n"
						+ "    \"id\": 1,\r\n"
						+ "    \"name\": \"shah\",\r\n"
						+ "    \"start_date\" : \"22-07-2021\",\r\n"
						+ "    \"end_date\": \"30-07-2021\",\r\n"
						+ "    \"state\" : [\r\n"
						+ "        {     \r\n"
						+ "            \"stateValue\": \"active\"\r\n"
						+ "          \r\n"
						+ "        }\r\n"
						+ "    ]   ,\r\n"
						+ "    \"channel\": [\r\n"
						+ "        {\r\n"
						+ "         \"channelValue\": \"sms\"\r\n"
						+ "        }\r\n"
						+ "    ], \r\n"
						+ "    \"price\": 100,\r\n"
						+ "    \"cateogry\": [\r\n"
						+ "        {\r\n"
						+ "         \"cateogryValue\": \"gaming\"\r\n"
						+ "        \r\n"
						+ "\r\n"
						+ "        }\r\n"
						+ "    ]   \r\n"
						+ "        \r\n"
						+ "    \r\n"
						+ "}")).andDo(MockMvcResultHandlers.print());
		 verify(campaignService).getAllCampaign();
		    verify(campaignService,times(1)).getAllCampaign();
		

	}
	
	@Test
	void listOfCampaignByIdTest() throws Exception {
		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Optional<Campaign> campaign = Optional.of(new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory));
		long id=1;
		Mockito.when(campaignService.getCampaignById(id)).thenReturn(campaign);
		mockMvc.perform(get("/campaign/1").
		           contentType(MediaType.APPLICATION_JSON).
		           content("{\r\n"
		           		+ "    \"id\": 1,\r\n"
		           		+ "    \"name\": \"shah\",\r\n"
		           		+ "    \"start_date\" : \"22-07-2021\",\r\n"
		           		+ "    \"end_date\": \"30-07-2021\",\r\n"
		           		+ "    \"state\" : [\r\n"
		           		+ "        {     \r\n"
		           		+ "            \"stateValue\": \"active\"\r\n"
		           		+ "          \r\n"
		           		+ "        }\r\n"
		           		+ "    ]   ,\r\n"
		           		+ "    \"channel\": [\r\n"
		           		+ "        {\r\n"
		           		+ "         \"channelValue\": \"sms\"\r\n"
		           		+ "        }\r\n"
		           		+ "    ], \r\n"
		           		+ "    \"price\": 100,\r\n"
		           		+ "    \"cateogry\": [\r\n"
		           		+ "        {\r\n"
		           		+ "         \"cateogryValue\": \"gaming\"\r\n"
		           		+ "        \r\n"
		           		+ "\r\n"
		           		+ "        }\r\n"
		           		+ "    ]   \r\n"
		           		+ "        \r\n"
		           		+ "    \r\n"
		           		+ "} ")).andExpect(MockMvcResultMatchers.status().isOk()).
		                         andDo(MockMvcResultHandlers.print());
        
		           
	}
	@Test
	void createCampaignTest() throws Exception {
		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Campaign campaign = new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory);
	
    Mockito.when(campaignService.createNewCampaign(campaign)).thenReturn(campaign);
    mockMvc.perform(MockMvcRequestBuilders.post("/campaign").
			contentType(MediaType.APPLICATION_JSON).content("{\r\n"
					+ "    \"id\": 1,\r\n"
					+ "    \"name\": \"shah\",\r\n"
					+ "    \"start_date\" : \"22-07-2021\",\r\n"
					+ "    \"end_date\": \"30-07-2021\",\r\n"
					+ "    \"state\" : [\r\n"
					+ "        {     \r\n"
					+ "            \"stateValue\": \"active\"\r\n"
					+ "          \r\n"
					+ "        }\r\n"
					+ "    ]   ,\r\n"
					+ "    \"channel\": [\r\n"
					+ "        {\r\n"
					+ "         \"channelValue\": \"sms\"\r\n"
					+ "        }\r\n"
					+ "    ], \r\n"
					+ "    \"price\": 100,\r\n"
					+ "    \"cateogry\": [\r\n"
					+ "        {\r\n"
					+ "         \"cateogryValue\": \"gaming\"\r\n"
					+ "        \r\n"
					+ "\r\n"
					+ "        }\r\n"
					+ "    ]   \r\n"
					+ "        \r\n"
					+ "    \r\n"
					+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
	 
	  //verify(campaignService,times(1)).createNewCampaign(campaign);
	
    
}
	@Test
	void updateCampaignTest() throws Exception {
		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Campaign campaign = new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory);
		Optional<Campaign> campaign1 = Optional.of(new Campaign(1, "kumar", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory));
		long id=1;
	
    Mockito.when(campaignService.updateNewCampaign(campaign,id)).thenReturn(campaign1);
    mockMvc.perform(MockMvcRequestBuilders.put("/campaign/1").
			contentType(MediaType.APPLICATION_JSON).content("{\r\n"
					+ "    \"id\": 1,\r\n"
					+ "    \"name\": \"shah\",\r\n"
					+ "    \"start_date\" : \"22-07-2021\",\r\n"
					+ "    \"end_date\": \"30-07-2021\",\r\n"
					+ "    \"state\" : [\r\n"
					+ "        {     \r\n"
					+ "            \"stateValue\": \"active\"\r\n"
					+ "          \r\n"
					+ "        }\r\n"
					+ "    ]   ,\r\n"
					+ "    \"channel\": [\r\n"
					+ "        {\r\n"
					+ "         \"channelValue\": \"sms\"\r\n"
					+ "        }\r\n"
					+ "    ], \r\n"
					+ "    \"price\": 100,\r\n"
					+ "    \"cateogry\": [\r\n"
					+ "        {\r\n"
					+ "         \"cateogryValue\": \"gaming\"\r\n"
					+ "        \r\n"
					+ "\r\n"
					+ "        }\r\n"
					+ "    ]   \r\n"
					+ "        \r\n"
					+ "    \r\n"
					+ "}")).andExpect(MockMvcResultMatchers.status().isOk()). 
                           andDo(MockMvcResultHandlers.print());
	 
	  //verify(campaignService,times(1)).updateNewCampaign(campaign, id);
	
    
}
	@Test
	void deleteCampaignByIdTest() throws Exception {
		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Campaign campaign = new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory);
		long id=1;
    Mockito.when(campaignService.deleteNewCampaign(id)).thenReturn(campaign);
    mockMvc.perform(MockMvcRequestBuilders.delete("/campaign/1").
			contentType(MediaType.APPLICATION_JSON).content("{\r\n"
					+ "    \"id\": 1,\r\n"
					+ "    \"name\": \"shah\",\r\n"
					+ "    \"start_date\" : \"22-07-2021\",\r\n"
					+ "    \"end_date\": \"30-07-2021\",\r\n"
					+ "    \"state\" : [\r\n"
					+ "        {     \r\n"
					+ "            \"stateValue\": \"active\"\r\n"
					+ "          \r\n"
					+ "        }\r\n"
					+ "    ]   ,\r\n"
					+ "    \"channel\": [\r\n"
					+ "        {\r\n"
					+ "         \"channelValue\": \"sms\"\r\n"
					+ "        }\r\n"
					+ "    ], \r\n"
					+ "    \"price\": 100,\r\n"
					+ "    \"cateogry\": [\r\n"
					+ "        {\r\n"
					+ "         \"cateogryValue\": \"gaming\"\r\n"
					+ "        \r\n"
					+ "\r\n"
					+ "        }\r\n"
					+ "    ]   \r\n"
					+ "        \r\n"
					+ "    \r\n"
					+ "}")).andExpect(MockMvcResultMatchers.status().isOk()). 
                              andDo(MockMvcResultHandlers.print());
	 
	}
	@Test
	void deleteAllCampaignTest() throws Exception {
		List<String> listOfState = Arrays.asList("active");
		List<String> listOfChannel = Arrays.asList("sms");
		List<String> listOfCategory = Arrays.asList("gaming");
		Campaign campaign = new Campaign(1, "shah", "22-07-2021", "30-07-2021", listOfState, listOfChannel, 100,
				listOfCategory);
    Mockito.when(campaignService.DeleteNewAllCampaign()).thenReturn(null);
    mockMvc.perform(MockMvcRequestBuilders.delete("/campaign").
			contentType(MediaType.APPLICATION_JSON).content("{\r\n"
					+ "    \"id\": 1,\r\n"
					+ "    \"name\": \"shah\",\r\n"
					+ "    \"start_date\" : \"22-07-2021\",\r\n"
					+ "    \"end_date\": \"30-07-2021\",\r\n"
					+ "    \"state\" : [\r\n"
					+ "        {     \r\n"
					+ "            \"stateValue\": \"active\"\r\n"
					+ "          \r\n"
					+ "        }\r\n"
					+ "    ]   ,\r\n"
					+ "    \"channel\": [\r\n"
					+ "        {\r\n"
					+ "         \"channelValue\": \"sms\"\r\n"
					+ "        }\r\n"
					+ "    ], \r\n"
					+ "    \"price\": 100,\r\n"
					+ "    \"cateogry\": [\r\n"
					+ "        {\r\n"
					+ "         \"cateogryValue\": \"gaming\"\r\n"
					+ "        \r\n"
					+ "\r\n"
					+ "        }\r\n"
					+ "    ]   \r\n"
					+ "        \r\n"
					+ "    \r\n"
					+ "}")).andExpect(MockMvcResultMatchers.status().isOk()). 
                              andDo(MockMvcResultHandlers.print());
	 
	}
	
}