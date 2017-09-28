package edu.orangecoastcollege.cs273.bwegener.inandout;

/**
 * Created on 9/25/17.
 */

public class Order {

    private int mCheeseburgers;
    private int mDoubleDoubles;
    private int mFrenchFries;
    private int mLargeDrinks;
    private int mMediumDrinks;
    private int mShakes;
    private int mSmallDrinks;

    public static final double PRICE_CHEESEBURGER = 2.15;
    public static final double PRICE_DOUBLE_DOUBLE = 3.60;
    public static final double PRICE_FRENCH_FRIES = 1.65;
    public static final double PRICE_LARGE_DRINK = 1.75;
    public static final double PRICE_MEDIUM_DRINK = 1.55;
    public static final double PRICE_SHAKE = 2.20;
    public static final double PRICE_SMALL_DRINK = 1.45;
    public static final double TAX_RATE = 0.08;

    public Order() {
    }

    public int getCheeseburgers() {
        return mCheeseburgers;
    }

    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }

    public int getDoubleDoubles() {
        return mDoubleDoubles;
    }

    public void setDoubleDoubles(int doubleDoubles) {
        mDoubleDoubles = doubleDoubles;
    }

    public int getFrenchFries() {
        return mFrenchFries;
    }

    public void setFrenchFries(int frenchFries) {
        mFrenchFries = frenchFries;
    }

    public int getLargeDrinks() {
        return mLargeDrinks;
    }

    public void setLargeDrinks(int largeDrinks) {
        mLargeDrinks = largeDrinks;
    }

    public int getMediumDrinks() {
        return mMediumDrinks;
    }

    public void setMediumDrinks(int mediumDrinks) {
        mMediumDrinks = mediumDrinks;
    }

    public int getShakes() {
        return mShakes;
    }

    public void setShakes(int shakes) {
        mShakes = shakes;
    }

    public int getSmallDrinks() {
        return mSmallDrinks;
    }

    public void setSmallDrinks(int smallDrinks) {
        mSmallDrinks = smallDrinks;
    }

    public double calculateSubtotal() {
        return getCheeseburgers() * PRICE_CHEESEBURGER + getDoubleDoubles() * PRICE_DOUBLE_DOUBLE +
                getFrenchFries() * PRICE_FRENCH_FRIES + getLargeDrinks() * PRICE_LARGE_DRINK +
                getMediumDrinks() * PRICE_MEDIUM_DRINK + getSmallDrinks() * PRICE_SMALL_DRINK +
                getShakes() * PRICE_SHAKE;
    }

    public int getNumberItemsOrdered()
    {
        return getCheeseburgers() + getDoubleDoubles() + getFrenchFries() + getLargeDrinks() +
                getMediumDrinks() + getSmallDrinks() + getShakes();
    }

    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }


}

