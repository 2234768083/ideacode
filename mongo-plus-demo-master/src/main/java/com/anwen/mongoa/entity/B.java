package com.anwen.mongoa.entity;

import com.anwen.mongo.annotation.ID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author JiaChaoYang
 * @project mongo-plus-demo
 * @description B
 * @date 2023-11-02 14:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class B {


    @ID
    private Long id;
}
