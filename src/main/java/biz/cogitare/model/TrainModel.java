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
//    private final LocalDateTime createTime;


    public TrainModel(String id, String origin, String destination, LocalDateTime scheduledTimeDeparture, List<PassengerModel> passengerModels) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.scheduledTimeDeparture = scheduledTimeDeparture;
        this.passengerModels = ValidationUtils.isNotNullAndNotEmpty(passengerModels, "Train must have at least one passenger");
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


    @Override
    public String toString() {
        return "TrainModel{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", scheduledTimeDeparture=" + scheduledTimeDeparture +
                ", passengerModels=" + passengerModels +
                '}';
    }
}
