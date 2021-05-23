package com.example.dopurok.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.dopurok.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        // инициализация нав контроллера (принемает активити и контейнер), инициализация идет
        //через класс Navigation
        navController = Navigation.findNavController(this,R.id.fragment_container);


        // Привязываем bottomNavigation и NavController
        // с помощью NavUi он принемает bottomNavigation и NavController
        NavigationUI.setupWithNavController(bottomNavigationView,navController);



    }
}