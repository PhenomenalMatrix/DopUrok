package com.example.dopurok.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.dopurok.App;
import com.example.dopurok.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private com.example.dopurok.databinding.ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.dopurok.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
//        bottomNavigationView = findViewById(R.id.bottom_nav);

        // инициализация нав контроллера (принемает активити и контейнер), инициализация идет
        //через класс Navigation
        navController = Navigation.findNavController(this,R.id.fragment_container);


        // Привязываем bottomNavigation и NavController
        // с помощью NavUi он принемает bottomNavigation и NavController
        NavigationUI.setupWithNavController(binding.bottomNav,navController);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.action_bar_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.sort_btn:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


}