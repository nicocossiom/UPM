package com.tapastop.app;

import com.tapastop.app.collections.DishCollection;
import com.tapastop.app.collections.UserCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Tapas top application.
 */
@SpringBootApplication
public class TapasTopApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        UserCollection.initialize();
        DishCollection.initialize();
        SpringApplication.run(TapasTopApplication.class, args);
    }

}
