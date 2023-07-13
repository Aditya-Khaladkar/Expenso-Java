package com.example.expenso.view.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.expenso.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    Button btnResetPassword;
    EditText passEmail;
    FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        firebaseAuth = FirebaseAuth.getInstance();

        btnResetPassword = findViewById(R.id.btnResetPassword);
        passEmail = findViewById(R.id.passEmail);

        btnResetPassword.setOnClickListener(v -> {

            resetPassword();

        });
    }

    private void resetPassword() {
        String email = passEmail.getText().toString();

        if (TextUtils.isEmpty(email)) {
            // Handle case when email is empty
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
        }

        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Password reset email sent successfully
                            Toast.makeText(ForgotPassword.this, "Password reset email sent", Toast.LENGTH_SHORT).show();
                        } else {
                            // Failed to send password reset email
                            Toast.makeText(ForgotPassword.this, "Failed to send password reset email", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}