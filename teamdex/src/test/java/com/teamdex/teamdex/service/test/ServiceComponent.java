package com.teamdex.teamdex.service.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.teamdex.teamdex.repository.DemoRepository;
import com.teamdex.teamdex.service.DemoService;

@RunWith(MockitoJUnitRunner.class)
public class ServiceComponent {

	private DemoService service;

	@Mock
	private DemoRepository mockRepo;

	@Before
	public void init() {
		service = new DemoService(mockRepo);
	}

	@Test
	public void shouldInteractWithRateFinderToFindBestRate() {
		service.findall();
		verify(mockRepo, times(1)).findAll();
	}

}
