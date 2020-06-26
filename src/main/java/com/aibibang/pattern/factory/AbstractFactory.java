package com.aibibang.pattern.factory;

/**
 * @author: Truman.P.Du
 * @date: 2020/6/26 22:02
 * @description:
 */
public class AbstractFactory {
    interface Factory {
        Product produceEngine();
        Product produceTyre();
    }

    class CarFactory implements Factory {

        @Override
        public Product produceEngine() {
            System.out.println("汽车工厂：生产发动机");
            return new Engine();
        }

        @Override
        public Product produceTyre() {
            System.out.println("汽车工厂：生产发轮胎");
            return new Tyre();
        }
    }

    class SuperCarFactory implements Factory {

        @Override
        public Product produceEngine() {
            System.out.println("超跑汽车工厂：生产发动机");
            return new Engine();
        }

        @Override
        public Product produceTyre() {
            System.out.println("超跑汽车工厂：生产发轮胎");
            return new Tyre();
        }
    }

    interface Product {
        void show();
    }

    class Tyre implements Product {
        @Override
        public void show() {
            System.out.println("轮胎。。。");
        }
    }

    class Engine implements Product {
        @Override
        public void show() {
            System.out.println("发动机。。。");
        }
    }
}
