package com.exzotech.service;

import com.exzotech.model.Expenses;
import com.exzotech.model.Income;
import com.exzotech.model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private List<Transaction> transactionList = new ArrayList<Transaction>();

    public void addTransaction(Transaction transaction){

        transactionList.add(transaction);
    }

    public List<Transaction> getAllTransactions(){

        return transactionList;
    }

    public boolean removeTransaction(Transaction transaction){

        return transactionList.remove(transaction);
    }

    public BigDecimal getTotalIncome(){

        BigDecimal totalIncome = BigDecimal.valueOf(0);

        for (int i = 0; i < transactionList.size(); i++){

           if ( transactionList.get(i) instanceof Income){

               totalIncome = totalIncome.add(transactionList.get(i).getAmount());
           }
        }

        return totalIncome;
    }

    public BigDecimal getTotalExpenses(){

        BigDecimal totalExpenses = BigDecimal.valueOf(0);

        for (int i = 0; i < transactionList.size(); i++){

            if ( transactionList.get(i) instanceof Expenses){

                totalExpenses = totalExpenses.add(transactionList.get(i).getAmount());
            }
        }

        return totalExpenses;
    }
}
