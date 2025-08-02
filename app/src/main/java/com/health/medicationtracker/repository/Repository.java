package com.health.medicationtracker.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.health.medicationtracker.data.MedDao;
import com.health.medicationtracker.data.MedsDatabase;
import com.health.medicationtracker.model.Medication;

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

    public void insert(Medication medication){
        executorService.execute(() -> {
            medDao.insert(medication);
        });
    }
}
