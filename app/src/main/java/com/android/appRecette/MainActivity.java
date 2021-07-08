package com.android.appRecette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static  final  String TAG = "MonMainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






            }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    //  super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_app,menu);

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_inscription) {

            Intent intent = new Intent(MainActivity.this, Inscription.class);
            startActivity(intent);
            Toast.makeText(this, "Inscrivez vous => " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_connexion) {

            Intent intent = new Intent(MainActivity.this, Connexion.class);
            startActivity(intent);
            Toast.makeText(this, "Connexion time => " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_profil)  {

            Intent PagePro = new Intent(MainActivity.this, Profil.class);
            startActivity(PagePro);
           Toast.makeText(this, "espace profil => " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;

        }else {
            return false;
        }
    }

       /*switch (item.getItemId()) {

            case R.id.menu_inscription:


               Toast.makeText(this, "Inscrivez vous => " + item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent PageInsc = new Intent(MainActivity.this, Inscription.class);
                startActivity(PageInsc)

              return true;

            case R.id.menu_connexion:
            menu_connexion();
                    Intent PageCo = new Intent(MainActivity.this, Connexion.class);
                        startActivity(PageCo);*

               Toast.makeText(this, "connecter vous => " + item.getTitle(), Toast.LENGTH_SHORT).show();

                return true;

            case R.id.menu_profil:

              Intent PagePro = new Intent(MainActivity.this, Profil.class);
                startActivity(PagePro);
                Toast.makeText(this, "Inscrivez vous => " + item.getTitle(), Toast.LENGTH_SHORT).show();
               return true;
           return super.onOptionsItemSelected(item);

        }*/




    }






