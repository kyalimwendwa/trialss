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

public class AllDoctorsAdapter extends RecyclerView.Adapter<AllDoctorsAdapter.ViewHolder>  {
    public   final RecyclerViewInterface recyclerViewInterface;
    Context context;
    List<AllDoctors> allDoctorsList;
    public void setFilteredList(List<AllDoctors>filteredList){
        this.allDoctorsList=filteredList;
        notifyDataSetChanged();
    }

    public AllDoctorsAdapter( Context context, List<AllDoctors> allDoctorsList,RecyclerViewInterface recyclerViewInterface) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.context = context;
        this.allDoctorsList = allDoctorsList;
    }

    @NonNull
    @Override
    public AllDoctorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.viewdoctors,parent,false);
        return new AllDoctorsAdapter.ViewHolder(v,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AllDoctorsAdapter.ViewHolder holder, int position) {
        AllDoctors allDoctors=allDoctorsList.get(position);
        holder.tvfullname.setText(allDoctors.getFullname());
        holder.tvspec.setText(allDoctors.getSpeciality());



        String imageUri=null;
        imageUri= allDoctors.getImage();
        Picasso.get().load(imageUri).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return allDoctorsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvfullname,tvspec,tvslot;

        public ViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView=itemView.findViewById(R.id.recylerview_image);
            tvfullname=itemView.findViewById(R.id.recylerview_fullname);
            tvspec=itemView.findViewById(R.id.recylerview_department);

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
