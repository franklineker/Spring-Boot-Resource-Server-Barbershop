package com.drnavalhabarbershop.resourceserver.web.dto;

import com.drnavalhabarbershop.resourceserver.domain.Barber;
import com.drnavalhabarbershop.resourceserver.domain.Client;
import com.drnavalhabarbershop.resourceserver.domain.Order;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AppointmentResponse {

    private String clientName;
    private String barberName;
    private String orderTitle;
    private String date;
    private String hour;
//    private Barber barber;
//    private Client client;
//    private Order order;
//    private Date date;
}
