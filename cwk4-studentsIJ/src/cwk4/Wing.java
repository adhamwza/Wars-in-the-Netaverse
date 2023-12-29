package cwk4;

public class Wing extends Force{


    public Wing(String No, String Name, int price, int AmountOfStrikers, int AmountOfLaserCannons, int AmountOfPhotonTorpedoes, int Power, boolean Hidden) {
        super(No, Name, price, AmountOfStrikers, AmountOfLaserCannons, AmountOfPhotonTorpedoes, Power, Hidden);

        super.getForceID();
        super.getForceName();
        super.getFee();
        super.getNumberOfStrikers();
        super.getNumberOfLaserCannons();
        super.getNumberOfPhotonTorpedoes();
        super.getStrength();
        super.CanCloack();


        super.toString();

    }
}
