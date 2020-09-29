# neilpiper.me Java archetype

Java project template for setting up quickly travis-ci, github.


To speed up creation locally set your environment variables, these are encrypted for the `.travis.yml` file.


```
export AWS_ACCESS_KEY_ID=[Your_AWS_Access_Key]
export AWS_SECRET_KEY=[Your_AWS_Secret_Key]
export GITPW=[Your GIT OAuth]
export DOCKER_USERNAME=[Your Dockerhub user]
export DOCKER_PASSWORD=[Your Dockerhub password]
```

Pseudo-code
* Connect to AEC
* Format Info into the JSON Schema for AU Political party
* Augment any futher data from other sources
* Post messages into the Graph Vertex Queue for Parties, People
* Validate Addresses
* Post messages into Graph relationships of Officers of Parties
  ** Officer (Role title / Capacity)
  ** Deputy Officer

SOURCE:

https://www.aec.gov.au/parties_and_representatives/party_registration/Registered_parties/Parties_and_Representatives/Party_Registration/Registered_parties/files/register-2019-11-22.json



Github - User or Organisation Repository.

The attribute `githubOrg` is used for creation against the correct repository.


After setting up the environment variables, Initialise your git repository then run the setup script.

```
git init
./gitsetup.sh
```




```
curl -u 'npiper' https://api.github.com/user/repos -d '{"name":"aec-parties-scraper"}
git init
gitsetup.sh	
```


```
curl -u 'npiper' https://api.github.com/orgs/game-of-mates/repos -d '{"name":"aec-parties-scraper"}
git init
gitsetup.sh	
```

# References

https://spring.io/guides/gs/messaging-rabbitmq/

https://hub.docker.com/_/rabbitmq

https://github.com/sanchigoyal/spring-mysql-rabbitmq-docker-example

Rabbit MQ (Static config)
https://medium.com/@thomasdecaux/deploy-rabbitmq-with-docker-static-configuration-23ad39cdbf39
