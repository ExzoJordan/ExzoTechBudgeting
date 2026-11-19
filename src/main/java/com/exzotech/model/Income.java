package com.exzotech.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Income extends Transaction {

    public Income(String description, BigDecimal amount, LocalDate date, String category) {

        super(description, amount, date, category);
    }


}
