package com.siska.notes_app2.dao;

import android.arch.persistence.room.Dao;
import android.view.View;
@Dao
public interface OnRegisterFragmentListener {
    void onRegisterButtonClicked(View view, String username, String password);
    void onLoginLinkClicked();
}
