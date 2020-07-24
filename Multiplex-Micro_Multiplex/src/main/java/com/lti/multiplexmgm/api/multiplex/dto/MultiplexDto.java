package com.lti.multiplexmgm.api.multiplex.dto;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MultiplexDto {
	
	@Id
	private String multiplexId;
	private String name;
	private String location;
	private int numberOfScreens;

}
