package com.boeing737checklist;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class OtherChecklistsActivity extends AppCompatActivity {

    View cardView777;
    View cardViewA320;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_checklists);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardView777 = findViewById(R.id.cardView777);
        cardViewA320 = findViewById(R.id.cardViewA320);
        
        cardView777OnClickListener();
        cardViewA320OnClickListener();
    }

    private void cardView777OnClickListener() {
        cardView777.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendToAppStore sendToAppStore = new SendToAppStore();
                sendToAppStore.sendToAppStore(OtherChecklistsActivity.this, "com.boeing777checklist");
            }
        });
    }

    private void cardViewA320OnClickListener() {
        cardViewA320.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendToAppStore sendToAppStore = new SendToAppStore();
                sendToAppStore.sendToAppStore(OtherChecklistsActivity.this, "com.airbusa320checklist");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
