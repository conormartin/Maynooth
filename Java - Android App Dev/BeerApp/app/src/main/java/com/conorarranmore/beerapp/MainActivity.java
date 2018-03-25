
// Code by Conor Martin

package com.conorarranmore.beerapp;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Create objects for each interactive element to be displayed on the screen
    EditText beerSearch;
    Button searchBtn;
    ImageButton mapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set each object to the relevant element in the main activity xml file
        beerSearch = findViewById(R.id.editText);
        searchBtn = findViewById(R.id.searchBtn);
        mapBtn = findViewById(R.id.imageButton);
        //Set an on click listener for the search button and map button, this will implement an intent when either button is clicked
        searchBtn.setOnClickListener(this);
        mapBtn.setOnClickListener(this);
    }

    //Create reference to Firebase database
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

    @Override //The onclick method activates when a button is clicked on the screen
    public void onClick(View view) {
        //Switch statement activates a case depending on which button is clicked
        switch (view.getId()) {
            //If search button is clicked, save search term in database
            case R.id.searchBtn:
                //Saves beer searched for in database
                final String userInput = beerSearch.getText().toString().toLowerCase();
                //Checks whether beer is already in database, adds it if not
                mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(userInput).exists()){
                            //If entry already exists in the database, do nothing
                        }
                        else {
                            //otherwise create new child named as user input
                           mRootRef.child(userInput);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
                //Intent method to link MainActivity to SearchResults when search button is clicked
                Intent intent = new Intent(this,SearchResults.class);
                intent.putExtra("Search",beerSearch.getText().toString().toLowerCase());
                final int result = 1;
                startActivityForResult(intent,result);

                //Method to display toast when button is clicked
                Context context = getApplicationContext();
                CharSequence text = "Searching";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                break;

            //Intent method to open maps activity when the button is clicked
            case R.id.imageButton:
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
            default:
                break;
        }
    }
}