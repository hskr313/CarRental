package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.PricingClass;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PricingClassAddForm {

    private int price_km;

    private int fine_day;

    public PricingClass toBLL(){
        return PricingClass.builder()
                .price_km(price_km)
                .fine_day(fine_day)
                .build();
    }
}
