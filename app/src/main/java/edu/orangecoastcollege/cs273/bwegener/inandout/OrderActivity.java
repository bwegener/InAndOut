package edu.orangecoastcollege.cs273.bwegener.inandout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * The OrderActivity allows the user to order any of the items below
 * then transfers these orders to the SummaryActivity
 *
 * @author Brian Wegener
 * @version 1.0
 *          <p>
 *          Created on 9/26/2017
 */
public class OrderActivity extends AppCompatActivity {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    private TextView mDoubleDoubleTextView;
    private TextView mCheeseburgerTextView;
    private TextView mFrenchFriesTextView;
    private TextView mShakesTextView;
    private TextView mLargeDrinkTextView;
    private TextView mMediumDrinkTextView;
    private TextView mSmallDrinkTextView;

    private EditText mDoubleDoubleEditText;
    private EditText mCheeseburgerEditText;
    private EditText mFrenchFriesEditText;
    private EditText mShakesEditText;
    private EditText mLargeDrinkEditText;
    private EditText mMediumDrinkEditText;
    private EditText mSmallDrinkEditText;
    private Button mOrderButton;

    private Order mOrder = new Order();

    /**
     * This is what happens when the app is first launched.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mDoubleDoubleTextView = (TextView) findViewById(R.id.doubleDoubleTV);
        mCheeseburgerTextView = (TextView) findViewById(R.id.cheeseburgerTV);
        mFrenchFriesTextView = (TextView) findViewById(R.id.frenchFriesTV);
        mShakesTextView = (TextView) findViewById(R.id.shakesTV);
        mLargeDrinkTextView = (TextView) findViewById(R.id.largeTV);
        mMediumDrinkTextView = (TextView) findViewById(R.id.mediumTV);
        mSmallDrinkTextView = (TextView) findViewById(R.id.smallTV);

        mDoubleDoubleTextView.setText("Double Double " + currency.format(mOrder.PRICE_DOUBLE_DOUBLE));
        mCheeseburgerTextView.setText("Cheeseburger " + currency.format(mOrder.PRICE_CHEESEBURGER));
        mFrenchFriesTextView.setText("French Fries " + currency.format(mOrder.PRICE_FRENCH_FRIES));
        mShakesTextView.setText("Shakes " + currency.format(mOrder.PRICE_SHAKE));
        mLargeDrinkTextView.setText("Large " + currency.format(mOrder.PRICE_LARGE_DRINK));
        mMediumDrinkTextView.setText("Medium " + currency.format(mOrder.PRICE_MEDIUM_DRINK));
        mSmallDrinkTextView.setText("Small " + currency.format(mOrder.PRICE_SMALL_DRINK));

        mDoubleDoubleEditText = (EditText) findViewById(R.id.doubleDoubleET);
        mCheeseburgerEditText = (EditText) findViewById(R.id.cheeseburgerET);
        mFrenchFriesEditText = (EditText) findViewById(R.id.frenchFriesET);
        mShakesEditText = (EditText) findViewById(R.id.shakesET);
        mLargeDrinkEditText = (EditText) findViewById(R.id.largeET);
        mMediumDrinkEditText = (EditText) findViewById(R.id.mediumET);
        mSmallDrinkEditText = (EditText) findViewById(R.id.smallET);
        mOrderButton = (Button) findViewById(R.id.placeOrderButton);

    }


    private void collectFoodOrder() {
        if (mDoubleDoubleEditText.getText().length() == 0)
            mOrder.setDoubleDoubles(0);
        else
            mOrder.setDoubleDoubles(Integer.parseInt(mDoubleDoubleEditText.getText().toString()));

        if (mCheeseburgerEditText.getText().length() == 0)
            mOrder.setCheeseburgers(0);
        else
            mOrder.setCheeseburgers(Integer.parseInt(mCheeseburgerEditText.getText().toString()));

        if (mFrenchFriesEditText.getText().length() == 0)
            mOrder.setFrenchFries(0);
        else
            mOrder.setFrenchFries(Integer.parseInt(mFrenchFriesEditText.getText().toString()));

        if (mShakesEditText.getText().length() == 0)
            mOrder.setShakes(0);
        else
            mOrder.setShakes(Integer.parseInt(mShakesEditText.getText().toString()));

        if (mLargeDrinkEditText.getText().length() == 0)
            mOrder.setLargeDrinks(0);
        else
            mOrder.setLargeDrinks(Integer.parseInt(mLargeDrinkEditText.getText().toString()));

        if (mMediumDrinkEditText.getText().length() == 0)
            mOrder.setMediumDrinks(0);
        else
            mOrder.setMediumDrinks(Integer.parseInt(mMediumDrinkEditText.getText().toString()));

        if (mSmallDrinkEditText.getText().length() == 0)
            mOrder.setSmallDrinks(0);
        else
            mOrder.setSmallDrinks(Integer.parseInt(mSmallDrinkEditText.getText().toString()));
    }

    /**
     * This collects all relevant items to be presented when the button is clicked
     * and the SummaryActivity is displayed to the user
     *
     * @param v the new view that the user sees.
     */

    protected void orderSummary(View v) {
        collectFoodOrder();
        String orderTotal = "Order Total " + currency.format(mOrder.calculateTotal());
        String numberOrdered = "Items Ordered: " + mOrder.getNumberItemsOrdered();
        String subtotal = "Subtotal: " + currency.format(mOrder.calculateSubtotal());
        String tax = "Tax (8%): " + currency.format(mOrder.calculateTax());

        Intent launchSummary = new Intent(this, SummaryActivity.class);

        launchSummary.putExtra("orderTotalTV", orderTotal);
        launchSummary.putExtra("itemsOrderedTV", numberOrdered);
        launchSummary.putExtra("subtotalTV", subtotal);
        launchSummary.putExtra("taxTV", tax);

        startActivity(launchSummary);
    }
}
