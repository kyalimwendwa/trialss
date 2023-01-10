package com.example.doctor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DentalDoctorAdapter extends RecyclerView.Adapter<DentalDoctorAdapter.ViewHolder>  {
    public   final  RecyclerViewInterface recyclerViewInterface;
    Context context;
    List<DentalDoctorModel> dentaldoctorModelList;

    public DentalDoctorAdapter(Context context, List<DentalDoctorModel> dentaldoctorModelList,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.dentaldoctorModelList = dentaldoctorModelList;
        this.recyclerViewInterface=recyclerViewInterface;
    }


    @NonNull
    @Override
    public DentalDoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.viewappoint1,parent,false);
        return new DentalDoctorAdapter.ViewHolder(v,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull DentalDoctorAdapter.ViewHolder holder, int position) {
        DentalDoctorModel dentalDoctorModel=dentaldoctorModelList.get(position);
        holder.tvfullname.setText(dentalDoctorModel.getFullname());
        holder.tvdate.setText(dentalDoctorModel.getDate());
       holder.tvslot.setText(dentalDoctorModel.getSlots());



        String imageUri=null;
        imageUri= dentalDoctorModel.getImage();
        Picasso.get().load(imageUri).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dentaldoctorModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvfullname,tvdate,tvslot;

        public ViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView=itemView.findViewById(R.id.recylerview_image1);
            tvfullname=itemView.findViewById(R.id.recylerview_fullname1);
            tvdate=itemView.findViewById(R.id.recylerview_date1);
           tvslot=itemView.findViewById(R.id.recylerview_slots);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (recyclerViewInterface!=null){
                       int pos=getAdapterPosition();
                       if (pos != RecyclerView.NO_POSITION){
                           recyclerViewInterface.onItemClick(pos);
                       }

                   }
               }
           });





        }
    }
}
