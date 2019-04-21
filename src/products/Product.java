package products;

import org.jetbrains.annotations.Contract;

public abstract class Product {
    private int price;
    private int expiretick;
    @Contract(pure = true)
    boolean expired(){return expiretick<=0;}

    Product(int price, int expiretick) {
        this.price = price;
        this.expiretick = expiretick;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getExpiretick() {
        return expiretick;
    }

    public void setExpiretick(int expiretick) {
        this.expiretick = expiretick;
    }

    public void updateTick(){
        this.expiretick--;
    }

    public abstract boolean sellable();

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    public abstract boolean getType();
}
