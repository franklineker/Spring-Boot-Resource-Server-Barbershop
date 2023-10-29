package com.drnavalhabarbershop.resourceserver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChairRequest {

    private String barberName;
    private String startDate;
    private String endDate;
}
