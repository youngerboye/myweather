package com.example.myweaher.gson;

import com.google.gson.annotations.SerializedName;

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    @SerializedName("cond_txt")
    public String condTxt;

    public class More{
        public String info;
    }
}
