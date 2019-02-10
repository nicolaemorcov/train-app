package biz.cogitare.controller;

import biz.cogitare.dto.PassengerDto;
import biz.cogitare.service.PassengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/createPassenger", method = RequestMethod.POST)
    public void createPassenger(@RequestBody PassengerDto passengerDto){
        passengerService.createPassenger(passengerDto);
    }


}
