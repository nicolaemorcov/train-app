package biz.cogitare.repository;

import biz.cogitare.model.PassengerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<PassengerModel, String> {

}
