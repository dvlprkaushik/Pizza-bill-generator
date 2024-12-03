public class Main {
    public static void main(String[] args) {
        Pizza basePizza = new Pizza(false, Pizza.Size.LARGE);
        basePizza.addExtraToppings();
        basePizza.addExtraCheese();
        basePizza.takeAway();
        basePizza.getBill();

        System.out.println();

        DeluxPizza deluxePizza = new DeluxPizza(false, Pizza.Size.MEDIUM);
        deluxePizza.takeAway();
        deluxePizza.getBill();
    }
}
