package com.qy25.sm.service.Base.impl;

import com.github.pagehelper.PageInfo;
import com.qy25.sm.mapper.base.BaseMapper;
import com.qy25.sm.service.Base.BaseService;
import com.qy25.sm.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BaseServiceImpl<T,ID> implements BaseService<T,ID> {

    @Autowired(required = true)
    private BaseMapper<T,ID>baseMapper;

    /**
     * 分页查询带条件的
     *
     * @return
     */
    @Override
    public PageVo<T> findPage() {
        List<T> ts = baseMapper.selectByExample(null);
        PageVo<T> pageVo = setPageVo(ts);
        return pageVo;
    }

    /**
     * 条件查询
     *
     * @param example
     * @return
     */
    @Override
    public PageVo<T> findPage(Object example) {
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
     * 批量操作
     *
     * @param list
     * @return
     */
    @Transactional
    @Override
    public int batchAddEntity(List<T> list) {
//这里操作了多次数据库，需要考虑事务问题
        list.forEach(item -> baseMapper.insert(item));
        //这里返回1假设它插入成功了,插入失败走异常处理
        return 1;
    }

    @Transactional
    @Override
    public int batchUpdateEntity(List<T> list) {
        list.forEach(item -> baseMapper.updateByPrimaryKey(item));
        return 1;
    }

    /**
     * service可以调用service层的方法，不可以用，虽然不会出错
     * @param ids
     * @return
     */
    @Override
    public int batchDeleteByIds(List<ID> ids) {

      ids.forEach(item->baseMapper.deleteByPrimaryKey(item));
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
