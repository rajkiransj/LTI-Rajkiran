package com.lti.moviemgm.api.movie.ui.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieDto {
	
	
	private String name;
	private String category;
	private String producer;
	private String director;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate releaseDate;

}
