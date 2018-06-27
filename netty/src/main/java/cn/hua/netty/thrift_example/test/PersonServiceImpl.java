package cn.hua.netty.thrift_example.test;

import cn.hua.netty.thrift_example.DataException;
import cn.hua.netty.thrift_example.Person;
import cn.hua.netty.thrift_example.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("GET CLIENT PARAM: " + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println(person.getUsername() + " : " + person.getAge() + " : " + person.isMarried());
    }
}
