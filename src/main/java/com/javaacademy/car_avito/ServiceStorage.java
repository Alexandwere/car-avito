package com.javaacademy.car_avito;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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

    public List<Advert> findAdvert(String brand, String color, BigDecimal price) {
        return data.values().stream()
                .filter(advert -> ((brand == null) || ((brand == null) && advert.getBrand() == null)
                        || advert.getBrand().equalsIgnoreCase(brand))
                        && ((color == null) || ((color == null) && advert.getColor() == null)
                        || advert.getColor().equalsIgnoreCase(color))
                        && ((price == null) || ((price == null) && advert.getPrice() == null)
                        || advert.getPrice().equals(price)))
                .toList();
    }

}
