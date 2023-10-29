package com.drnavalhabarbershop.resourceserver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequest {

    private String orderID;
    private String clientName;
    private String clientID;
    private String barberName;
    private String barberID;
    private String orderTitle;
    private String date;
    private String hour;
}
