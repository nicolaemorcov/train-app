package biz.cogitare.service;

import biz.cogitare.dto.PassengerDto;
import biz.cogitare.dto.TrainDto;
import biz.cogitare.model.TrainModel;


public interface TrainService {
    TrainDto getTrainById(String id);
    void createTrain(TrainDto trainDto);
}
