package com.example.myweaher.db;

import org.litepal.crud.DataSupport;

import lombok.Data;

/**
 * @author: Jackson Young
 * @data: 2020-03-23 11:48
 * @description: 省
 */
@Data
public class Province extends DataSupport {

    private int id;

    private String provinceName;

    private int provinceCode;

}
