package foods.decorators;

import java.util.*;
import foods.Food;

// DECORATOR PATTERN : Here we decorate food with condiments.
public abstract class CondimentDecorator extends Food {

	public abstract String getDescription();
}