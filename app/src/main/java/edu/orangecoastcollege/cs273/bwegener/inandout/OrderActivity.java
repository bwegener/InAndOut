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

    private void collectFoodOrder()
    {
        mOrder.setDoubleDoubles(Integer.parseInt(mDoubleDoubleEditText.getText().toString()));
        mOrder.setCheeseburgers(Integer.parseInt(mCheeseburgerEditText.getText().toString()));
        mOrder.setFrenchFries(Integer.parseInt(mFrenchFriesEditText.getText().toString()));
        mOrder.setShakes(Integer.parseInt(mShakesEditText.getText().toString()));
        mOrder.setLargeDrinks(Integer.parseInt(mLargeDrinkEditText.getText().toString()));
        mOrder.setMediumDrinks(Integer.parseInt(mMediumDrinkEditText.getText().toString()));
        mOrder.setSmallDrinks(Integer.parseInt(mSmallDrinkEditText.getText().toString()));
    }

    protected void orderSummary(View v)
    {
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
