package com.drnavalhabarbershop.resourceserver.mapper;

import com.drnavalhabarbershop.resourceserver.domain.Chair;
import com.drnavalhabarbershop.resourceserver.web.dto.ChairRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChairMapper {

    public static Chair toChair(ChairRequest request) {
        return request != null ? Chair
                .builder()
                .barberName(request.getBarberName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build() : null;
        }
}
