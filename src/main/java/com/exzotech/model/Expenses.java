package com.exzotech.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expenses extends Transaction {

    public Expenses(String description, BigDecimal amount, LocalDate date, String category ){

        super(description, amount, date, category);

    }


}
