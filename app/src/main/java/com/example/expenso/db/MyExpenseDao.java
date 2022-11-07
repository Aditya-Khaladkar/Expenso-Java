package com.example.expenso.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.expenso.model.ExpenseModel;

import java.util.List;

@Dao
public interface MyExpenseDao {

    @Query("SELECT * FROM my_expense")
    List<ExpenseModel> getAllExpense();

    @Insert
    void insertExpense(ExpenseModel myExpense);

    @Query("SELECT sum(price) FROM my_expense")
    int getAllPrice();
}