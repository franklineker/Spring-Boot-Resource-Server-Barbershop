package com.drnavalhabarbershop.resourceserver.mapper;

import br.com.drnavalha.enums.UserType;
import com.drnavalhabarbershop.resourceserver.domain.Barber;
import com.drnavalhabarbershop.resourceserver.web.dto.BarberRequest;
import com.drnavalhabarbershop.resourceserver.web.dto.BarberResponse;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;

@NoArgsConstructor
public class BarberMapper {

    public static Barber toBarber(BarberRequest request) {
        return request != null ? Barber
                .builder()
                .userType(UserType.ofCode(request.getUserType()))
                .person(request.getPerson())
                .about(request.getAbout())
                .rating(request.getRating())
                .createdDate(LocalDateTime.now())
                .build() : null;
    }

    public static BarberResponse toBarberResponse(Barber barber) {
        return BarberResponse.builder()
                .id(barber.getId())
                .person(barber.getPerson())
                .about(barber.getAbout())
                .rating(barber.getRating())
                .build();
    }

    public static BarberRequest toBarberRequest(Barber barber) throws IOException{



        return BarberRequest.builder()
                .id(barber.getId())
                .userType(barber.getUserType().getCode())
                .about(barber.getAbout())
                .rating(barber.getRating())
                .person(barber.getPerson())
                .profilePicture(barber.getProfilePicture())
                .build();
    }

}
