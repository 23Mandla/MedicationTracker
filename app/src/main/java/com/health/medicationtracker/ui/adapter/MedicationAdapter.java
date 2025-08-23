package com.health.medicationtracker.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.health.medicationtracker.databinding.MedicationCardBinding;
import com.health.medicationtracker.model.Medication;

import java.util.ArrayList;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder> {

    private ArrayList<Medication> medicationList;

    public MedicationAdapter(ArrayList<Medication> medicationList) {
        medicationList.clear();
        this.medicationList = medicationList;

    }

    @NonNull
    @Override
    public MedicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /*
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_medication, parent, false);
            return new MedViewHolder(view);
        **/

        MedicationCardBinding medicationCardBinding = MedicationCardBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false);
        return new MedicationViewHolder(medicationCardBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull MedicationViewHolder holder, int position) {
        /*
            Medication med = medications.get(position);
            holder.name.setText(med.getName());
            holder.dosage.setText(med.getDosage());
        * */
        Medication medication = medicationList.get(position);
        holder.medicationCardBinding.setMedication(medication);
    }

    @Override
    public int getItemCount() {
        if (medicationList != null) {
            return medicationList.size();
        }

        return 0;
    }

    public void setMedicationList(ArrayList<Medication> medicationList) {
        this.medicationList = medicationList;
        notifyDataSetChanged();
    }

    public Medication getMedication(int position){
        return medicationList.get(position);
    }


    public void removeMedication(int position){
        medicationList.remove(position);
        notifyItemRemoved(position);
    }

    public static class MedicationViewHolder extends RecyclerView.ViewHolder {
        private final MedicationCardBinding medicationCardBinding;

        public MedicationViewHolder(MedicationCardBinding medicationCardBinding) {
            super(medicationCardBinding.getRoot());
            this.medicationCardBinding = medicationCardBinding;
        }

    }
}
