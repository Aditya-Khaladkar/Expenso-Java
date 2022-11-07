package com.example.expenso.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.expenso.MainActivity;
import com.example.expenso.R;
import com.example.expenso.db.MyExpenseDao;
import com.example.expenso.db.MyExpenseDb;
import com.example.expenso.model.ExpenseModel;
import com.example.expenso.util.DatabaseService;

public class AddExpense extends AppCompatActivity {
    EditText ed_expenseName, ed_expensePrice, ed_expenseDescription;
    CalendarView calendarView;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        final MyExpenseDb myExpenseDb = new DatabaseService().initDb(this);
        final MyExpenseDao myExpenseDao = myExpenseDb.myExpenseDao();

        ed_expenseName = findViewById(R.id.ed_expenseName);
        ed_expensePrice = findViewById(R.id.ed_expensePrice);
        ed_expenseDescription = findViewById(R.id.ed_expenseDescription);
        calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                date = day + " / " + month + " / "+ year;
            }
        });

        findViewById(R.id.btn_addExpense).setOnClickListener(view -> {
            

            new Thread(new Runnable() {
                @Override
                public void run() {
                    ExpenseModel myExpense = new ExpenseModel();
                }
            }).start();

        });
    }
}