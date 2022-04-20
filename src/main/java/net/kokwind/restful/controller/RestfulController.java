package net.kokwind.restful.controller;

import net.kokwind.restful.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/restful")
public class RestfulController {
    @GetMapping("/request")
    public String doGetRequest() {
        //双引号中如果包含双引号，要使用转移字符\来转义
        return "{\"message\":\"返回查询结果\"}";
    }

    // 发送post /restful/request/100请求
    @PostMapping ("/request/{rid}")
    public String doPostRequest(@PathVariable("rid") Integer requestId, Person person) {
        System.out.println(person.getName() + ":" + person.getAge());
        //双引号中如果包含双引号，要使用转移字符\来转义
        return "{\"message\":\"数据新建成功\",\"id\":"   + requestId + "}";
    }

    @PutMapping ("/request")
    public String doPutRequest(Person person) {
        System.out.println(person.getName() + ":" + person.getAge());
        //双引号中如果包含双引号，要使用转移字符\来转义
        return "{\"message\":\"数据更新成功\"}";
    }

    @DeleteMapping("/request")
    public String doDeleteRequest() {
        //双引号中如果包含双引号，要使用转移字符\来转义
        return "{\"message\":\"数据删除成功\"}";
    }

    @GetMapping("/person")
    public Person getPerson(Integer id) {
        Person person = new Person();
        if(id == 1) {
            person.setName("kokwind");
            person.setAge(18);

        } else if(id == 2) {
            person.setName("kong");
            person.setAge(20);
        }
        return person;
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        List list = new ArrayList();
        Person p1 = new Person();
        p1.setName("kokwind");
        p1.setAge(18);
        p1.setBirthday(new Date());
        list.add(p1);
        Person p2 = new Person();
        p2.setName("kong");
        p2.setAge(20);
        p2.setBirthday(new Date());
        list.add(p2);
        return list;
    }
}
