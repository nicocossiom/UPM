package com.tapastop.app.controller;

import com.tapastop.app.collections.DishCollection;
import com.tapastop.app.collections.UserCollection;
import com.tapastop.app.model.Dish;
import com.tapastop.app.model.User;
import com.tapastop.app.requests.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * The type Main controller.
 */
@Controller
public class MainController {


    /**
     * Login form string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("loginobject", new LoginObject());
        return "login";
    }

    /**
     * Enter age string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/age")
    public String enterAge(Model model) {
        model.addAttribute("birthdate", new Birthdate());
        return "age";
    }

    /**
     * Check age string.
     *
     * @param birthDate the birth date
     * @param model     the model
     * @return the string
     */
    @PostMapping("/age")
    public String checkAge(@ModelAttribute Birthdate birthDate, Model model) {
        model.addAttribute("birthdate", birthDate);
        if (!birthDate.checkBirthDate()) {
            return "age-error";
        } else {
            return "redirect:register";
        }
    }

    /**
     * Enter user string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/register")
    public String enterUser(Model model) {
        model.addAttribute("registerobject", new RegisterObject());
        return "register";
    }

    /**
     * Register user string.
     *
     * @param registerObject the register object
     * @param model          the model
     * @return the string
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegisterObject registerObject, Model model) {
        model.addAttribute("registerobject", registerObject);
        if (registerObject.getId() == null || registerObject.getId().isBlank()) {
            model.addAttribute("status", "El nombre de usuario no puede ser vacio");
            return "register";
        }
        if (registerObject.getPassword() == null || registerObject.getPassword().length() < 6) {
            model.addAttribute("status", "La contraseña debe tener por lo menos 6 caracteres");
            return "register";
        }
        if (!registerObject.getEmail().equals(registerObject.getConfirmEmail())) {
            model.addAttribute("status", "Las direcciones de correo no coinciden");
            return "register";
        }
        if (!registerObject.getPassword().equals(registerObject.getConfirmPassword())) {
            model.addAttribute("status", "Las contraseñas no coinciden");
            return "register";
        }
        if (UserCollection.userExists(registerObject.getId())) {
            model.addAttribute("status", "Ya existe un usuario con ese nombre");
            return "register";
        }
        /*
            A partir de aqui se considera valida la informacion dada por el usuario
         */

