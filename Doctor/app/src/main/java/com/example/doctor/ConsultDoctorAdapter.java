package com.example.doctor;

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

public class ConsultDoctorAdapter  extends RecyclerView.Adapter<ConsultDoctorAdapter.ViewHolder>  {
    Context context;
    List<ConsultDoctorModel> consultDoctorModelList;

    public ConsultDoctorAdapter(Context context, List<ConsultDoctorModel> consultDoctorModelList) {
        this.context = context;
        this.consultDoctorModelList = consultDoctorModelList;
    }


    @NonNull
    @Override
    public ConsultDoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.seedoctors,parent,false);
        return new ConsultDoctorAdapter .ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultDoctorAdapter.ViewHolder holder, int position) {
        ConsultDoctorModel consultDoctorModel=consultDoctorModelList.get(position);
        holder.tvfullname.setText(consultDoctorModel.getFullname());
        holder.tvdate.setText(consultDoctorModel.getDate());
        holder.tvdepartment.setText(consultDoctorModel.getDepartment());
        holder.tvtime1.setText(consultDoctorModel.getTime1());
        holder.tvtime2.setText(consultDoctorModel.getTime2());
        holder.tvtime3.setText(consultDoctorModel.getTime3());




        String imageUri=null;
        imageUri= consultDoctorModel.getImage();
        Picasso.get().load(imageUri).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return consultDoctorModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvfullname,tvdepartment,tvdate,tvtime1,tvtime2,tvtime3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.recylerview_image1);
            tvfullname=itemView.findViewById(R.id.recylerview_fullname1);
            tvdepartment=itemView.findViewById(R.id.recylerview_department1);
            tvdate=itemView.findViewById(R.id.recylerview_date1);
            tvtime1=itemView.findViewById(R.id.recylerview_time1);
            tvtime2=itemView.findViewById(R.id.recylerview_time2);
            tvtime3=itemView.findViewById(R.id.recylerview_time3);

        }
    }
}
