package com.rms.ratemanagementservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.ratemanagementservice.helper.RatemanagementDTO;
import com.rms.ratemanagementservice.model.Rate;
import com.rms.ratemanagementservice.repo.RatemanagementRepository;
import com.rms.ratemanagementservice.service.RateManagementService;

@RunWith(SpringRunner.class)
@WebMvcTest(RateManagementController.class)
public class RateManagementControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private RateManagementService rateService;
	
	@MockBean
	private RatemanagementRepository rateManagementRepo;
	
	protected static RatemanagementDTO ratemanagementDTO;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public static final String UUID = "{uuid}";
	
	public static final String COMMON_URL = "/surcharge/v1/rate";
	
	@Before
	public void setUp() {
		ratemanagementDTO = new RatemanagementDTO();
	}
	
	@Test
	public void testOkForAddRate() throws Exception {
		Mockito.when(rateManagementRepo.save(any(Rate.class))).thenReturn(ratemanagementDTO.randomRequest().get());
		StringBuilder uriBuilder = new StringBuilder().append(COMMON_URL);
		URI uri = new URI(uriBuilder.toString().replace(UUID, String.valueOf(ratemanagementDTO.generateRate())));
		ResultActions mvcResult = mockMvc.perform(post(uri).content(objectMapper.writeValueAsString(ratemanagementDTO.randomRequest().get()))
				.contentType(MediaType.APPLICATION_JSON));
		assertThat(mvcResult).isNotNull();
		mvcResult.andExpect(status().isCreated());
	}
	
	@Test
	public void testFailureForAddRate() throws Exception {
		StringBuilder uriBuilder = new StringBuilder().append(COMMON_URL);
		URI uri = new URI(uriBuilder.toString().replace(UUID, String.valueOf(ratemanagementDTO.generateRate())));
		ResultActions mvcResult = mockMvc.perform(post(uri).content(objectMapper.writeValueAsString(ratemanagementDTO.randomRequest().get()))
				.contentType(MediaType.APPLICATION_JSON));
		assertThat(mvcResult).isNotNull();
		mvcResult.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testOkGetRate() throws Exception {
		Mockito.when(rateService.getRate(any(Long.class))).thenReturn(ratemanagementDTO.randomRequest());
		StringBuilder uriBuilder = new StringBuilder().append(COMMON_URL);
		URI uri = new URI(uriBuilder.toString().replace(UUID, String.valueOf(ratemanagementDTO.randomRequest().get())));
		ResultActions mvcResult = mockMvc.perform(get((uri)));
		assertThat(mvcResult).isNotNull();
		mvcResult.andExpect(status().isOk());
	}
	
	@Test
	public void testFailureGetRate() throws Exception {
		Mockito.when(rateService.getRate(any(Long.class))).thenReturn(ratemanagementDTO.randomRequest());
		StringBuilder uriBuilder = new StringBuilder().append(COMMON_URL);
		URI uri = new URI(uriBuilder.toString().replace("", String.valueOf(ratemanagementDTO.generateRate())));
		ResultActions mvcResult = mockMvc.perform(get((uri)));
		assertThat(mvcResult).isNotNull();
		mvcResult.andExpect(status().isBadRequest());
	}
	
	
}
