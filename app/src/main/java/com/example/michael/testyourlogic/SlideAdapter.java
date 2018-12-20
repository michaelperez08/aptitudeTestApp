package com.example.michael.testyourlogic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.michael.testyourlogic.entities.Pregunta;

public class SlideAdapter extends PagerAdapter {
    Activity activity;
    LayoutInflater layoutInflater;
    Pregunta pregunta;

    private int[] listOfImages = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4
    };

    private String[] listOfTitles = {
            "ENUNCIADO",
            "OPCIONES",
            "null",
            "null"
    };


    private int[] listOfBackgroundColors = {
            Color.rgb(255,255,255),
            Color.rgb(255,255,255),
            Color.rgb(110,49,89),
            Color.rgb(55,55,55)
    };

    public SlideAdapter(Activity activity, Pregunta pregunta) {
        this.activity = activity;
        this.pregunta = pregunta;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide, container, false);
        LinearLayout layoutslides = view.findViewById(R.id.slidelinearlayout);
        //ImageView imgSlide = view.findViewById(R.id.slideimg);
        TextView txtTitle = view.findViewById(R.id.title);
        TextView txtDescription = view.findViewById(R.id.description);
        Button btOpcion1 = view.findViewById(R.id.button_option1);
        Button btOpcion2 = view.findViewById(R.id.button_option2);
        Button btOpcion3 = view.findViewById(R.id.button_option3);
        Button btOpcion4 = view.findViewById(R.id.button_option4);
        Button btOpcion5 = view.findViewById(R.id.button_option5);

        if (position==0){
            btOpcion1.setVisibility(View.INVISIBLE);
            btOpcion2.setVisibility(View.INVISIBLE);
            btOpcion3.setVisibility(View.INVISIBLE);
            btOpcion4.setVisibility(View.INVISIBLE);
            btOpcion5.setVisibility(View.INVISIBLE);

            txtTitle.setText("ENUNCIADO");
            txtDescription.setText(pregunta.getEnunciado());
        }else if(position==1){

            btOpcion1.setText(pregunta.getOpciones().get(0).getOpcion());
            btOpcion1.setOnClickListener(onOpcionSelected(pregunta.getOpciones().get(0).isCorrecta()));
            btOpcion2.setText(pregunta.getOpciones().get(1).getOpcion());
            btOpcion2.setOnClickListener(onOpcionSelected(pregunta.getOpciones().get(1).isCorrecta()));
            btOpcion3.setText(pregunta.getOpciones().get(2).getOpcion());
            btOpcion3.setOnClickListener(onOpcionSelected(pregunta.getOpciones().get(2).isCorrecta()));
            btOpcion4.setText(pregunta.getOpciones().get(3).getOpcion());
            btOpcion4.setOnClickListener(onOpcionSelected(pregunta.getOpciones().get(3).isCorrecta()));
            btOpcion5.setText(pregunta.getOpciones().get(4).getOpcion());
            btOpcion5.setOnClickListener(onOpcionSelected(pregunta.getOpciones().get(4).isCorrecta()));

            txtTitle.setText("OPCIONES");
            txtDescription.setText("La respuesta es");
        }

        layoutslides.setBackgroundColor(listOfBackgroundColors[position]);
        //imgSlide.setImageResource(listOfImages[position]);
        txtTitle.setText(listOfTitles[position]);

        container.addView(view);
        return view;
    }

    public View.OnClickListener onOpcionSelected(final boolean correcta){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correcta){
                    Toast.makeText(activity, "Opcion Correcta", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(activity, "Opcion Incorrecta", Toast.LENGTH_SHORT).show();
                }
                ((SliderActivity) activity).pasarPregunta();
            }
        };
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
