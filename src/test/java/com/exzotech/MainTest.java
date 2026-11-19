package com.exzotech;

import com.exzotech.model.Expenses;
import com.exzotech.model.Income;
import com.exzotech.service.TransactionService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    //Tests if empty list created returns 0
    @Test
    void getTotalIncomeEmptyListTest(){

        TransactionService transactionService = new TransactionService();

       assertEquals(BigDecimal.ZERO, transactionService.getTotalIncome() );
    }

    //Tests if income amount of object is correctly stored
    @Test
    void getIncomeWithIncomeTest(){

        TransactionService transactionService  = new TransactionService();
        Income income = new Income("Test Money", BigDecimal.valueOf(500), LocalDate.now(), "Test Category" );

        transactionService.addTransaction(income);

        assertEquals(BigDecimal.valueOf(500),transactionService.getTotalIncome() );
    }

    //Tests if expenses affect total income.
    @Test
    void getTotalIncomeWithExpensesTest(){

        TransactionService transactionService = new TransactionService();
        Expenses expenses = new Expenses("Test expense", BigDecimal.valueOf(150), LocalDate.now(), "Expense Test Category");

        transactionService.addTransaction(expenses);

        assertEquals(BigDecimal.ZERO, transactionService.getTotalIncome());

    }

    //Tests if empty list created returns 0
    @Test
    void getTotalExpensesEmptyListTest(){

        TransactionService transactionService = new TransactionService();

        assertEquals(BigDecimal.ZERO, transactionService.getTotalExpenses() );
    }

    //Tests if Expenses amount of object is correctly stored
    @Test
    void getExpensesWithExpensesTest(){

        TransactionService transactionService  = new TransactionService();
        Expenses expenses = new Expenses("Test Money", BigDecimal.valueOf(500), LocalDate.now(), "Test Category" );

        transactionService.addTransaction(expenses);

        assertEquals(BigDecimal.valueOf(500),transactionService.getTotalExpenses() );
    }

    //Tests if income affect total expenses.
    @Test
    void getTotalExpensesWithIncomeTest(){

        TransactionService transactionService = new TransactionService();
        Income income = new Income("Test expense", BigDecimal.valueOf(150), LocalDate.now(), "Expense Test Category");

        transactionService.addTransaction(income);

        assertEquals(BigDecimal.ZERO, transactionService.getTotalExpenses());

    }

    @Test
    void addTrasnactionTest(){

        TransactionService transactionService = new TransactionService();
        Income income  = new Income("Test expense", BigDecimal.valueOf(150), LocalDate.now(), "Expense Test Category");

        transactionService.addTransaction(income);

        assertEquals(1,transactionService.getAllTransactions().size());

    }

    @Test
    void removeTrasnactionTest(){

        TransactionService transactionService = new TransactionService();
        Income income  = new Income("Test expense", BigDecimal.valueOf(150), LocalDate.now(), "Expense Test Category");
        Expenses expenses = new Expenses("Test Money", BigDecimal.valueOf(500), LocalDate.now(), "Test Category" );

        transactionService.addTransaction(income);
        transactionService.addTransaction(expenses);

        assertTrue(transactionService.removeTransaction(income));
        assertTrue(transactionService.getAllTransactions().contains(expenses));
    }

    @Test
    void unsuccessfulRemoveTrasnactionTest(){

        TransactionService transactionService = new TransactionService();
        Income income  = new Income("Test expense", BigDecimal.valueOf(150), LocalDate.now(), "Expense Test Category");

        assertFalse(transactionService.removeTransaction(income));
        assertEquals(0,transactionService.getAllTransactions().size());
    }

    @Test
    void getAllTrasnactionsTest(){

        TransactionService transactionService = new TransactionService();
        Income income  = new Income("Test expense", BigDecimal.valueOf(150), LocalDate.now(), "Expense Test Category");
        Expenses expenses = new Expenses("Test Money", BigDecimal.valueOf(500), LocalDate.now(), "Test Category" );

        transactionService.addTransaction(income);
        transactionService.addTransaction(expenses);

        assertTrue(transactionService.getAllTransactions().contains(income));
        assertTrue(transactionService.getAllTransactions().contains(expenses));
        assertEquals(2,transactionService.getAllTransactions().size());
    }
}
