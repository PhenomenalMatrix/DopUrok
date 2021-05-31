package com.example.dopurok.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dopurok.App;
import com.example.dopurok.R;
import com.example.dopurok.databinding.FragmentFormBinding;
import com.example.dopurok.databinding.FragmentRoomBinding;
import com.example.dopurok.model.Users;

public class FormFragment extends Fragment {

    private FragmentFormBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getDatabase().userDao().insert(new Users(binding.nameEt.getText().toString(),binding.fioEt.getText().toString(),R.drawable.ic_launcher_background));
                NavController navController = Navigation.findNavController(requireActivity(),R.id.fragment_container);
                navController.navigateUp();
            }
        });
    }
}