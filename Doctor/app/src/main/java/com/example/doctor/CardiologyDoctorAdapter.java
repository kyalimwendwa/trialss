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

public class CardiologyDoctorAdapter extends RecyclerView.Adapter<CardiologyDoctorAdapter.ViewHolder>  {
    Context context;
    List<CardiologyDoctorModel> cardiologydoctorModelList;

    public CardiologyDoctorAdapter(Context context, List<CardiologyDoctorModel> cardiologydoctorModelList) {
        this.context = context;
        this.cardiologydoctorModelList = cardiologydoctorModelList;
    }


    @NonNull
    @Override
    public CardiologyDoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.seedoctors,parent,false);
        return new CardiologyDoctorAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardiologyDoctorAdapter.ViewHolder holder, int position) {
        CardiologyDoctorModel cardiologyDoctorModel=cardiologydoctorModelList.get(position);
        holder.tvfullname.setText(cardiologyDoctorModel.getFullname());
        holder.tvdate.setText(cardiologyDoctorModel.getDate());
        holder.tvdepartment.setText(cardiologyDoctorModel.getDepartment());
        holder.tvtime1.setText(cardiologyDoctorModel.getTime1());
        holder.tvtime2.setText(cardiologyDoctorModel.getTime2());
        holder.tvtime3.setText(cardiologyDoctorModel.getTime3());




        String imageUri=null;
        imageUri= cardiologyDoctorModel.getImage();
        Picasso.get().load(imageUri).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return cardiologydoctorModelList.size();
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
