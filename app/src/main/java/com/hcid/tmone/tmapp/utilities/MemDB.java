package com.hcid.tmone.tmapp.utilities;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

// TODO: Add pictures and attraction name for different countries
/**
 * In-memory database storing place information
 * Created by liusu on 4/1/17.
 */
public class MemDB {
    private HashMap<String, ArrayList<String>> places = new HashMap<>();
    private HashMap<String, String> introductions = new HashMap<>();
    private HashMap<String, String> destination_information = new HashMap<>();
    private String[] destinations = {"Cambodia", "India", "Brazil", "Turkey", "Kenya"};

    private String[] items = {"item 1", "item 2", "item 3", "item 4", "item 5", "item 6", "item 7", "item 8", "item 9", "item 10", "item 11", "item 12"};
    private HashMap<String, Item> checklist = new HashMap<>();
    private HashMap<String, Incident> incidents = new HashMap<>();

    private int NUMBER_OF_ITEMS = 12;
    private int NUMBER_OF_INCIDENTS = 10;
    private enum SEVERITY{
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public MemDB(){

        /**
         * Place Information Initialization
         */
        ArrayList<String> attractions;
        String intro;
        String info;

        attractions = new ArrayList<>();
        attractions.add("Angkor Wat");
        attractions.add("Bayon Temple");
        attractions.add("Ta Prohm");
        intro = "Cambodia Introduction Cambodia Introduction\n" +
                "Cambodia Introduction Cambodia Introduction\n" +
                "Cambodia Introduction Cambodia Introduction\n" +
                "Cambodia Introduction Cambodia Introduction\n" +
                "Cambodia Introduction Cambodia Introduction\n" +
                "Cambodia Introduction Cambodia Introduction\n";
        info = "Location: TBD   Race: TBD   Religion: TBD\n" +
                "Language: TBD  Currency: TBD   Stability:  TBD";
        places.put(destinations[0], attractions);
        introductions.put(destinations[0], intro);
        destination_information.put(destinations[0], info);

        attractions = new ArrayList<>();
        attractions.add("Angkor Wat");
        attractions.add("Bayon Temple");
        attractions.add("Ta Prohm");
        intro = "India Introduction India Introduction\n" +
                "India Introduction India Introduction\n" +
                "India Introduction India Introduction\n" +
                "India Introduction India Introduction\n" +
                "India Introduction India Introduction\n" +
                "India Introduction India Introduction\n";
        info = "Location: TBD   Race: TBD   Religion: TBD\n" +
                "Language: TBD  Currency: TBD   Stability:  TBD";
        places.put(destinations[1], attractions);
        introductions.put(destinations[1], intro);
        destination_information.put(destinations[1], info);

        attractions = new ArrayList<>();
        attractions.add("Angkor Wat");
        attractions.add("Bayon Temple");
        attractions.add("Ta Prohm");
        intro = "Brazil Introduction Brazil Introduction\n" +
                "Brazil Introduction Brazil Introduction\n" +
                "Brazil Introduction Brazil Introduction\n" +
                "Brazil Introduction Brazil Introduction\n" +
                "Brazil Introduction Brazil Introduction\n" +
                "Brazil Introduction Brazil Introduction\n";
        info = "Location: TBD   Race: TBD   Religion: TBD\n" +
                "Language: TBD  Currency: TBD   Stability:  TBD";
        places.put(destinations[2], attractions);
        introductions.put(destinations[2], intro);
        destination_information.put(destinations[2], info);

        attractions = new ArrayList<>();
        attractions.add("Angkor Wat");
        attractions.add("Bayon Temple");
        attractions.add("Ta Prohm");
        intro = "Turkey Introduction Turkey Introduction\n" +
                "Turkey Introduction Turkey Introduction\n" +
                "Turkey Introduction Turkey Introduction\n" +
                "Turkey Introduction Turkey Introduction\n" +
                "Turkey Introduction Turkey Introduction\n" +
                "Turkey Introduction Turkey Introduction\n";
        info = "Location: TBD   Race: TBD   Religion: TBD\n" +
                "Language: TBD  Currency: TBD   Stability:  TBD";
        places.put(destinations[3], attractions);
        introductions.put(destinations[3], intro);
        destination_information.put(destinations[3], info);

        attractions = new ArrayList<>();
        attractions.add("Angkor Wat");
        attractions.add("Bayon Temple");
        attractions.add("Ta Prohm");
        intro = "Kenya Introduction Kenya Introduction\n" +
                "Kenya Introduction Kenya Introduction\n" +
                "Kenya Introduction Kenya Introduction\n" +
                "Kenya Introduction Kenya Introduction\n" +
                "Kenya Introduction Kenya Introduction\n" +
                "Kenya Introduction Kenya Introduction\n";
        info = "Location: TBD   Race: TBD   Religion: TBD\n" +
                "Language: TBD  Currency: TBD   Stability:  TBD";
        places.put(destinations[4], attractions);
        introductions.put(destinations[4], intro);
        destination_information.put(destinations[4], info);
        


        /**
         * Checklist Information Initialization (TODO: Make It Location Based)
         */

        for(int i = 0 ; i < NUMBER_OF_ITEMS ; i++){
            checklist.put(items[i], new Item(items[i], "description: this is " + items[i], i));
        }

        /**
         * Alert list Information Initialization (TODO: Make It Location Based)
         */

        for(int i = 0 ; i < NUMBER_OF_INCIDENTS; i++){
            SEVERITY temp;
            switch ((i + 4) % 4){
                case 0:
                    temp = SEVERITY.LOW;
                    break;
                case 1:
                    temp = SEVERITY.MEDIUM;
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

    public int getNUMBER_OF_ITEMS() {
        return NUMBER_OF_ITEMS;
    }

    public int getNUMBER_OF_INCIDENTS(){
        return NUMBER_OF_INCIDENTS;
    }

    /**
     * Destination function utilities
     */
    public ArrayList<String> getAttractions(String name){
        return places.get(name);
    }

    public String getIntro(String name){
        return introductions.get(name);
    }

    public String getInfo(String name){
        return destination_information.get(name);
    }

    public String[] getPlaces(){
       return destinations;
    }


    /**
     * Checklist function utilities
     */

    public String[] getChecklist(){
        return items;
    }
    public String getItemDescription(String name){

        System.out.println(name);
        return checklist.get(name).description;
    }

    public int getItemVotes(String name){
        return checklist.get(name).votes;
    }

    /**
     * Alert list function utilities
     */
    public String[] getIncidentTitles(){
        String[] titles = new String[NUMBER_OF_INCIDENTS];
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


    /**
     * Utility Classes
     */

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
