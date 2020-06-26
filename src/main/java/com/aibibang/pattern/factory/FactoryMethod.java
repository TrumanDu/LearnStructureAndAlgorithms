package com.aibibang.pattern.factory;

/**
 * @author: Truman.P.Du
 * @date: 2020/6/26 22:02
 * @description:
 */
public class FactoryMethod {
    interface Factory {
        Car produce();
    }

    class CarFactory implements Factory {
        @Override
        public Car produce() {
            System.out.println("汽车工程生产");
            return new Bus();
        }
    }

    class SuperCarFactory implements Factory {
        @Override
        public Car produce() {
            System.out.println("超跑汽车工程生产");
            return new SuperCar();
        }
    }

    interface Car {
        void show();
    }

    class Bus implements Car {
        @Override
        public void show() {
            System.out.println("公共汽车。。。");
        }
    }

    class SuperCar implements Car {
        @Override
        public void show() {
            System.out.println("超跑。。。");
        }
    }
}
