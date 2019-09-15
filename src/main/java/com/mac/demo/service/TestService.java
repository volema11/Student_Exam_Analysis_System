package com.mac.demo.service;

import com.mac.demo.model.Test;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Classname TestService
 * @Description TODO
 * @Date 2019/9/12 12:46 上午
 * @Created by wangxianlin
 */
public interface TestService {

    /**
     * 删除考试
     * @param testId
     * @return
     */
    int deleteByTest(Integer testId);

    /**
     * 发布考试
     * @param record
     * @return
     */
    int insertTest(Test record);

    /**
     * 修改考试
     * @param record
     * @return
     */
    int updateByTest(Test record);

    /**
     * 获取考试列表
     * @param page
     * @param limit
     * @return
     */
    Map<String,Object> getTest(Integer page, Integer limit);
}
