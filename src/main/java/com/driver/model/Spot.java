package com.driver.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private SpotType spotType;
    private int pricePerHour;
    private boolean occupied ;
    public int getPricePerHour() {
        return pricePerHour;
    }
    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    @ManyToOne
    @JoinColumn
    private ParkingLot parkingLot;
    @OneToMany(mappedBy = "spot",cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();
    public Spot(){}
    public void setId(int id) {
        this.id = id;
    }
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }
    public List<Reservation> getReservationList() {
        return reservationList;
    }
    public int getId() {
        return id;
    }
    public ParkingLot getParkingLot() {
        return parkingLot;
    }
    public SpotType getSpotType() {
        return spotType;
    }
    public boolean getOccupied(){
        return occupied;
    }
    public Spot(int pricePerHouse, boolean occupied, SpotType spotType){
        setOccupied(occupied);
        setSpotType(spotType);
        setPricePerHour(pricePerHouse);
    }
}