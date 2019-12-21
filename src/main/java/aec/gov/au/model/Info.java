package aec.gov.au.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {

  @JsonProperty("Title")
  private String title = null;

  @JsonProperty("GeneratedOn")
  private String generatedOn = null;


}
