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

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentHistoricalSitesBinding binding;
    private SiteAdapter adapter;
    private ArrayList<Site> sites = new ArrayList<>();
    private String mParam1;
    private String mParam2;

    public HistoricalSitesFragment() {
        // Required empty public constructor
    }

    public static HistoricalSitesFragment newInstance(String param1, String param2) {
        HistoricalSitesFragment fragment = new HistoricalSitesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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