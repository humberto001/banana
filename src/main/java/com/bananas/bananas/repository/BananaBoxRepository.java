package com.bananas.bananas.repository;

import com.bananas.bananas.domain.model.BananaBox;
import com.bananas.bananas.domain.model.BananaRepository;
import com.bananas.bananas.domain.model.BananaType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class BananaBoxRepository implements BananaRepository {

    List <BananaBox> bananaBoxes = new ArrayList <>();

    @Override
    public String toString() {
        return "BananaRepository{" +
                "bananaBoxes=" + bananaBoxes +
                '}';
    }

    public void save(BananaBox box) {
        bananaBoxes.add(box);
        box.setId(UUID.randomUUID().toString().substring(0, 20));//gerando ID
    }

    public BananaBox findById(String id) {
        for (BananaBox box : bananaBoxes) {
            if (box.getId().equals(id))
                return box;
        }
        return null;
    }

    public void remove(String id) {
        Iterator <BananaBox> iterator = bananaBoxes.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                System.out.println(bananaBoxes.toString());
            }
        }
    }

    public void updateQtd(int qtd, String id) {
        for (BananaBox box : bananaBoxes) {
            if (box.equals(id)) {
                box.setQtd(qtd);
            }
        }
    }

    public void updateType(String id, BananaType bananaType) {
        for (BananaBox box : bananaBoxes) {
            if (box.getId().equals(id)) {
                box.setBananaType(bananaType);
            }
        }
    }

    public void updateAll(BananaBox bananaBox, String id) {
        for (BananaBox box : bananaBoxes) {
            if (box.getId().equals(bananaBox.getId())) {
                box.setBananaType(bananaBox.getBananaType());
                box.setQtd(bananaBox.getQtd());
            }
        }
    }
}
