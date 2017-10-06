package com.bananas.bananas;

import com.bananas.bananas.domain.model.BananaBox;
import com.bananas.bananas.domain.model.BananaType;
import com.bananas.bananas.repository.BananaBoxRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.bananas.bananas.domain.model.BananaType.NANICA;

@Configuration
public class BananaBoxConfiguration {

    @Bean
    public BananaBoxRepository config() {

        BananaBoxRepository bananaBoxes = new BananaBoxRepository();

        BananaBox bananaBox = new BananaBox();
        bananaBox.setBananaType(NANICA);
        bananaBox.setQtd(45);
        bananaBox.setId("1234");
        bananaBoxes.save(bananaBox);

        BananaBox bananaBox1 = new BananaBox();
        bananaBox1.setBananaType(BananaType.MACA);
        bananaBox1.setQtd(45);
        bananaBox1.setId("4567");
        bananaBoxes.save(bananaBox1);

        BananaBox bananaBox2 = new BananaBox();
        bananaBox2.setBananaType(BananaType.TERRA);
        bananaBox2.setQtd(45);
        bananaBox2.setId("890");
        bananaBoxes.save(bananaBox2);

        System.out.println(bananaBoxes.toString());

        return bananaBoxes;
    }

}
