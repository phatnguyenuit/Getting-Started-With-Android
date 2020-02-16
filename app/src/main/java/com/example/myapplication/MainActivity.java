package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Declare binding
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get binding view
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);

        binding.btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtHello.setText("Hello " + binding.editName.getText().toString());
                hideKeyBoard(v);
            }
        });
        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtHello.setText("");
                binding.editName.setText("");
                binding.editName.requestFocus();
                showKeyBoard(binding.editName);
            }
        });
    }

    private void hideKeyBoard(View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void showKeyBoard(View editView) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(editView, 0);
    }
}
