package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {

    private String feedbacks;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setTitle("Feedback");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                feedbacks = editText.getText().toString();

                if(feedbacks.isEmpty())
                {
                    editText.setError("Please enter your comment");
                    editText.requestFocus();
                    return;
                }

                else if(!isInternetAvailable())
                {
                    Toast.makeText(getApplicationContext(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
                    return;
                }

                else
                {
                    button.setEnabled(false);

                    DatabaseReference database = FirebaseDatabase.getInstance().getReference("comments");

                    String key =  database.push().getKey();

                    database.child(key).setValue(editText.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                editText.setText(null);
                                Toast.makeText(feedback.this, "Thanks for your feedback", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    });
                }


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return false;
        }
    }

    public boolean isInternetAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

}