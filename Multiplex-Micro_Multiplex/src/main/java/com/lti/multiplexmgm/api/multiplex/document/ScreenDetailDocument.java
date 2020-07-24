package com.lti.multiplexmgm.api.multiplex.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDetailDocument {
	
	@Id
	private String screenId;
	private String multiplex;
	private String screensize;
	private String totalNoSeats;
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	public String getMultiplex() {
		return multiplex;
	}
	public void setMultiplex(String multiplex) {
		this.multiplex = multiplex;
	}
	public String getScreensize() {
		return screensize;
	}
	public void setScreensize(String screensize) {
		this.screensize = screensize;
	}
	public String getTotalNoSeats() {
		return totalNoSeats;
	}
	public void setTotalNoSeats(String totalNoSeats) {
		this.totalNoSeats = totalNoSeats;
	}
	
}
