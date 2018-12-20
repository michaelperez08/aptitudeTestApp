package com.example.michael.testyourlogic;

import android.app.Activity;

import com.example.michael.testyourlogic.core.ManagerPreguntas;
import com.example.michael.testyourlogic.entities.Preguntas;
import com.example.michael.testyourlogic.helper.JsonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConfigurationLoader {

    public boolean loadConfiguration(Activity activity) {
        try {
            StringBuffer sb = new StringBuffer();
            String userdire = System.getProperty("user.dir");
            InputStream is = activity.getAssets().open("preguntas.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            JsonUtils jsonUtils = new JsonUtils();
            Preguntas preguntas = jsonUtils.convertToObject(sb.toString(), Preguntas.class);
            ManagerPreguntas.getInstance().setListaDePreguntas(preguntas);
        }catch(IOException e){
            return false;
        }

        return true;
    }
}
