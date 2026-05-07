package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VegetableServiceImpl implements VegetableService {
    private final VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }


    @Override
    public List<Vegetable> getPriceAsc() {
        return vegetableRepository.getVegetableAsc();
    }

    @Override
    public Vegetable getById(Long id) {
        return vegetableRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vegetable> getPriceDesc() {
        return vegetableRepository.getVegetableDesc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable delete(Long id) {
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        vegetableRepository.delete(vegetable.get());
        return vegetable.get();
    }
}
