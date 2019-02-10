package biz.cogitare.service;

import biz.cogitare.dto.PassengerDto;
import biz.cogitare.model.PassengerModel;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PassengerService {

    void createPassenger(PassengerDto passengerDto);
    List<PassengerDto> convertToPassengerDtos(List<PassengerModel> passengerModels);
    List<PassengerModel> convertToPassengerModels(List<PassengerDto> passengerDtos);

}
