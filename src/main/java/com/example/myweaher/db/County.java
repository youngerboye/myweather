package com.example.myweaher.db;

import org.litepal.crud.DataSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Jackson Young
 * @data: 2020-03-23 11:50
 * @description: 县
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class County extends DataSupport {

    private int id;

    private String countyName;

    private String weatherId;

    private int cityId;
}


