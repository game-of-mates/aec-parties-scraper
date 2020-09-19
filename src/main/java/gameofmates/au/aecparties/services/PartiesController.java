package gameofmates.au.aecparties.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import aec.gov.au.model.Party;
import gameofmates.au.aecparties.providers.RemoteAecPoliticalPartiesService;

@RestController
public class PartiesController {
	
	  private final RemoteAecPoliticalPartiesService serviceCallout;
	
	  PartiesController(RemoteAecPoliticalPartiesService service ) {
		    this.serviceCallout = service;
		  }

	  @GetMapping("/parties")
	  List<Party> all() {
		  
	    return serviceCallout.getParties().getParties();
	  }
}
