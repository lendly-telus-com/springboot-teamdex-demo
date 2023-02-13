package com.teamdex.teamdex.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.reset;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.teamdex.teamdex.entity.DemoModel;
import com.teamdex.teamdex.repository.DemoRepository;
import com.teamdex.teamdex.service.DemoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

	@Autowired
	private DemoService service;

	@MockBean
	private DemoRepository demoRepository;

	@BeforeEach
	public void setup() {

		Long alternativeArtistsId = 23L;
		Long sentiId = 91L;
		List<DemoModel> demoModel = new ArrayList<>();

		DemoModel alternativeArtists = new DemoModel();
		alternativeArtists.setId(alternativeArtistsId);
		alternativeArtists.setArtist_name("Parokya");
		alternativeArtists.setArtist_genre("90's");
		alternativeArtists.setAlbums_recorded(8);
		alternativeArtists.setUsername("mangjose@gmail.com");

		DemoModel senti = new DemoModel();
		senti.setId(sentiId);
		senti.setArtist_name("Moira");
		senti.setArtist_genre("Melenyal");
		senti.setAlbums_recorded(4);
		senti.setUsername("sawi@gmail.com");

		demoModel.add(alternativeArtists);
		demoModel.add(senti);

		Mockito.when(demoRepository.findAll()).thenReturn(demoModel);

	}

	@AfterEach
	void teardown() {

		reset(demoRepository);
	}

	@Test
	public void FindAllArtists() {

		List<DemoModel> foundArtists = service.findall();

		assertNotNull(foundArtists);
		assertEquals(2, foundArtists.size());

	}

	@Test
	public void DeleteArtistById() {

		service.deleteArtists(23L);

		Mockito.verify(demoRepository, Mockito.times(1)).deleteById(23L);
	}

}
