package com.boeing737checklist;

import java.util.ArrayList;

// Class to retrieve the appropriate checklist

public class GetChecklist {

    public ArrayList<ChecklistRow> getPreFlightChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Block Fuel");
        name.add("Payload");
        name.add("Parking Brake");
        name.add("Battery Switch");
        name.add("Standby Power Selector");
        name.add("APU Bleed Switch");
        name.add("L FWD Fuel Pump");
        name.add("APU Generator Switch");
        name.add("APU Generator Switches (1 & 2)");
        name.add("Position Light");
        name.add("Logo Lights");
        name.add("Cockpit Lights");
        name.add("Emer. Exit Lights");
        name.add("Passenger Signs");
        name.add("Seat Belt Signs");
        name.add("APU Bleed Switch");
        name.add("Pack Control Switches (L & R)");
        name.add("IRS Mode Selectors (1 & 2)");
        name.add("FMC Initialization");

        ArrayList<String> action = new ArrayList<>();
        action.add("LOAD & VERIFY");
        action.add("LOAD & VERIFY");
        action.add("SET");
        action.add("ON, GUARD CLOSED");
        action.add("GUARD CLOSED");
        action.add("OFF");
        action.add("ON");
        action.add("START");
        action.add("ON");
        action.add("ON, STEADY");
        action.add("AS NEEDED");
        action.add("AS NEEDED");
        action.add("ARMED, GUARD CLOSED");
        action.add("ON");
        action.add("OFF");
        action.add("ON");
        action.add("AUTO/HIGH");
        action.add("NAV");
        action.add("POSITION");


        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getCockpitPreparationChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Yaw Damper");
        name.add("Fuel Pumps");
        name.add("Ground Power Switch");
        name.add("Engine Generator Switches (1 & 2)");
        name.add("APU Generator Switches (1 & 2)");
        name.add("Window Heat");
        name.add("Probe Heat (L & R)");
        name.add("Wing/Engine Anti-Ice");
        name.add("ELEC Hydraulic Pumps (1 & 2");
        name.add("ENG Hydraulic Pumps (1 & 2");
        name.add("Trim Air");
        name.add("Temperature Control Knobs");
        name.add("RECIRC Fan Switches (1 & 2)");
        name.add("Pack Control Switches (L & R)");
        name.add("Isolation Valve Switch");
        name.add("Engine Bleed Switches (1 & 2)");
        name.add("APU Bleed Switch");
        name.add("Pressurization Panel");
        name.add("ATIS");
        name.add("FMC");
        name.add("AFDS (Altimeter, F/D, NAV, IAS, HDG, ALT)");
        name.add("Flight Instruments");
        name.add("Warning Annunciations");
        name.add("Autobrakes");
        name.add("Stabilizer Trim");
        name.add("Transponder/TCAS");
        name.add("Comm. / Audio Panel");
        name.add("Aileron / Rudder Trim");
        name.add("Taxi & Takeoff Briefing");

        ArrayList<String> action = new ArrayList<>();
        action.add("ON");
        action.add("OFF/AS NEEDED");
        action.add("OFF");
        action.add("OFF");
        action.add("ON");
        action.add("ON");
        action.add("OFF");
        action.add("OFF");
        action.add("OFF");
        action.add("ON");
        action.add("ON");
        action.add("AUTO/AS DESIRED");
        action.add("AUTO");
        action.add("AUTO/HIGH");
        action.add("OPEN");
        action.add("ON");
        action.add("ON");
        action.add("SET/AUTO");
        action.add("OBTAIN");
        action.add("PROGRAM");
        action.add("SET");
        action.add("SET/NO FLAGS");
        action.add("CHECK");
        action.add("RTO");
        action.add("SET __ UNITS");
        action.add("TEST/SET");
        action.add("SET");
        action.add("SET 0");
        action.add("COMPLETE");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getBeforeStartChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Cabin & Cargo Doors");
        name.add("Seat Belt Signs");
        name.add("External Power/Air");
        name.add("AFT & FWD Fuel Pumps (4)");
        name.add("Center Fuel Pumps (2)");
        name.add("ELEC Hydraulic Pumps (1 & 2)");
        name.add("Anti-Collision Lights");

        ArrayList<String> action = new ArrayList<>();
        action.add("CLOSED");
        action.add("ON");
        action.add("DISCONNECT");
        action.add("ON");
        action.add("AS NEEDED");
        action.add("ON");
        action.add("ON");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getEngineStartChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Lower Display Unit");
        name.add("Pack Control Switches (L & R)");
        name.add("Engine 2 Start");
        name.add("Engine 2 Start Selector");
        name.add("Engine 2 Fuel Control Switch");
        name.add("Engine 1 Start");
        name.add("Engine 1 Start Selector");
        name.add("Engine 1 Fuel Control Switch");

