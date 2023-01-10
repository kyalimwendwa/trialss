package com.example.medica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;


public class OnBoarding extends AppCompatActivity {
private OnboardingAdapter onboardingAdapter;
private LinearLayout layoutOnboardingIndicators;
private MaterialButton buttonOnboardingAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);
        layoutOnboardingIndicators=findViewById(R.id.layoutOnboardingIndicators);
        buttonOnboardingAction=findViewById(R.id.buttonOnboardingAction);
        setupOnboardingItems();
        ViewPager2 onboardingViewPager=findViewById(R.id.onboardingViewpager);
        onboardingViewPager.setAdapter(onboardingAdapter);
        setupOnboardingIndicators();
        setCurrentOnboardingIndicator(0);
        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });
        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onboardingViewPager.getCurrentItem() + 1<onboardingAdapter.getItemCount()){
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem()+1);
                }else {
       startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }
            }
        });

    }
    private  void setupOnboardingItems(){
        List<OnboardingItem> onboardingItems=new ArrayList<>();
        OnboardingItem itemPayOnline=new OnboardingItem();
        itemPayOnline.setTitle("");
        itemPayOnline.setDescription("Book an appointment with the right doctor");
        itemPayOnline.setImage(R.drawable.online);

        OnboardingItem bookMedicine=new OnboardingItem();
        bookMedicine.setTitle("");
        bookMedicine.setDescription("Get medicines delivery to your doorstep");
        bookMedicine.setImage(R.drawable.de);

        OnboardingItem keepRecord=new OnboardingItem();
        keepRecord.setTitle("");
        keepRecord.setDescription("Keep your medical history handy");
        keepRecord.setImage(R.drawable.de);

        OnboardingItem consultDoctor=new OnboardingItem();
        consultDoctor.setTitle("");
        consultDoctor.setDescription("Schedule a consultation with doctor");
        consultDoctor.setImage(R.drawable.online);

        onboardingItems.add(itemPayOnline);
        onboardingItems.add(bookMedicine);
        onboardingItems.add(keepRecord);
        onboardingItems.add(consultDoctor);

        onboardingAdapter=new OnboardingAdapter(onboardingItems);
    }
    private  void setupOnboardingIndicators(){
        ImageView[] indicators= new ImageView[onboardingAdapter.getItemCount()];
      LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(
              ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
      );
      layoutParams.setMargins(8,0,8,0);
      for (int i=0;i<indicators.length;i++){
          indicators[i]=new ImageView(getApplicationContext());
          indicators[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive));
          indicators[i].setLayoutParams(layoutParams);
          layoutOnboardingIndicators.addView(indicators[i]);
      }
    }
    private  void setCurrentOnboardingIndicator(int index){
        int childCount=layoutOnboardingIndicators.getChildCount();
        for (int i=0;i<childCount;i++){
            ImageView imageView=(ImageView) layoutOnboardingIndicators.getChildAt(i);
            if (i==index){
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active));

            }else{
               imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive));
            }
        }
        if (index==onboardingAdapter.getItemCount()-1){
            buttonOnboardingAction.setText("Get started");
        }else {
            buttonOnboardingAction.setText("Get Started");
        }

    }

}