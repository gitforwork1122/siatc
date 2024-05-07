package sia.tacocoud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import sia.tacocoud.Ingredient;
import sia.tacocoud.Ingredient.Type;
import sia.tacocoud.repository.IngredientRepository;


import java.util.Map;
import java.util.HashMap;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String source) {
        return ingredientRepo.findById(source).orElse(null);
    }
}







