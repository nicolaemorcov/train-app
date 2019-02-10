package biz.cogitare.service;

import biz.cogitare.dto.PassengerDto;
import biz.cogitare.model.PassengerModel;
import biz.cogitare.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }


    public PassengerDto convertToPassengerDto(PassengerModel passengerModel){
        PassengerDto passengerDto = new PassengerDto(
                passengerModel.getId(),
                passengerModel.getFirstName(),
                passengerModel.getLastName(),
                passengerModel.getAge(),
                passengerModel.getAddressModel().convertToAddressDto()

        );
        return passengerDto;
    }

    public PassengerModel convertToPassengerModel(PassengerDto passengerDto){
        PassengerModel passengerModel = new PassengerModel(
                passengerDto.getId(),
                passengerDto.getFirstName(),
                passengerDto.getLastName(),
                passengerDto.getAge(),
                passengerDto.getAddressDto().convertToAddressModel()
        );
        return  passengerModel;
    }

    public List<PassengerDto> convertToPassengerDtos(List<PassengerModel> passengerModels){
        List<PassengerDto> passengerDtos = new ArrayList<PassengerDto>();
        for(PassengerModel passengerModel : passengerModels){
            passengerDtos.add(convertToPassengerDto(passengerModel));
        }
        return passengerDtos;
    }

    public List<PassengerModel> convertToPassengerModels(List<PassengerDto> passengerDtos){
        List<PassengerModel> passengerModels = new ArrayList<PassengerModel>();
        for(PassengerDto passengerDto : passengerDtos){
            passengerModels.add(convertToPassengerModel(passengerDto));
        }
        return passengerModels;
    }




    @Override
    public void createPassenger(PassengerDto passengerDto) {
        passengerRepository.save(convertToPassengerModel(passengerDto));
    }
}
