package products;

public class FarmProduct extends Product {
    //TODO Make private variable source animal once animal has been implemented.
    //private Animal source;

    public FarmProduct(int price, int expiretick) {
        super(price, expiretick);
    }

    @Override
    public boolean sellable() {
        return expired();
    }


}
