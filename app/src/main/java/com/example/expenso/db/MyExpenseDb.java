package com.example.expenso.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.expenso.model.ExpenseModel;

@Database(
        entities = {
                ExpenseModel.class
        },
        version = 1
)
public abstract class MyExpenseDb extends RoomDatabase {
    public abstract MyExpenseDao myExpenseDao();
}