        ArrayList<String> action = new ArrayList<>();
        action.add("ENGINE");
        action.add("OFF");
        action.add("ANNOUNCE");
        action.add("GROUND");
        action.add("RUN");
        action.add("ANNOUNCE");
        action.add("GROUND");
        action.add("RUN");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getBeforeTaxiChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Engine Generator Switches (1 & 2)");
        name.add("APU Bleed Switch");
        name.add("Pack Control Switches (L & R)");
        name.add("Isolation Valve Switch");
        name.add("Probe Heat (L & R)");
        name.add("Wing / Engine Anti-Ice");
        name.add("APU Generator Switch");
        name.add("Engine Start Selectors");
        name.add("Flaps");
        name.add("Autothrottle");
        name.add("Flight Controls");
        name.add("EICAS");
        name.add("Taxi Light");
        name.add("Runway Turnoff Lights");

        ArrayList<String> action = new ArrayList<>();
        action.add("ON");
        action.add("OFF");
        action.add("AUTO");
        action.add("AUTO");
        action.add("ON");
        action.add("AS NEEDED");
        action.add("OFF");
        action.add("OFF");
        action.add("SET, GREEN LIGHT");
        action.add("ARM");
        action.add("FREE & CORRECT");
        action.add("RECALL & CHECK");
        action.add("ON");
        action.add("AS NEEDED");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getBeforeTakeoffChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Engine Start Selectors");
        name.add("Landing Lights");
        name.add("Strobe Lights");
        name.add("Traffic Mode");
        name.add("Clock");
        name.add("Transponder Mode");

        ArrayList<String> action = new ArrayList<>();
        action.add("CONT");
        action.add("ON");
        action.add("ON");
        action.add("TFC");
        action.add("RUN");
        action.add("TA/RA");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getAfterTakeoffChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Landing Gear");
        name.add("Flaps");
        name.add("Autobrake");
        name.add("Engine Start Selectors");
        name.add("Above 10,000 FT");
        name.add("Seat Belt Signs");
        name.add("Transition Altitude");

        ArrayList<String> action = new ArrayList<>();
        action.add("UP, OFF");
        action.add("UP");
        action.add("OFF");
        action.add("OFF");
        action.add("LDG LTS OFF");
        action.add("AS DESIRED");
        action.add("SET STANDARD");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getDescentChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("FMC");
        name.add("Flight Instruments (NAV, ALT, Radios");
        name.add("Transition Altitude");
        name.add("Wing/Engine Anti-Ice");
        name.add("Recall");
        name.add("Autobrake");
        name.add("Landing Data");
        name.add("Approach Briefing");

        ArrayList<String> action = new ArrayList<>();
        action.add("VERIFY ARRIVAL/APPROACH");
        action.add("SET");
        action.add("SET QNH");
        action.add("AS NEEDED");
        action.add("CHECK");
        action.add("AS REQUIRED");
        action.add("VREF __, MINIMUMS __");
        action.add("COMPLETE");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getBeforeLandingChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Below 10,000 FT");
        name.add("Speed Brakes");
        name.add("Seat Belt Signs");
        name.add("Altimeters");
        name.add("Engine Start Selectors");

        ArrayList<String> action = new ArrayList<>();
        action.add("LDG LTS ON");
        action.add("ARM");
        action.add("ON");
        action.add("SET QNH");
        action.add("CONT");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getAfterLandingChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Landing Lights");
        name.add("Strobe Lights");
        name.add("Taxi Lights");
        name.add("APU");
        name.add("Engine Start Selectors");
        name.add("Probe Heat (L & R)");
        name.add("Wing/Engine Anti-Ice");
        name.add("Autobrakes");
        name.add("Speed Brakes");
        name.add("Flaps");
        name.add("Transponder Mode");

        ArrayList<String> action = new ArrayList<>();
        action.add("OFF");
        action.add("OFF");
        action.add("ON");
        action.add("START");
        action.add("OFF");
        action.add("OFF");
        action.add("OFF");
        action.add("OFF");
        action.add("DOWN");
        action.add("UP");
        action.add("STBY");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }

    public ArrayList<ChecklistRow> getShutdownChecklist() {
        ArrayList<ChecklistRow> returnList = new ArrayList<>();

        ArrayList<String> name = new ArrayList<>();
        name.add("Parking Brake");
        name.add("Taxi Light");
        name.add("APU Generator Switches (1 & 2)");
        name.add("APU Bleed Switch");
        name.add("Engine Fuel Control Switch (1 & 2)");
        name.add("Seat Belt Signs");
        name.add("Anti-Collision Lights");
        name.add("Position Light");
        name.add("AFT, FWD, CTR Fuel Pumps (6)");
        name.add("L FWD Fuel Pump");
        name.add("ELEC Hydraulic Pumps");
        name.add("Isolation Valve Switch");
        name.add("Flight Directors");

        ArrayList<String> action = new ArrayList<>();
        action.add("SET");
        action.add("OFF");
        action.add("ON");
        action.add("ON");
        action.add("CUTOFF");
        action.add("OFF");
        action.add("OFF");
        action.add("ON, STEADY");
        action.add("OFF");
        action.add("ON");
        action.add("OFF");
        action.add("OPEN");
        action.add("OFF");

        for (int i = 0; i < name.size(); i++) {
            ChecklistRow row = new ChecklistRow();
            row.setCheckListName(name.get(i));
            row.setCheckListAction(action.get(i));

            returnList.add(row);
        }

        return returnList;
    }
}
