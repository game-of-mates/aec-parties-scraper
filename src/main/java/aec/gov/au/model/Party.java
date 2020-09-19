package aec.gov.au.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Party {
  
  @JsonProperty("id")
  private String id;
  
  @JsonProperty("nameOfParty")
  private String name;
  
  @JsonProperty("partyRegisterDate")
  private String partyRegisterDate;
  
  @JsonProperty("abbreviation")
  private String abbreviation;
  
  @JsonProperty("logoDataUri")
  private String logoDataUri;
  
  @JsonProperty("branches")
  private List<Party> branches;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPartyRegisterDate() {
    return partyRegisterDate;
  }

  public void setPartyRegisterDate(String partyRegisterDate) {
    this.partyRegisterDate = partyRegisterDate;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public String getLogoDataUri() {
    return logoDataUri;
  }

  public void setLogoDataUri(String logoDataUri) {
    this.logoDataUri = logoDataUri;
  }

  public List<Party> getBranches() {
    return branches;
  }

  public void setBranches(List<Party> branches) {
    this.branches = branches;
  }
}
