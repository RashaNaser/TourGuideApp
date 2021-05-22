package com.rns.tourguideapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rns.tourguideapplication.databinding.CustomLayoutBinding;
import com.rns.tourguideapplication.model.Site;

import java.util.ArrayList;

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.SiteHolder> {

    private final ArrayList<Site> sites;

    public SiteAdapter(ArrayList<Site> sites) {
        this.sites = sites;
    }

    @NonNull
    @Override
    public SiteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SiteHolder(CustomLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SiteHolder holder, int position) {
        holder.setData(sites.get(position));
    }

    @Override
    public int getItemCount() {
        return sites.size();
    }

    public static class SiteHolder extends RecyclerView.ViewHolder {
        public CustomLayoutBinding binding;
        public Site site;

        public SiteHolder(CustomLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setData(Site site) {
            this.site = site;
            binding.customImage.setImageResource(site.getmSiteImage());
            binding.customName.setText(site.getmSiteName());
            binding.customLocation.setText(site.getmSiteLocation());
        }
    }
}