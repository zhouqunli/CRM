package com.qy25.sm.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)//转json 的时候，只转值不为null的
public class AxiosResult<T> {

    private int status;

    private String message;

    private T data;

    private AxiosResult(){

    }

    /**
     * 成功返回的方法
     * @param <T>
     * @return
     */

    public static <T>AxiosResult<T>success(){
        return setData(AxiosStatus.OK,null);
    }

    /**
     * 封装数据公共方法
     */
    private static <T>AxiosResult<T> setData(AxiosStatus axiosStatus,T data){
        AxiosResult<T>axiosResult=new AxiosResult<>();
        axiosResult.setData(data);
        axiosResult.setStatus(axiosStatus.getStatus());
        axiosResult.setMessage(axiosStatus.getMessage());
             return axiosResult;
    }
    /**
     * 成功返回的方法，带具体数据
     */

    public static <T>AxiosResult<T>success(T data){
        return setData(AxiosStatus.OK,data);
    }

    /**
 * 成功返回的方法自定义状态码
 */

public static <T>AxiosResult<T>success(AxiosStatus axiosStatus){
    return setData(axiosStatus,null);
}


    /**
     * 成功返回带数据
     * @param axiosStatus
     * @param data
     * @param <T>
     * @return
     */

    public static <T>AxiosResult<T>success(AxiosStatus axiosStatus,T data){
        return setData(axiosStatus,data);
    }
    /**
     * 错误的返回携带数据
     */
    public static <T>AxiosResult<T>error(T data){
        return setData(AxiosStatus.ERROR,data);
    }

    /**
     * 错误的返回，带自定义状态码
     */

    public static <T>AxiosResult<T>error(AxiosStatus axiosStatus,T data){
        return setData(axiosStatus,data);
    }



    public static <T>AxiosResult<T>error(){
        return setData(AxiosStatus.ERROR,null);
    }
}
