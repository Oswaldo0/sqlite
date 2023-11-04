package com.example.sqllite.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sqllite.Entidades.Personas;
import com.example.sqllite.R;
import com.example.sqllite.ViewModel.PersonaViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PersonaViewModel personaViewModel;
    private ListView rvcPersonas;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvcPersonas = findViewById(R.id.rcvPersonas);
        personaViewModel = new
                ViewModelProvider(this).get(PersonaViewModel.class);
        Personas persona = new Personas();
        persona.nombrePersona = "Oswaldo";
        persona.apellidoPersona = "Alvarez";
        persona.edadPersona = 29;
        personaViewModel.insertPersona(persona);
        LiveData<List<Personas>> liveDataPersonas =
                personaViewModel.getListaDePersonas();
        liveDataPersonas.observe(this, personas -> {
            List<Personas> lstPersonas = personas;
            ArrayAdapter<Personas> adapter = new
                    ArrayAdapter<>(MainActivity.this,

                    android.R.layout.simple_list_item_1, lstPersonas);
            rvcPersonas.setAdapter(adapter);
        });
    }
}
