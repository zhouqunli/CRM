package com.qy25.sm.service.base;

import com.qy25.sm.mapper.base.BaseMapper;
import com.qy25.sm.vo.PageVo;

import java.util.*;

public interface BaseService<T,ID> {


    PageVo<T>findAll();

    PageVo<T>findAll(Object example);

    T findById(ID id);

    int addEntity(T entity);

    int updateEntity(T entity);

    int deleteById(ID id);

    int batchDeleteByIds(List<ID> ids);

    PageVo<T>setPageVo(List<T>list);

    public BaseMapper<T,ID> getBaseMapper();
}
