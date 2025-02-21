package com.naversync.naversync.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.openapitools.client.model.OdersDetailsAccommodationsOutput;
import org.openapitools.client.model.OrdersDetailsAccommodationsRequest;
import org.json.JSONObject;

import java.io.IOException;

@Service
public class NotificationReceiveService
{
    @Autowired
    private ObjectMapper objectMapper;

    private static final String ORDER_DETAILS_ACCOMMODATION_API_URL = "http://localhost:8081/api/downstream";
    private final OkHttpClient httpClient = new OkHttpClient();
    static com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
    static{
        mapper.setPropertyNamingStrategy(
                com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE);
        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public OdersDetailsAccommodationsOutput callOrdersDetailsAccommodation(OrdersDetailsAccommodationsRequest accommodationsRequest) throws IOException {
        // Convert the accommodationsRequest object to JSON using ObjectMapper
        String requestBodyJson = objectMapper.writeValueAsString(accommodationsRequest);

        // Create the request body with the serialized JSON
        RequestBody body = RequestBody.create(requestBodyJson, MediaType.parse("application/json"));

        // Build the HTTP POST request
        Request request = new Request.Builder()
                .url(ORDER_DETAILS_ACCOMMODATION_API_URL)
                .post(body)
                .build();

        // Make the call and handle the response
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Failed request with HTTP status: " + response.code());
            } else {
                // Deserialize the response body into OdersDetailsAccommodationsOutput using ObjectMapper
                return objectMapper.readValue(response.body().string(), OdersDetailsAccommodationsOutput.class);
            }
        }
    }

    /*public OdersDetailsAccommodationsOutput callOrdersDetailsAccommodation(OrdersDetailsAccommodationsRequest accommodationsRequest) throws IOException {
        OdersDetailsAccommodationsOutput detailsAccommodationsOutput = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put( "accommodations", accommodationsRequest);
        RequestBody body = RequestBody.create(jsonObject.toString(),  MediaType.parse("application/json"));

        Request  request = new Request.Builder().url(ORDER_DETAILS_ACCOMMODATION_API_URL).post(body).build();
        try(Response response = httpClient.newCall(request).execute()) {
            if(response.isSuccessful()) {
                throw  new RuntimeException();
            }else {
                return objectMapper.readValue(response.body().string(), OdersDetailsAccommodationsOutput.class);
            }

        }
    }*/
}
