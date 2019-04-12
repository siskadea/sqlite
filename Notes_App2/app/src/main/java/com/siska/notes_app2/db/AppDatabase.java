package com.siska.notes_app2.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.siska.notes_app2.dao.NoteDao;
import com.siska.notes_app2.dao.UserDao;
import com.siska.notes_app2.models.Note;
import com.siska.notes_app2.models.User;

@Database(entities = {User.class, Note.class}, version = 1,exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "notes";

    private static volatile AppDatabase INSTANCE = null;
    public abstract UserDao userDao();

    public abstract NoteDao noteDao();

    public static AppDatabase getInstance(final Context context) {
        synchronized (AppDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room
                        .databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }


}