package org.RedisExample;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;


class RedisClient {

    private static RedissonClient client;

    public static RedissonClient getClient() {

        if (client == null) {

            Config config = new Config();
            config.useSingleServer()
                    .setAddress("redis://127.0.0.1:6379");

            client = Redisson.create(config);
        }

        return client;
    }
}

class MyCache {

    private final RedissonClient client = RedisClient.getClient();

    public <T> T get(Integer key) {

        RBucket<T> bucket = client.getBucket(key.toString());
        return bucket.get();
    }

    public void put(Integer key, Object value, long ttlMillis) {

        RBucket<Object> bucket = client.getBucket(key.toString());
        bucket.set(value, ttlMillis, TimeUnit.MILLISECONDS);
    }
}

class MyClass {
    private static final MyCache myCache = new MyCache();

    public Student getData(Integer id) {

        Student student = myCache.get(id);

        if (student == null) {

            System.out.println("Fetching from DB...");

            student = retrieveDataFromDatabase(id);

            myCache.put(id, student, 600_000); // 10 minutes
        } else {

            System.out.println("Fetching from Redis...");
        }

        return student;
    }

    private Student retrieveDataFromDatabase(Integer id) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Student student = session.get(Student.class, id);
        session.close();
        factory.close();

        return student;
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass service = new MyClass();

        Student student = service.getData(6);
        System.out.println(student);

        Student stu = service.getData(6);
        System.out.println(stu);

        // shutdown Redis client
        RedisClient.getClient().shutdown();

        System.out.println("Program finished.");
    }
}
