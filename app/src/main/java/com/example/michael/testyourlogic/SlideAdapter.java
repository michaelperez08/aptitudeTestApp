package com.example.michael.testyourlogic;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    private int[] listOfImages = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4
    };

    private String[] listOfTitles = {
            "COSMONAUT",
            "SATELITE",
            "GALAXY",
            "ROCKET"
    };

    private String[] listOfDescriptions = {
            "Este es  una cosmonauta",
            "Esto es una satelite",
            "Esto es una galaxia",
            "Y esto es un cometa"
    };

    private int[] listOfBackgroundColors = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return listOfTitles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide, container, false);
        LinearLayout layoutslides = view.findViewById(R.id.slidelinearlayout);
        ImageView imgSlide = view.findViewById(R.id.slideimg);
        TextView txtTitle = view.findViewById(R.id.title);
        TextView txtDescription = view.findViewById(R.id.description);

        layoutslides.setBackgroundColor(listOfBackgroundColors[position]);
        imgSlide.setImageResource(listOfImages[position]);
        txtTitle.setText(listOfTitles[position]);
        txtDescription.setText(listOfDescriptions[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
