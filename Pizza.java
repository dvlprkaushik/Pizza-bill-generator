public class Pizza {
    private int price;
    private boolean veg, isExtraCheeseAdded = false, isExtraToppingsAdded = false, isOptedForTakeAway = false;
    private int extraCheesePrice = 100;
    private int extraToppings = 150;
    private int bagPack = 20;
    private int basePizzaPrice;
    private int sizePrice = 0;
    private static final int DISCOUNT_THRESHOLD = 700;
    private static final int DISCOUNT_AMOUNT = 100;

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private Size size;

    public Pizza(boolean veg, Size size) {
        this.veg = veg;
        this.size = size;

        if (this.veg) {
            this.price = 300;
        } else {
            this.price = 400;
        }

        this.basePizzaPrice = this.price;
        setSizePrice(size);
    }

    private void setSizePrice(Size size) {
        switch (size) {
            case SMALL:
                sizePrice = 0;
                break;
            case MEDIUM:
                sizePrice = 50;
                break;
            case LARGE:
                sizePrice = 100;
                break;
        }
        this.price += sizePrice;
    }

    public void addExtraCheese() {
        isExtraCheeseAdded = true;
        this.price += extraCheesePrice;
    }

    public void addExtraToppings() {
        isExtraToppingsAdded = true;
        this.price += extraToppings;
    }

    public void takeAway() {
        isOptedForTakeAway = true;
        this.price += bagPack;
    }

    public void getBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("======= PIZZA BILL =======\n");
        bill.append(String.format("%-20s: %s\n", "Pizza Type", veg ? "Veg" : "Non-Veg"));
        bill.append(String.format("%-20s: %d\n", "Base Price", basePizzaPrice));
        bill.append(String.format("%-20s: +%d\n", "Size (" + size + ")", sizePrice));

        if (isExtraCheeseAdded) {
            bill.append(String.format("%-20s: +%d\n", "Extra Cheese", extraCheesePrice));
        }
        if (isExtraToppingsAdded) {
            bill.append(String.format("%-20s: +%d\n", "Extra Toppings", extraToppings));
        }
        if (isOptedForTakeAway) {
            bill.append(String.format("%-20s: +%d\n", "Takeaway Charge", bagPack));
        }

        // Apply discount if applicable
        if (price > DISCOUNT_THRESHOLD) {
            bill.append(String.format("%-20s: -%d\n", "Discount Applied", DISCOUNT_AMOUNT));
            price -= DISCOUNT_AMOUNT;
        }

        bill.append("---------------------------\n");
        bill.append(String.format("%-20s: %d\n", "Total Bill", price));
        bill.append("===========================\n");
        System.out.println(bill);
    }
}
