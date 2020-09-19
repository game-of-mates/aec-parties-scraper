package gameofmates.au.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An AEC Registered political party, includes branches.
 */
@ApiModel(description = "An AEC Registered political party, includes branches.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-10T23:29:57.308Z")

public class AUParty {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("abbreviation")
	private String abbreviation = null;

	@JsonProperty("registrationDate")
	private LocalDate registrationDate = null;

	@JsonProperty("lastUpdated")
	private LocalDate lastUpdated = null;

	@JsonProperty("electionFundingPayments")
	private Boolean electionFundingPayments = null;

	@JsonProperty("logoURI")
	private String logoURI = null;

	@JsonProperty("webpage")
	private String webpage = null;

	@JsonProperty("branches")
	@Valid
	private List<AUParty> branches = null;

	public AUParty id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * URN identifier of the aec.gov.au Party
	 * 
	 * @return id
	 **/
	@ApiModelProperty(example = "urn:aec.gov.au:party:animaljusticeparty", value = "URN identifier of the aec.gov.au Party")

	@Pattern(regexp = "urn\\:aec.gov.au\\:party\\:[A-Z,a-z,0-9,#,!]*")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AUParty name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name Of Party
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "Animal Justice Party", value = "Name Of Party")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AUParty abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}

	/**
	 * Abbreviation used for the party
	 * 
	 * @return abbreviation
	 **/
	@ApiModelProperty(example = "AJP", value = "Abbreviation used for the party")

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public AUParty registrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
		return this;
	}

	/**
	 * AEC Registration date of the party
	 * 
	 * @return registrationDate
	 **/
	@ApiModelProperty(example = "1984-06-22", value = "AEC Registration date of the party")

	@Valid

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public AUParty lastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
		return this;
	}

	/**
	 * AEC modification to registration
	 * 
	 * @return lastUpdated
	 **/
	@ApiModelProperty(example = "2010-11-23", value = "AEC modification to registration")

	@Valid

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public AUParty electionFundingPayments(Boolean electionFundingPayments) {
		this.electionFundingPayments = electionFundingPayments;
		return this;
	}

	/**
	 * Does party currently receive AEC funding?
	 * 
	 * @return electionFundingPayments
	 **/
	@ApiModelProperty(example = "true", value = "Does party currently receive AEC funding?")

	public Boolean isElectionFundingPayments() {
		return electionFundingPayments;
	}

	public void setElectionFundingPayments(Boolean electionFundingPayments) {
		this.electionFundingPayments = electionFundingPayments;
	}

	public AUParty logoURI(String logoURI) {
		this.logoURI = logoURI;
		return this;
	}

	/**
	 * base64 encoded string of the Parties logo / image
	 * 
	 * @return logoURI
	 **/
	@ApiModelProperty(example = "data:image/jpeg;charset=utf-8;base64,/9", value = "base64 encoded string of the Parties logo / image")

	public String getLogoURI() {
		return logoURI;
	}

	public void setLogoURI(String logoURI) {
		this.logoURI = logoURI;
	}

	public AUParty webpage(String webpage) {
		this.webpage = webpage;
		return this;
	}

	/**
	 * URL of the parties page
	 * 
	 * @return webpage
	 **/
	@ApiModelProperty(example = "https://animaljusticeparty.org/", value = "URL of the parties page")

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public AUParty branches(List<AUParty> branches) {
		this.branches = branches;
		return this;
	}

	public AUParty addBranchesItem(AUParty branchesItem) {
		if (this.branches == null) {
			this.branches = new ArrayList<AUParty>();
		}
		this.branches.add(branchesItem);
		return this;
	}

	/**
	 * Branches of this party, such as State branches of a national party.
	 * 
	 * @return branches
	 **/
	@ApiModelProperty(value = "Branches of this party, such as State branches of a national party.")

	@Valid

	public List<AUParty> getBranches() {
		return branches;
	}

	public void setBranches(List<AUParty> branches) {
		this.branches = branches;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AUParty auParty = (AUParty) o;
		return Objects.equals(this.id, auParty.id) && Objects.equals(this.name, auParty.name)
				&& Objects.equals(this.abbreviation, auParty.abbreviation)
				&& Objects.equals(this.registrationDate, auParty.registrationDate)
				&& Objects.equals(this.lastUpdated, auParty.lastUpdated)
				&& Objects.equals(this.electionFundingPayments, auParty.electionFundingPayments)
				&& Objects.equals(this.logoURI, auParty.logoURI) && Objects.equals(this.webpage, auParty.webpage)
				&& Objects.equals(this.branches, auParty.branches);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, abbreviation, registrationDate, lastUpdated, electionFundingPayments, logoURI,
				webpage, branches);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AUParty {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
		sb.append("    registrationDate: ").append(toIndentedString(registrationDate)).append("\n");
		sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
		sb.append("    electionFundingPayments: ").append(toIndentedString(electionFundingPayments)).append("\n");
		sb.append("    logoURI: ").append(toIndentedString(logoURI)).append("\n");
		sb.append("    webpage: ").append(toIndentedString(webpage)).append("\n");
		sb.append("    branches: ").append(toIndentedString(branches)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
