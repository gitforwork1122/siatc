package sia.tacocoud.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocoud.Ingredient;

@Repository
public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}