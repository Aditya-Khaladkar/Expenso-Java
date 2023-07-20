package com.example.expenso.util;

import android.content.Context;
import android.view.View;

import androidx.room.Room;

import com.example.expenso.db.MyExpenseDb;

public class DatabaseService {
    public MyExpenseDb initDb(Context context) {
        return Room
                .databaseBuilder(context, MyExpenseDb.class, "expenseDb")
                .build();
    }
}
