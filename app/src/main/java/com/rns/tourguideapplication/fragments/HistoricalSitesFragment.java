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
import com.rns.tourguideapplication.databinding.FragmentHistoricalSitesBinding;
import com.rns.tourguideapplication.model.Site;

import java.util.ArrayList;

public class HistoricalSitesFragment extends Fragment {

    private FragmentHistoricalSitesBinding binding;
    private SiteAdapter adapter;
    private ArrayList<Site> sites = new ArrayList<>();

    public HistoricalSitesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoricalSitesBinding.inflate(inflater, container, false);
        initializeRecyclerView();
        return binding.getRoot();
    }

    private void setData() {
        sites.add(new Site(getString(R.string.omari), getString(R.string.omari_location), R.drawable.omari_site));
        sites.add(new Site(getString(R.string.hilarion), getString(R.string.hilarion_location), R.drawable.hilarion));
        sites.add(new Site(getString(R.string.samara), getString(R.string.smara_location), R.drawable.samara));
    }

    private void initializeRecyclerView() {
        setData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setHasFixedSize(true);
        adapter = new SiteAdapter(sites);
        binding.recyclerView.setAdapter(adapter);
    }
}