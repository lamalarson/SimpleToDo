package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.guest3.myapplication.R;

import static com.example.guest3.myapplication.MainActivity.ITEM_POSITION;
import static com.example.guest3.myapplication.MainActivity.ITEM_TEXT;

public class EditItemActivity extends AppCompatActivity {
    // text field containing updated item description
    EditText etItemText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etItemText = (EditText) findViewById(R.id.etItemText);
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        getSupportActionBar().setTitle(R.string.tache_modi);
    }
    public void onSaveItem(View v) {
        Intent data = new Intent();
        data.putExtra(ITEM_TEXT, etItemText.getText().toString());
        data.putExtra(ITEM_POSITION, position); // ints work too
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the edit activity, passes intent back to main
    }
}
