package aec.gov.au.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {

	@JsonProperty("Title")
	private String title = null;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGeneratedOn() {
		return generatedOn;
	}

	public void setGeneratedOn(String generatedOn) {
		this.generatedOn = generatedOn;
	}

	@JsonProperty("GeneratedOn")
	private String generatedOn = null;

}
