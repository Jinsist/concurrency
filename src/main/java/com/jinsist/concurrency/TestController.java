package com.jinsist.concurrency;


import com.jinsist.concurrency.example.sync.Student;
import com.jinsist.concurrency.example.sync.TestEntity;
import com.jinsist.concurrency.example.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/test002")
    public String test002(String name) {
        TestEntity testEntity = new TestEntity();
        Student stu = new Student();
        stu.setName(name);
        testEntity.test002(stu);
        return "test";
    }

    @RequestMapping("/test003")
    public String test003(String name) {
        TestEntity testEntity = new TestEntity();
        Student stu = new Student();
        stu.setName(name);
        testEntity.test002(stu);
        return "test";
    }

    @RequestMapping("/threadLocal")
    public Long threadLocalTest() {
        log.info("{}", RequestHolder.getId());
        return RequestHolder.getId();
    }
}
