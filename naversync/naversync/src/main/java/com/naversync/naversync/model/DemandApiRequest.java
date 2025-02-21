package com.naversync.naversync.model;

import lombok.Data;

import java.util.List;

@Data
public class DemandApiRequest
{
    private  String created;
    private  String status;
    private  List<Long> reservation_Id;
    private  String travel_purpose;
    private  String currency;
    private  List<String> orders;

    public DemandApiRequest(String created, String status, List<Long> reservation_Id, String travel_purpose, String currency, List<String> orders) {
        this.created = created;
        this.status = status;
        this.reservation_Id = reservation_Id;
        this.travel_purpose = travel_purpose;
        this.currency = currency;
        this.orders = orders;

    }


}
