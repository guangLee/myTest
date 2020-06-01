package com.thread;

import java.util.concurrent.atomic.AtomicReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString@AllArgsConstructor@Data
class User{
    private String name;
    private int age;
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {

        User zs = new User("zs", 22);
        User ls = new User("ls", 22);

        AtomicReference<User> userAtomicReference = new AtomicReference<>();

        userAtomicReference.set(zs);

        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get().toString());

        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get().toString());
    }
}