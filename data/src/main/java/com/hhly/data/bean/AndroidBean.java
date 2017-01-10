package com.hhly.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 描    述：安卓文章
 * 作    者：xul@13322.com
 * 时    间：2016/9/13
 */
public class AndroidBean implements Parcelable {
    public String _id;
    public String createdAt;
    public String desc;
    public String publishedAt;
    public String source;
    public String type;
    public String url;
    public boolean used;
    public String who;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._id);
        dest.writeString(this.createdAt);
        dest.writeString(this.desc);
        dest.writeString(this.publishedAt);
        dest.writeString(this.source);
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeByte(this.used ? (byte) 1 : (byte) 0);
        dest.writeString(this.who);
    }

    public AndroidBean() {
    }

    protected AndroidBean(Parcel in) {
        this._id = in.readString();
        this.createdAt = in.readString();
        this.desc = in.readString();
        this.publishedAt = in.readString();
        this.source = in.readString();
        this.type = in.readString();
        this.url = in.readString();
        this.used = in.readByte() != 0;
        this.who = in.readString();
    }

    public static final Parcelable.Creator<AndroidBean> CREATOR = new Parcelable.Creator<AndroidBean>() {
        @Override
        public AndroidBean createFromParcel(Parcel source) {
            return new AndroidBean(source);
        }

        @Override
        public AndroidBean[] newArray(int size) {
            return new AndroidBean[size];
        }
    };
}
