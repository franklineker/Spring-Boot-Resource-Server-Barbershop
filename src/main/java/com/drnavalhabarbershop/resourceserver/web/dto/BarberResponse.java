package com.drnavalhabarbershop.resourceserver.web.dto;

import com.drnavalhabarbershop.resourceserver.domain.Person;
import lombok.Builder;
import lombok.Data;
import org.bson.types.Binary;

@Data
@Builder
public class BarberResponse {

    private String id;
    private Integer userType;
    private Person person;
    private String about;
    private Double rating;
    private Binary profilePicture;
}
