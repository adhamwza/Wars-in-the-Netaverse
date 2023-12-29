package cwk4;

import java.lang.reflect.Type;

public class Force {

        //fields
        public String ForceNo;
        public String ForceName;
        public int Fee;
        private int NumberOfStrikers;
        private int NumberOfLaserCannons;
        private int NumberOfPhotonTorpedoes;
        private int Strength;
        private boolean Cloacking;


        //constructor
        public Force(String No, String Name, int price, int AmountOfStrikers, int AmountOfLaserCannons, int AmountOfPhotonTorpedoes, int Power, boolean Hidden){

            this.ForceNo = No;
            this.ForceName = Name;
            this.Fee = price;
            this.NumberOfStrikers = AmountOfStrikers;
            this.NumberOfLaserCannons = AmountOfLaserCannons;
            this.NumberOfPhotonTorpedoes = AmountOfPhotonTorpedoes;
            this.Strength = Power;
            this.Cloacking = Hidden;


        }

        //Accessors
        public String getForceID(){
            return ForceNo;
        }

        public String getForceName(){
            return ForceName;
        }

        public int getFee(){
            return Fee;
        }

        public int getNumberOfStrikers(){
            return NumberOfStrikers;
        }

        public int getNumberOfLaserCannons(){
            return NumberOfLaserCannons;
        }
        public int getNumberOfPhotonTorpedoes(){
            return NumberOfPhotonTorpedoes;
        }
        public int getStrength(){
            return Strength;
        }
        public boolean CanCloack(){
            return Cloacking;
        }

        //End of Accessors



        //This method below checks if the pass at hand contains more than 3 credits and if so permits user to board ferry whilst subtracting the number of credits
        //by 3. If user does not have enough credits, the console would tell the user so.
      /*  public String State(){

            if (NumberOfCredits < 3){
                //System.out.println("Cannot ride ferry due to insufficient funds");
                return false;
            }else{
                //System.out.println("Welcome Aboard the ferry");
                NumberOfCredits = NumberOfCredits - 3;
                JourneyPoints = JourneyPoints + 1;
            }return true;
        }

       */



        //This method below provides and prints a string which contains all information regarding set Force, each record in its own line due to the \n.
        public String toString(){
            String s;
            s ="Force ID: " +  ForceNo  + '\n' + "Force Name: " +  ForceName  + '\n' +"Number of Strikers: " + NumberOfStrikers  + '\n' + "Number Of Laser Cannons: " + NumberOfLaserCannons + '\n' +"Number of Photon Torpedoes: " + NumberOfPhotonTorpedoes + '\n' + "Strength: " + Strength + '\n' + "Cloacking Ability: " + Cloacking;
            //System.out.println(s);
            return s;
        }

    }


