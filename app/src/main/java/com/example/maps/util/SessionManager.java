package com.example.maps.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.maps.MapsActivity;

import java.util.HashMap;

public class SessionManager {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    public static final String KEY_IDS = "id_user";
    private static final String KEY_NAMA = "nm_user";
    private static final String KEY_LEVEL = "level_user";
    private static final String is_login = "logginstatus";
    private final String SHARE_NAME = "loginsession";
    private final int MODE_PRIVATE = 0;
    private Context _context;

    public SessionManager(Context context) {
        this._context = context;
        sp = _context.getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
        editor = sp.edit();
    }

    public void storeLogin(String id_user, String name, String level) {
        editor.putBoolean(is_login, true);
        editor.putString(KEY_IDS, id_user);
        editor.putString(KEY_NAMA, name);
        editor.putString(KEY_LEVEL, level);
        editor.commit();
    }

    public HashMap getDetailLogin() {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_IDS, sp.getString(KEY_IDS,null));
        map.put(KEY_LEVEL, sp.getString(KEY_LEVEL,null));
        map.put(KEY_NAMA, sp.getString(KEY_NAMA,null));
        return map;
    }

    public void checkLogin() {
        if (!this.Loggin()){
            Intent login = new Intent(_context, MapsActivity.class);
            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(login);
        }
    }

    public Boolean Loggin() {
        return sp.getBoolean(is_login, false);
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }



}
