package com.debin.demoapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class FakeServer implements Parcelable {

    private String userName;
    private String password;

    public FakeServer() {

    }

    protected FakeServer(Parcel in) {
        userName = in.readString();
        password = in.readString();
    }

    public void registerUser(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public boolean isExistingUser(String username, String password) {
        return this.userName.equals(username) && this.password.equals(password);
    }

    public static final Creator<FakeServer> CREATOR = new Creator<FakeServer>() {
        @Override
        public FakeServer createFromParcel(Parcel in) {
            return new FakeServer(in);
        }

        @Override
        public FakeServer[] newArray(int size) {
            return new FakeServer[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(password);
    }
}
