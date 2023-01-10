package com.example.medica;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class Dental extends AppCompatActivity implements RecyclerViewInterface {
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageView searchview_image,back;
    SearchView searchView;
    RecyclerView recyclerView;
    AllDoctorsAdapter allDoctorsAdapter;
    List<AllDoctors> dentalMdlList;
    LinearLayout all,heart,kidney,therapy,bones,lungs,eyes,stomach;
    Button  dental;




    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dental=findViewById(R.id.dental);
        all=findViewById(R.id.all);
        heart=findViewById(R.id.heart);





        kidney=findViewById(R.id.kidney);
        therapy=findViewById(R.id.therapy);
        bones=findViewById(R.id.bones);
        lungs=findViewById(R.id.lungs);
        eyes=findViewById(R.id.eyes);
        stomach=findViewById(R.id.stomach);

        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        searchview_image=findViewById(R.id.searchview_image);
        back=findViewById(R.id.backk);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dental.this,Startpage.class);
                startActivity(intent);
            }
        });
        searchview_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setVisibility(View.VISIBLE);
            }
        });
        recyclerView = findViewById(R.id.recylerview_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dentalMdlList= new ArrayList<AllDoctors>();
        allDoctorsAdapter= new AllDoctorsAdapter(Dental.this,dentalMdlList,this);
        recyclerView.setAdapter(allDoctorsAdapter);
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("All Doctors ");
        mStorage = FirebaseStorage.getInstance();

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    AllDoctors allDoctors= snapshot.getValue( AllDoctors.class);
                dentalMdlList.add(allDoctors);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(Dental.this,AppointmentHours.class);
        intent.putExtra("Fullname",dentalMdlList.get(position).getFullname());
        intent.putExtra("Speciality",dentalMdlList.get(position).getSpeciality());
        intent.putExtra("Image",dentalMdlList.get(position).getImage());
        intent.putExtra("Date",dentalMdlList.get(position).getDate());
        intent.putExtra("Slots",dentalMdlList.get(position).getSlots());
        intent.putExtra("Date1",dentalMdlList.get(position).getDate1());
        intent.putExtra("Slots2",dentalMdlList.get(position).getSlots2());
        intent.putExtra("Date2",dentalMdlList.get(position).getDate2());
        intent.putExtra("Slots3",dentalMdlList.get(position).getSlots3());
        intent.putExtra("Date3",dentalMdlList.get(position).getDate3());
        intent.putExtra("Slots4",dentalMdlList.get(position).getSlots4());
        intent.putExtra("Date4",dentalMdlList.get(position).getDate4());
        intent.putExtra("Slots5",dentalMdlList.get(position).getSlots5());


        intent.putExtra("Alex",dentalMdlList.get(position).getAlex());
        intent.putExtra("Betty",dentalMdlList.get(position).getBetty());
        intent.putExtra("Can",dentalMdlList.get(position).getCan());
        intent.putExtra("Done",dentalMdlList.get(position).getDone());
        intent.putExtra("Earn",dentalMdlList.get(position).getEarn());
        intent.putExtra("Fay",dentalMdlList.get(position).getFay());
        intent.putExtra("Gal",dentalMdlList.get(position).getGal());
        intent.putExtra("Hug",dentalMdlList.get(position).getHug());
        intent.putExtra("Ian",dentalMdlList.get(position).getIan());
        intent.putExtra("Jack",dentalMdlList.get(position).getJack());
        intent.putExtra("Kyali",dentalMdlList.get(position).getKyali());
        intent.putExtra("Lime",dentalMdlList.get(position).getLime());
        intent.putExtra("Mine",dentalMdlList.get(position).getMine());
        intent.putExtra("Nike",dentalMdlList.get(position).getNike());
        intent.putExtra("Org",dentalMdlList.get(position).getOrg());
        intent.putExtra("Rap",dentalMdlList.get(position).getRap());

        intent.putExtra("Ed1",dentalMdlList.get(position).getEd1());
        intent.putExtra("Ed2",dentalMdlList.get(position).getEd2());
        intent.putExtra("Ed3",dentalMdlList.get(position).getEd3());
        intent.putExtra("Ed4",dentalMdlList.get(position).getEd4());
        intent.putExtra("Ed5",dentalMdlList.get(position).getEd5());
        intent.putExtra("Ed6",dentalMdlList.get(position).getEd6());
        intent.putExtra("Ed7",dentalMdlList.get(position).getEd7());
        intent.putExtra("Ed8",dentalMdlList.get(position).getEd8());
        intent.putExtra("Ed9",dentalMdlList.get(position).getEd9());
        intent.putExtra("Ed10",dentalMdlList.get(position).getEd10());
        intent.putExtra("Ed11",dentalMdlList.get(position).getEd11());
        intent.putExtra("Ed12",dentalMdlList.get(position).getEd12());
        intent.putExtra("Ed13",dentalMdlList.get(position).getEd13());
        intent.putExtra("Ed14",dentalMdlList.get(position).getEd14());
        intent.putExtra("Ed15",dentalMdlList.get(position).getEd15());
        intent.putExtra("Ed16",dentalMdlList.get(position).getEd16());

        intent.putExtra("Ed17",dentalMdlList.get(position).getEd17());
        intent.putExtra("Ed18",dentalMdlList.get(position).getEd18());
        intent.putExtra("Ed19",dentalMdlList.get(position).getEd19());
        intent.putExtra("Ed20",dentalMdlList.get(position).getEd20());
        intent.putExtra("Ed21",dentalMdlList.get(position).getEd21());
        intent.putExtra("Ed22",dentalMdlList.get(position).getEd22());
        intent.putExtra("Ed23",dentalMdlList.get(position).getEd23());
        intent.putExtra("Ed24",dentalMdlList.get(position).getEd24());
        intent.putExtra("Ed25",dentalMdlList.get(position).getEd25());
        intent.putExtra("Ed26",dentalMdlList.get(position).getEd26());
        intent.putExtra("Ed27",dentalMdlList.get(position).getEd27());
        intent.putExtra("Ed28",dentalMdlList.get(position).getEd28());
        intent.putExtra("Ed29",dentalMdlList.get(position).getEd29());
        intent.putExtra("Ed30",dentalMdlList.get(position).getEd30());
        intent.putExtra("Ed31",dentalMdlList.get(position).getEd31());
        intent.putExtra("Ed32",dentalMdlList.get(position).getEd32());

        intent.putExtra("Ed33",dentalMdlList.get(position).getEd33());
        intent.putExtra("Ed34",dentalMdlList.get(position).getEd34());
        intent.putExtra("Ed35",dentalMdlList.get(position).getEd35());
        intent.putExtra("Ed36",dentalMdlList.get(position).getEd36());
        intent.putExtra("Ed37",dentalMdlList.get(position).getEd37());
        intent.putExtra("Ed38",dentalMdlList.get(position).getEd38());
        intent.putExtra("Ed39",dentalMdlList.get(position).getEd39());
        intent.putExtra("Ed40",dentalMdlList.get(position).getEd40());
        intent.putExtra("Ed41",dentalMdlList.get(position).getEd41());
        intent.putExtra("Ed42",dentalMdlList.get(position).getEd42());
        intent.putExtra("Ed43",dentalMdlList.get(position).getEd43());
        intent.putExtra("Ed44",dentalMdlList.get(position).getEd44());
        intent.putExtra("Ed45",dentalMdlList.get(position).getEd45());
        intent.putExtra("Ed46",dentalMdlList.get(position).getEd46());
        intent.putExtra("Ed47",dentalMdlList.get(position).getEd47());
        intent.putExtra("Ed48",dentalMdlList.get(position).getEd48());

        intent.putExtra("Ed49",dentalMdlList.get(position).getEd49());
        intent.putExtra("Ed50",dentalMdlList.get(position).getEd50());
        intent.putExtra("Ed51",dentalMdlList.get(position).getEd51());
        intent.putExtra("Ed52",dentalMdlList.get(position).getEd52());
        intent.putExtra("Ed53",dentalMdlList.get(position).getEd53());
        intent.putExtra("Ed54",dentalMdlList.get(position).getEd54());
        intent.putExtra("Ed55",dentalMdlList.get(position).getEd55());
        intent.putExtra("Ed56",dentalMdlList.get(position).getEd56());
        intent.putExtra("Ed57",dentalMdlList.get(position).getEd57());
        intent.putExtra("Ed58",dentalMdlList.get(position).getEd58());
        intent.putExtra("Ed59",dentalMdlList.get(position).getEd59());
        intent.putExtra("Ed60",dentalMdlList.get(position).getEd60());
        intent.putExtra("Ed61",dentalMdlList.get(position).getEd61());
        intent.putExtra("Ed62",dentalMdlList.get(position).getEd62());
        intent.putExtra("Ed63",dentalMdlList.get(position).getEd63());
        intent.putExtra("Ed64",dentalMdlList.get(position).getEd64());

        startActivity(intent);

    }
    private void filterList(String text) {
        List<AllDoctors> filteredList=new ArrayList<>();
        for (AllDoctors allDoctors:dentalMdlList){
            if (allDoctors.getSpeciality().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(allDoctors);
            }

        }
        if (filteredList.isEmpty()){

        }else {
            allDoctorsAdapter.setFilteredList(filteredList);
        }


    }
    private void setTextViewColor(TextView textView, int...color) {
        TextPaint paint=textView.getPaint();
        float width=paint.measureText(textView.getText().toString());
        Shader shader=new LinearGradient(0,0,width,textView.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
        textView.setTextColor(color[0]);
    }
}