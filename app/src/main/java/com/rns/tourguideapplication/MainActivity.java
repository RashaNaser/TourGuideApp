package com.rns.tourguideapplication;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.rns.tourguideapplication.databinding.ActivityMainBinding;
import com.rns.tourguideapplication.databinding.NavHeaderBinding;
import com.rns.tourguideapplication.fragments.AboutGazaFragment;
import com.rns.tourguideapplication.fragments.HistoricalSitesFragment;
import com.rns.tourguideapplication.fragments.HotelsFragment;
import com.rns.tourguideapplication.fragments.MuseumsFragment;
import com.rns.tourguideapplication.fragments.RestaurantsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle drawerToggle;
    private ArrayList<MenuItem> menuItems;
    private int oldPosition;
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        drawerToggle = setupDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(true);
        binding.drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        NavHeaderBinding navHeaderBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.nav_header, binding.navView, false);
        binding.navView.addHeaderView(navHeaderBinding.getRoot());

        setupDrawerContent(binding.navView);

        menuItems = new ArrayList<>();
        for (int i = 0; i < binding.navView.getMenu().size(); i++) {
            menuItems.add(binding.navView.getMenu().getItem(i));
        }

        openFragment(new HistoricalSitesFragment(), R.id.container);
        binding.navView.getMenu().getItem(oldPosition).setChecked(true);
        setTitle(binding.navView.getMenu().getItem(oldPosition).getTitle());
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            selectDrawerItem(menuItem);
            return true;
        });
    }

    @SuppressLint("NonConstantResourceId")
    public void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.historical:
                openFragment(new HistoricalSitesFragment(), R.id.container);
                break;
            case R.id.museum:
                openFragment(new MuseumsFragment(), R.id.container);
                break;
            case R.id.hotel:
                openFragment(new HotelsFragment(), R.id.container);
                break;
            case R.id.restaurant:
                openFragment(new RestaurantsFragment(), R.id.container);
                break;
            case R.id.about:
                openFragment(new AboutGazaFragment(), R.id.container);
                break;
        }

        menuItem.setChecked(true);

        binding.navView.getMenu().getItem(oldPosition).setChecked(false);
        oldPosition = menuItems.indexOf(menuItem);
        setTitle(menuItem.getTitle());
        binding.drawerLayout.closeDrawers();
    }

    public void openFragment(Fragment fragment, int container) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this
                , binding.drawerLayout
                , binding.toolbar
                , R.string.drawer_open
                , R.string.drawer_close);
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}