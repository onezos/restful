package net.kokwind.restful.controller;

import net.kokwind.restful.entity.Person;
import org.springframework.web.bind.annotation.*;

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
}
