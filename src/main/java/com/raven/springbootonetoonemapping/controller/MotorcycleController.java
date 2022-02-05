package com.raven.springbootonetoonemapping.controller;

import com.raven.springbootonetoonemapping.entiry.Motorcycle;
import com.raven.springbootonetoonemapping.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/motorcycle")
public class MotorcycleController {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    // TO SAVE
    @PostMapping("/saveMotorcycle")
    public Motorcycle saveMotorcycle(@RequestBody Motorcycle motorcycle) {
        System.out.println("Motorcycle save called...");
        Motorcycle outMotorcycle = motorcycleRepository.save(motorcycle);
        System.out.println("Saved Motorcycle :: " + outMotorcycle);

        return outMotorcycle;
    }

    // TO GET
    @GetMapping("/getMotorcycle/{id}")
    public Optional<Motorcycle> getMotorcycle(@PathVariable String id) {
        System.out.println("Motorcycle get() called...");
        Optional<Motorcycle> outMotorcycle = motorcycleRepository.findById(Integer.valueOf(id));
        System.out.println("Motorcycle with Engine :: " + outMotorcycle);

        return outMotorcycle;
    }
}
