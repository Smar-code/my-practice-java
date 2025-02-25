package com.naversync.naversync.integration;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.testng.IConfigurable;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
@SpringBootTest
public class NaverSyncIntegrationTest {

   @Autowired
   private KafkaTemplate<String, String> kafkaTemplate;

    private WireMockServer wireMockServer;

    @BeforeEach
    public void setup() {
        wireMockServer = new WireMockServer(8081);
        wireMockServer.start();

        configureFor("localhost", 8081);
        stubFor(post(urlEqualTo("http://localhost:8081")).
                willReturn(aResponse().withStatus(200)));
    }

    @AfterEach
    public void teardown() {
        wireMockServer.stop();
    }

    @Test
    public void testSync() {

        String  testMessage = "{" + "\"affiliatedId\": \"1234\" ,"+
                " \"bookingDate\": \"2025-02-23\" ,"+
                "\"bookingStatus\": \"CONFIRMED\" }" + "}";

        kafkaTemplate.send("sync_topic", testMessage);
        verify(postRequestedFor(urlEqualTo("http://localhost:8080")));
    }
}
