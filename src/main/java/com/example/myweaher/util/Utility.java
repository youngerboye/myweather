package com.example.myweaher.util;

import android.text.TextUtils;

import com.example.myweaher.db.City;
import com.example.myweaher.db.County;
import com.example.myweaher.db.Province;
import com.example.myweaher.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author: Jackson Young
 * @data: 2020-03-23 12:08
 * @description: 解析和处理服务器返回的数据
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     * @param response
     * @return
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvince = new JSONArray(response);
                for (int i = 0; i < allProvince.length() ; i++) {
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province()
                            .setProvinceName(provinceObject.getString("name"))
                            .setProvinceCode(provinceObject.getInt("id"));

                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCity = new JSONArray(response);
                for (int i = 0; i < allCity.length() ; i++) {
                    JSONObject provinceObject = allCity.getJSONObject(i);
                    City city = new City()
                            .setCityName(provinceObject.getString("name"))
                            .setCityCode(provinceObject.getInt("id"))
                            .setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounty= new JSONArray(response);
                for (int i = 0; i < allCounty.length() ; i++) {
                    JSONObject countyObject = allCounty.getJSONObject(i);
                    County city = new County()
                            .setCountyName(countyObject.getString("name"))
                            .setWeatherId(countyObject.getString("weather_id"))
                            .setCityId(cityId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将返回的JSON数据解析成Weather类
     */
    public static Weather handleWeatherResponse(String response) {
        try {
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}


