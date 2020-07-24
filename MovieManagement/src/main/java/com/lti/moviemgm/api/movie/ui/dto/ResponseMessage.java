package com.lti.moviemgm.api.movie.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
	
	private String messageType; // success/failure
	private String message;

}
