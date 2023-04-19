package com.example.practico6android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsrName;
    private EditText etPsw;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsrName = findViewById(R.id.edit_text_username);
        etPsw = findViewById(R.id.edit_text_password);
        btLogin = findViewById(R.id.button_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsrName.getText().toString();
                String contrasenia = etPsw.getText().toString();

                if (isValidCredentials(usuario, contrasenia)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isValidCredentials(String usuario, String contrasenia
    ) {
        return usuario.equals("1") && contrasenia.equals("1");
    }
}
