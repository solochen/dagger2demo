package com.mydagger.demo.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chenshaolong on 2019/10/17.
 */

public class Self implements Parcelable{

    private String nickname;
    private String avatar;

    protected Self(Parcel in) {
        nickname = in.readString();
        avatar = in.readString();
    }

    public static final Creator<Self> CREATOR = new Creator<Self>() {
        @Override
        public Self createFromParcel(Parcel in) {
            return new Self(in);
        }

        @Override
        public Self[] newArray(int size) {
            return new Self[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nickname);
        dest.writeString(avatar);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
