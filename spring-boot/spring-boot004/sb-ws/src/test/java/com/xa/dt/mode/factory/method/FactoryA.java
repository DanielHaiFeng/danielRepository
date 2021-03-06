package com.xa.dt.mode.factory.method;

/**
 * @ FactoryA.java
 * 具体工厂A
 * 负责具体的产品A生产
 */
public class FactoryA extends Factory {

    @Override
    Product getProduct() {
        return new ProductA();
    }
}
