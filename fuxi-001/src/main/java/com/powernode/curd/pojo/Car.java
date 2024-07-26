package com.powernode.curd.pojo;

import java.util.Date;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/3 17:19
 * @description:
 */
public class Car {
    private Integer id;
    private String carNum;
    private String brand;
    private  Double guidePrice;
    private String produceTime;
    private String carType;


    public Car() {
    }

    public Car(Integer id, String carNum, String brand, Double guidePrice, String produceTime, String carType) {
        this.id = id;
        this.carNum = carNum;
        this.brand = brand;
        this.guidePrice = guidePrice;
        this.produceTime = produceTime;
        this.carType = carType;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return carNum
     */
    public String getCarNum() {
        return carNum;
    }

    /**
     * 设置
     * @param carNum
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    /**
     * 获取
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取
     * @return guidePrice
     */
    public Double getGuidePrice() {
        return guidePrice;
    }

    /**
     * 设置
     * @param guidePrice
     */
    public void setGuidePrice(Double guidePrice) {
        this.guidePrice = guidePrice;
    }

    /**
     * 获取
     * @return produceTime
     */
    public String getProduceTime() {
        return produceTime;
    }

    /**
     * 设置
     * @param produceTime
     */
    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    /**
     * 获取
     * @return carType
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置
     * @param carType
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String toString() {
        return "Car{id = " + id + ", carNum = " + carNum + ", brand = " + brand + ", guidePrice = " + guidePrice + ", produceTime = " + produceTime + ", carType = " + carType + "}";
    }
}
