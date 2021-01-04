package com.qy25.sm.service.base.impl;

import com.github.pagehelper.PageInfo;
import com.qy25.sm.mapper.base.BaseMapper;
import com.qy25.sm.service.base.BaseService;
import com.qy25.sm.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {
    @Autowired
    private BaseMapper<T, ID> baseMapper;

    /**
     * 如果下面的五个方法都不适用，有可能要使用baseMapper
     * @return
     */
    public BaseMapper<T,ID>getBaseMapper(){
        return baseMapper;
    }

    @Override
    public PageVo<T> findAll() {
        return setPageVo(baseMapper.selectByExample(null));
    }

    /**
     * 有条件分页查询
     * @param example
     * @return
     */
    @Override
    public PageVo<T> findAll(Object example) {
        return setPageVo(baseMapper.selectByExample(example));
    }

    @Override
    public T findById(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addEntity(T entity) {
        return baseMapper.insert(entity);
    }

    @Override
    public int updateEntity(T entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteById(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
   @Transactional
    @Override
    public int batchDeleteByIds(List<ID> ids) {
      ids.forEach(id->baseMapper.deleteByPrimaryKey(id));
        return 1;
    }


    @Override
    public PageVo<T> setPageVo(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        PageVo<T> pageVo = new PageVo<>();
        pageVo.setList(list);
        pageVo.setTotal(total);
        return pageVo;
    }
}
