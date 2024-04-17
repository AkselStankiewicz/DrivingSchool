package com.github.aksel.appSchool.service;

import com.github.aksel.appSchool.entity.CarEntity;
import com.github.aksel.appSchool.exception.exceptions.CarNotFoundException;
import com.github.aksel.appSchool.repository.CarEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarEntityRepository carRepository;

    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    public CarEntity addCar(CarEntity car) {
        return carRepository.save(car);
    }

    public CarEntity getCarById(Long id) {
        return carRepository.findCarEntityById(id).orElseThrow(CarNotFoundException::new);
    }

    public CarEntity updateCar(CarEntity car) {

        CarEntity entity = carRepository.findCarEntityById(car.getId()).orElseThrow(CarNotFoundException::new);

        entity.setBrand(car.getBrand());
        entity.setModel(car.getModel());
        entity.setPlates(car.getPlates());
        entity.setProdYear(car.getProdYear());
        entity.setLastMaintenanceMileage(car.getLastMaintenanceMileage());
        entity.setMileage(car.getMileage());
        entity.setTrainer(car.getTrainer());

        return carRepository.save(car);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

}
