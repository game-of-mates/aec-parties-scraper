package gameofmates.au.aecparties.providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aec.gov.au.model.RegisteredPartiesCollection;

@Service
public class RemoteAecPoliticalPartiesService {

	private static final Logger logger = LoggerFactory.getLogger(RemoteAecPoliticalPartiesService.class);

	private final RestTemplate aecPartiesTemplate;

	@Value("${au.gameofmates.parties.url}")
	private String au_gameofmates_parties_url;

	public RemoteAecPoliticalPartiesService(RestTemplateBuilder restBuilder) {
		this.aecPartiesTemplate = restBuilder.build();
	}

	/**
	 * Return a list of political parties.
	 * 
	 * @return list of parties.
	 */
	public RegisteredPartiesCollection getParties() {
		logger.info("Entry");

		RegisteredPartiesCollection a = aecPartiesTemplate.getForObject(au_gameofmates_parties_url, RegisteredPartiesCollection.class);
		return a;
	}

}
