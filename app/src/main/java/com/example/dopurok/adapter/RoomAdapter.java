package com.example.dopurok.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dopurok.R;
import com.example.dopurok.databinding.ItemRoomBinding;
import com.example.dopurok.model.Users;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {

    private OnItemClick click;
    private List<Users> list = new LinkedList<>();
    private ItemRoomBinding binding;

    public void addItems(List<Users> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addClick(OnItemClick onItemClick){
        click = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         binding = ItemRoomBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemRoomBinding itemView) {
            super(binding.getRoot());

        }

        public void onBind(Users users) {
            binding.firstTv.setText(users.getName());
            binding.secondTv.setText(users.getFio());
            binding.getRoot().setOnLongClickListener(v -> {
                click.onLongClick(users);
                return true;
            });

        }

    }

    public interface OnItemClick{
        void onLongClick(Users users);
    }
}
