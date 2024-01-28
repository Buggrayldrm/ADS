package com.boyslab.ads.dtos.request.reportingDebris;

import com.boyslab.ads.entities.ReportingDebris;
public record AddReportingDebrisDSto(
        String phoneNumber,
        String imageUrl,
        String city,
        String district,
        String neighbourhood,
        String street,
        String locationDescription,
        Boolean ekipVarMı
) {
    public static ReportingDebris convertToEntity(AddReportingDebrisDSto dto){

        ReportingDebris reportingDebris=new ReportingDebris();
        reportingDebris.setPhoneNumber(dto.phoneNumber);
        reportingDebris.setImage(dto.imageUrl);
        reportingDebris.setCity(dto.city);
        reportingDebris.setDistrict(dto.district);
        reportingDebris.setNeighbourhood(dto.neighbourhood);
        reportingDebris.setStreet(dto.street);
        reportingDebris.setLocationDescription(dto.locationDescription);
        reportingDebris.setEkipVarMı(dto.ekipVarMı);


        return reportingDebris;
    }
}