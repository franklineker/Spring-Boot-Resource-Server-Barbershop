package com.drnavalhabarbershop.resourceserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "chairs")
public class Chair {

    @Id
    private String id;
    private String barberID;
    private String barberName;
    private String startDate;
    private String endDate;
}
