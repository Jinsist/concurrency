package com.jinsist.concurrency.example.sync;

class SynchronizedExample1 {

//    public static void main(String[] args) {
//
//        TestEntity testEntity = new TestEntity();
//        Student student1 = new Student();
//        Student student2 = new Student();
//        student1.setName(Integer.valueOf(2).toString());
//        student1.setAge(Integer.valueOf(2).toString());
//        student2.setName(Integer.valueOf(2).toString());
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> {
//            testEntity.test002(student1);
//        });
//        executorService.execute(() -> {
//            testEntity.test003(student1);
//        });
//    }
}

public class TestEntity {

    synchronized void test001() {
            System.out.println("111");
    }

    public void test002(Student stu) {
        synchronized (stu.getName()) {
            System.out.println("222");
        }
    }
    public void test003(Student stu) {
        synchronized (stu.getName()) {
            System.out.println("333");
        }
    }
}


