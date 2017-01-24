package com.boeing737checklist;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<ChecklistRow> Checklist;
    Context context;
    int checklistID;
    int ratio;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewName;
        public TextView textViewAction;
        public CheckBox checkbox;
        Context viewHolderContext;

        public ViewHolder(View view, Context context) {
            super(view);
            this.viewHolderContext = context;

            view.setClickable(true);
            view.setOnClickListener(this);

            textViewName = (TextView) view.findViewById(R.id.textViewChecklistName);
            textViewAction = (TextView) view.findViewById(R.id.textViewActionName);
            checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        }

        // Handling clicks here
        @Override
        public void onClick(View v) {
            TextView name = (TextView) v.findViewById(R.id.textViewChecklistName);
            TextView action = (TextView) v.findViewById(R.id.textViewActionName);
            CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkbox);

            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
                name.setTextColor(Color.parseColor("#212121"));
                action.setTextColor(Color.parseColor("#212121"));
            } else {
                checkBox.setChecked(true);
                name.setTextColor(Color.parseColor("#B6B6B6"));
                action.setTextColor(Color.parseColor("#FF4081"));
            }


        }
    }

    public RecyclerViewAdapter(ArrayList<ChecklistRow> checklist, Context passedContext, int checklistID) {
        this.Checklist = checklist;
        this.context = passedContext;
        this.checklistID = checklistID;

        ratio = 100/Checklist.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checklist_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ChecklistRow row = Checklist.get(position);

        // Setting the values from the arraylist to the textboxes
        holder.textViewName.setText(Checklist.get(position).checkListName);
        holder.textViewAction.setText(Checklist.get(position).checkListAction);

        // Making the checkboxs and color change work
        holder.checkbox.setOnCheckedChangeListener(null);
        holder.checkbox.setChecked(row.isChecked);

        // Changing the color of the text if it has been selected
        if (row.isChecked()) {
            holder.textViewName.setTextColor(Color.parseColor("#B6B6B6"));
            holder.textViewAction.setTextColor(Color.parseColor("#FF4081"));
        } else {
            holder.textViewName.setTextColor(Color.parseColor("#212121"));
            holder.textViewAction.setTextColor(Color.parseColor("#212121"));
        }

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                row.setChecked(isChecked);

                boolean isComplete = true;


                // Checking if all the boxes have been ticked
                for (ChecklistRow row : Checklist) {
                    if (!row.isChecked()) {
                        isComplete = false;
                        break;
                    }
                }

                if (isChecked) {
                    ((MainActivity) context).incrementOrDecrementProgressBar(ratio, true);
                } else {
                    ((MainActivity) context).incrementOrDecrementProgressBar(ratio, false);
                }

                // Check if the checklist has been completed
                if (isComplete) {
                    ((MainActivity) context).selectCompleteOrIncomplete(checklistID, true);
                } else {
                    ((MainActivity) context).selectCompleteOrIncomplete(checklistID, false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Checklist.size();
    }

}
