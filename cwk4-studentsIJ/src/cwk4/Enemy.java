package cwk4;

import java.util.ArrayList;

public class Enemy {

    String EnemyCode;

    int Strength;
    //public ArrayList<Force> forceList;

    public Enemy(String enemycode, int power){
        EnemyCode = enemycode;
        Strength = power;
        //this.forceList = new ArrayList<Force>();
    }

    public String getCode(){
        return EnemyCode;
    }
    public int getStrength(){
        return Strength;
    }



    public String toString(){
        String string;
        string = ( '\n' +" This Enemy's Code: " + '\n' + "This Enemy has a strength of: " + Strength);
        //System.out.println(string);
        return string;
    }
}
