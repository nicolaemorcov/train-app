package biz.cogitare.service;

import biz.cogitare.dto.PassengerDto;
import biz.cogitare.dto.TrainDto;
import biz.cogitare.model.PassengerModel;
import biz.cogitare.model.TrainModel;
import biz.cogitare.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public final class TrainServiceImpl implements TrainService {

    private TrainRepository trainRepository;
    private PassengerService passengerService;

    @Autowired
    public TrainServiceImpl(TrainRepository trainRepository, PassengerService passengerService) {
        this.trainRepository = trainRepository;
        this.passengerService = passengerService;
    }

    private TrainModel convertToTrainModel(TrainDto trainDto){
        TrainModel trainModel = new TrainModel(
                trainDto.getId(),
                trainDto.getOrigin(),
                trainDto.getDestination(),
                trainDto.getScheduledTimeDeparture(),
                passengerService
                    .convertToPassengerModels(trainDto.getPassengerDtos()),
                trainDto.getStationList()
        );
        return trainModel;
    }

    public TrainDto converToTrainDto(TrainModel trainModel){
        TrainDto trainDto = new TrainDto(
                trainModel.getId(),
                trainModel.getOrigin(),
                trainModel.getDestination(),
                trainModel.getScheduledTimeDeparture(),
                passengerService
                        .convertToPassengerDtos(trainModel.getPassengerModels()),
                trainModel.getStationList()
        );
        return trainDto;
    }




    @Override
    public TrainDto getTrainById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        TrainModel trainModel = trainRepository.getTrainById(id);
        TrainDto trainDto = converToTrainDto(trainModel);
        trainRepository.
        return trainDto;
    }

    @Override
    public void createTrain(TrainDto trainDto) {
        trainRepository.save(convertToTrainModel(trainDto));
    }




}
