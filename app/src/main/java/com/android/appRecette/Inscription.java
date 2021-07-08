package com.android.appRecette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Inscription extends AppCompatActivity {
    EditText pseudo, password , mail;
    Button validerIns;
    DBHelper madb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        pseudo = (EditText)findViewById(R.id.pseudo);
        mail = (EditText)findViewById(R.id.mail);
        password = (EditText)findViewById(R.id.password);
        validerIns = (Button)findViewById(R.id.validerIns);





        madb = new DBHelper(this);
        validerIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String pseudoe = pseudo.getText().toString();
                String maile = mail.getText().toString();
                String  passworde = password.getText().toString();

                if ( pseudoe.equals("") || maile.equals("") || passworde.equals("")) {
                    Toast.makeText(Inscription.this, "Veuillez remplir l'intégralité des champs ", Toast.LENGTH_LONG).show();
                }
                else{
                    Boolean verifPseudoMail = madb.checkpseudoMail(pseudoe ,maile);
                    if(verifPseudoMail == false)
                    {
                        Boolean ajoutDonnée = madb.insertData(pseudoe,maile,passworde);
                        if(ajoutDonnée == true){
                            Toast.makeText(Inscription.this, "Ajout réussie", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(Inscription.this, Connexion.class);
                            startActivity(intent);
                        }

                        else{
                            Toast.makeText(Inscription.this, "echec d'ajout", Toast.LENGTH_LONG).show();

                        }
                    }else{
                        Toast.makeText(Inscription.this, "l'utilisateur existe déja ", Toast.LENGTH_LONG).show();

                    }
                }



            }


        });

    }
}



