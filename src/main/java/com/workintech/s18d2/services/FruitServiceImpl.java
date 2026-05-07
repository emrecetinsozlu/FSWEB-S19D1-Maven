package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }


    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public Fruit getById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new PlantException("Meyve bulunamadı",HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> searchByName(String name) {

        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit delete(Long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isEmpty()) {
            throw new PlantException("Meyve bulunamadı " + fruitOptional.get().getName(), HttpStatus.NOT_FOUND);
        }
        fruitRepository.delete(fruitOptional.get());
        return fruitOptional.get();
    }
}
