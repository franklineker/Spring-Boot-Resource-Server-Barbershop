package com.drnavalhabarbershop.resourceserver.web.dto;

import com.drnavalhabarbershop.resourceserver.domain.Barber;
import com.drnavalhabarbershop.resourceserver.domain.Client;
import com.drnavalhabarbershop.resourceserver.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
//    private Barber barber;
//    private Client client;
//    private Order order;
//    private Date date;
}
