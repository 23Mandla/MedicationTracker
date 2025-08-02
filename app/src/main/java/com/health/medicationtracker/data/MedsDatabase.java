package com.health.medicationtracker.data;

import android.content.Context;
import android.media.MediaCas;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.health.medicationtracker.model.Medication;

/**
 * {@code MedsDatabase} Room database for storing and retrieving medication data.
 * {@code Medication} main access point in the app.
 * {@link MedDao} provides methods to interact with DAO.
 */
@Database(entities = {Medication.class}, version = 1)
public abstract class MedsDatabase extends RoomDatabase {

    public abstract MedDao getMedDao();

    public static MedsDatabase medsDatabaseInstance;

    //singleton method
    public static synchronized MedsDatabase getInstance(Context context){
        if(medsDatabaseInstance == null){
            medsDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MedsDatabase.class, "meds_database").build(); //identify medication database on the app
        }
        return medsDatabaseInstance;
    }
}
