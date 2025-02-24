# openapi-java-client

booking.com Demand API
- API version: 3.1
  - Build date: 2025-02-17T20:12:31.101197700+05:30[Asia/Calcutta]
  - Generator version: 7.7.0

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>3.1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'openapi-java-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'openapi-java-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "org.openapitools:openapi-java-client:3.1"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-3.1.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

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

## Documentation for API Endpoints

All URIs are relative to *https://demandapi.booking.com/3.1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccommodationsApi* | [**accommodationsAvailability**](docs/AccommodationsApi.md#accommodationsAvailability) | **POST** /accommodations/availability | Get a property&#39;s availability
*OrdersApi* | [**ordersDetailsAccommodations**](docs/OrdersApi.md#ordersDetailsAccommodations) | **POST** /orders/details/accommodations | list accommodation for orders


## Documentation for Models

 - [AccommodationsAvailabilityInput](docs/AccommodationsAvailabilityInput.md)
 - [AccommodationsAvailabilityOutput](docs/AccommodationsAvailabilityOutput.md)
 - [AccommodationsDetailsInputByOrders](docs/AccommodationsDetailsInputByOrders.md)
 - [AccommodationsDetailsInputByReservations](docs/AccommodationsDetailsInputByReservations.md)
 - [Booker](docs/Booker.md)
 - [OdersDetailsAccommodationsOutput](docs/OdersDetailsAccommodationsOutput.md)
 - [OrdersDetailsAccommodationsRequest](docs/OrdersDetailsAccommodationsRequest.md)
 - [OrdersDetailsDataAccommodationsOutput](docs/OrdersDetailsDataAccommodationsOutput.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization

Endpoints do not require authorization.


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



