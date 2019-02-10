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
//    private final LocalDateTime createTime;


    public TrainDto(String id, String origin, String destination, LocalDateTime scheduledTimeDeparture, List<PassengerDto> passengerDtos) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.scheduledTimeDeparture = scheduledTimeDeparture;
        this.passengerDtos = passengerDtos;
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

    @Override
    public String toString() {
        return "TrainDto{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", scheduledTimeDeparture=" + scheduledTimeDeparture +
                ", passengerDtos=" + passengerDtos +
                '}';
    }
}
