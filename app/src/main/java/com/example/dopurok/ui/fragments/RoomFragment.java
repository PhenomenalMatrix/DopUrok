package com.example.dopurok.ui.fragments;

import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.dopurok.App;
import com.example.dopurok.R;
import com.example.dopurok.adapter.RoomAdapter;
import com.example.dopurok.databinding.FragmentRoomBinding;
import com.example.dopurok.model.Users;
import com.example.dopurok.ui.activity.MainActivity;
import java.util.List;


public class RoomFragment extends Fragment implements RoomAdapter.OnItemClick{

    private FragmentRoomBinding binding;
    private RoomAdapter adapter;
    private MainActivity mainActivity = new MainActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        binding = FragmentRoomBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        roomInit();
        binding.fabBtn.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity(),R.id.fragment_container);
            navController.navigate(R.id.formFragment);

        });
    }


    private void roomInit() {
        App.getDatabase().userDao().getAll().observe(getViewLifecycleOwner(), new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> users) {
                initRecycler(users);
            }
        });
    }

    private void initRecycler(List<Users> users) {
        adapter = new RoomAdapter();
        adapter.addItems(users);
        adapter.addClick(this::onLongClick);
        binding.roomRv.addItemDecoration(new DividerItemDecoration(requireContext(),RecyclerView.VERTICAL));
        binding.roomRv.setAdapter(adapter);
    }


    @Override
    public void onLongClick(Users users) {
        App.getDatabase().userDao().delete(users);
    }

    private void loadSortRoom(){
        App.getDatabase().userDao().getSort().observe(getViewLifecycleOwner(), new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> users) {
                adapter.notifyDataSetChanged();
                initRecycler(users);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.action_bar_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.sort_btn:
                loadSortRoom();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}