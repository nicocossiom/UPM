package com.tapastop.app;

import com.tapastop.app.collections.DishCollection;
import com.tapastop.app.collections.UserCollection;
import com.tapastop.app.controller.MainController;
import com.tapastop.app.model.Dish;
import com.tapastop.app.model.User;
import com.tapastop.app.requests.Birthdate;
import com.tapastop.app.requests.RegisterObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(MainController.class)
class TapasTopUnitTests {

    @Autowired
    private MockMvc mvc;

    @BeforeAll
    static void initCollections() throws Exception {
        UserCollection.initialize();
        DishCollection.initialize();
    }

    @Test
    void test1HomePage() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/");
        MvcResult result = mvc.perform(req).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void test2AuthNull() throws Exception {
        User respo = UserCollection.authUser(null, null);
        assertNull(respo);
    }

    @Test
    void test3AuthHappy() throws Exception {
        User respo = UserCollection.authUser("juanillo", "123456");
        assertNotNull(respo);
        assertEquals("juanillo", respo.getId());
    }

    @Test
    void test4AuthWrong() throws Exception {
        User respo = UserCollection.authUser("noexiste", "noexiste");
        assertNull(respo);
    }

    @Test
    void test5BirthdateFail() throws Exception {
        Birthdate bd = new Birthdate();
        bd.setDay("31");
        bd.setMonth("12");
        bd.setYear("2004");
        assertFalse(bd.checkBirthDate());
    }

    @Test
    void test6BirthdatePass() throws Exception {
        Birthdate bd = new Birthdate();
        bd.setDay("15");
        bd.setMonth("10");
        bd.setYear("2004");
        assertTrue(bd.checkBirthDate());
    }

    @Test
    void test7BirthdateInvalid() throws Exception {
        Birthdate bd = new Birthdate();
        bd.setDay("not");
        bd.setMonth("a");
        bd.setYear("date");
        assertFalse(bd.checkBirthDate());
    }

    @Test
    void test8BirthdateBlank() throws Exception {
        Birthdate bd = new Birthdate();
        bd.setDay("");
        bd.setMonth("");
        bd.setYear("");
        assertFalse(bd.checkBirthDate());
    }

    @Test
    void test9RateDishOnce() throws Exception {
        Dish d = DishCollection.getDishes().get(0);
        DishCollection.rateDish(0, 5);
        assertEquals(5.0, d.getRating());
        DishCollection.initialize();
    }

    @Test
    void test10RateDishMultipleTimes() throws Exception {
        Dish d = DishCollection.getDishes().get(0);
        DishCollection.rateDish(0, 3);
        DishCollection.rateDish(0, 2);
        DishCollection.rateDish(0, 1);
        assertEquals(2.0, d.getRating());
        DishCollection.initialize();
    }

    @Test
    void test11RateDishInvalid() throws Exception {
        Dish d = DishCollection.getDishes().get(0);
        DishCollection.rateDish(0, 9000);
        assertEquals(0.0, d.getRating());
        DishCollection.initialize();
    }

    @Test
    void test12AddDish() throws Exception {
        Dish d = new Dish("test dish", "test bar", "test", "tasty", "test", "test");
        DishCollection.addDish(d);
        assertEquals(1, d.getId());
    }

    @Test
    void test13RegisterUserOk() throws Exception {
        User u = new User("pepetest", "123", null, null, null, null);
        UserCollection.addUser(u);
        User got = UserCollection.authUser("pepetest", "123");
        assert got != null;
        assertEquals("pepetest", got.getId());
        UserCollection.initialize();
    }

    @Test
    void test14RegisterUserExistingFail() throws Exception {
        User u = new User("juanillo", "123", null, null, null, null);
        boolean addresult = UserCollection.addUser(u);
        assertFalse(addresult);
        UserCollection.initialize();
    }

    @Test
    void test15ModifyUser() throws Exception {
        RegisterObject base =  new RegisterObject();
        base.setId("moddable");
        base.setPassword("123");
        User u = new User(base);
        UserCollection.addUser(u);
        RegisterObject modded =  new RegisterObject();
        modded.setId("modded");
        modded.setPassword("123");
        User modUser = new User(modded);
        UserCollection.modifyUser(u.getId(), modUser);
        assertTrue(UserCollection.userExists("modded"));
        assertFalse(UserCollection.userExists("moddable"));
        UserCollection.initialize();
    }

    @Test
    void test16ModifyNonexistentUser() throws Exception {
        RegisterObject modded =  new RegisterObject();
        modded.setId("modded");
        modded.setPassword("123");
        User modUser = new User(modded);
        UserCollection.modifyUser("modded", modUser);
        assertFalse(UserCollection.userExists("modded"));
        UserCollection.initialize();
    }



}
