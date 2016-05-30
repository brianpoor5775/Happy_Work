/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.parse.FindCallback;
import java.util.List;

/**
 * Created by Drew Gregory on 3/25/2016.
 */
public class StarterApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    /*Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                    .applicationId("kodingkidz_Zealth")
                    .clientKey(null)
                    .server("http://zealth-kodingkidz.herokuapp.com/parse/")
                    .build()
    );*/
    Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                    .applicationId("brianpoor5775_parse-server-example")
                    .clientKey(null)
                    .server("http://apcs-is-a-thing.herokuapp.com/parse/")
                    .build()
    );


    //Example Code for saving Parse Object...




      /*ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");
    query.whereEqualTo("playerName", "Bill Collins");
    Log.d("Searching", "I am here");
    try {
      List<ParseObject> taskList = query.find();
      Log.d("ZealthApplication", "NOTotal number of tasks satisfying query is " + taskList.size());
    } catch (ParseException e) {
      Log.d("ZealthApplication", "Error: " + e.getMessage());
    }
    */
/*
gameScore.saveInBackground(new SaveCallback() {
      public void done(ParseException e) {
        if (e == null) {
          Log.i("Parse", "Save Succeeded");
        } else {
          Log.i("Parse", "Save Failed");
        }
      }
    });
 */


        /*  Retrieve saved data
        ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");
        query.getInBackground("parseobjID", new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // get the object
                } else {
                   // Display error
                }
           }
        });
        */

        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
        query.whereEqualTo("Name", "Hahaha");
        query.findInBackground (new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                 if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                     if (scoreList.size() > 0)
                        Log.d("first score", "" + scoreList.get(0).getInt("Year"));
                     for (int i = 0; i < scoreList.size(); i++ ){
                         ParseObject score = scoreList.get(i);
                         Log.d("Parse delete", "Deleting record");
                         score.deleteInBackground();
                     }
                 } else {
                    Log.d("score", "Error: " + e.getMessage());
                 }
            }
         });
         */


        /*ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
        */
  }
}



/*
import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;


public class StarterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(this);

    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
*/