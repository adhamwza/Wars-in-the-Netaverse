package cwk4;

public class Battle {

    //Fields
    int BattleNO;
    String type;
    String Enemy;
    int EnemyPwr;
    int Losses;
    int Gains;

    //End of Fields


    //Constructor with required fields and initialization
    public Battle(int No, String Type, String EnemyName, int Strength, int losses, int gains) {
        BattleNO = No;
        type = Type;
        Enemy = EnemyName;
        EnemyPwr = Strength;
        Losses = losses;
        Gains = gains;

        //Accessors that return certain details or fields
    }
        public int getCode(){
            return BattleNO;
        }
        public String getType(){
        return  type;
        }
        public String getEnemyName(){
        return Enemy;
        }
        public int getEnemyStrength(){
        return EnemyPwr;
        }
        public int getLosses(){
        return Losses;
        }
        public int getGains(){
        return Gains;
        }

        //End of Accessors


    //public String Fight(){

    //}


    //A to String method that returns all information about a battle in a string
    public String toString(){
        String string;
        string = ( '\n' +" This Battle Code is: " + BattleNO +'\n' + "This battle type is: " + type + '\n' + "This Enemy's name is: " + Enemy + '\n' + "This enemy has a strength of: " + EnemyPwr + '\n' + "The Losses are: " + Losses + '\n' + "The gains are: " + Gains);
        //System.out.println(string);
        return string;
    }
    }

