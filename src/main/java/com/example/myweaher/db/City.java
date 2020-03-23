package com.example.myweaher.db;

import org.litepal.crud.DataSupport;

import lombok.Data;

/**
 * @author: Jackson Young
 * @data: 2020-03-23 11:48
 * @description: 市
 */
@Data
public class City extends DataSupport {
    private int id;
    private String cityName;
    private int cityCode;
    private int provinceId;

}


