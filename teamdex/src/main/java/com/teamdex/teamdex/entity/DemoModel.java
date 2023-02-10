package com.teamdex.teamdex.entity;

import org.springframework.http.MediaType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table
public class DemoModel {

	public DemoModel() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String artist_name;

	private String artist_genre;

	private int albums_recorded;

	private String username;

	public DemoModel orElseThrow(Object object) {
		return null;
	}

	public DemoModel accept(MediaType applicationJsonUtf8) {
		// TODO Auto-generated method stub
		return null;
	}

}
