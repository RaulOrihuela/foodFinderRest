package mx.tec.foodFinder.bean;

public class SupermarketIngredient {
    private String supermarket, ingredient;
    private double price;

    public SupermarketIngredient() { }

    public SupermarketIngredient(String supermarket, String ingredient, double price) {
        this.supermarket = supermarket;
        this.ingredient = ingredient;
        this.price = price;
    }

    public String getSupermarket() { return supermarket; }
    public void setSupermarket(String supermarket) { this.supermarket = supermarket; }

    public String getIngredient() { return ingredient; }
    public void setIngredient(String ingredient) { this.ingredient = ingredient; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "SupermarketIngredient{" +
                "supermarket='" + supermarket + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", price=" + price +
                '}';
    }
}
