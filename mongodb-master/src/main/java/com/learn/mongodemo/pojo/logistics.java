package com.learn.mongodemo.pojo;

import lombok.Data;


/**
 * 物流信息实体类
 */
@Data
@SuppressWarnings("all")
public class logistics {

    private int orderId;// 订单id

    private String operation;// 操作

    private String operator;// 操作员

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private String operationTime;// 操作时间

    private String address;// 地址

    private String details;// 备注细节

    public logistics() {
    }

    public logistics(int orderId, String operation, String operator, String operationTime,
                     String address, String details) {
        this.orderId = orderId;
        this.operation = operation;
        this.operator = operator;
        this.operationTime = operationTime;
        this.address = address;
        this.details = details;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}