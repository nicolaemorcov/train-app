package biz.cogitare.model;

import biz.cogitare.controller.ValidationUtils;
import biz.cogitare.dto.TrainDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "train")
public final class TrainModel {
    @Id
    private final String id;
    private final String origin;
    private final String destination;
    private final LocalDateTime scheduledTimeDeparture;
    private final List<PassengerModel> passengerModels;
    private final List<String> stationList;
//    private final LocalDateTime createTime;


    public TrainModel(String id, String origin, String destination, LocalDateTime scheduledTimeDeparture, List<PassengerModel> passengerModels, List<String> stationList) {
        this.id = ValidationUtils.isNotNullAndNotEmpty(id, "Train ID must not be empty");
        this.origin = ValidationUtils.isNotNullAndNotEmpty(origin, "Origin  must not be empty");
        this.destination = ValidationUtils.isNotNullAndNotEmpty(destination, "Destination must not be empty");
        this.scheduledTimeDeparture = scheduledTimeDeparture;
        this.passengerModels = ValidationUtils.isNotNullAndNotEmpty(passengerModels, "Train must have at least one passenger");
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

    public List<PassengerModel> getPassengerModels() {
        return passengerModels;
    }

    public List<String> getStationList() {
        return stationList;
    }

    @Override
    public String toString() {
        return "TrainModel{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", scheduledTimeDeparture=" + scheduledTimeDeparture +
                ", passengerModels=" + passengerModels +
                ", stationList=" + stationList +
                '}';
    }
}
