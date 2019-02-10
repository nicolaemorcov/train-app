package biz.cogitare.controller;

import biz.cogitare.dto.PassengerDto;
import biz.cogitare.dto.TrainDto;
import biz.cogitare.model.TrainModel;
import biz.cogitare.repository.TrainRepository;
import biz.cogitare.service.TrainService;
import biz.cogitare.service.TrainServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public final class TrainController {

    TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody TrainDto getTrain(@PathVariable String id) {
        LOG.info("Getting train with ID: {}.", id);
        TrainDto train = trainService.getTrainById(id);
        LOG.info(train.toString());

        return train;
    }

    // can change on createOrUpdate ?
    @RequestMapping(value = "/createtrain", method = RequestMethod.POST)
    public void createTrain(@RequestBody TrainDto train){
        trainService.createTrain(train);
    }


    @RequestMapping(value = "/updatetrain", method = RequestMethod.POST)
    public void updateTrain(@RequestBody TrainDto train){
        trainService.createTrain(train);
    }





}
