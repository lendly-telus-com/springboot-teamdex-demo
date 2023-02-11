package com.teamdex.teamdex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamdex.teamdex.entity.DemoModel;
import com.teamdex.teamdex.exception.ArtistsNotFoundException;
import com.teamdex.teamdex.repository.DemoRepository;

@Service
public class DemoService {

	@Autowired
	private DemoRepository demoRepository;

	public DemoService(DemoRepository mockRepo) {

	}

	public List<DemoModel> findall() {
		return demoRepository.findAll();
	}

	public Optional<DemoModel> saveModel(DemoModel demoModel) {
		demoRepository.save(demoModel);
		return demoRepository.findById(demoModel.getId());

	}

	public void deleteArtists(Long id) {
		demoRepository.deleteById(id);

	}

	public DemoModel updateArtistsById(Long id, DemoModel demoModel) {

		DemoModel oldArtists = demoRepository.findById(id)
				.orElseThrow(() -> new ArtistsNotFoundException("Artists with id " + id + " not found "));
		oldArtists.setAlbums_recorded(demoModel.getAlbums_recorded());
		oldArtists.setArtist_genre(demoModel.getArtist_genre());
		oldArtists.setArtist_name(demoModel.getArtist_name());
		oldArtists.setUsername(demoModel.getUsername());
		demoRepository.save(oldArtists);
		return oldArtists;
	}

}
