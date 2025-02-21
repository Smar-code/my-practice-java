package com.naversync.naversync.service;

import com.naversync.naversync.model.DemandApiRequest;
import com.naversync.naversync.model.NaverSyncResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.openapitools.client.model.OdersDetailsAccommodationsOutput;
import org.openapitools.client.model.OrdersDetailsAccommodationsRequest;

@Service
public class NaverMappingService
{
  @Autowired
    private NotificationReceiveService notificationReceiveService;

    private NaverSyncResponse naverSyncResponse;

    protected NaverSyncResponse prepareNaverSyncDetails(DemandApiRequest input)
    {
      OdersDetailsAccommodationsOutput detailsAccommodationsOutput =
              detailsAccommodations(input);
      naverSyncResponse = buildNaverSync(detailsAccommodationsOutput);
      return naverSyncResponse;

    }

  protected NaverSyncResponse buildNaverSync(org.openapitools.client.model.OdersDetailsAccommodationsOutput detailsAccommodationsOutput) {
      return new NaverSyncResponse.Builder()
              .affiliateId(123456L)
              .checkInDate(detailsAccommodationsOutput.getData().get(1).getCheckin().toString())
              .build();
  }

  protected org.openapitools.client.model.OdersDetailsAccommodationsOutput detailsAccommodations(DemandApiRequest input)
  {
    org.openapitools.client.model.AccommodationsDetailsInputByReservations accommodationsDetailsInputByReservations =
            new org.openapitools.client.model.AccommodationsDetailsInputByReservations();
    if(input.getCurrency() != null){
      accommodationsDetailsInputByReservations.setCurrency(input.getCurrency());
    }
    accommodationsDetailsInputByReservations.setReservations(input.getReservation_Id());
    OrdersDetailsAccommodationsRequest request = new OrdersDetailsAccommodationsRequest(accommodationsDetailsInputByReservations);
    try
    {
      return notificationReceiveService.callOrdersDetailsAccommodation(request);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
