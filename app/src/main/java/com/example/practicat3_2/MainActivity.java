package com.example.practicat3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {




    ListView lista;

    String[][] datos = {
            {"Dragon Ball Z", "Marruffo Marrukito", "23:49", "9", "Goku y sus amigos salvan al mundo"},
            {"Naruto", "Adolf Hitler", "25:17", "7", "Naruto salva a la aldea de la hoja y se convierte en el heroe del pueblo."},
            {"Cowboy Bepop", "Luis Fernando Castro", "26:01", "8", "El vaquero espacial en busca de nuevas aventuras acompañado de su fiel Spike"},
            {"Plastic memories", "Ricardo Mendoza", "28:12", "7", "Un anime sentimental que te hará vibrar y estallar de emoción desde el primer momento"},
            {"Full Metal Alchemist", "Dana Flores", "31:48", "9", "Fullmetal Alchemist, también conocida como Full Metal Alchemist, FMA o Hagaren, abreviatura en japonés es una serie de manga escrita e ilustrada por Hiromu Arakawa. Su primera adaptación al anime fue dirigida por Seiji Mizushima y la segunda por Yasuhiro Irie"},
            {"SNK","Renato Coronel", "28:01", "8", "Shingeki no Kyojin, también conocida en países de habla hispana como Ataque a los titanes y Ataque de los titanes, \u200B\u200B es una serie de manga japonesa escrita e ilustrada por Hajime Isayama."}
    };



    int[] datosImg = {R.drawable.battle_game, R.drawable.castlevania, R.drawable.devilman_crybaby, R.drawable.la_eyenda_de_korra, R.drawable.parasyte, R.drawable.super_once};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lista=(ListView) findViewById(R.id.lvLista);

        lista.setAdapter(new Adaptador(this,datos,datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesPelicula.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][4]);
                startActivity(visorDetalles);
            }
        });

       /*
        FloatingActionButton Favorito=(FloatingActionButton) findViewById(R.id.Favorito);
        Favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Se añadio a Favoritos",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();
            }
        });*/
    }
}