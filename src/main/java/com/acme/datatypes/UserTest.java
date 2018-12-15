package com.acme.datatypes;

import com.acme.datatypes.User;
// the old namespace mentioned in the original tutorial is outdated
//import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import java.io.File;
import java.net.URL;
import java.io.IOException;

public class UserTest {
  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    File jsonFile = new File("user.json");
    URL jsonUrl = new URL("https://gist.githubusercontent.com/SafwenBensaid/9b88d16b46a67fe793d46bd7ba28218c/raw/45b72e10ff6ddd06ee759e85bc472078c9f7667f/person.json");
    String jsonStr = 
      "{\"name\":{\"first\":\"Joe\",\"last\":\"Sixpack\"},\"gender\":\"MALE\",\"verified\":false,\"userImage\":\"Rm9vYmFyIQ==\"}";
    User user = null;

    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

    // IMPORTANT
    // without this option set adding new fields breaks old code
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    user = mapper.readValue(jsonFile, User.class);
    System.out.println(user.getName().getFirst());

    user = mapper.readValue(jsonUrl, User.class);
    System.out.println(user.getName().getLast());

    user = mapper.readValue(jsonStr, User.class);
    System.out.println(user.getGender());
  }
}
