package sia.tacocoud.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sia.tacocoud.model.Ingredient;

@CrossOrigin(origins="http://localhost:8080")
public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}