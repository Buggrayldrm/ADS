package com.boyslab.ads.dtos.response.reportingDebris;

import com.boyslab.ads.dtos.request.reportingDebris.ReportingDebrisDto;
import com.boyslab.ads.entities.ReportingDebris;

public record ReportingDebrisResponseDto(
        String id,
        String phoneNumber,
        String imageUrl,
        String city,
        String district,
        String neighbourhood,
        String street,
        String locationDescription,
        Boolean ekipVarMı
) {
    public static ReportingDebrisDto convertToDto(ReportingDebris reportingDebris){
        return new ReportingDebrisDto(
                reportingDebris.getId(),
                reportingDebris.getPhoneNumber(),
                reportingDebris.getImage(),
                reportingDebris.getCity(),
                reportingDebris.getDistrict(),
                reportingDebris.getNeighbourhood(),
                reportingDebris.getStreet(),
                reportingDebris.getLocationDescription(),
                reportingDebris.getEkipVarMı()
        );
    }
}
