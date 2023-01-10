package com.example.medica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PatientShowInfoAdapter extends RecyclerView.Adapter<PatientShowInfoAdapter.ViewHolder>  {

    Context context;
    List<PatientShowInfo> patientShowInfoList;

    public PatientShowInfoAdapter(Context context, List<PatientShowInfo> patientShowInfoList) {
        this.context = context;
        this.patientShowInfoList = patientShowInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.viewappoint3,parent,false);
        return new PatientShowInfoAdapter.ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PatientShowInfo patientShowInfo=patientShowInfoList.get(position);
        holder.tvfullname.setText(patientShowInfo.getDate());
        holder.tvdate.setText(patientShowInfo.getTime());
        holder.tvdate1.setText(patientShowInfo.getTime1());
        holder.tvpurpose.setText(patientShowInfo.getPurpose());
        holder.tvyear.setText(patientShowInfo.getAge());
        holder.tvstatus.setText(patientShowInfo.getStatus());
        holder.tvdocname.setText(patientShowInfo.getDoctor());





    }

    @Override
    public int getItemCount() {
        return patientShowInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvfullname,tvdate,tvpurpose,tvyear,tvstatus,tvdocname,tvdate1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvfullname=itemView.findViewById(R.id.recylerview_fullname3);
            tvdate=itemView.findViewById(R.id.recylerview_date3);
            tvpurpose=itemView.findViewById(R.id.recylerview_purpose3);
            tvyear=itemView.findViewById(R.id.recylerview_year3);
            tvstatus=itemView.findViewById(R.id.recylerview_status3);
            tvdocname=itemView.findViewById(R.id.recylerview_doctor3);
            tvdate1=itemView.findViewById(R.id.recylerview_date7);



        }
    }
}
