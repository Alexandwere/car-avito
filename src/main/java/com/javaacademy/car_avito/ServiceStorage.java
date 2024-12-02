package com.javaacademy.car_avito;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ServiceStorage {
    private final Map<Integer, Advert> data = new HashMap<>();
    private int count = 0;

    public void save(Advert advert) {
        count++;
        advert.setId(count);
        data.put(count, advert);
    }

    public List<Advert> getAll() {
        return data.values().stream().toList();
    }

    public Optional<Advert> getById(Integer id) {
        return Optional.ofNullable(data.get(id));
    }

    public boolean deleteById(Integer id) {
        return data.remove(id) != null;
    }
    
}
