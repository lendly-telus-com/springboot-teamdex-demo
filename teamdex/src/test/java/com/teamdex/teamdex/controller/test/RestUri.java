package com.teamdex.teamdex.controller.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.teamdex.teamdex.controller.DemoController;
import com.teamdex.teamdex.service.DemoService;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class RestUri {

	@MockBean
	private DemoService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void GetAll() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/v1/artists").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).andExpect(status().isOk()).andReturn();

	}

}
