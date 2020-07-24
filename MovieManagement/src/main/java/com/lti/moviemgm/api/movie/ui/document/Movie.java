package com.lti.moviemgm.api.movie.ui.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "movies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String name;
	private String category;
	private String producer;
	private String director;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate releaseDate;

}
