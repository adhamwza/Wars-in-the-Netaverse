package cwk4;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Provide a command line user interface
 * 
 * @author A.A.Marczyk
 * @version 06/10/23
 */
public class GameUI implements Serializable
{
    private Scanner myIn = new Scanner(System.in);

    private void playGame() throws IOException, ClassNotFoundException {
        int choice;
        String admiralName;
        int result = -1;
        System.out.println("Enter admiral's name");
        String s = myIn.nextLine();
        cwk4.WIN gp = new cwk4.SpaceWars(s);
        choice = 100;
        while (choice != 0 )
        {
            choice = getMenuItem();
            if (choice == 1)  //All forces
            {
                System.out.println(gp.getAllForces());
            }
            else if (choice == 2) //List all battles
            {
                System.out.println(gp.getAllBattles());
            }
            else if (choice == 3) //get Force
            {
                System.out.println("Enter Force reference");
                myIn.nextLine();
                String ref = (myIn.nextLine()).trim();
                System.out.println(gp.getForceDetails(ref));
            } 
            else if (choice == 4) //activate Force
            {
                System.out.println("Please enter the reference of the force you would like to activate");
                myIn.nextLine();
                String refnum = (myIn.nextLine()).trim();
                gp.activateForce(refnum);
                System.out.println(activation(gp.activateForce(refnum)));
                
            }
            else if (choice == 5) //List ASFleet
            {
                System.out.println(gp.getASFleet());
                
            }
            else if (choice == 6) //engage in a battle
            {
                System.out.println("Please enter the number of the battle you would like to fight");
                myIn.nextLine();
                int bnum = (myIn.nextInt());
                gp.doBattle(bnum);
                if(gp.doBattle(bnum) == 0){
                    System.out.println("Congratulations, battle won");
                } else if (gp.doBattle(bnum) == 1) {
                    System.out.println("Battle lost because there was no appropriate force");
                } else if (gp.doBattle( bnum) == 2) {
                    System.out.println("Battle lost");
                }else if(gp.doBattle(bnum) == 3){
                    System.out.println("You lost the battle and now you have been defeated");
                }else{
                    System.out.println("No such battle");
                }

            }
            
            else if (choice == 7) //recall force
            {
                System.out.println("Please enter the reference number of the force you would like to recall");
                myIn.nextLine();
                String refst = (myIn.nextLine().trim());
                gp.recallForce(refst);
                System.out.println("Force recalled");
                
            }
            else if (choice==8) //view game state
            {
                System.out.println(gp.toString());
            }
             //Uncomment after task 3.5
             else if (choice == 9) // Task 3.5 only
             {
                 System.out.println("Write to file");
                 gp.saveGame("battles.txt");
             }
             else if (choice == 10) // Task 3.5 only
             {
                 System.out.println("Restore from file");
                 gp = gp.restoreGame("olenka.txt");
                 System.out.println(gp.toString());
             }
        }  
        System.out.println("Thank-you");
    }
    
    private int getMenuItem()
    {   
        int choice = 100;  
        System.out.println("Main Menu");
        System.out.println("0. Quit");
        System.out.println("1. List all forces");
        System.out.println("2. List all battles"); 
        System.out.println("3. View details of a force");
        System.out.println("4. Activate a force into the Active Star  fleet");
        System.out.println("5. List forces in Active Star Fleet");
        System.out.println("6. Engage in a battle");
        System.out.println("7. Recall a force");
        System.out.println("8. View the state of the game");
        //For Task 3.5 only
         System.out.println("9. Save this game");
         System.out.println("10. Restore a game");
       
        
        while (choice < 0 || choice  > 10)
        {
            System.out.println("Enter the number of your choice");
            choice =  myIn.nextInt();
        }
        return choice;        
    } 
    
    private String activation(int code)
    {
        switch (code)
        {
            case 0:return "force is activated"; 
            case 1:return "force is not in the UFFDock"; 
            case 2:return "not enough money";
            case -1:return "no such force";
            default: return "Error";
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GameUI myGame = new GameUI();
        myGame.playGame();
    }
}