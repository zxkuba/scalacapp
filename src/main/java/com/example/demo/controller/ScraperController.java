package com.example.demo.controller;

import com.example.demo.model.ResponseDTO;
import com.example.demo.service.ScraperService;
import com.example.demo.service.ScraperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/v1/joke")
public class ScraperController {

    @Autowired
    ScraperService scraperService;

    @GetMapping()
    public Set<ResponseDTO> getAllJokesFromWeb(){
        return scraperService.getJokes();
    }

}
