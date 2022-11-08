# AppMarketing
App Marketing


1- Write to your database


// Write a message to the database


FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference myRef = database.getReference("message");

myRef.setValue("Hello, World!");

// Read from the database

myRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        String value = dataSnapshot.getValue(String.class);
        Log.d(TAG, "Value is: " + value);
    }

    @Override
    public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
    }
});

# Add this global rule
-keepattributes Signature

# This rule will properly ProGuard all the model classes in
# the package com.yourcompany.models.
# Modify this rule to fit the structure of your app.
-keepclassmembers class com.yourcompany.models.** {
  *;
}

2) Repository clonen: git clone git@github.com:bastianNebra/AppMarketing.git
3) eigener Branch erstellen: git Branch branchName
4) Branch wechseln : git checkhout branchName
5)Änderung committen: git commit -m "Message" 
6) git pull : git push --rebase origin master
7) git push ins Remote Repository:  git push --set-upstream origin branchName
8) Branchen Zusammenführen und Änderungen im master Branch zu übertragen: git merge 
