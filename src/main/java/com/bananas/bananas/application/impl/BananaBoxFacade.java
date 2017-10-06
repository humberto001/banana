package com.bananas.bananas.application.impl;

import com.bananas.bananas.domain.model.BananaBox;

public interface BananaBoxFacade {

    void save(BananaBox box);

    BananaBox findById(String id);

    void delete(String id);

    void updateAll(BananaBox box, String id);
}

