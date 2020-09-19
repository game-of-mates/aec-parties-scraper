package aec.gov.au.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisteredPartiesCollection {
  
  
  @JsonProperty("Info")
  private Info info = null;
  
  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  public List<Party> getParties() {
    return parties;
  }

  public void setParties(List<Party> parties) {
    this.parties = parties;
  }

  @JsonProperty("Details")
  private List<Party> parties;

}
