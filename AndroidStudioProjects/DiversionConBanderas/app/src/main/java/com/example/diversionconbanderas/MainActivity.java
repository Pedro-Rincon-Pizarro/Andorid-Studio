package com.example.diversionconbanderas;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    Button btInicio, btFinal;
    ImageButton ibt1, ibt2;
    TextView txt1, txt2;
    MediaPlayer mpInicio, mpCorrecto, mpIncorrecto, mpAdios;
    List<Integer> usados = new ArrayList<>();

    int[] imagenes = {R.drawable.ad,R.drawable.ae,R.drawable.af,R.drawable.ag,R.drawable.al, R.drawable.am, R.drawable.ao, R.drawable.aq,R.drawable.ar,
            R.drawable.as,R.drawable.at,R.drawable.au,R.drawable.aw,R.drawable.ax, R.drawable.az, R.drawable.ba, R.drawable.bb, R.drawable.bd, R.drawable.be,
            R.drawable.bf,R.drawable.bg,R.drawable.bh,R.drawable.bi,R.drawable.bj, R.drawable.bl,R.drawable.bm,R.drawable.bn, R.drawable.bo, R.drawable.bq,
            R.drawable.br, R.drawable.bs, R.drawable.bt, R.drawable.bv,R.drawable.bw, R.drawable.by,R.drawable.bz, R.drawable.ca, R.drawable.cc,R.drawable.cd,
            R.drawable.cf, R.drawable.cg, R.drawable.ch, R.drawable.ci, R.drawable.ck, R.drawable.cl,R.drawable.cm, R.drawable.cn, R.drawable.co,R.drawable. cr,
            R.drawable.cu, R.drawable.cv, R.drawable.cw, R.drawable.cx, R.drawable.cy, R.drawable.cz, R.drawable.de, R.drawable.dj, R.drawable.dk, R.drawable.dm,
            R.drawable.dz, R.drawable.ec,R.drawable.ee, R.drawable.eg, R.drawable.eh, R.drawable.er, R.drawable.es, R.drawable.et, R.drawable.fi, R.drawable.fj,
            R.drawable.fk, R.drawable.fm, R.drawable.fo, R.drawable.fr, R.drawable.ga, R.drawable.gb, R.drawable.gd, R.drawable.ge, R.drawable.gf, R.drawable.gg,
            R.drawable.gh, R.drawable.gi, R.drawable.gl, R.drawable.gm, R.drawable.gn, R.drawable.gp, R.drawable.gq, R.drawable.gr, R.drawable.gt, R.drawable.gu,
            R.drawable.gw, R.drawable.gy, R.drawable.hk, R.drawable.hm, R.drawable.hn, R.drawable.hr, R.drawable.hu, R.drawable.id, R.drawable.ie,R.drawable.il,
            R.drawable.im, R.drawable.in, R.drawable.iq, R.drawable.ir, R.drawable.is, R.drawable.it, R.drawable.je, R.drawable.jm, R.drawable.jo, R.drawable.jp,
            R.drawable.ke,R.drawable.kg,R.drawable.ki,R.drawable.km,R.drawable.kn,R.drawable.kp,R.drawable.kr,R.drawable.kw,R.drawable.kz,R.drawable.la,R.drawable.lb,
            R.drawable.lc,R.drawable.li,R.drawable.lk,R.drawable.lr,R.drawable.ls,R.drawable.lt,R.drawable.lu, R.drawable.lv,R.drawable.ly,R.drawable.ma,R.drawable.mc,
            R.drawable.md,R.drawable.me,R.drawable.mf,R.drawable.mg,R.drawable.mh, R.drawable.mk,R.drawable.ml,R.drawable.mm,R.drawable.mn};

    String[] paises = {"Andorra", "Emiratos Arabes", "Afganistan", "Antigua y Barbuda", "Albania", "Armenia", "Angola", "Antártida", "Argentina", "Samoa Americana",
            "Austria", "Australia", "Aruba", "Islas Aland", "Azerbaian", "Bosnia y Herzgovina", "Barbados", "Bangladesh", "Bélgica", "Burkina Faso", "Bulgaria",
            "Baréin", "Burundi", "Benín", "San Bartolomé", "Bermudas", "Brunéi", "Bolivia", "Caribe Neerlandés", "Brasil", "Bahamas", "Bután", "Isla Bouvet",
            "Botsuana", "Bielorrusia", "Belice", "Canadá", "Islas Cocos", "Republica democratica del Congo", "Republica Centroafricana", "Congo", "Suiza", "Irlanda",
            "Islas Cook", "Chile", "Camerún", "China", "Colombia", "Costa Rica", "Cuba", "Cabo Verde", "Curazao", "Isla de Navidad", "Chipre", "Republica Checa",
            "Alemania", "Yibuti", "Dinamarca", "Dominica", "Argelia", "Ecuador", "Estonia", "Egipto", "Sahara Occidental", "Eritrea", "España", "Etiopía","Finlandia",
            "Fiyi", "Islas Malvidas", "Micronesia", "Islas Feroe", "Francia", "Gabon", "Gran Bretaña", "Granada", "Georgia", "Guayana Francesa", "Guernsey", "Ghana",
            "Gibraltar", "Groenlandia", "Gambia", "Guinea", "Guadalupe", "Guinea Ecuatorial", "Grecia", "Guatemala", "Guam", "Ginea-Bisáu", "Guyana", "Hong Kong",
            "Australia", "Honduras", "Croacia", "Hungria", "Indonesia", "Irlanda", "Estado Genocida", "Isla de Man", "India", "Irak", "Irán", "Islandia", "Italia",
            "Jersey", "Jamaica", "Jordania", "Japón", "Kenia","Kirguistán", "Kiribati", "Comoras", "San Cristobal y Nieves", "Corea del Norte", "Corea del Sur", "Kuwait",
            "kazajistán","Laos", "Libano", "Santa Lucia", "Liechtenstein", "Sri Lanka", "Liberia", "Lesoto", "Lituania", "Luxemburgo", "Letonia", "Libia", "Marruecos",
            "Mónaco", "Moldavia", "Montenegro", "Francia", "Madagascar", "Islas Marshall", "Macedonia del Norte", "Mali", "Birmania", "Mongolia"};





    Random rd = new Random();
    int temp3 = 0;
    int temp1 = rd.nextInt(imagenes.length);
    int temp2 = rd.nextInt(imagenes.length);
    int puntos = 0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);





        while(temp2 == temp1)
        {
            temp2 = rd.nextInt(imagenes.length);
        }

        btInicio = findViewById(R.id.btInicio);
        btFinal =findViewById(R.id.btFinal);

        btFinal.setVisibility(View.INVISIBLE);

        ibt1 = findViewById(R.id.ibt1);
        ibt1.setVisibility(View.INVISIBLE);

        ibt2 = findViewById(R.id.ibt2);
        ibt2.setVisibility(View.INVISIBLE);
        txt1 = findViewById(R.id.textView);
        txt1.setVisibility(View.INVISIBLE);
        txt2 = findViewById(R.id.textView2);
        txt2.setVisibility(View.INVISIBLE);
        mpInicio = MediaPlayer.create(this, R.raw.inicio);
        mpCorrecto = MediaPlayer.create(this, R.raw.acierto);
        mpIncorrecto = MediaPlayer.create(this, R.raw.incorrecto);
        mpAdios = MediaPlayer.create(this, R.raw.fin);



        btInicio.setOnClickListener(view ->
        {
            usados.clear();
            ibt1.setImageResource(imagenes[temp1]);
            ibt2.setImageResource(imagenes[temp2]);



            btInicio.setVisibility(View.GONE);
            temp3 = rd.nextInt(2);
            if(temp3 == 0)
            {
                txt1.setText("Elige la bandera de " + paises[temp1]);
            }
            else
            {
                txt1.setText("Elige la bandera de " + paises[temp2]);
            }
            ibt1.setVisibility(View.VISIBLE);
            ibt2.setVisibility(View.VISIBLE);
            btFinal.setVisibility(View.VISIBLE);
            txt2.setVisibility(View.VISIBLE);
            txt2.setText("Puntos: " + puntos);
            txt1.setVisibility(View.VISIBLE);

            mpInicio.start();
        });

        ibt1.setOnClickListener(view ->
        {
            if(temp3 == 0)
            {
                Toast.makeText(MainActivity.this, "Correcto!!", Toast.LENGTH_SHORT).show();
                puntos += 10;
                txt2.setText("Puntos: " + puntos);

                mpIncorrecto.reset();
                mpCorrecto.start();
                usados.add(imagenes[temp1]);
                do
                {
                    temp1 = rd.nextInt(imagenes.length);
                } while (usados.contains(imagenes[temp1]));
                comprobarBanderasLibres();


            }
            else
            {
                Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                puntos -= 5;
                txt2.setText("Puntos: " + puntos);

                mpCorrecto.reset();
                mpIncorrecto.start();
                temp1 = rd.nextInt(paises.length);

            }
            temp2 = rd.nextInt(paises.length);
            while(temp2 == temp1 && usados.contains(imagenes[temp2]))
            {
                temp2 = rd.nextInt(imagenes.length);
            }

            ibt1.setImageResource(imagenes[temp1]);
            ibt2.setImageResource(imagenes[temp2]);
            temp3 = rd.nextInt(2);
            if(temp3 == 0)
            {
                txt1.setText("Elige la bandera de " + paises[temp1]);
            }
            else
            {
                txt1.setText("Elige la bandera de " + paises[temp2]);
            }

        });

        ibt2.setOnClickListener(view ->
        {
            if(temp3 == 1)
            {
                Toast.makeText(MainActivity.this, "Correcto!!", Toast.LENGTH_SHORT).show();
                puntos += 10;
                txt2.setText("Puntos: " + puntos);

                mpIncorrecto.reset();
                mpCorrecto.start();
                usados.add(imagenes[temp2]);
                do
                {
                    temp2 = rd.nextInt(paises.length);
                } while (usados.contains(imagenes[temp2]));

                if(usados.size() == imagenes.length - 1)
                {
                    mpAdios.start();
                    ibt1.setVisibility(View.INVISIBLE);
                    ibt2.setVisibility(View.INVISIBLE);
                    txt1.setVisibility(View.INVISIBLE);
                    txt2.setVisibility(View.INVISIBLE);
                    btFinal.setVisibility(View.INVISIBLE);
                    btInicio.setVisibility(View.VISIBLE);
                }

                temp1 = rd.nextInt(paises.length);
                while(temp1 == temp2 && usados.contains(imagenes[temp1]))
                {
                    temp1 = rd.nextInt(imagenes.length);
                }


            }
            else
            {
                Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                puntos -= 5;
                txt2.setText("Puntos: " + puntos);
                mpCorrecto.reset();
                mpIncorrecto.start();
                temp1 = rd.nextInt(paises.length);
                temp2 = rd.nextInt(paises.length);
                while(temp2 == temp1)
                {
                    temp2 = rd.nextInt(imagenes.length);
                }

            }
            ibt1.setImageResource(imagenes[temp1]);
            ibt2.setImageResource(imagenes[temp2]);
            temp3 = rd.nextInt(2);
            if(temp3 == 1)
            {
                txt1.setText("Elige la bandera de " + paises[temp2]);
            }
            else
            {
                txt1.setText("Elige la bandera de " + paises[temp1]);
            }
        });

        btFinal.setOnClickListener(view ->
        {
            mpAdios.start();
            ibt1.setVisibility(View.INVISIBLE);
            ibt2.setVisibility(View.INVISIBLE);
            txt1.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            btFinal.setVisibility(View.INVISIBLE);
            btInicio.setVisibility(View.VISIBLE);

        });
    }

    private void comprobarBanderasLibres() {
        if(usados.size() == imagenes.length - 1)
        {
            Toast.makeText(MainActivity.this, "Fin del Juego, has conseguido " + puntos + " puntos.", Toast.LENGTH_SHORT).show();
            mpAdios.start();
            ibt1.setVisibility(View.INVISIBLE);
            ibt2.setVisibility(View.INVISIBLE);
            txt1.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            btFinal.setVisibility(View.INVISIBLE);
            btInicio.setVisibility(View.VISIBLE);
        }
    }
}