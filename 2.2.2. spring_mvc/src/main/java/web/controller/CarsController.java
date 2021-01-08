package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(
            @RequestParam(value = "count", required = false) Integer count, ModelMap model) {

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("model1", 1, "owner1"));
        cars.add(new Car("model2", 2, "owner2"));
        cars.add(new Car("model3", 3, "owner3"));
        cars.add(new Car("model4", 4, "owner4"));
        cars.add(new Car("model5", 5, "owner5"));

        model.addAttribute("cars", carService.getCars(cars, count));

        return "cars";
    }

}
