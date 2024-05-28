package sia.tacocoud.data;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.tacocoud.model.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}