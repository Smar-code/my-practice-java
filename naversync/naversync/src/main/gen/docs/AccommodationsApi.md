# AccommodationsApi

All URIs are relative to *https://demandapi.booking.com/3.1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**accommodationsAvailability**](AccommodationsApi.md#accommodationsAvailability) | **POST** /accommodations/availability | Get a property&#39;s availability |


<a id="accommodationsAvailability"></a>
# **accommodationsAvailability**
> AccommodationsAvailabilityOutput accommodationsAvailability(accommodationsAvailabilityInput)

Get a property&#39;s availability

use this endpoint to return details product availability,price changes of the accommodation matching a given search criteria.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AccommodationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://demandapi.booking.com/3.1");

    AccommodationsApi apiInstance = new AccommodationsApi(defaultClient);
    AccommodationsAvailabilityInput accommodationsAvailabilityInput = new AccommodationsAvailabilityInput(); // AccommodationsAvailabilityInput | 
    try {
      AccommodationsAvailabilityOutput result = apiInstance.accommodationsAvailability(accommodationsAvailabilityInput);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccommodationsApi#accommodationsAvailability");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **accommodationsAvailabilityInput** | [**AccommodationsAvailabilityInput**](AccommodationsAvailabilityInput.md)|  | [optional] |

### Return type

[**AccommodationsAvailabilityOutput**](AccommodationsAvailabilityOutput.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |

