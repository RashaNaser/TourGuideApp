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
import com.rns.tourguideapplication.databinding.FragmentMuseumsBinding;
import com.rns.tourguideapplication.model.Site;

import java.util.ArrayList;

public class MuseumsFragment extends Fragment {

    private FragmentMuseumsBinding binding;
    private SiteAdapter adapter;
    private ArrayList<Site> sites = new ArrayList<>();

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMuseumsBinding.inflate(inflater, container, false);
        initializeRecyclerView();
        return binding.getRoot();
    }

    private void setData() {
        sites.add(new Site(getString(R.string.basha), getString(R.string.basha_location), R.drawable.basha));
        sites.add(new Site(getString(R.string.gaza_museum), getString(R.string.almathaf_location), R.drawable.gaza_musem));
    }

    private void initializeRecyclerView() {
        setData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setHasFixedSize(true);
        adapter = new SiteAdapter(sites);
        binding.recyclerView.setAdapter(adapter);
    }
}