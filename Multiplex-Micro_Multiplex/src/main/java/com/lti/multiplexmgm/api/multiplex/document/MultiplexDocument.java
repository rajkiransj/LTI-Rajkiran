package com.lti.multiplexmgm.api.multiplex.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "multiplex")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MultiplexDocument {

	@Id
	private String multiplexId;
	private String name;
	private String location;
	// private List<String> screens;
	private String numberOfScreens;

}
