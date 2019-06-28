package se.juneday.systemetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import se.juneday.systemetapp.domain.Product;

public class ProductActivity extends AppCompatActivity {

  private static final String LOG_TAG = ProductActivity.class.getSimpleName();
  private List<String> types;
  private Button ButtonAddToCart;
  private Button ButtonProceed;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product);

    Button ButtonAddToCart = (Button) findViewById(R.id.ButtonAddToCart);

    ButtonAddToCart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Log.i(LOG_TAG, "tillagd i varukorg");

        Toast.makeText(getApplicationContext(), "Tillagd i varukorg", Toast.LENGTH_LONG)
                .show();


        ButtonProceed = (Button) findViewById(R.id.ButtonProceed);
        ButtonProceed.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View view) {

            Intent i = new Intent( ProductActivity.this, CartActivity.class);
            startActivity(i);
          }

        });


        Bundle extras = getIntent().getExtras();
        Product p = (Product) extras.get("product");

        displayProduct(p);


      }


      private void setViewText(int viewId, String label, String text) {
        TextView tv = findViewById(viewId);
        tv.setText(Html.fromHtml("<b>" + label + "</b>: " + text));
        Log.d(LOG_TAG, " * " + text);
      }

      private void displayProduct(Product product) {
        setViewText(R.id.product_name, "Name", product.name());
        setViewText(R.id.product_volume, "Volume", String.valueOf(product.volume()));
        setViewText(R.id.product_alcohol, "Alcohol", String.valueOf(product.alcohol()));
        setViewText(R.id.product_price, "Price", String.valueOf(product.price()));
      }




  });
  }
}
