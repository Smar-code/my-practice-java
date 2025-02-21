package com.naversync.naversync.service;

import com.naversync.naversync.model.DemandApiRequest;
import com.naversync.naversync.model.NaverSyncResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.openapitools.client.model.DataElement;
import org.openapitools.client.model.OdersDetailsAccommodationsOutput;
import org.openapitools.client.model.AccommodationsDetailsInputByReservations;
import org.openapitools.client.model.OrdersDetailsAccommodationsRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NaverMappingServiceTest {

    private NaverMappingService naverMappingService;

    @Mock
    private NotificationReceiveService notificationReceiveService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        naverMappingService = spy(new NaverMappingService());
     //  naverMappingService.notificationReceiveService = notificationReceiveService; // Inject mock dependency
    }

    @Test
    void testPrepareNaverSyncDetails() {

        // Arrange
        DemandApiRequest input = new DemandApiRequest(
                "2025-12-12","Booked",Arrays.asList(5434L),
                "Business","USD",Arrays.asList("876yui0987")
        );
        OdersDetailsAccommodationsOutput mockOutput = createMockOutput();
        NaverSyncResponse mockResponse = createMockResponse();

        doReturn(mockOutput).when(naverMappingService).detailsAccommodations(input);
        doReturn(mockResponse).when(naverMappingService).buildNaverSync(mockOutput);

        // Act
        NaverSyncResponse result = naverMappingService.prepareNaverSyncDetails(input);
        System.out.println(result);
        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(mockResponse, result, "Response should match the mocked result");
        verify(naverMappingService, times(1)).detailsAccommodations(input);
        verify(naverMappingService, times(1)).buildNaverSync(mockOutput);
    }

   /* @Test
    void testDetailsAccommodations_ValidInput() {
        // Arrange
        DemandApiRequest input = new DemandApiRequest();
        input.setCurrency("USD");
        input.setReservation_Id("12345");

        OrdersDetailsAccommodationsRequest request = new OrdersDetailsAccommodationsRequest();
        request.setAccommodationsDetailsInputByReservations(new OrdersDetailsAccommodationsInputByReservations());

        OdersDetailsAccommodationsOutput mockOutput = createMockOutput();
        when(notificationReceiveService.callOrdersDetailsAccommodation(any(OrdersDetailsAccommodationsRequest.class)))
                .thenReturn(mockOutput);

        // Act
        OdersDetailsAccommodationsOutput result = naverMappingService.detailsAccommodations(input);

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(mockOutput, result, "Result should match the mocked output");
        verify(notificationReceiveService, times(1)).callOrdersDetailsAccommodation(any(OrdersDetailsAccommodationsRequest.class));
    }
*/
    @Test
    void testBuildNaverSync() {
        // Arrange
        OdersDetailsAccommodationsOutput mockOutput = createMockOutput();

        // Act
        NaverSyncResponse result = new NaverSyncResponse.Builder()
                .affiliateId(123456L)
                .checkInDate(mockOutput.getData().get(1).getCheckin().toString())
                .build();

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(123456L, result.getAffiliateId(), "AffiliateId should be the expected value");
        assertEquals("2023-12-01", result.getCheckInDate(), "CheckInDate should match the mocked value");
    }

    // Mocking helper for OdersDetailsAccommodationsOutput
    private OdersDetailsAccommodationsOutput createMockOutput() {
        OdersDetailsAccommodationsOutput output = new OdersDetailsAccommodationsOutput();

        org.openapitools.client.model.OrdersDetailsDataAccommodationsOutput data1 = new org.openapitools.client.model.OrdersDetailsDataAccommodationsOutput();

        data1.setCheckin(LocalDate.parse("2023-11-30"));

        org.openapitools.client.model.OrdersDetailsDataAccommodationsOutput data2 = new org.openapitools.client.model.OrdersDetailsDataAccommodationsOutput();
        data2.setCheckin(LocalDate.parse("2023-12-01"));

        List<org.openapitools.client.model.OrdersDetailsDataAccommodationsOutput> dataList = new ArrayList<>();
        dataList.add(data1);
        dataList.add(data2);

        output.setData(dataList);
        return output;
    }

    // Mocking helper for NaverSyncResponse
    private NaverSyncResponse createMockResponse() {
        return new NaverSyncResponse.Builder()
                .affiliateId(123456L)
                .checkInDate("2023-12-01")
                .build();
    }
}