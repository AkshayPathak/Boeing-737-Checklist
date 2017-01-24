package com.boeing737checklist;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.boeing737checklist.fragments.ChecklistFragment;
import com.github.clans.fab.FloatingActionButton;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class MainActivity extends AppCompatActivity {

    Drawer drawer;
    PrimaryDrawerItem item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11;
    Toolbar toolbar;

    FloatingActionButton fab;
    MaterialProgressBar materialProgressBar;

    @Override
    protected void onStart() {
        super.onStart();

        // Code regarding the rate this app
        RateThisApp.onStart(this);
        RateThisApp.showRateDialogIfNeeded(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        materialProgressBar = (MaterialProgressBar) findViewById(R.id.progressBar);

        loadSettings();

        initDrawer();

        initFab();

        showPromotionalImage();
    }

    private void loadSettings() {
        // Getting the shared preferences initially so we can load all the settings
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        loadAlwaysOnSetting(settings.getBoolean("AlwaysKeepScreenOn", false));

        settings.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                switch (key) {
                    case "AlwaysKeepScreenOn":
                        loadAlwaysOnSetting(sharedPreferences.getBoolean("AlwaysKeepScreenOn", false));
                        break;
                }
            }
        });
    }

    private void loadAlwaysOnSetting(Boolean alwaysOn) {
        if (alwaysOn) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    private void initFab() {
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to the next checklist with the FAB is clicked
                drawer.setSelectionAtPosition(drawer.getCurrentSelectedPosition() + 1, true);
            }
        });
    }

    private void initDrawer() {
        // Start the initial fragment
        Fragment checklistFragment = new ChecklistFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("checklistID", "1");
        checklistFragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.fragment_container, checklistFragment).commit();

        // Image in the drawer
        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .build();

        initItems();

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .addDrawerItems(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        fab.setVisibility(View.INVISIBLE);

                        // If it is changed, the progress bar will reset
                        resetProgressBar();

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        Fragment checklistFragment = new ChecklistFragment();
                        Bundle bundle = new Bundle();

                        // Starting the appropriate fragment based on which one is clicked
                        switch (position) {
                            case 1:
                                bundle.putString("checklistID", "1");
                                break;
                            case 2:
                                bundle.putString("checklistID", "2");
                                break;
                            case 3:
                                bundle.putString("checklistID", "3");
                                break;
                            case 4:
                                bundle.putString("checklistID", "4");
                                break;
                            case 5:
                                bundle.putString("checklistID", "5");
                                break;
                            case 6:
                                bundle.putString("checklistID", "6");
                                break;
                            case 7:
                                bundle.putString("checklistID", "7");
                                break;
                            case 8:
                                bundle.putString("checklistID", "8");
                                break;
                            case 9:
                                bundle.putString("checklistID", "9");
                                break;
                            case 10:
                                bundle.putString("checklistID", "10");
                                break;
                            case 11:
                                bundle.putString("checklistID", "11");
                                break;
                        }

                        checklistFragment.setArguments(bundle);
                        fragmentManager.beginTransaction().replace(R.id.fragment_container, checklistFragment).commit();

                        return false;
                    }
                })
                .build();
    }

    private void initItems() {
        item1 = new PrimaryDrawerItem().withName("Pre-Flight").withBadge("Incomplete");
        item2 = new PrimaryDrawerItem().withName("Cockpit Preparation").withBadge("Incomplete");
        item3 = new PrimaryDrawerItem().withName("Before Start").withBadge("Incomplete");
        item4 = new PrimaryDrawerItem().withName("Engine Start").withBadge("Incomplete");
        item5 = new PrimaryDrawerItem().withName("Before Taxi").withBadge("Incomplete");
        item6 = new PrimaryDrawerItem().withName("Before Takeoff").withBadge("Incomplete");
        item7 = new PrimaryDrawerItem().withName("After Takeoff").withBadge("Incomplete");
        item8 = new PrimaryDrawerItem().withName("Descent").withBadge("Incomplete");
        item9 = new PrimaryDrawerItem().withName("Before Landing").withBadge("Incomplete");
        item10 = new PrimaryDrawerItem().withName("After Landing").withBadge("Incomplete");
        item11 = new PrimaryDrawerItem().withName("Shutdown").withBadge("Incomplete");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_other) {
            Intent intent = new Intent(this, OtherChecklistsActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_reset) {
            // Making a dialog if reset button has been clicked
            new MaterialDialog.Builder(this)
                    .title("Reset all checklists?")
                    .positiveText("Reset")
                    .negativeText("Cancel")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
                            initDrawer();
                            fab.setVisibility(View.INVISIBLE);
                            resetProgressBar();
                        }
                    })
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }

    // Changing the badge on the drawer if it has been completed and activating or deactivating the fab
    public void selectCompleteOrIncomplete(int checklistID, boolean isComplete) {
        switch (checklistID) {
            case 1:
                if (isComplete) {
                    item1.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item1.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item1);
                break;
            case 2:
                if (isComplete) {
                    item2.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item2.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item2);
                break;
            case 3:
                if (isComplete) {
                    item3.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item3.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item3);
                break;
            case 4:
                if (isComplete) {
                    item4.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item4.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item4);
                break;
            case 5:
                if (isComplete) {
                    item5.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item5.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item5);
                break;
            case 6:
                if (isComplete) {
                    item6.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item6.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item6);
                break;
            case 7:
                if (isComplete) {
                    item7.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item7.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item7);
                break;
            case 8:
                if (isComplete) {
                    item8.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item8.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item8);
                break;
            case 9:
                if (isComplete) {
                    item9.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item9.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item9);
                break;
            case 10:
                if (isComplete) {
                    item10.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item10.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item10);
                break;
            case 11:
                if (isComplete) {
                    item11.withBadge("Complete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorAccent));
                } else {
                    item11.withBadge("Incomplete").withBadgeStyle(new BadgeStyle().withTextColorRes(R.color.colorPrimary));
                }
                drawer.updateItem(item11);
                break;
        }

        // Activating/deactivating the fab
        if (isComplete && drawer.getCurrentSelectedPosition() != 11) {
            fab.setVisibility(View.VISIBLE);
        } else {
            fab.setVisibility(View.INVISIBLE);
        }
    }

    // Setting the maximum of the progress bar
    public void setProgressBarMax(ArrayList<ChecklistRow> Checklist) {
        int ratio = 100/Checklist.size();
        materialProgressBar.setMax((ratio*(Checklist.size()))*10000);
    }

    // *10000 to smoothen out the progress bar
    public void incrementOrDecrementProgressBar(int ratio, boolean increment) {
        ObjectAnimator animator;

        // If true add, else subtract
        if (increment) {
            animator = ObjectAnimator.ofInt(materialProgressBar, "progress", materialProgressBar.getProgress() + ratio*10000);
        } else {
            animator = ObjectAnimator.ofInt(materialProgressBar, "progress", materialProgressBar.getProgress() + ratio*10000*(-1));
        }

        animator.setDuration(300);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();

    }

    public void resetProgressBar() {
        ObjectAnimator animator = ObjectAnimator.ofInt(materialProgressBar, "progress", 0);
        animator.setDuration(1000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
    }

    // Making sure the back button does not kill the activity
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void showPromotionalImage() {
        // Seeing if the promotional item has already been shown
        final SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        boolean isShown = sharedPreferences.getBoolean("isShown", false);

        // Display the dialog if it is shown
        if (!isShown) {
            new MaterialDialog.Builder(this)
                    .customView(R.layout.promotional_image, false)
                    .positiveText("Check it out!")
                    .negativeText("No thanks")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            // Open play store
                            SendToAppStore sendToAppStore = new SendToAppStore();
                            sendToAppStore.sendToAppStore(MainActivity.this, "com.boeing777checklist");

                            // Now set the preference to true
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("isShown", true);
                            editor.commit();
                        }
                    })
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("isShown", true);
                            editor.commit();
                        }
                    })
                    .show();
        }
    }
}
