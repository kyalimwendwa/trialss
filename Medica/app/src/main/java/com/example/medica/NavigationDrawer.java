package com.example.medica;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.example.medica.databinding.ActivityNavigationDrawerBinding;
import com.example.medica.ui.Settings.SettingsFragment;
import com.example.medica.ui.appointment.AppointmentFragment;
import com.example.medica.ui.consultations.ConsultationFragment;
import com.example.medica.ui.mydoctors.DoctorsFragment;
import com.example.medica.ui.orders.OrderFragment;
import com.example.medica.ui.payments.PaymentFragment;
import com.example.medica.ui.reminders.RemindersFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationDrawerBinding binding;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth=FirebaseAuth.getInstance();
        currentUser=mAuth.getCurrentUser();

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);
        binding.appBarNavigationDrawer.fab.setVisibility(View.GONE);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_orders, R.id.nav_appointment,R.id.nav_consultations,R.id.nav_mydoctors,R.id.nav_reminders,R.id.nav_payment,R.id.nav_settings )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationView navigationView1=(NavigationView) findViewById(R.id.nav_view);
        navigationView1.setNavigationItemSelectedListener(this);
        updateNavHeader();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.nav_home){
            getSupportActionBar().setTitle("Home");
            Intent intent=new Intent(NavigationDrawer.this,RegisterActivity.class);
            startActivity(intent);
        }else if (id==R.id.nav_appointment)
        {
            getSupportActionBar().setTitle("Appointment");
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation_drawer,new AppointmentFragment()).commit();

        }else if (id==R.id.nav_orders)
        {
            getSupportActionBar().setTitle("Orders");
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation_drawer,new OrderFragment()).commit();

        }else if (id==R.id.nav_consultations)
        {
            getSupportActionBar().setTitle("Consultations");
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation_drawer,new ConsultationFragment()).commit();

        }else if (id==R.id.nav_mydoctors)
        {
            getSupportActionBar().setTitle("Doctors");
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation_drawer,new DoctorsFragment()).commit();

        }else if (id==R.id.nav_reminders)
        {
            getSupportActionBar().setTitle("Reminder");
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation_drawer,new RemindersFragment()).commit();

        }else if (id==R.id.nav_payment)
        {
            getSupportActionBar().setTitle("Payment");
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation_drawer,new PaymentFragment()).commit();

        }else if (id==R.id.nav_settings)
        {
            getSupportActionBar().setTitle("Settings");
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation_drawer,new SettingsFragment()).commit();

        }
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void updateNavHeader(){
        NavigationView navigationView1=(NavigationView) findViewById(R.id.nav_view);
        View headerView=navigationView1.getHeaderView(0);
        TextView navUsername=headerView.findViewById(R.id.nav_username);
        TextView navuserMail=headerView.findViewById(R.id.nav_user_mail);
        ImageView navuserPhot=headerView.findViewById(R.id.nav_user_photo);
        navuserMail.setText(currentUser.getEmail());
        navUsername.setText(currentUser.getDisplayName());

        Glide.with(this).load(currentUser.getPhotoUrl()).into(navuserPhot);


    }
}