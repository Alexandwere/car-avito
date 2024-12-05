package com.javaacademy.car_avito;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/advert")
public class AdvertController {
    private final ServiceStorage serviceStorage;

    @PostMapping
    public void createAdvert(@RequestBody Advert advert) {
        serviceStorage.save(advert);
    }

    @GetMapping
    public List<Advert> getAll() {
        return serviceStorage.getAll();
    }

    @DeleteMapping("/{id}")
    public boolean deleteAdvert(@PathVariable Integer id) {
        return serviceStorage.deleteById(id);
    }

    @GetMapping("/{id}")
    public Advert getAdvertById(@PathVariable Integer id) {
        return serviceStorage.getById(id).orElseThrow();
    }

    @GetMapping("/search")
    public List<Advert> search(@RequestParam(required = false) String brand,
                               @RequestParam(required = false) String color,
                               @RequestParam(required = false) BigDecimal price) {
        return serviceStorage.findAdvert(brand, color, price);
    }

}
