package aec.gov.au.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Party {
  
  @JsonProperty("id")
  private String id;
  
  @JsonProperty("nameOfParty")
  private String name;
  
  @JsonProperty("branches")
  private List<Party> branches;
}
