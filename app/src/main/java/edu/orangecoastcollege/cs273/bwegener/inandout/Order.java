package edu.orangecoastcollege.cs273.bwegener.inandout;

/**
 * The Order class handles all of the items on the menu
 * that can be ordered. It also handles all of the prices,
 * as well as calculating number of items ordered,
 * subtotal, tax, and total.
 *
 * @author Brian Wegener
 * @version 1.0
 *          <p>
 *          Created on 9/25/17.
 */

public class Order {

    private int mCheeseburgers;
    private int mDoubleDoubles;
    private int mFrenchFries;
    private int mLargeDrinks;
    private int mMediumDrinks;
    private int mShakes;
    private int mSmallDrinks;

    /**
     * The final price of the Cheeseburger
     */
    public static final double PRICE_CHEESEBURGER = 2.15;

    /**
     * The final price of the Double Double
     */
    public static final double PRICE_DOUBLE_DOUBLE = 3.60;

    /**
     * The final price of the French Fries
     */
    public static final double PRICE_FRENCH_FRIES = 1.65;

    /**
     * The final price of the Large Drink
     */
    public static final double PRICE_LARGE_DRINK = 1.75;

    /**
     * The final price of the Medium Drink
     */
    public static final double PRICE_MEDIUM_DRINK = 1.55;

    /**
     * The final price of the Shake
     */
    public static final double PRICE_SHAKE = 2.20;

    /**
     * The final price of the Small Drink
     */
    public static final double PRICE_SMALL_DRINK = 1.45;

    /**
     * The final tax rate for the items
     */
    public static final double TAX_RATE = 0.08;

    /**
     * This is the default constructor, which sets all the items to 0.
     */
    public Order() {
    }

    /**
     * This gets the amount of cheeseburgers.
     *
     * @return the cheeseburgers ordered.
     */
    public int getCheeseburgers() {
        return mCheeseburgers;
    }

    /**
     * This sets the amount of cheeseburgers ordered
     *
     * @param cheeseburgers the cheeseburgers ordered
     */
    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }

    /**
     * This gets the amount of double doubles.
     *
     * @return the double doubles ordered.
     */
    public int getDoubleDoubles() {
        return mDoubleDoubles;
    }

    /**
     * This sets the amount of double doubles ordered.
     *
     * @param doubleDoubles the double doubles ordered.
     */
    public void setDoubleDoubles(int doubleDoubles) {
        mDoubleDoubles = doubleDoubles;
    }

    /**
     * This gets the amount of french fries ordered.
     *
     * @return the french fries ordered.
     */
    public int getFrenchFries() {
        return mFrenchFries;
    }

    /**
     * This sets the amount of french fries ordered.
     *
     * @param frenchFries the french fries ordered.
     */
    public void setFrenchFries(int frenchFries) {
        mFrenchFries = frenchFries;
    }

    /**
     * This gets the amount of large drinks ordered.
     *
     * @return the amount of large drinks ordered.
     */
    public int getLargeDrinks() {
        return mLargeDrinks;
    }

    /**
     * This sets the amount of large drinks ordered.
     *
     * @param largeDrinks the large drinks ordered.
     */
    public void setLargeDrinks(int largeDrinks) {
        mLargeDrinks = largeDrinks;
    }

    /**
     * This gets the amount of medium drinks ordered.
     *
     * @return the amount of medium drinks ordered.
     */
    public int getMediumDrinks() {
        return mMediumDrinks;
    }

    /**
     * This sets the amount of medium drinks ordered.
     *
     * @param mediumDrinks the medium drinks ordered.
     */
    public void setMediumDrinks(int mediumDrinks) {
        mMediumDrinks = mediumDrinks;
    }

    /**
     * This gets the amount of shakes ordered.
     *
     * @return the amount of shakes ordered.
     */
    public int getShakes() {
        return mShakes;
    }

    /**
     * This sets the amount of shakes ordered.
     *
     * @param shakes the shakes ordered.
     */
    public void setShakes(int shakes) {
        mShakes = shakes;
    }

    /**
     * This gets the amount of small drinks ordered.
     *
     * @return the amount of small drinks ordered.
     */
    public int getSmallDrinks() {
        return mSmallDrinks;
    }

    /**
     * This sets the amount of small drinks ordered.
     *
     * @param smallDrinks the small drinks ordered.
     */
    public void setSmallDrinks(int smallDrinks) {
        mSmallDrinks = smallDrinks;
    }

    /**
     * This calculates the subtotal by multiplying the amount of each item by it's price.
     *
     * @return the subtotal of all items
     */
    public double calculateSubtotal() {
        return getCheeseburgers() * PRICE_CHEESEBURGER + getDoubleDoubles() * PRICE_DOUBLE_DOUBLE +
                getFrenchFries() * PRICE_FRENCH_FRIES + getLargeDrinks() * PRICE_LARGE_DRINK +
                getMediumDrinks() * PRICE_MEDIUM_DRINK + getSmallDrinks() * PRICE_SMALL_DRINK +
                getShakes() * PRICE_SHAKE;
    }

    /**
     * This gets the number of all items ordered.
     *
     * @return the number of items ordered.
     */
    public int getNumberItemsOrdered() {
        return getCheeseburgers() + getDoubleDoubles() + getFrenchFries() + getLargeDrinks() +
                getMediumDrinks() + getSmallDrinks() + getShakes();
    }

    /**
     * This calculates the tax for all of the items.
     *
     * @return the tax.
     */
    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    /**
     * This calculates the total, by adding the tax to the subtotal.
     *
     * @return the total cost of all items ordered.
     */
    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

}

