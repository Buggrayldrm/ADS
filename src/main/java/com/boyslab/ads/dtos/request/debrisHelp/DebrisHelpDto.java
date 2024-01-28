package com.boyslab.ads.dtos.request.debrisHelp;


import com.boyslab.ads.entities.DebrisHelp;

public record DebrisHelpDto(
        int debrisID,

        String name,

        String surname,

        String city,

        String district,

        int numberOfTeam,

        String equipment,

        String description

) {

    public static DebrisHelp convertToEntity(DebrisHelpDto dto){

        DebrisHelp debrisHelp=new DebrisHelp();

        debrisHelp.setDebrisId(dto.debrisID);

        debrisHelp.setName(dto.name);

        debrisHelp.setSurname(dto.surname);

        debrisHelp.setCity(dto.city);

        debrisHelp.setDistrict(dto.district);

        debrisHelp.setNumberOfTeam(dto.numberOfTeam);

        debrisHelp.setEquipment(dto.equipment);

        debrisHelp.setDescription(dto.description);



        return debrisHelp;
    }


}