package factories;

import iProducts.Milk;
import iProducts.Jogurt;
import iProducts.Cheese;
import java.util.function.Supplier;

/**
 *
 * @author aleksandrpasharin
 */
public class AbstractMeijeriFactory {
    
    Supplier<Milk> milkSupplier;
    Supplier<Jogurt> jogurtSupplier;
    Supplier<Cheese> cheeseSupplier;    
}
