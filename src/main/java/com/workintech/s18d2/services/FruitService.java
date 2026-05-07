package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;


// burda repodan veri çekme işlemini yapacak method signiture ları yazıyoruz

public interface FruitService {
    List<Fruit> getByPriceAsc();
    Fruit getById(Long id);
    List<Fruit> getByPriceDesc();
    Fruit save(Fruit fruit);
    List<Fruit> searchByName(String name);
    Fruit delete(Long id);
    // bu methodların implemantasyonunu imp sınıfı içerisinde repository yi kullanarak yapacağız
}
