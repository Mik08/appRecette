package com.android.appRecette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Connexion extends AppCompatActivity {
    EditText pseudo, password;
    Button validerCo;
    DBHelper madb;
    EditText mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


        pseudo = (EditText)findViewById(R.id.pseudo);
        mail = (EditText)findViewById(R.id.mail);
        password = (EditText)findViewById(R.id.password);
        validerCo = (Button)findViewById(R.id.validerCo);
        madb = new DBHelper(this);

        validerCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String maile = mail.getText().toString();
                String pseudoe = pseudo.getText().toString();
                String passworde = password.getText().toString();

                if (pseudoe.equals("") || passworde.equals("") || maile.equals("")) {
                    Toast.makeText(Connexion.this, "Veuillez remplir l'intégralité des champs avant de valider", Toast.LENGTH_LONG).show();
                } else {
                    Boolean resultatconnexion = madb.checkPseudoPassword(pseudoe, passworde);
                    if (resultatconnexion == true) {
                        Toast.makeText(Connexion.this, "Connexion reussie", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(Connexion.this, Profil.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Connexion.this, "Information erronée", Toast.LENGTH_LONG).show();

                    }
                }

            }

        });


    }
}
