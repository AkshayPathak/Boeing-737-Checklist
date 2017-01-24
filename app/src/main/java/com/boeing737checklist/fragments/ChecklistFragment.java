package com.boeing737checklist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boeing737checklist.ChecklistRow;
import com.boeing737checklist.GetChecklist;
import com.boeing737checklist.MainActivity;
import com.boeing737checklist.R;
import com.boeing737checklist.RecyclerViewAdapter;

import java.util.ArrayList;

public class ChecklistFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checklist, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();

        int checklistID = Integer.parseInt(getArguments().getString("checklistID"));
        ArrayList<ChecklistRow> Checklist = new ArrayList<>();
        GetChecklist getChecklist = new GetChecklist();

        // Change the toolbar name and get the appropriate checklist
        switch (checklistID) {
            case 1:
                actionBar.setTitle("Pre-Flight");
                Checklist = getChecklist.getPreFlightChecklist();
                break;
            case 2:
                actionBar.setTitle("Cockpit Preparation");
                Checklist = getChecklist.getCockpitPreparationChecklist();
                break;
            case 3:
                actionBar.setTitle("Before Start");
                Checklist = getChecklist.getBeforeStartChecklist();
                break;
            case 4:
                actionBar.setTitle("Engine Start");
                Checklist = getChecklist.getEngineStartChecklist();
                break;
            case 5:
                actionBar.setTitle("Before Taxi");
                Checklist = getChecklist.getBeforeTaxiChecklist();
                break;
            case 6:
                actionBar.setTitle("Before Takeoff");
                Checklist = getChecklist.getBeforeTakeoffChecklist();
                break;
            case 7:
                actionBar.setTitle("After Takeoff");
                Checklist = getChecklist.getAfterTakeoffChecklist();
                break;
            case 8:
                actionBar.setTitle("Descent Checklist");
                Checklist = getChecklist.getDescentChecklist();
                break;
            case 9:
                actionBar.setTitle("Before Landing");
                Checklist = getChecklist.getBeforeLandingChecklist();
                break;
            case 10:
                actionBar.setTitle("After Landing");
                Checklist = getChecklist.getAfterLandingChecklist();
                break;
            case 11:
                actionBar.setTitle("Shutdown");
                Checklist = getChecklist.getShutdownChecklist();
                break;
        }

        // Telling the main activity which checklist is selected
        ((MainActivity) getActivity()).setProgressBarMax(Checklist);

        // Populating the recyclerview with the appropriate checklist
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerViewChecklist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(Checklist, getActivity(), checklistID);
        recyclerView.setAdapter(adapter);
    }
}
