package com.tahrirsquad.morsimeter.services;

import com.tahrirsquad.morsimeter.model.PromiseStats;
import com.tahrirsquad.morsimeter.repositories.PromiseRepository;
import org.springframework.stereotype.Service;

@Service
public class PromiseService {

    private PromiseRepository promiseRepository;

    public PromiseService(PromiseRepository promiseRepository) {
        this.promiseRepository = promiseRepository;
    }

    public PromiseStats calcTotalStats(){
        return PromiseStats.create(promiseRepository.findAll());
    }



}