        User newUser = new User(registerObject);
        UserCollection.addUser(newUser);
        model.addAttribute("status", "Registrado con éxito, puede volver al inicio y entrar");
        return "register";
    }

    @GetMapping("/modify/{user}")
    public String showModify(Model model, @PathVariable String user) {
        RegisterObject ro = new RegisterObject();
        User curUser = UserCollection.getUser(user);
        ro.setAddress(curUser.getAddress());
        ro.setEmail(curUser.getEmail());
        ro.setConfirmEmail(curUser.getEmail());
        ro.setName(curUser.getName());
        ro.setPassword(curUser.getPassword());
        ro.setConfirmPassword(curUser.getPassword());
        ro.setSurname(curUser.getSurname());
        ro.setImagePath(curUser.getImagePath());
        ro.setId(user);
        model.addAttribute("registerobject", ro);
        return "modify";
    }

    @PostMapping("/modify/{user}")
    public String modifyUser(@ModelAttribute RegisterObject registerObject, Model model, @PathVariable String user) {
        model.addAttribute("registerobject", registerObject);
        if (registerObject.getId() == null || registerObject.getId().isBlank()) {
            model.addAttribute("status", "El nombre de usuario no puede ser vacio");
            return "modify";
        }
        if (registerObject.getPassword() == null || registerObject.getPassword().length() < 6) {
            model.addAttribute("status", "La contraseña debe tener por lo menos 6 caracteres");
            return "modify";
        }
        if (!registerObject.getEmail().equals(registerObject.getConfirmEmail())) {
            model.addAttribute("status", "Las direcciones de correo no coinciden");
            return "modify";
        }
        if (!registerObject.getPassword().equals(registerObject.getConfirmPassword())) {
            model.addAttribute("status", "Las contraseñas no coinciden");
            return "modify";
        }
        if (UserCollection.userExists(registerObject.getId()) && !registerObject.getId().equalsIgnoreCase(user)) {
            model.addAttribute("status", "Ya existe un usuario con ese nombre");
            return "modify";
        }
        /*
            A partir de aqui se considera valida la informacion dada por el usuario
         */

        User newUser = new User(registerObject);
        UserCollection.modifyUser(user, newUser);
        return getHome(newUser.getId(), model);
    }


    /**
     * Process login string.
     *
     * @param loginObject the login object
     * @param model       the model
     * @return the string
     */
    @PostMapping("/")
    public String processLogin(@ModelAttribute LoginObject loginObject, Model model) {
        model.addAttribute("loginobject", loginObject);
        User retrieved = UserCollection.authUser(loginObject.getUser(), loginObject.getPass());
        if (retrieved == null) {
            model.addAttribute("status", "Usuario o contraseña incorrectos");
            return "login";
        } else {
            return "redirect:home/" + loginObject.getUser();
        }
    }

    /**
     * Show rate string.
     *
     * @param model the model
     * @param id    the id
     * @param user  the user
     * @return the string
     */
    @GetMapping("/rate/{user}/{id}")
    public String showRate(Model model, @PathVariable String id, @PathVariable String user) {
        RateDishRequest rq = new RateDishRequest();
        rq.setUser(user);
        rq.setId(id);
        rq.setName(DishCollection.getDishName(Integer.parseInt(id)));
        model.addAttribute("rateDishRequest", rq);
        return "rate";
    }

    /**
     * Process rate string.
     *
     * @param rq    the rq
     * @param model the model
     * @param id    the id
     * @param user  the user
     * @return the string
     */
    @PostMapping("/rate/{user}/{id}")
    public String processRate(@ModelAttribute RateDishRequest rq, Model model,
                              @PathVariable String id, @PathVariable String user) {
        int idnum = Integer.parseInt(id);
        int rating = Integer.parseInt(rq.getRating());
        DishCollection.rateDish(idnum, rating);
        /*
            Retorno a la vista principal
         */
        return getHome(user, model);
    }

    /**
     * Show add string.
     *
     * @param model the model
     * @param user  the user
     * @return the string
     */
    @GetMapping("/add/{user}")
    public String showAdd(Model model, @PathVariable String user) {
        AddDishRequest rq = new AddDishRequest();
        rq.setUser(user);
        model.addAttribute("addDishRequest", rq);
        return "add-dish";
    }

    /**
     * Process add string.
     *
     * @param rq    the rq
     * @param model the model
     * @param user  the user
     * @return the string
     */
    @PostMapping("/add/{user}")
    public String processAdd(@ModelAttribute AddDishRequest rq, Model model, @PathVariable String user) {
        Dish dish = new Dish();
        dish.setBar(rq.getBar());
        dish.setName(rq.getName());
        dish.setOrigin(rq.getOrigin());
        dish.setTaste(rq.getTaste());

        DishCollection.addDish(dish);
        /*
            Retorno a la vista principal
         */
        return getHome(user, model);
    }


    /**
     * Gets home.
     *
     * @param user  the user
     * @param model the model
     * @return the home
     */
    @GetMapping("/home/{user}")
    public String getHome(@PathVariable("user") String user, Model model) {
        model.addAttribute("loginobject", new LoginObject(user, null));
        model.addAttribute("dishes", DishCollection.getDishes());
        return "main";
    }

    @GetMapping("/help/{user}")
    public String getHelp(@PathVariable("user") String user, Model model) {
        model.addAttribute("loginobject", new LoginObject(user, null));
        return "help";
    }

}
