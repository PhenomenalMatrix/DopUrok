package com.example.dopurok.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dopurok.model.Users;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UsersDao {

    @Query("SELECT * FROM Users")
    LiveData<List<Users>> getAll();

    @Query("SELECT * FROM Users ORDER BY name ASC")
    LiveData<List<Users>> getSort();

    @Insert
    void insert(Users users);

    @Delete
    void delete(Users users);

}
