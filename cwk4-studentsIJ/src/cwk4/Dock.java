package cwk4;

import java.util.ArrayList;
import java.util.Objects;

public class Dock {
    //fields
    private String DockName;
    private int Capacity;

    public String LAF = "";


    public static ArrayList<Force> ForceList;

    //Constructor
    public Dock(String Name, int C){

        this.DockName = Name;
        this.Capacity = C;
        this.setForceList(new ArrayList<Force>());
    }


    //This method just returns the Dock Name
    public String getDockName(){
        return DockName;
    }


    //This method returns the maximum capacity of set Dock
    public int getMax(){
        return Capacity;
    }


    //This method adds a force to the force list array list while providing the user with a message to confirm the addition of force
    public void enter(Force p){
        ForceList.add(p);
        //System.out.println("force has been added");
    }
    public void leave(Force p){
        Force pp = findForce(p.getForceID());
        if (pp != null){
            getForceList().remove(pp);
        }
    }

    //This method checks the array list looking for a certain force. If found it returns the force and prints out its information. If not found returns null
    public Force findForce (String p){
        for(int a = 0; a < getForceList().size(); a++){
            Force ps = getForceList().get(a);

            if (Objects.equals(ps.getForceID(), p)){
                return ps;
            }
        }
        return null;
    }



    //This method uses the empty string created above (or alternatively can be created here) and increments with the force list and adds each dorce with
    //its information to set empty string until done
    public String ListAllForces(){
        // String LAP = "";
        for(int i = 0; i < getForceList().size(); i++){
            Force p = getForceList().get(i);
            LAF = LAF + p.toString();

        }return LAF;
        //System.out.println(LAP);
    }

    //This method checks whether the dock is full or not while providing the user with a message to inform whether a dock is full or not
    public boolean Maxedout(){
        if (getForceList().size() >= Capacity){
            return true;
        }
        else{
            return false;
        }
    }

    //This method checks whether a force exists on the dock or not. If found it returns and prints the information of the force
    //If not found it only declares that the force does not exist on set dock
    public boolean IsInDock(String l){

        for (int x = 0; x < getForceList().size(); x++){
            Force p = getForceList().get(x);
            if (Objects.equals(p.getForceID(), l)){

                return true;
            }

        }return false;

    }


    //This method just returns and prints all information regarding set dock
    public String toString(){
        String string;
        string = ('\n' + "This Dock's name: " + DockName + '\n' + "This Dock's capacity" + Capacity
                + '\n' + " This Dock contains all these Forces: " + '\n' + LAF);
        return string;
    }

    public ArrayList<Force> getForceList() {
        return ForceList;
    }

    public void setForceList(ArrayList<Force> forceList) {
        ForceList = forceList;
    }
}

