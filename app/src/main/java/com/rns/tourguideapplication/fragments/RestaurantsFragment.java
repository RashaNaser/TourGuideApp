package com.rns.tourguideapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rns.tourguideapplication.R;
import com.rns.tourguideapplication.adapter.SiteAdapter;
import com.rns.tourguideapplication.databinding.FragmentRestaurantsBinding;
import com.rns.tourguideapplication.model.Site;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    private FragmentRestaurantsBinding binding;
    private SiteAdapter adapter;
    private ArrayList<Site> sites = new ArrayList<>();

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRestaurantsBinding.inflate(inflater, container, false);
        initializeRecyclerView();
        return binding.getRoot();
    }

    private void setData() {
        sites.add(new Site(getString(R.string.light_house), getString(R.string.blue_sammak_location), R.drawable.light));
        sites.add(new Site(getString(R.string.sammak), getString(R.string.blue_sammak_location), R.drawable.samak));
        sites.add(new Site(getString(R.string.mazaj), getString(R.string.mazaj_location), R.drawable.majaz));
    }

    private void initializeRecyclerView() {
        setData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setHasFixedSize(true);
        adapter = new SiteAdapter(sites);
        binding.recyclerView.setAdapter(adapter);
    }
}