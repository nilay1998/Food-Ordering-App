package com.example.androidlogin;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Sessions {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String PREF_NAME = "AndroidHivePref";
    private static final String IS_ADMIN = "IsAdmin";

    public Sessions (Context context) {
        pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        editor = pref.edit();
    }

    void createSession()
    {
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }

    void adminLogin()
    {
        editor.putBoolean(IS_LOGIN, true);
        editor.putBoolean(IS_ADMIN,true);
        editor.commit();
    }

    void adminLogout()
    {
        editor.putBoolean(IS_LOGIN, false);
        editor.putBoolean(IS_ADMIN,false);
        editor.commit();
    }

    void killSession()
    {
        editor.putBoolean(IS_LOGIN, false);
        editor.commit();
    }

    boolean isAdmin() { return  pref.getBoolean(IS_ADMIN,false); }

    boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
