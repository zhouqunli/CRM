package com.qy25.sm.controller.base;
import com.github.pagehelper.PageHelper;
import com.qy25.sm.common.http.AxiosResult;
import com.qy25.sm.service.Base.BaseService;
import com.qy25.sm.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
public class BaseController<T,ID> {


    @Autowired
    private BaseService<T,ID>baseService;

    @GetMapping
    public AxiosResult<PageVo<T>>findPage(@RequestParam(defaultValue = "1") int currentPage
            ,@RequestParam(defaultValue = "5") int pageSize){
        PageHelper.startPage(currentPage,pageSize);

        PageVo<T> page = baseService.findPage();
        return AxiosResult.success(page);
    }

    @GetMapping("{id}")
    public AxiosResult<T>findById(@PathVariable ID id){

        return AxiosResult.success(baseService.findById(id));
    }


    @PostMapping
    public AxiosResult<Void>addEntity(@RequestBody T entity){
       return toAxios(baseService.addEntity(entity));
    }

    /**
     *修改
     */

    @PutMapping
    public AxiosResult<Void>updateEntity(@RequestBody T entity){
      return toAxios(baseService.updateEntity(entity));
    }


    @DeleteMapping("{id}")
    public AxiosResult<Void>deleteEntity(@PathVariable ID id){

       return toAxios(baseService.deleteById(id));
    }

    /**
     * 抽取出来，为了批量操作
     */
    public AxiosResult<Void> toAxios(int row){
      return row>0?AxiosResult.success():AxiosResult.error();
    }
}
