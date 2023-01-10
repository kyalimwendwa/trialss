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

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    Context context;
    List<DoctorModel> doctorModelList;
    public void setFilteredList(List<DoctorModel>filteredList){
        this.doctorModelList=filteredList;
        notifyDataSetChanged();
    }

    public DoctorAdapter(Context context, List<DoctorModel> doctorModelList) {
        this.context = context;
        this.doctorModelList = doctorModelList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.viewdoctors,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorModel doctorModel=doctorModelList.get(position);
        holder.tvfullname.setText(doctorModel.getFullname());

        holder.tvdepartment.setText(doctorModel.getDepartment());

        String imageUri=null;
        imageUri= doctorModel.getImage();
        Picasso.get().load(imageUri).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return doctorModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvfullname,tvdepartment;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.recylerview_image);
            tvfullname=itemView.findViewById(R.id.recylerview_fullname);
            tvdepartment=itemView.findViewById(R.id.recylerview_department);
        }
    }
}
