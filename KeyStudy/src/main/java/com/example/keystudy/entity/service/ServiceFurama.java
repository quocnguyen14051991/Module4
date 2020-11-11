package com.example.keystudy.entity.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class ServiceFurama implements Validator {
    @Id
    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "service_area")
    private Integer serviceArea;

    @Column(name = "service_cost")
    private Double serviceCost;

    @Column(name = "service_max_people")
    private Integer serviceMaxPeople;

    @Column(name = "standard_room")
    private String standardRoom;

    @Column(name = "description_other_convenience")
    private String descriptionService;

    @Column(name = "pool_area")
    private Double poolArea;

    @Column(name = "number_of_floor")
    private String numberOfFloor;

    public ServiceFurama() {
    }

    public ServiceFurama(String serviceId, String serviceName, Integer serviceArea, Double serviceCost,
                         Integer serviceMaxPeople, String standardRoom, String descriptionService, Double poolArea, String numberOfFloor) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionService = descriptionService;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_type")
    private ServiceType serviceType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_type")
    private RentType rentType;


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceFurama serviceFurama = (ServiceFurama) target;
        String idService = serviceFurama.getServiceId();
        String numberOffFloor=serviceFurama.getNumberOfFloor();
        if(idService.equals(""))
        {
            errors.rejectValue("serviceId","service.id.empty");
        }
        if(!idService.matches("^DV-[\\d]{4}"))
        {
            errors.rejectValue("serviceId","service.id.valid");
        }
        if(numberOffFloor.equals(""))
        {
            errors.rejectValue("numberOfFloor","service.numberOfFloor.empty");
        }
        if(!numberOffFloor.matches("^[1-9][\\d]*$"))
        {
            errors.rejectValue("numberOfFloor","service.numberOfFloor.valid");
        }
    }
}
