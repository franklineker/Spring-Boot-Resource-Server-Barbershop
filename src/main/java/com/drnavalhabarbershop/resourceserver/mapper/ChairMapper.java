package com.drnavalhabarbershop.resourceserver.mapper;

import br.com.drnavalha.web.dto.ChairRequest;
import com.drnavalhabarbershop.resourceserver.domain.Chair;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChairMapper {

    public static Chair toChair(ChairRequest request) {
        return request != null ? Chair
                .builder()
                .barberID(request.getBarberID())
                .barberName(request.getBarberName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build() : null;
        }
}
