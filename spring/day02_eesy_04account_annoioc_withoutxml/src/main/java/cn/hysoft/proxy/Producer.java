package cn.hysoft.proxy;

import cn.hysoft.proxy.IProducer;

public class Producer implements IProducer {
    public void saleProduct(Float money){
        System.out.println("销售产品，并拿到钱"+money);
    }

    public void afterService(Float money){
        System.out.println("提供售后服务，并拿到钱"+money);
    }
}
