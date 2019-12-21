package aec.gov.au.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisteredPartiesCollection {
  
  
  @JsonProperty("Info")
  private Info info = null;
  
  @JsonProperty("Details")
  private List<Party> parties;

}
