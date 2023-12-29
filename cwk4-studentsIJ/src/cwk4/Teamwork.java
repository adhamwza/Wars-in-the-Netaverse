package src.cwk4;


/**
 * Adham
 * Mohamed
 * Omar
 * Aihan
 * 
 * @author Group 4
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "4";
        
        details[1] = "Wael";
        details[2] = "Adham";
        details[3] = "20022232";

        details[4] = "Lawindy";
        details[5] = "Mohamed";
        details[6] = "20023744";

        details[7] = "Abu Ouf";
        details[8] = "Omar";
        details[9] = "20022468";


        details[10] = "Khaled";
        details[11] = "Aihan";
        details[12] = "20045581";

    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
