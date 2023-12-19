package com.anwen.mongoa.entity;

import com.anwen.mongo.annotation.ID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JiaChaoYang
 * @project mongo-plus-demo
 * @description A
 * @date 2023-11-02 14:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class A {

    @ID
    private Long id;
}
