package com.mongodb.log;

import com.mongodb.pojo.LogBean;

import java.util.List;

/**
 * 日志业务逻辑接口
 */
public interface logService
        /**
         * 查询所有日志
         *
         * @return 包含所有日志的列表
         */
{
    List<LogBean> findlog();

}
