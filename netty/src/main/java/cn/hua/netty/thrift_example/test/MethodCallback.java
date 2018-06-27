package cn.hua.netty.thrift_example.test;

import cn.hua.netty.thrift_example.Person;
import org.apache.thrift.async.AsyncMethodCallback;

/*public class MethodCallback implements AsyncMethodCallback<Void>  {






    @Override
    public void onComplete(Void response) {
        System.out.println("完成");
    }

    @Override
    public void onError(Exception exception) {
        System.out.println("onError");
    }
}*/

public class MethodCallback implements AsyncMethodCallback<Person> {


    @Override
    public void onComplete(Person response) {
        System.out.println(response.getUsername());
        System.out.println(response.getAge());
        System.out.println(response.isMarried());
    }

    @Override
    public void onError(Exception exception) {
        System.out.println("onError");
    }
}