package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.driver.model.*;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer>{

    Spot save(int parkingLotId, Integer numberOfWheels, Integer pricePerHour);

    Spot findById(int parkingLotId, int spotId, int pricePerHour);
}
