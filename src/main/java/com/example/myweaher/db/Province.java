package com.example.myweaher.db;

import org.litepal.crud.DataSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author: Jackson Young
 * @data: 2020-03-23 11:48
 * @description: 省
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Province extends DataSupport {

    private int id;

    private String provinceName;

    private int provinceCode;

}
