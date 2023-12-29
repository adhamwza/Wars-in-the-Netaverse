package cwk4;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * This class implements the behaviour expected from a WIN
 system as required for 5COM2007 - March 2023
 * 
 * @author Group 4
 * @version March 2023
 */


public class SpaceWars implements WIN, Serializable {
//fields
    String f = "";
    String ff = "";
    String fff = "";
    String ffff = "";

    public ArrayList<Force> ListofForces;

    public ArrayList<Force> ListofDeadForces;

    public ArrayList<Force> ListofForcesinDock;

    public ArrayList<Force> ListofForcesoverall;

    public ArrayList<Battle> ListofBattles;

    String Name;
//end of fields


//**************** WIN **************************  

    /**
     * Constructor requires the name of the admiral
     *
     * @param admiral the name of the admiral
     */
    public SpaceWars(String admiral) {
        Name = admiral;
        Admiral s = new Admiral(admiral);
        this.ListofForces = new ArrayList<Force>();
        this.ListofBattles = new ArrayList<Battle>();
        this.ListofDeadForces = new ArrayList<Force>();
        this.ListofForcesinDock = new ArrayList<Force>();
        this.ListofForcesoverall = new ArrayList<Force>();

        setupForces();
        setupBattles();
    }

    /** Second constructor - task 3.5
     *  To be added for task 3.5
     */
 //   public SpaceWars2(String admiral, File file) {
 //       Name = admiral;
 //       file = readBattles(battles.txt);
 //       Admiral s = new Admiral(admiral);
 //       this.ListofForces = new ArrayList<Force>();
 //       this.ListofBattles = new ArrayList<Battle>();
 //       this.ListofDeadForces = new ArrayList<Force>();
 //       this.ListofForcesinDock = new ArrayList<Force>();
 //       this.ListofForcesoverall = new ArrayList<Force>();

   //     setupForces();
   // }


    /**
     * Returns a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Active Star Fleet(ASF),(or, "No forces" if Star Fleet is empty)
     *
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Star Fleet,(or, "No forces" if Active Star Fleet is empty)
     **/
    public String toString() {
        String stringcheese = "";
        if (ListofForces.size() != 0) {
            stringcheese = "This Admiral's name is: " + Admiral.getName() + '\n' + "Is this admiral defeated? " + isDefeated() + '\n' + "Admiral bitcoins: " + Admiral.Bitcoins +'\n' + "The force in ASF are" + ListAllAliveForces();
        } else {
            stringcheese = "This Admiral's name is: " + Admiral.getName() + '\n' + "Is this admiral defeated? " + isDefeated() + '\n'  + "Admiral bitcoins: " + Admiral.Bitcoins +'\n' + "The ASF is empty";
        }
        return stringcheese;
    }


    /**
     * returns true if war chest <=0 AND the active Star Fleet(ASF) has no
     * forces which can be recalled.
     *
     * @returns true if war chest <=0 and the active Star Fleet(ASF) has no
     * forces which can be recalled.
     */
    public boolean isDefeated() {
        if (getWarchest() < 120 && ListofForces.size() == 0) {
            //System.out.println("You're Defeated");
            return TRUE;
        }

        return false;
    }


    /**
     * returns the number of bit coins in the war chest
     *
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest() {
        int x = Admiral.Bitcoins;
        return x;
    }

    /* Returns a list of all forces in the system by listing :
     * All forces in the Active Star Fleet(ASF), or "No forces in ASF")
     * All forces remaining in the UFF dock, or "No forces in UFF dock
     * All forces destroyed as a result of losing a battle, or "No destroyed forces"
     */
    public String getAllForces(){
        ListAllForcesinDock();
        ListAllDeadForces();
        ListAllAliveForces();
        String string = " ";
        if (ListofForces.size() == 0 && ListofDeadForces.size() == 0 && ListofForcesinDock.size() == 0) {
            string = "No forces in ASF and UFF Dock and no destroyed forces as well";
        } else if (ListofForces.size() == 0 && ListofForcesinDock.size() == 0) {
            string = "No forces in ASF and no Forces in Dock, however, here is a list of all the destroyed forces: " + '\n' + ff;
        } else if (ListofForces.size() == 0 && ListofDeadForces.size() == 0) {
            string = "No forces in ASF and no Destroyed Forces , however, here is a list of all the forces in Dock: " + '\n' + fff;
        } else if (ListofDeadForces.size() == 0 && ListofForcesinDock.size() == 0) {
            string = "No Destroyed forces and no forces in dock , however, here is a list of all the forces in ASF: " + '\n' + f;
        } else {
            string = "Forces in ASF: " + '\n' + f + "Forces in UFF Dock" + fff + '\n' + "Destroyed Forces: " + ff;
        }
        return string;
    }


