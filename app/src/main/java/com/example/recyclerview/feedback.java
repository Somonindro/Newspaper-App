package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class feedback extends AppCompatActivity {

    private String feedbacks;
    private String email;
    private EditText editText;
    private Button button;
    private EditText emailFeedback;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setTitle("Feedback");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.submit);
        emailFeedback = findViewById(R.id.emailFeedback);
        progressBar = findViewById(R.id.progressfeed);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                feedbacks = editText.getText().toString();
                email = emailFeedback.getText().toString();

                if(email.isEmpty())
                {
                    emailFeedback.setError("Please enter your email address");
                    emailFeedback.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    emailFeedback.setError("Please enter a valid email address");
                    emailFeedback.requestFocus();
                    return;
                }

                if(feedbacks.isEmpty())
                {
                    editText.setError("Please enter your feedback");
                    editText.requestFocus();
                    return;
                }

                if(!isInternetAvailable())
                {
                    Toast.makeText(getApplicationContext(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    button.setEnabled(false);
                    progressBar.setVisibility(View.VISIBLE);

                    DatabaseReference database = FirebaseDatabase.getInstance().getReference("comments");

                    String key =  database.push().getKey();

                    database.child(key).setValue(email+"\n\n\n"+feedbacks).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                editText.setText(null);
                                progressBar.setVisibility(View.GONE);
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