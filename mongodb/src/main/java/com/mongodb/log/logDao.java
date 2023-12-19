package com.mongodb.log;

import com.mongodb.pojo.LogBean;

import java.util.List;

/**
 * 日志数据访问接口
 */
public interface logDao {
    /**
     * 查询所有日志
     *
     * @return 包含所有日志的列表
     */
    List<LogBean> findlog();
}
