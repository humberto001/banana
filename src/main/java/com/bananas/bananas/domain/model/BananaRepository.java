package com.bananas.bananas.domain.model;

public interface BananaRepository {

    void save(BananaBox box);

    BananaBox findById(String id);

    void remove(String id);

    void updateAll(BananaBox box, String id);

}
