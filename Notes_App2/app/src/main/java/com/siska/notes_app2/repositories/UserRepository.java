package com.siska.notes_app2.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.siska.notes_app2.dao.UserDao;
import com.siska.notes_app2.db.AppDatabase;
import com.siska.notes_app2.models.User;

public class UserRepository {
    private UserDao dao;
    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        dao = db.userDao();
    }

    public LiveData<User> getUserByUsername(String username) {
        return dao.getUserByUsername(username);
    }
    public void insert(User user) {

    }

    private static class InsertAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao asyncTaskDao;
        private UserDao dao;

        @Override
        protected Void doInBackground(User... users) {
            return null;
        }
        InsertAsyncTask(UserDao dao) {
            asyncTaskDao = dao;
        }
        public void insert(User user) {
            new InsertAsyncTask(dao).execute(user);
        }

    }
}
