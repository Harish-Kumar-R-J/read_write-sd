package com.example.write_read_sd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class MainActivity extends AppCompatActivity {
    EditText txtWrite;
    Button btnWrite, btnRead;
    TextView txtRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtWrite = (EditText) findViewById(R.id.txtWrite);
        txtRead = (TextView) findViewById(R.id.txtRead);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txtWrite.getText().toString();
                try {
                    FileOutputStream ofStream = new FileOutputStream(new File(getFilesDir(),
                            "demo"));
                    OutputStreamWriter osWriter = new OutputStreamWriter(ofStream);
                    osWriter.write(text);
                    osWriter.close();
                    ofStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } } });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream ifStream = new FileInputStream(new File(getFilesDir(), "demo"));
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(ifStream));
                    String read = "";
                    String line;
                    while ((line = bReader.readLine()) != null) {
                        read += line + "\n";
                    }
                    bReader.close();
                    ifStream.close();
                    txtRead.setText(read);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }}