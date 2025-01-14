package com.example.assignment2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateVat extends AppCompatActivity implements View.OnClickListener {

    private Button BackVatBtn , CalBtnVat;
    private EditText inputPrice , PriceVat , Vatvat , TotalVat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculate_vat);

        BackVatBtn = findViewById(R.id.BackVatBtn);
        BackVatBtn.setOnClickListener(this);
        BackVatBtn.setBackgroundColor(Color.parseColor("#964B00"));

        CalBtnVat = findViewById(R.id.CalBtnVat);
        CalBtnVat.setOnClickListener(this);
        CalBtnVat.setBackgroundColor(Color.parseColor("#964B00"));

        inputPrice = findViewById(R.id.inputVat);
        inputPrice.setHint("ใส่ราคาสินค้าเป็นตัวเลข");

        PriceVat = findViewById(R.id.PriceVat);
        Vatvat = findViewById(R.id.Vatvat);
        TotalVat = findViewById(R.id.TotalVat);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.CalBtnVat) {
            calculate();
        } else if (v.getId() == R.id.BackVatBtn) {
            finish();
        }
    }

    public void calculate() {
        String input = inputPrice.getText().toString();

        if (!input.isEmpty()) {
            try {
                int price = Integer.parseInt(input);

                if (price >= 0) {
                    String formatprice = String.format("%.2f" , (double) price);
                    PriceVat.setText(formatprice);

                    double vat = price * 0.07;
                    String formatVat = String.format("%.2f" , vat);
                    Vatvat.setText(formatVat);

                    double total = vat + price;
                    String formatTotal = String.format("%.2f" , total);
                    TotalVat.setText(formatTotal);

                } else {
                    Toast.makeText(this, "ราคา " + price + " ไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e ){
                Toast.makeText(this, "โปรดกรอกราคาเป็นตัวเลขเท่านั้น", Toast.LENGTH_SHORT).show();
            }
        } else {
            //ถ้าค่าว่างให้แจ้งเตือน
            Toast.makeText(this, "คุณยังไม่ได้กรอกราคา", Toast.LENGTH_SHORT).show();
        }
        inputPrice.setText("");
        inputPrice.setHint("ใส่ราคาสินค้าเป็นตัวเลข");
    }
}