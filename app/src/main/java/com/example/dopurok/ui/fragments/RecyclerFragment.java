package com.example.dopurok.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dopurok.R;
import com.example.dopurok.adapter.MainAdapter;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    private RecyclerView recyclerView;
    private MainAdapter adapter = new MainAdapter();
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // заполняем данные для адаптера
        creatList();
        // метод для инициализации ресайклера и адаптера
        initRecycler(view);
    }

    // инициализация ресайклера и адаптера
    private void initRecycler(View view) {
        //1. инициализировали ресайклер
        recyclerView = view.findViewById(R.id.recycler_rv);
        //2. отправляем данные в адаптер
        adapter.AddItems(list);
        //3. засовываем внутрь ресайклера Адапер
        recyclerView.setAdapter(adapter);
    }

    private void creatList() {
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("sssss");
        list.add("eddddd");
    }
}