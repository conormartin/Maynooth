
// Code by Conor Martin

package com.conorarranmore.beerapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchResults extends AppCompatActivity implements View.OnClickListener {
    //Create a number of new TextViews to display different information from search results
    //SuppressLint ensures the API request runs faster by not checking for irrelevant errors
    @SuppressLint("StaticFieldLeak")
    static TextView descriptionTextView;
    @SuppressLint("StaticFieldLeak")
    static TextView nameTextView;
    @SuppressLint("StaticFieldLeak")
    static TextView alcTextView;
    @SuppressLint("StaticFieldLeak")
    RatingBar ratingBar;
    Button submitBtn;
    TextView mRatingScore;
    TextView totalRatings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        //Stores user input in search box as a String when the search button is clicked
        Intent intent = getIntent();
        String userInput = intent.getStringExtra("Search");

        //Sets each object to the relevant elements from the xml file
        descriptionTextView = findViewById(R.id.descriptionTextView);
        nameTextView = findViewById(R.id.nameTextView);
        alcTextView = findViewById(R.id.alcTextView);
        ratingBar = findViewById(R.id.ratingBar);
        submitBtn = findViewById(R.id.submitBtn);
        mRatingScore = findViewById(R.id.ratingScoreTextView);
        totalRatings = findViewById(R.id.numOfRatingsTextView);

        //Sets an on click listener for the search button and map button, this will implement an intent when either button is clicked
        submitBtn.setOnClickListener(this);

        //Create an object of the SearchActivity class, the userInput is concatenated to the URL along with the API key
        SearchActivity beerSearch = new SearchActivity();
        beerSearch.execute("http://api.brewerydb.com/v2/search?key=858f0c102ca8ff58fe12ed8d295e27df%20&q="+userInput+"&type=beer");

        //Gets ID number of Firebase user & creates database child called rating and a sub child with UserID as its name
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userID = currentFirebaseUser.getUid();
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mRatingsDisplay = mRootRef.child(userInput).child("Rating").child(userID);

        //Gets previous user rating saved in database and displays it as ratingBar
        mRatingsDisplay.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null) {
                    String ratingString = dataSnapshot.getValue().toString();
                    float rating = Float.parseFloat(ratingString);
                    ratingBar.setRating(rating);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        //Get average ratings by adding all values into an array list using a for loop, convert to float then calculating average
        DatabaseReference mAverageRatings = mRootRef.child(userInput).child("Rating");
        mAverageRatings.addValueEventListener(new ValueEventListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Saves each rating in an array list
                ArrayList ratingList = new ArrayList<String>();
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    ratingList.add(String.valueOf(ds.getValue()));
                }
                float sum = 0;
                int count = 0;
                //Gets each rating and adds them together
                if(dataSnapshot.getValue() != null) {
                    for(int i=0; i<ratingList.size(); i++) {
                        float currentRating = Float.valueOf((String)ratingList.get(i));
                        sum += currentRating;
                        count++;
                    }
                    //Gets the average rating by dividing sum by number of ratings then displays it in a textview
                    float avgRating = sum/(ratingList.size());
                    //Displays rating set to one decimal point
                    mRatingScore.setText(String.valueOf(String.format("%.1f",avgRating)));
                    String numOfReviews = Integer.toString(count);
                    totalRatings.setText(numOfReviews);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override //The onclick method activates when the submit button is clicked on the screen
    public void onClick(View view) {

        final float rating = ratingBar.getRating();
        //Retrieves user input from the main activity as a String
        Intent intent = getIntent();
        final String userInput = intent.getStringExtra("Search");
        //Gets current user of firebase database
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentFirebaseUser != null) {
            final String userID = currentFirebaseUser.getUid();
            DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
            final DatabaseReference mRatingRef = mRootRef.child(userInput).child("Rating");
            mRatingRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(userInput).child("Rating").child(userID).exists()) {
                        //If a rating already exists, overwrite, else save new rating in the database
                    } else {
                        mRatingRef.child(userID).setValue(rating);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }

        //Toast to confirm rating has been submitted when submit button clicked
        Context context = getApplicationContext();
        CharSequence text = "Rating Submitted!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}