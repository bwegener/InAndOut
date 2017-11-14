package edu.orangecoastcollege.cs273.bwegener.inandout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * This is the SummaryActivity where all of the items from
 * the OrderActivity are collected and all of the calculations
 * are shown.
 *
 * @author Brian Wegener
 * @version 1.0
 *          <p>
 *          Created on 9/26/2017
 */
public class SummaryActivity extends AppCompatActivity {

    private TextView mOrderTotal;
    private TextView mNumberOrdered;
    private TextView mSubtotal;
    private TextView mTax;

    /**
     * This is what happens when the SummaryActivity is launched.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intentFromOrder = getIntent();

        String orderTotal = intentFromOrder.getStringExtra("orderTotalTV");
        String numberOrdered = intentFromOrder.getStringExtra("itemsOrderedTV");
        String subtotal = intentFromOrder.getStringExtra("subtotalTV");
        String tax = intentFromOrder.getStringExtra("taxTV");

        mOrderTotal = (TextView) findViewById(R.id.orderTotalTV);
        mOrderTotal.setText(orderTotal);

        mNumberOrdered = (TextView) findViewById(R.id.itemsOrderedTV);
        mNumberOrdered.setText(numberOrdered);

        mSubtotal = (TextView) findViewById(R.id.subtotalTV);
        mSubtotal.setText(subtotal);

        mTax = (TextView) findViewById(R.id.taxTV);
        mTax.setText(tax);

    }

    /**
     * This sends the user back to the order screen.
     *
     * @param v
     */
    protected void goToOrder(View v) {
        Intent intentToOrder = new Intent(this, OrderActivity.class);
        startActivity(intentToOrder);
    }
}
