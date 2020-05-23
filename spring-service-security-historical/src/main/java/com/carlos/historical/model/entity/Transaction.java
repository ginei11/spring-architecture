package com.carlos.historical.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction")
public class Transaction {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getAccontId() {
        return accontId;
    }

    public void setAccontId(int accontId) {
        this.accontId = accontId;
    }

    private String id;
    private double amount;
    private String type;
    private String creationDate;
    private int accontId;
}
