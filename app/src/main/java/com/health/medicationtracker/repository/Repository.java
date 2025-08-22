package com.health.medicationtracker.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.health.medicationtracker.data.MedDao;
import com.health.medicationtracker.data.MedsDatabase;
import com.health.medicationtracker.model.Medication;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private final MedDao medDao;

    ExecutorService executorService;
    Handler handler;

    public Repository(Application application){
        MedsDatabase medsDatabase = MedsDatabase.getInstance(application);
        this.medDao = medsDatabase.getMedDao();
        this.executorService = Executors.newSingleThreadExecutor(); //runs on a single thread in the background
        this.handler = new Handler(Looper.getMainLooper()); //updates the UI

    }

    public void AddMedication(Medication medication){
        executorService.execute(() -> {
            medDao.insert(medication);
        });
    }

    public void deleteMedication(Medication medication){
        executorService.execute(() -> {
            medDao.delete(medication);
        });
    }

    public LiveData<List<Medication>> getAllMedication(){
        return medDao.getAllMedication();
    }

    //testing
    public List<Medication> getAllMedicationList(){
        return medDao.getAllMedicationList();
    }

    public void deleteAllMedication(){
        executorService.execute(() -> {
            medDao.deleteAllMedication();
        });
    }
}
