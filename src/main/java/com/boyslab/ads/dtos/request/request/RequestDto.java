package com.boyslab.ads.dtos.request.request;

import com.boyslab.ads.entities.Category;
import com.boyslab.ads.entities.Request;
import com.boyslab.ads.entities.enums.Status;

public record RequestDto(
        String tc,
        String name,
        String surname,
        int birthDay,
        String description,
        String phone,
        String city,
        String district,
        String neighbourhood,
        String street,
        String locationDescription,
        Status status,
        int categoryId
        ) {
    public static Request convertToEntity(RequestDto dto){
        Category category = new Category();
        category.setId(dto.categoryId);
        Request request = new Request();
        request.setName(dto.name);
        request.setDescription(dto.description);
        request.setCity(dto.city);
        request.setDistrict(dto.district);
        request.setPhone(dto.phone);
        request.setBirthDay(dto.birthDay);
        request.setSurname(dto.surname);
        request.setNeighbourhood(dto.neighbourhood);
        request.setStreet(dto.street);
        request.setStatus(dto.status);
        request.setCategory(category);
        request.setLocationDescription(dto.locationDescription);
        request.setTc(dto.tc);

        return request;

    }

}
