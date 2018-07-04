package com.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author
 * @create 2017-11-21 9:50
 **/
public class DynamicProxy {

    //要代理的对象
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object getProxyObject(){
        //代理对象由哪一个类加载器加载
        ClassLoader classLoader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] classes = new Class[] {Object.class};
        //当调用代理对象的方法时，执行的方法
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy:正在返回的代理对象，一般在invoke方法中不使用该个对象
             * @param method:正在被调用的方法
             * @param args:调用方法时传入的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //调用目标中的方法
                Object result = method.invoke(target,args);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,classes,handler);
    }
}
