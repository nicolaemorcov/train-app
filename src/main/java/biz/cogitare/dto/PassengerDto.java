package biz.cogitare.dto;

import biz.cogitare.controller.ValidationUtils;
import biz.cogitare.model.PassengerModel;

import java.io.Serializable;

public final class PassengerDto implements Serializable {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final AddressDto addressDto;

    public PassengerDto(String id, String firstName, String lastName, int age, AddressDto addressDto) {
        this.id = ValidationUtils.isNotNullAndNotEmpty(id, "passenger ID should not be empty");
        this.firstName = ValidationUtils.isNotNullAndNotEmpty(firstName, "firstName should not be empty");
        this.lastName = ValidationUtils.isNotNullAndNotEmpty(lastName, "lastName should not be empty");
        this.age = ValidationUtils.checkMinValue(age, 10, "You must be minimum 10 Years old");
        this.addressDto = ValidationUtils.isNotNull(addressDto, "Address should not be empty");
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }


    @Override
    public String toString() {
        return "PassengerModel{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }





}
