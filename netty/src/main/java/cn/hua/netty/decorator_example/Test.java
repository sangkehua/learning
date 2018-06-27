package cn.hua.netty.decorator_example;

public class Test {
    public static void main(String[] args) {
        new ConcreteDecorator1(new ConcreteComponent()).doSomething();
    }
}
