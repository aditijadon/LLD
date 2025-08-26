package com.example.design.licious.controller;

import com.example.interview.service.ICache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private ICache cache;

    @GetMapping(path="/{key}")
    public int get(@PathVariable final int key){
        return cache.get(key);
    }

    @PutMapping(path = "/{key}")
    public void put(@PathVariable int key, @RequestParam final int value){
        cache.put(key, value);
    }
}
