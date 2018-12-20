package com.example.michael.testyourlogic;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.michael.testyourlogic.core.ManagerPreguntas;
import com.example.michael.testyourlogic.entities.Pregunta;

public class SliderActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlideAdapter myAdapter;
    private int preguntaActaul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        preguntaActaul = 0;

        viewPager = findViewById(R.id.viewpager);
        myAdapter = new SlideAdapter(this, getSiguentePregunta());
        viewPager.setAdapter(myAdapter);
    }

    public void pasarPregunta(){
        Pregunta siguientePregunta = getSiguentePregunta();
        if(siguientePregunta!=null){
            deplegarSiguientePregunta(siguientePregunta);
        }else{
            Toast.makeText(this, "Fin del Juego", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }

    public void deplegarSiguientePregunta(Pregunta pregunta){
        viewPager.setAdapter(new SlideAdapter(this, pregunta));
        viewPager.getAdapter().notifyDataSetChanged();
        viewPager.setCurrentItem(0);
    }

    public Pregunta getSiguentePregunta(){
        if(preguntaActaul<ManagerPreguntas.getInstance().getListaDePreguntas().getPreguntas().size()){
            preguntaActaul++;
            return ManagerPreguntas.getInstance().getListaDePreguntas().getPreguntas().get(preguntaActaul-1);
        }else{
            return null;
        }
    }
}
