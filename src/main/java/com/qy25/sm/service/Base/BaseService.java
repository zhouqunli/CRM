package com.qy25.sm.service.Base;

import com.qy25.sm.vo.PageVo;

import java.util.*;

/**
 * service层也需要泛型,entity和数据类型
 */
public interface BaseService<T,ID>{
    /**
     * 分页查询
     */

    PageVo<T>findPage();
    /**
     * 通过iD查询
     */

    T findById(ID id);

    /**
     * 添加操作(可以添加所有对象，所以用一个泛型)
     */

    int addEntity(T entity);



    /**
     * 修改操作
     */

    int updateEntity(T entity);

    /**
     * 删除操作
     */
    int deleteById(ID id);


    /**
     * 批量添加
     */

    int batchAddEntity(List<T>list);

    /**
     * 批量修改
     * @param list
     * @return
     */
    int batchUpdateEntity(List<T>list);
    /**
     * 批量删除
     */

    int batchDeleteByIds(List<ID>ids);

    /**
     * 封装分页数据
     */
    PageVo<T> findPage(Object example);

    PageVo<T>setPageVo(List<T>list);
}
