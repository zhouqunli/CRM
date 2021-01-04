package com.qy25.sm.entity;

import com.qy25.sm.entity.base.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class Brand extends BaseEntity<String> {


    private String brandName;

    private String brandSize;

    private String brandDesc;

    private String brandLogo;

}