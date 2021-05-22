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
import com.rns.tourguideapplication.databinding.FragmentHotelsBinding;
import com.rns.tourguideapplication.model.Site;

import java.util.ArrayList;

public class HotelsFragment extends Fragment {

    private FragmentHotelsBinding binding;
    private SiteAdapter adapter;
    private ArrayList<Site> sites = new ArrayList<>();

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHotelsBinding.inflate(inflater, container, false);
        initializeRecyclerView();
        return binding.getRoot();
    }

    private void setData() {
        sites.add(new Site(getString(R.string.almathaf), getString(R.string.almathaf_location), R.drawable.almathaf_hotel));
        sites.add(new Site(getString(R.string.blue_beach), getString(R.string.blue_sammak_location), R.drawable.blue_beach_hotel));
        sites.add(new Site(getString(R.string.arcmed), getString(R.string.arcmed_location), R.drawable.arcmed_hotel));
    }

    private void initializeRecyclerView() {
        setData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setHasFixedSize(true);
        adapter = new SiteAdapter(sites);
        binding.recyclerView.setAdapter(adapter);
    }
}