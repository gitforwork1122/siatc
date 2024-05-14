package sia.tacocoud.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;
import sia.tacocoud.Ingredient;
import sia.tacocoud.Ingredient.Type;
import sia.tacocoud.Order;
import sia.tacocoud.Taco;
import sia.tacocoud.data.IngredientRepository;
import sia.tacocoud.data.TacoRepository;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));
        Type[] types = Type.values();
        for(Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors, @ModelAttribute Order order) {
        if(errors.hasErrors()) {
            return "design";
        }
        log.info("Processing design:" + taco);
        Taco saved = designRepo.save(taco);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        List<Ingredient> filteredIngredients = new ArrayList<Ingredient>();
        for(Ingredient ingredient: ingredients) {
            if(ingredient.getType().equals(type))
                filteredIngredients.add(ingredient);
        }
        return filteredIngredients;
    }

}