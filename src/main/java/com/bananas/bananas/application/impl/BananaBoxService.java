package com.bananas.bananas.application.impl;

import com.bananas.bananas.domain.model.BananaBox;
import com.bananas.bananas.domain.model.BananaBoxValidator;
import com.bananas.bananas.domain.model.BananaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BananaBoxService implements BananaBoxFacade {

    private BananaRepository bananaBoxRepository;
    private BananaBoxValidator bananaBoxValidator;

    @Autowired
    public BananaBoxService(BananaRepository repository, BananaBoxValidator validator) {
        this.bananaBoxRepository = repository;
        this.bananaBoxValidator = validator;
    }

    @Override
    public void save(BananaBox box) {
        bananaBoxValidator.checkRules(box);
        bananaBoxRepository.save(box);
    }

    @Override
    public BananaBox findById(String id) {
        return bananaBoxRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        bananaBoxRepository.remove(id);
    }

    @Override
    public void updateAll(BananaBox box, String id) {
        bananaBoxRepository.updateAll(box, id);
    }

}
