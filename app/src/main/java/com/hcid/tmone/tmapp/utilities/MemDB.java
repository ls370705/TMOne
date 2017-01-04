package com.hcid.tmone.tmapp.utilities;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * In-memory database storing place information
 * Created by liusu on 4/1/17.
 */
public class MemDB {
    private HashMap<String, ArrayList<String>> places = new HashMap<>();
    private HashMap<String, String> introductions = new HashMap<>();
    private String[] destinations = {"Cambodia", "India", "Brazil", "Turkey", "Kenya"};
    private HashMap<String, Item> items = new HashMap<>();
    private HashMap<String, Incident> incidents = new HashMap<>();
    private int NUMBER_OF_ITEMS = 12;
    private int NUMBER_OF_INCEDENTS = 10;
    private enum SEVERITY{
        LOW, MEDUIM, HIGH, CRITICAL
    }


    public MemDB(){
        ArrayList<String> attractions;

        for(String i : destinations){
            attractions = new ArrayList<>();
            attractions.add(i + " Attraction 1");
            attractions.add(i + " Attraction 2");
            attractions.add(i + " Attraction 3");
            places.put(i, attractions);
            introductions.put(i, i + " Introduction");
        }

        for(int i = 0 ; i < NUMBER_OF_ITEMS ; i++){
            items.put("item " + i, new Item("item " + i, "description: this is item " + i, i));
        }

        for(int i = 0 ; i < NUMBER_OF_INCEDENTS ; i++){
            SEVERITY temp;
            switch ((i + 4) % 4){
                case 0:
                    temp = SEVERITY.LOW;
                    break;
                case 1:
                    temp = SEVERITY.MEDUIM;
                    break;
                case 2:
                    temp = SEVERITY.HIGH;
                    break;
                case 3:
                    temp = SEVERITY.CRITICAL;
                    break;
                default:
                    temp = SEVERITY.CRITICAL;
                    break;
            }
            incidents.put("incident " + i, new Incident("incident " + i, "description: this is incident " + i, new Date(),temp));
        }

    }

    public ArrayList<String> getAttractions(String name){
        return places.get(name);
    }

    public String getIntro(String name){
        return introductions.get(name);
    }

    public String[] getPlaces(){
       return destinations;
    }

    public int getNUMBER_OF_ITEMS() {
        return NUMBER_OF_ITEMS;
    }

    public int getNUMBER_OF_INCEDENTS(){
        return NUMBER_OF_INCEDENTS;
    }
    public String getItemDescription(String name){
        return items.get(name).description;
    }

    public int getItemVotes(String name){
        return items.get(name).votes;
    }

    public String[] getIncidentTitles(){
        String[] titles = new String[NUMBER_OF_INCEDENTS];
        ArrayList<String> temp = new ArrayList<>();
        for(String i : incidents.keySet()) temp.add(i);
        temp.toArray(titles);

        return titles;
    }

    public String getIncidentDescription(String title){
        return incidents.get(title).description;
    }

    public String getIncidentDate(String title){
        return incidents.get(title).time.toString();
    }

    public String getIncidentSeverity(String title){
        return incidents.get(title).severity.toString();
    }


    private class Item{
        private String name;
        private String description;
        private int votes;

        private Item(String name, String description, int votes){
            this.name = name;
            this.description = description;
            this.votes = votes;
        }
    }

    private class Incident{
        private String title;
        private String description;
        private Date time;
        private SEVERITY severity;

        private Incident(String title, String description, Date time, SEVERITY severity){
            this.title = title;
            this.description = description;
            this.time = time;
            this.severity = severity;
        }
    }
}
