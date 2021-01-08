package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {

    @Override
    public List<Car> getCars(List<Car> cars, Integer count) {
        if (count != null) {
           if (count > 0 && count < 5) {
               return cars.stream().limit(count).collect(Collectors.toList());
           } else {
               return cars;
           }
        } else {
            return cars;
        }
    }
}
