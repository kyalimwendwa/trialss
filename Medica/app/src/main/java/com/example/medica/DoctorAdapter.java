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

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    public   final RecyclerViewInterface1 recyclerViewInterface1;
    Context context;
    List<DoctorModel> doctorModelList;

    public void setFilteredList(List<DoctorModel>filteredList){
        this.doctorModelList=filteredList;
        notifyDataSetChanged();
    }

    public DoctorAdapter(Context context, List<DoctorModel> doctorModelList,RecyclerViewInterface1 recyclerViewInterface1) {
        this.recyclerViewInterface1 = recyclerViewInterface1;
        this.context = context;
        this.doctorModelList = doctorModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.viewdoctors,parent,false);
        return new DoctorAdapter.ViewHolder(v,recyclerViewInterface1);
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
        public ViewHolder(@NonNull View itemView, RecyclerViewInterface1 recyclerViewInterface1) {
            super(itemView);

            imageView=itemView.findViewById(R.id.recylerview_image);
            tvfullname=itemView.findViewById(R.id.recylerview_fullname);
            tvdepartment=itemView.findViewById(R.id.recylerview_department);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface1!=null){
                        int pos=getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface1.onItemClick(pos);
                        }

                    }
                }
            });
        }
    }
}
