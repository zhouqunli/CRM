package com.qy25.sm.mapper.base;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *使用泛型，做一个基本的mapper所有的实现都能调用
 */
@Component
//还有存在双主键问题，两个主键类型就不一样了
public interface BaseMapper<T,ID> {
    long countByExample(Object example);

    int deleteByExample(Object example);
    // ID有可能是Long类型有可能是int类型，或者String类型,Serializable是所有基本类型的父类
    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(Object example);

    T selectByPrimaryKey(ID id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

    int updateByExample(@Param("record") T record, @Param("example") Object example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
