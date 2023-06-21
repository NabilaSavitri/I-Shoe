package com.nabilasavitri.i_shoe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nabilasavitri.i_shoe.databinding.ItemTambahBinding;

import java.util.ArrayList;
import java.util.List;

public class TambaViewAdapter extends RecyclerView.Adapter<TambaViewAdapter.ViewHolder> {
    private List<Tambah> data = new ArrayList<>();
    private OnItemLongClickListener onItemLongClickListener ;

    public  void setData(List<Tambah> data) {
        this.data = data;
        notifyDataSetChanged();
    }



    public void setOnItemLongClickListener(TambaViewAdapter.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public TambaViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemTambahBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TambaViewAdapter.ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        Tambah tambah = data.get(pos);

        holder.itemTambahBinding.tvNamaMerekSepatu.setText(tambah.getNamaMerekSepatu());
        holder.itemTambahBinding.tvModelSepatu.setText(tambah.getModelSepatu());
        holder.itemTambahBinding.tvJenisSepatu.setText(tambah.getJenisSepatu());
        holder.itemTambahBinding.tvWarnaSepatu.setText(tambah.getWarnaSepatu());
        holder.itemTambahBinding.tvUkuranSepatu.setText(String.valueOf(tambah.getUkuranSepatu()));
        holder.itemTambahBinding.tvJumlahSepatu.setText(String.valueOf(tambah.getJumlahSepatu()));
        holder.itemTambahBinding.tvHargaPerPcsSepatu.setText(String.valueOf(tambah.getHargaPerPcsSepatu()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener.onItemLongClick(v,tambah,pos);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemTambahBinding itemTambahBinding;

        public ViewHolder(@NonNull ItemTambahBinding itemView) {
            super(itemView.getRoot());
            itemTambahBinding = itemView;
        }
    }
    public interface OnItemLongClickListener {
        void onItemLongClick(View v, Tambah tambah, int position);
    }
}
