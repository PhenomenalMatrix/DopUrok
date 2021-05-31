package com.example.dopurok.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.dopurok.model.Users;

@Database(entities = {Users.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsersDao userDao();
}
