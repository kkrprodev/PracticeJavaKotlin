package designpatterns.creational.singleton;

import java.util.Optional;

public class JSingleton {

    private static JSingleton jSingleton;
    private String name;

    private JSingleton(String name) {
        this.name = name;
    }

    public static JSingleton getInstance(String name) {

        Optional.ofNullable(jSingleton).orElseGet(() -> {
            jSingleton = new JSingleton(name);
            return jSingleton;
        });

        return jSingleton;
    }

    public String getName() {
        return this.name;
    }
}
