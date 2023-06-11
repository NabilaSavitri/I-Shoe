package com.nabilasavitri.i_shoe;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class TambahViewAdapater extends RecyclerView.Adapter<TambahViewAdapater.ViewHolder> {
    private List<Tambah> data = new ArrayList<>();

    public void setData(List<Tambah> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TambahViewAdapater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Inflater ItemTambahBinding;
        return new ViewHolder(ItemTambahBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        Tambah tambah = data.get(pos);
        holder.itemTambahBinding.tvUser

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Object itemTambahBinding;

        public int getAdapterPosition() {


        }
    }
}