    /**
     * Returns true if force is in the United Forces Fleet(UFF), else false
     *
     * @param ref reference of the force
     * @return a String representation of all forces in the United Forces Fleet(UFF)
     **/
    public boolean isInUFFDock(String ref) {
        for (Force f : ListofForcesinDock) {
            String II = f.getForceID();
            if (II.equalsIgnoreCase(ref)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Returns a String representation of all forces in the United Forces Fleet(UFF) dock.
     * Does not include destroyed forces
     *
     * @return a String representation of all forces in the United Forces Fleet(UFF) dock.
     **/
    public String getForcesInDock() {
        ListAllForcesinDock();
        String s = "\n\n************ Forces available in UFFleet Dock********\n" + fff;

        return s;
    }

    /**
     * Returns a list of all destroyed forces in the system
     *
     * @return all destroyed forces
     */
    public String getDestroyedForces() {
        ListAllDeadForces();

        return "\n***** Destroyed Forces ****\n" + ff;
    }

    /**
     * Returns details of the force with the given reference code, or "No such force"
     *
     * @param ref the reference of the force
     * @return details of the force with the given reference code
     **/
    public String getForceDetails(String ref) {
        for (Force f : ListofForcesoverall) {
            String II = f.getForceID();
            if (II.equalsIgnoreCase(ref) && isInASFleet(ref)) {
                return"Force is active" + f.toString();
            } else if (II.equalsIgnoreCase(ref)) {
                return f.toString();
            }
        }
        return "\nNo such force";
    }


    // ***************** Active Star Fleet Forces ************************

    /**
     * Allows a force to be activated into the Active Star Fleet(ASF), but
     * only if there are enough resources for the activation fee.The force's
     * state is set to "active"
     *
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the UFF dock or is destroyed
     * 2 if not enough money, -1 if no such force
     **/
    public int activateForce(String ref) {
        boolean forceFound = true;
        for (Force force : ListofForcesinDock) {
            String I = force.getForceID();
            if (I.equalsIgnoreCase(ref) && Admiral.Bitcoins >= force.Fee) {
                System.out.println("Activating Force " + I);
                ListofForcesinDock.remove(force);
                ListofForces.add(force);
                Admiral.Bitcoins -= force.Fee;
                return 0;
            }

            if (!forceFound) {
                //System.out.println("Force not found in ListofForcesinDock but found in UFFDock");
                return 1;
            } else if (Admiral.Bitcoins < 120) {
                //System.out.println("Force not found");
                return 2;
            }
        }
        return -1;
    }

    /**
     * Returns true if the force with the reference code is in
     * the Active Star Fleet(ASF), false otherwise.
     *
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the active Star Fleet(ASF), false otherwise.
     **/
    public boolean isInASFleet(String ref) {
        for (Force f : ListofForces) {
            String II = f.getForceID();
            if (II.equalsIgnoreCase(ref)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a String representation of the forces in the active
     * Star Fleet(ASF), or the message "No forces activated"
     *
     * @return a String representation of the forces in the active
     * Star Fleet, or the message "No forces activated"
     **/
    public String getASFleet() {
        ListAllAliveForces();
        String s = "\n****** Forces in the Active Star Fleet******\n" + f;

        return s;
    }

    /**
     * Recalls a force from the Star Fleet(ASF) back to the UFF dock, but only
     * if it is in the Active Star Fleet(ASF)
     *
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref) {
        Force forceToRemove = null;
        for (Force force : ListofForces) {
            if (force.getForceID().equalsIgnoreCase(ref)) {
                forceToRemove = force;
                break;
            }
        }
        if (forceToRemove != null) {
            ListofForces.remove(forceToRemove);
            ListofForcesinDock.add(forceToRemove);
            Admiral.Bitcoins += (forceToRemove.Fee / 2);
        }
    }


//**********************Battles************************* 

    /**
     * returns true if the number represents a battle
     *
     * @param num is the number of the required battle
     * @returns true if the number represents a battle
     **/
    public boolean isBattle(int num) {
        for (Battle b : ListofBattles) {
            int bi = b.getCode();
            if (bi == num) {
                return true;
            }
        }
        return false;
    }


    /**
     * Provides a String representation of a battle given by
     * the battle number
     *
     * @param num the number of the battle
     * @return returns a String representation of a battle given by
     * the battle number
     **/
    public String getBattle(int num) {
        for (Battle b : ListofBattles) {
            int bi = b.getCode();
            if (bi == num) {
                return b.toString();
            }
        }

        return "No such battle";
    }

    /**
     * Provides a String representation of all battles
     *
     * @return returns a String representation of all battles
     **/
    public String getAllBattles() {
        ListAllBattles();
        String s = "\n************ All Battles ************\n" + ffff;

        return s;
    }


    /**
     * Retrieves the battle represented by the battle number.Finds
     * a force from the Active Star Fleet which can engage in the battle.The
     * results of battle will be one of the following:
     * 0 - Battle won, battle gains added to the war chest,
     * 1 - Battle lost as no suitable force available, battle losses
     * deducted from war chest
     * 2 - Battle lost on battle strength , battle losses
     * deducted from war chest and force destroyed
     * 3 - If a battle is lost and admiral completely defeated (no resources and
     * no forces to recall)
     * -1 - no such battle
     *
     * @param battleNo is the number of the battle
     * @return an int showing the result of the battle (see above)
     */
    public int doBattle(int battleNo) {
        Force appropriateForce = getAppropriateForce(battleNo);
        if (appropriateForce == null) {
            return 1;
        }
        for (Battle b : ListofBattles) {
            int bi = b.getCode();
            if (bi == battleNo) {
                int enemyStrength = b.getEnemyStrength();
                int forceStrength = appropriateForce.getStrength();
                if (forceStrength > enemyStrength) {
                    Admiral.Bitcoins += b.getGains();
                    return 0;
                } else if (forceStrength < enemyStrength) {
                    Admiral.Bitcoins -= b.getLosses();
                    ListofForces.remove(appropriateForce);
                    return 2;
                }
            }
        }
        if (Admiral.Bitcoins == 0 && ListofForces.size() == 0) {
            return 3;
        }
        return -1;
    }




    //*******************************************************************************
    private void setupForces() {
        Force F1 = new Force("IW1", "Twister", 200, 10, 0, 0, 200, FALSE);
        Force F2 = new Force("SS2", "Enterprise", 300, 0, 10, 20, 200, FALSE);
        Force F3 = new Force("WB3", "Droop", 300, 0, 0, 0, 100, FALSE);
        Force F4 = new Force("IW4", "Winger", 200, 20, 0, 0, 400, FALSE);
        Force F5 = new Force("WB5", "Hang", 400, 0, 0, 0, 300, TRUE);
        Force F6 = new Force("SS6", "Voyager", 450, 0, 15, 10, 200, FALSE);
        Force F7 = new Force("SS7", "Explorer", 120, 0, 4, 5, 65, FALSE);
        Force F8 = new Force("WB9", "Hover", 300, 0, 0, 0, 400, FALSE);
        Force F9 = new Force("IW10", "Flyer", 200, 5, 0, 0, 100, FALSE);

        ListofForcesinDock.add(F1);
        ListofForcesinDock.add(F2);
        ListofForcesinDock.add(F3);
        ListofForcesinDock.add(F4);
        ListofForcesinDock.add(F5);
        ListofForcesinDock.add(F6);
        ListofForcesinDock.add(F7);
        ListofForcesinDock.add(F8);
        ListofForcesinDock.add(F9);

        ListofForcesoverall.add(F1);
        ListofForcesoverall.add(F2);
        ListofForcesoverall.add(F3);
        ListofForcesoverall.add(F4);
        ListofForcesoverall.add(F5);
        ListofForcesoverall.add(F6);
        ListofForcesoverall.add(F7);
        ListofForcesoverall.add(F8);
        ListofForcesoverall.add(F9);

    }

    private void setupBattles() {
        Battle B1 = new Battle(1, "Fight", "Borg", 200, 300, 100);
        Battle B2 = new Battle(2, " Skirmish", "Kardassians", 700, 200, 120);
        Battle B3 = new Battle(3, "Ambush", "Ferengi", 100, 400, 150);
        Battle B4 = new Battle(4, "Fight", "Ewoks", 600, 600, 200);
        Battle B5 = new Battle(5, "Ambush", "Borg", 500, 400, 90);
        Battle B6 = new Battle(6, " Skirmish", "Groaners", 150, 100, 100);
        Battle B7 = new Battle(7, "Fight", "Borg", 150, 500, 300);
        Battle B8 = new Battle(8, "Ambush", "Wailers", 300, 300, 300);

        ListofBattles.add(B1);
        ListofBattles.add(B2);
        ListofBattles.add(B3);
        ListofBattles.add(B4);
        ListofBattles.add(B5);
        ListofBattles.add(B6);
        ListofBattles.add(B7);
        ListofBattles.add(B8);

    }

    //**************************Add your own private methods here ***********************


    //*******************************************************************************

    //These methods are not needed until Task 3.5. Uncomment them to complete task 3.5
    // ***************   file write/read  *********************

     /** Writes whole game to the specified file
      * @param fname name of file storing requests
      */
     public void saveGame(String fname) throws IOException {
        FileOutputStream X = new FileOutputStream("src/cwk4.ser/" + fname + ".txt");
          ObjectOutputStream Y = new ObjectOutputStream(X);
          Y.writeObject(fname);
          Y.close();
          X.close();
}

//     
//     /** reads all information about the game from the specified file 
//      * and returns a SpaceWars object
//      * @param fname name of file storing the game
//      * @return the game (as a SpaceWars object)
//      */
     public SpaceWars restoreGame(String fname) throws IOException, ClassNotFoundException {


            FileInputStream K = new FileInputStream("src/cwk4.ser/" + fname + ".txt");
            ObjectInputStream J = new ObjectInputStream(K);
             SpaceWars you = new SpaceWars(fname);
             J.readObject();
             J.readObject();
             J.close();
             K.close();
             return you;
}
//         
//     }
// 
//     /** Reads information about battles from the specified file into the appropriate collection
//      * @param the name of the file
//      */
private void readBattles() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("battles.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            // do something with each line, e.g. add it to a list or parse it
            System.out.println(line);
        }

        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    //Lists all forces that are alive in force list
    private String ListAllAliveForces() {
        if (ListofForces.size() != 0) {
            for (int x = 0; x < ListofForces.size(); x++) {
                Force force = ListofForces.get(x);
                f = f + force.toString();
                //return f;
            }
            return f;
        } else {
            f = "No Forces in Fleet";

        }
        return f;
    }

    //Lists all defeated forces
    private String ListAllDeadForces() {
        if (ListofDeadForces.size() != 0) {
            for (int x = 0; x < ListofDeadForces.size(); x++) {
                Force force = ListofDeadForces.get(x);
                ff = ff + force.toString();
                //return ff;
            }
            return ff;
        } else {
            ff = "No Forces in Fleet";

        }
        return ff;
    }

    //Lists all forces in dock
    public String ListAllForcesinDock() {
        if (ListofForcesinDock.size() != 0) {
            for (int x = 0; x < ListofForcesinDock.size(); x++) {
                Force force = ListofForcesinDock.get(x);
                fff = fff + force.toString();
                //return fff;
            }
            return fff;
        } else {
            fff = "No Forces in Fleet";

        }
        return fff;
    }
//Lists all battles
    public String ListAllBattles() {
        if (ListofBattles.size() != 0) {
            for (int x = 0; x < ListofBattles.size(); x++) {
                Battle battle = ListofBattles.get(x);
                ffff = ffff + battle.toString();
                //return ffff;
            }
            return ffff;
        } else {
            ffff = "No battles";

        }
        return ffff;
    }

    //This method intakes a battle number and returns the appropriate force to undertake set battle. A starship and a warbird can fight a Fight battle
    //while a wing and a starship can skirmish, and finally a wing can fight an ambush and a warbird can as well, however, only if it has cloacking.
    private Force getAppropriateForce(int Battleno) {
        Force force = null;
        for (Battle b : ListofBattles) {
            int bi = b.getCode();
            if (bi == Battleno) {
                for (int x = 0; x < ListofForces.size(); x++) {
                    force = ListofForces.get(x);
                    if (b.getType().equalsIgnoreCase("Fight")) { //starship and warbird
                        if (force instanceof Starship || force instanceof Warbird) {
                            return force;
                        }
                    } else if (b.getType().equalsIgnoreCase("Skirmish")) { // wings and starships
                        if (force instanceof Wing || force instanceof Starship) {
                            return force;
                        }
                    } else if (b.getType().equalsIgnoreCase("Ambush")) { // Wings and Warbird if they have cloack
                        if (force instanceof Wing) {
                            return force;
                        }
                            else if (force instanceof Warbird && force.CanCloack()) {
                                return force;
                            }
                        }
                    }
                }
            }
        return force;

        }
    }


