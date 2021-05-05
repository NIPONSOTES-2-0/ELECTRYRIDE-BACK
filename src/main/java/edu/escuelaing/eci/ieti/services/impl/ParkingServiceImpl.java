package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.Parking;
import edu.escuelaing.eci.ieti.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import edu.escuelaing.eci.ieti.services.ParkingService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ParkingServiceImpl implements ParkingService{

    @Autowired
    private ParkingRepository parkingRepository;


    @Override
    public List<Parking> getParkings(){
        return parkingRepository.findAll();
    }

    @Override
    public void rentedBike(String id){
        //log.info(mongoOps.findOne(new Query(where("name").is("Joe")), Person.class));
        //parkingRepository.updateFirst(query(where("id").is(id)), update("bikes_aviable", 1000), Parking.class);
        Parking parking = findParkingBydId(id);
        System.out.println("\n PARKING FORMATEADO: "+parking+" \n");
        if(parking != null){
            //Esta variable puede cambiar dependiendo si dejamos que un usuario alquile mas de una bici al tiempo
            int bikesRented = 1;
            int actualBikes = parking.getBikes_aviables();
            if((actualBikes-bikesRented>=0) && (bikesRented>0)){
                parking.setBikes_aviables(actualBikes-bikesRented);
                parkingRepository.save(parking);
            }

        }
    }

    @Override
    public Parking findParkingBydId(String id){

        Optional<Parking> optionalParking = parkingRepository.findById(id);
        System.out.println("\n Parking OPTIONAL: "+optionalParking+" \n");
        Parking parking=null;        
        if(!optionalParking.isEmpty()){        
            parking = optionalParking.get();
        }
        return parking;
    }

}
