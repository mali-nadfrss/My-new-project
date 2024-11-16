package com.mali.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class OAuth {

  public static String requestAccessToken() throws JsonProcessingException {

    // Create a RestTemplate to describe the request
    RestTemplate restTemplate = new RestTemplate();

    // Specify the http headers that we want to attach to the request
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.add("Authorization", "no Auth");

    // Create a map of the key/value pairs that we want to supply in the body of the request
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add(
        "client_id",
        "3MVG94YrNIs0WS4dZr0NGpcoVY3W7x8BPEtwHaK2siiKNrZ3uNHUF9Uhigb86DznsFlN4DAWTe4sxBSz4KXPr");
    map.add("username", "admin@sparepalli664.pd");
    map.add("password", "Newgate#123JnGoHsppeXZghcMWB0aqIOog2");
    map.add("grant_type", "password");
    map.add("client_secret", "85AF73034A124B5FCED4E15F122876A18D796DDACA125CF7496D81E018A0EADA");

    // Create an HttpEntity object, wrapping the body and headers of the request
    HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

    // Execute the request, as a POSt, and expecting a TokenResponse object in return
    ResponseEntity<String> response =
        restTemplate.exchange(
            "https://login.salesforce.com/services/oauth2/token",
            HttpMethod.POST,
            entity,
            String.class);
    if (response.getStatusCode().equals(HttpStatus.OK)) {
      Map<String, Object> res = new ObjectMapper().readValue(response.getBody(), HashMap.class);
      return response.getBody();
    } else {
      throw new RuntimeException("exception occurred while requetsing access token");
    }
  }

  public static void main(String[] args) throws JsonProcessingException {
    requestAccessToken();
  }
}
