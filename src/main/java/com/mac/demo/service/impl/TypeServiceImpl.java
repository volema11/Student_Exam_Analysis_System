package com.mac.demo.service.impl;

import com.mac.demo.mapper.TypeMapper;
import com.mac.demo.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname TypeServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:57 上午
 * @Created by wangxianlin
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeMapper typeMapper;
}