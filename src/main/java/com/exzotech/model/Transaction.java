package com.exzotech.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Transaction {

    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private String category;

    protected Transaction (String description, BigDecimal amount, LocalDate date, String category){
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public String getDescription(){

        return description;
    }

    public BigDecimal getAmount(){

        return amount;
    }

    public LocalDate getDate(){

        return date;
    }

    public String getCategory(){

        return category;
    }
}
