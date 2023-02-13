package com.teamdex.teamdex.repository.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.reset;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.teamdex.teamdex.entity.DemoModel;
import com.teamdex.teamdex.repository.DemoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DemoRepositoryTest {

	@MockBean
	private DemoRepository demoRepository;
	private List<DemoModel> demoModel;

	@BeforeEach
	public void setup() {

		Long sentiId = 91L;
		List<DemoModel> demoModel = new ArrayList<>();

		DemoModel senti = new DemoModel();
		senti.setId(sentiId);
		senti.setArtist_name("Moira");
		senti.setArtist_genre("Melenyal");
		senti.setAlbums_recorded(4);
		senti.setUsername("sawi@gmail.com");

		demoModel.add(senti);

		Mockito.when(demoRepository.findAll()).thenReturn(demoModel);

	}

	@AfterEach
	void teardown() {

		reset(demoRepository);
	}

	@Test
	public void FindAllArtistsInDatabase() {

		OngoingStubbing<List<DemoModel>> result = Mockito.when(demoRepository.findAll()).thenReturn(demoModel);

		assertNotNull(result);

	}

}
