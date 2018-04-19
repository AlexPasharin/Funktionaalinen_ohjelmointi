package products;

import iProducts.Milk;

/**
 *
 * @author aleksandrpasharin
 */
public class LactosFreeMilk implements Milk {

    @Override
    public boolean isLactosFree() {
        return true;
    }

}
