package com.test.navegacionconfragmentos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Cargar el fragmento inicial
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new RedFragment())
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.nav_red) {
                selectedFragment = new RedFragment();
            } else if (item.getItemId() == R.id.nav_blue) {
                selectedFragment = new BlueFragment();
            } else if (item.getItemId() == R.id.nav_green) {
                selectedFragment = new GreenFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });
    }
}