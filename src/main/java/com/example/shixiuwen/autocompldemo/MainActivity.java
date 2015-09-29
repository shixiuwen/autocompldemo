package com.example.shixiuwen.autocompldemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;


public class MainActivity extends ActionBarActivity {

    private String[] columns = new String[]{ContactsContract.Contacts._ID,ContactsContract.Contacts.DISPLAY_NAME};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, columns, null, null, null);
        ContactListAdapter adapter = new ContactListAdapter(this,cursor);

        AutoCompleteTextView textView = (AutoCompleteTextView)findViewById(R.id.edit);
        textView.setAdapter(adapter);
    }
}
