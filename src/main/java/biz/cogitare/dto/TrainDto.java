package biz.cogitare.dto;

import biz.cogitare.controller.ValidationUtils;
import biz.cogitare.model.TrainModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public final class TrainDto implements Serializable {



    private final String id;
    private final String origin;
    private final String destination;
    private final LocalDateTime scheduledTimeDeparture;
    private final List<PassengerDto> passengerDtos;
    private final List<String> stationList;
//    private final LocalDateTime createTime;


    public TrainDto(String id, String origin, String destination, LocalDateTime scheduledTimeDeparture, List<PassengerDto> passengerDtos, List<String> stationList) {
        this.id = ValidationUtils.isNotNullAndNotEmpty(id, "Train ID must not be empty");
        this.origin = ValidationUtils.isNotNullAndNotEmpty(origin, "Origin  must not be empty");
        this.destination = ValidationUtils.isNotNullAndNotEmpty(destination, "Destination must not be empty");
        this.scheduledTimeDeparture = scheduledTimeDeparture;
        this.passengerDtos = ValidationUtils.isNotNullAndNotEmpty(passengerDtos, "Train must have at least one passenger");
        this.stationList = ValidationUtils.isNotNullAndNotEmpty(stationList, "Add all stations for the train");
    }

    public String getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getScheduledTimeDeparture() {
        return scheduledTimeDeparture;
    }

    public List<PassengerDto> getPassengerDtos() {
        return passengerDtos;
    }

    public List<String> getStationList() {
        return stationList;
    }

    @Override
    public String toString() {
        return "TrainDto{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", scheduledTimeDeparture=" + scheduledTimeDeparture +
                ", passengerDtos=" + passengerDtos +
                ", stationList=" + stationList +
                '}';
    }
}
