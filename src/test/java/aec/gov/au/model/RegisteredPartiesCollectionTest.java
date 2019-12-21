package aec.gov.au.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=gameofmates.au.aecparties.AecScraperApplication.class)
@JsonTest
public class RegisteredPartiesCollectionTest {

  @Autowired
  private JacksonTester<RegisteredPartiesCollection> json;


  @Test
  public void deserializeJSON() throws IOException {


    ResourceLoader resourceLoader = new DefaultResourceLoader();
    Resource resource = resourceLoader.getResource("classpath:TEST-aec.gov.au-Registered_parties-2Parties-7Branches.json");

    String jsonString = RegisteredPartiesCollectionTest.asString(resource);
    

    ObjectContent<RegisteredPartiesCollection> parties = this.json.parse(jsonString);
    
    parties.getObject();

  }

  public static String asString(Resource resource) {
    try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
      return FileCopyUtils.copyToString(reader);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

}
