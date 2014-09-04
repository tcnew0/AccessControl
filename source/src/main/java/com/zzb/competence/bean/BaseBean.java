package com.zzb.competence.bean;

import com.alibaba.fastjson.JSON;

/**
 * Created by guanzhenxing on 2014-06-22.
 */
public abstract class BaseBean {

    /**
     * 将对象转json，便于前台传递数据：显示、修改
     * @return JSON
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
