package cwk4;

import java.util.ArrayList;


public class Admiral {

    //Fields
    String f = " ";
    String fff = "";
    static String AdmiralName;
    static int Bitcoins;
    public ArrayList<Force> forcelist;

    //End of Fields


    //Constructor with required parameters and initialization of fields
    public Admiral(String admiralName){
        AdmiralName = admiralName;
        Bitcoins = 1000;
        this.forcelist = new ArrayList<Force>();
    }

    //Constructors
    public static String getName(){
        return AdmiralName;
    }

    public int getBitcoins(){
        return Bitcoins;
    }
    //End of Constructors


    //A method that returns a string with all forces in inventory
    public String getForcesinInventory(){
        for(int x = 0; x <= forcelist.size(); x++){
            Force ff = forcelist.get(x);
            f = f + ff.toString();
        }
        return f;

    }

    //A method that returns a string if a force is added to inventory and obviously adds force to inventory and deducts bit coins
    public String addtoinventory(Force f){
        String ss = " ";
          forcelist.add(f);
          Bitcoins = Bitcoins - f.Fee;
          ss = "Force added";
          if(Bitcoins <= 0){
              ss = "Your Bitcoin chest is empty, try recalling some forces first";
              return ss;
          }
          return ss;
    }



    //Recalls force to dock and returns 50% of its fee to the admiral's war chest. Returns a string with a suitable message
    public String RecalltoDock(Force f){
        String s = "";
        for(int x = 0; x <= forcelist.size(); x++){
            Force c = forcelist.get(x);
            if( c.getForceID() == f.getForceID()){
                int fee = c.getFee();
                forcelist.remove(c);
                Bitcoins = Bitcoins + (fee/2);
                Dock.ForceList.add(c);
                s = "Force removed";
            }else{
                s = "Force not found";
            }
        }return s;
    }


//A to string method that provides all details about the admiral in a string fashion
    public String toString(){
        String string;
        string = ( '\n' +" This Admiral's Name: " + AdmiralName + '\n' +  "The amount of bitcoins available is: " +Bitcoins+ '\n' +"The forces in the inventory are: " +f);
        //System.out.println(string);
        return string;
    }

}
