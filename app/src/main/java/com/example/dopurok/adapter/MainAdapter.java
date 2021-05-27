package com.example.dopurok.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dopurok.R;
import com.example.dopurok.model.Users;
import com.example.dopurok.ui.fragments.RecyclerFragment;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    // Список адаптера
    private ArrayList<Users> name = new ArrayList<>();

    // Для добавления данных из вне
    // в свой собственный лист (который находится в адаптере)
    public void AddItems(ArrayList<Users> list){
        this.name.addAll(list);
        notifyDataSetChanged();
    }


    // Создает вьюХолдер и привязывает отображение (item)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(name.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView fio;
        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_tv);
            fio = itemView.findViewById(R.id.fio_tv);
            img = itemView.findViewById(R.id.img_view);

        }

        public void onBind(Users user) {
            name.setText(user.getName());
            fio.setText(user.getFio());
            img.setImageResource(user.getImage());
        }
    }
}
