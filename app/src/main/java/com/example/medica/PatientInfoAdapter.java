package com.example.medica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PatientInfoAdapter extends RecyclerView.Adapter<PatientInfoAdapter.ViewHolder>  {
    public   final RecyclerViewInterface2 recyclerViewInterface2;
    Context context;
    List<PatientInfo> patientInfoList;

    public PatientInfoAdapter( Context context, List<PatientInfo> patientInfoList,RecyclerViewInterface2 recyclerViewInterface2) {
        this.recyclerViewInterface2 = recyclerViewInterface2;
        this.context = context;
        this.patientInfoList = patientInfoList;
    }

    @NonNull
    @Override
    public PatientInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.viewappoint2,parent,false);
        return new PatientInfoAdapter.ViewHolder(v,recyclerViewInterface2);
    }
    @Override
    public void onBindViewHolder(@NonNull PatientInfoAdapter.ViewHolder holder, int position) {
        PatientInfo patientInfo=patientInfoList.get(position);
        holder.tvfullname.setText(patientInfo.getPatientname());
        holder.tvdate.setText(patientInfo.getDatetime());
        holder.tvtime.setText(patientInfo.getTime());
        holder.tvpurpose.setText(patientInfo.getDatetime1());
        holder.tvyear.setText(patientInfo.getPatientemail());

        String imageUri=null;
        imageUri= patientInfo.getImage();
        Picasso.get().load(imageUri).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return patientInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvfullname,tvdate,tvpurpose,tvyear,tvtime;
        public ViewHolder(@NonNull View itemView,RecyclerViewInterface2 recyclerViewInterface2) {
            super(itemView);
            imageView=itemView.findViewById(R.id.recylerview_image2);
            tvfullname=itemView.findViewById(R.id.recylerview_fullname2);
            tvdate=itemView.findViewById(R.id.recylerview_date2);
            tvpurpose=itemView.findViewById(R.id.recylerview_purpose);
            tvyear=itemView.findViewById(R.id.recylerview_year);
            tvtime=itemView.findViewById(R.id.recylerview_time2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface2!=null){
                        int pos=getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface2.onItemClick(pos);
                        }

                    }
                }
            });

        }
    }
}
