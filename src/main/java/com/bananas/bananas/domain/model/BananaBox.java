package com.bananas.bananas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BananaBox implements Serializable {
    private int qtd;
    private BananaType bananaType;
    private String id;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public BananaType getBananaType() {
        return bananaType;
    }

    public void setBananaType(BananaType bananaType) {
        this.bananaType = bananaType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BananaBox{" +
                "qtd=" + qtd +
                ", bananaType=" + bananaType +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BananaBox bananaBox = (BananaBox) o;

        return id.equals(bananaBox.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
