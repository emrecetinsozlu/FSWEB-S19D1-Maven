package com.workintech.s18d2.controller;


import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {
    private final VegetableService vegetableService;
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping()
    public List<Vegetable> getVegetables() {
        return vegetableService.getPriceAsc();
    }
    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }
    @GetMapping("/desc")
    public List<Vegetable> getAllDesc() {
        return vegetableService.getPriceDesc();
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> getVegetablesByName(@RequestParam String name) {
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id) {
        return vegetableService.delete(id);
    }

}
