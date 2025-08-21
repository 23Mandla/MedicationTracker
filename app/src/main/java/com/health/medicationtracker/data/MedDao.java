package com.health.medicationtracker.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.health.medicationtracker.model.Medication;

import java.util.List;

@Dao
public interface MedDao {

    @Insert
    void insert(Medication medication);

    @Query("SELECT * FROM medication")
    LiveData<List<Medication>> getAllMedication();

    // for testing
    @Query("SELECT * FROM medication")
    List<Medication> getAllMedicationList();

    @Delete
    void delete(Medication medication);

    @Query("DELETE FROM medication")
    void deleteAllMedication();

}
