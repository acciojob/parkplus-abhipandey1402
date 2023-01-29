package com.driver.services.impl;

import com.driver.model.SpotType;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.driver.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
        ParkingLot parkingLot = parkingLotRepository1.save(name, address);
        return parkingLot;
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
        Spot spot = spotRepository1.save(parkingLotId, numberOfWheels, pricePerHour);
        return spot;
    }

    @Override
    public void deleteSpot(int spotId) {
        parkingLotRepository1.deleteById(spotId);
    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {
        Spot spot = spotRepository1.findById(parkingLotId, spotId, pricePerHour);
        ParkingLot parkingLot = spot.getParkingLot();


        parkingLot.setId(parkingLotId);
        spot.setParkingLot(parkingLot);
        spot.setId(spotId);
        spot.setPricePerHour(pricePerHour);

        Spot updatedSpot = spotRepository1.save(spot);
        return updatedSpot;
    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
        parkingLotRepository1.deleteById(parkingLotId);
    }
}
