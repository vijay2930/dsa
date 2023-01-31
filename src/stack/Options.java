package stack;
import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


class Options {
    private JSONObject root;
    private JSONObject currentObj;
    private JSONArray optionsArray=new JSONArray();
    private int choice;
    Scanner sc=new Scanner(System.in);
    Options(){
        try{
            JSONParser parser=new JSONParser();
            FileReader reader=new FileReader("E:\\workspace\\ZSGS\\test\\src\\stack\\data.json");
            root=(JSONObject)parser.parse(reader);
            currentObj=(JSONObject)root.get("1");
            optionsArray=(JSONArray)currentObj.get("options");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public JSONObject getFirstPage(){
        return (JSONObject)root.get("1");
    }
    public JSONObject getCurrentObj() {
        return currentObj;
    }
    public void setCurrentObj(JSONObject currentObj) {
        this.currentObj = currentObj;
        this.optionsArray=(JSONArray)currentObj.get("options");
    }
    public JSONArray getOptionsArray() {
        return optionsArray;
    }
    public void printOptions(){
        String des=(String)currentObj.get("description");
        System.out.printf("%20s\n",des);
        for(int i=0;i<optionsArray.size();i++){
            JSONObject temp=(JSONObject)this.optionsArray.get(i);
            System.out.println(temp.get("id")+" "+temp.get("description"));
        }
    }
    public void getInput(){
        JSONArray valid=(JSONArray)currentObj.get("validChoice");
        while(true){
            System.out.print("Enter your choice:");
            this.choice=0;
            while(sc.hasNextInt()){
                this.choice=sc.nextInt();
                if(choice!=0)
                    break;
            }
            if(((long)valid.get(0)<=this.choice && (long)valid.get(1)>=this.choice)){
                break;
            }
            System.out.println("Invalid choice.Try to enter a valid choice...\n");
            break;
        }
        this.choice--;

    }
    public long getChoice(){
        getInput();
        updateCurrentObj();
        long id=(long)currentObj.get("id");
        if(id==100){
            getNumber();
            updateCurrentObj();
            id=(long)currentObj.get("id");
        }
        return id;
    }
    public void getNumber(){
        System.out.print("Enter the Number:");
        Long num=sc.nextLong();
        System.out.println("No:"+num);
        printOptions();
        getInput();
    }
    public void updateCurrentObj(){
        JSONObject temp=(JSONObject)optionsArray.get(choice);
        String nextId=(String)temp.get("nextId");
        currentObj=(JSONObject)root.get(nextId);
        optionsArray=(JSONArray)currentObj.get("options");
    }
}
