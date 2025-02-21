# OrdersApi

All URIs are relative to *https://demandapi.booking.com/3.1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**ordersDetailsAccommodations**](OrdersApi.md#ordersDetailsAccommodations) | **POST** /orders/details/accommodations | list accommodation for orders |


<a id="ordersDetailsAccommodations"></a>
# **ordersDetailsAccommodations**
> OdersDetailsAccommodationsOutput ordersDetailsAccommodations(ordersDetailsAccommodationsRequest)

list accommodation for orders

 The endpoint return all info

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://demandapi.booking.com/3.1");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    OrdersDetailsAccommodationsRequest ordersDetailsAccommodationsRequest = new OrdersDetailsAccommodationsRequest(); // OrdersDetailsAccommodationsRequest | 
    try {
      OdersDetailsAccommodationsOutput result = apiInstance.ordersDetailsAccommodations(ordersDetailsAccommodationsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#ordersDetailsAccommodations");
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
| **ordersDetailsAccommodationsRequest** | [**OrdersDetailsAccommodationsRequest**](OrdersDetailsAccommodationsRequest.md)|  | [optional] |

### Return type

[**OdersDetailsAccommodationsOutput**](OdersDetailsAccommodationsOutput.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | succesful response. |  -  |

