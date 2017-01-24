package com.boeing737checklist;

public class ChecklistRow {
    protected String checkListName;
    protected String checkListAction;
    protected boolean isChecked = false;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getCheckListName() {
        return checkListName;
    }

    public void setCheckListName(String checkListName) {
        this.checkListName = checkListName;
    }

    public String getCheckListAction() {
        return checkListAction;
    }

    public void setCheckListAction(String checkListAction) {
        this.checkListAction = checkListAction;
    }
}
