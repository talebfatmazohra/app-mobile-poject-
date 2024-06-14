package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginBtn;
    Button disconnectBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Récupération des références des éléments de la vue
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.RegisterButton);
        disconnectBtn = findViewById(R.id.disloginButton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin") ){
                    //afficher message de retour
                    Toast.makeText(MainActivity.this, "Connexion Reussit", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Echec de connexion Veuillez verifier le mot de passe ou le nom d'utilisateur", Toast.LENGTH_SHORT).show();
            }
        }
        ;
    })
;}
    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }}

 /*   private void startActivity(Intent intent) {

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Définition du comportement du bouton de connexion
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Vérification des identifiants
                if (validateCredentials(username, password)) {
                    // Connexion réussie, redirection vers une autre activité
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    // Connexion échouée, affichage d'un message d'erreur
                    Toast.makeText(LoginActivity.this, "Identifiants incorrects", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateCredentials(String username, String password) {
        // Logique de validation des identifiants (par exemple, comparaison avec une base de données)
        return username.equals("myusername") && password.equals("mypassword");
    }
}*/