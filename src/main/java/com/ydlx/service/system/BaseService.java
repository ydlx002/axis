package com.ydlx.service.system;

import com.ydlx.domain.vo.ResultVo;

/**
 * Created by ydlx on 2017/5/3.
 */
public interface BaseService<T> {

    /**
     * 根据ID获取信息
     * @param id
     * @return
     */
     T getInfoById(Integer id);

    /**
     * 新增信息
     * @param t
     * @return
     */
     ResultVo addInfo(T t);

    /**
     * 更新信息
     * @param t
     * @return
     */
     ResultVo updateInfo(T t);


    /***
     * 根据ID删除信息
     * @param id
     * @return
     */
    ResultVo deleteInfo(Integer id);


}
