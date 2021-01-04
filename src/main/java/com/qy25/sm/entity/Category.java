package com.qy25.sm.entity;

import com.qy25.sm.entity.base.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class Category extends BaseEntity<Long> {


    private String categoryName;

    private String categoryDesc;

    private Long parentId;



}