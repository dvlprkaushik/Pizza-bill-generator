public class DeluxPizza extends Pizza {
    public DeluxPizza(boolean veg, Size size) {
        super(veg, size);
        super.addExtraCheese();
        super.addExtraToppings();
    }

    @Override
    public void addExtraCheese() {
    }

    @Override
    public void addExtraToppings() {
    }
}
