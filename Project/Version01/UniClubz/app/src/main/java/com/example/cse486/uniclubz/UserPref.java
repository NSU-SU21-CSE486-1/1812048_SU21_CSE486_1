package com.example.cse486.uniclubz;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class UserPref {

    // Shared Preferences
    SharedPreferences userinfopref;

    Editor editor;
    Context mcontext;


    private static final String PREF_NAME = "UserInfoPref";
    enum Keys{
        LOGGED_IN
    }

    public UserPref(Context context) {
        this.mcontext = context;
        userinfopref = mcontext.getSharedPreferences(PREF_NAME,0 );

    }

    // user info
    public String getName() {
        return userinfopref.getString("name", "user");
    }

    public void setName(String name) {
        editor = userinfopref.edit();
        editor.putString("name", name);
        editor.apply();

    }

    public String getEmail() {

        return userinfopref.getString("email", "email@email.com");
    }

    public void setEmail(String email) {
        editor = userinfopref.edit();
        editor.putString("email", email);
        editor.apply();

    }


    public String getNID() {

        return userinfopref.getString("NID", "123");
    }

    public void setNID(String nid) {
        editor = userinfopref.edit();
        editor.putString("NID", nid);
        editor.commit();

    }

    public String getDOB() {

        return userinfopref.getString("dob", "0");
    }

    public void setDOB(String dob) {
        editor = userinfopref.edit();
        editor.putString("dob", dob);
        editor.commit();

    }


    public String getSID() {

        return userinfopref.getString("SID", "123");
    }

    public void setSID(String sid) {
        editor = userinfopref.edit();
        editor.putString("SID", sid);
        editor.commit();

    }

    public String getDept() {

        return userinfopref.getString("dept", "None");
    }

    public void setDept(String dept) {
        editor = userinfopref.edit();
        editor.putString("dept", dept);
        editor.commit();
    }

    public String getUni() {

        return userinfopref.getString("uni", "0");
    }

    public void setUni(String uni) {
        editor = userinfopref.edit();
        editor.putString("uni", uni);
        editor.commit();
    }

    public String getStudy() {

        return userinfopref.getString("study", "1");
    }

    public void setStudy(String study) {
        editor = userinfopref.edit();
        editor.putString("study", study);
        editor.commit();
    }

    public String getPhone() {

        return userinfopref.getString("phone", "");
    }

    public void setPhone(String phone) {
        editor = userinfopref.edit();
        editor.putString("phone", phone);
        editor.commit();
    }

    public String getBloodGroup() {

        return userinfopref.getString("bloodgroup", "A+");
    }

    public void setBloodGroup(String bloodgroup) {
        editor = userinfopref.edit();
        editor.putString("bloodgroup", bloodgroup);
        editor.commit();
    }

    public void setLogin(boolean isLoggedIn) {
        editor = userinfopref.edit();
        editor.putBoolean(Keys.LOGGED_IN.name(), isLoggedIn);
        editor.apply();

    }

    public boolean isLoggedIn() {
        return userinfopref.getBoolean(Keys.LOGGED_IN.name(), false);
    }


}
