package com.example.sqllite.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sqllite.DAO.PersonaDAO;
import com.example.sqllite.Entidades.Personas;

@Database(entities = {Personas.class}, version = 1)
public abstract class PersonasDatabase extends RoomDatabase {
    private static PersonasDatabase instance;
    public abstract PersonaDAO personaDAO();
    public static synchronized PersonasDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            PersonasDatabase.class, "personasdb")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}