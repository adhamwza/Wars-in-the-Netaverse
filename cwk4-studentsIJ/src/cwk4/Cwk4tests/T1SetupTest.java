/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 * The reason behind some of the fails we might see is that we decided to add some details in the parameters of force such as number of cannons
 * and such. The reason behind this is that what if in a future version of the game force types develop to have more cannon types than they currently do
 * therefore rather than putting the types of cannons in the inherited classes, we used it in the general force parent class, and whichever cannon type a force
 * does not possess we simply write 0
 */
package cwk4.Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author aam
 */
public class T1SetupTest {
    WIN game;
    
    public T1SetupTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new SpaceWars("David");
    }
    
    @After
    public void tearDown() {
    }

    private boolean containsText(String text, String[] str) {
        boolean result = true;
        for (String temp : str) {
            result = result && (text.toLowerCase()).contains(temp.toLowerCase());
        }
        return result;
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   
    @Test
    public void gameCorrectlyInitialised() {
        String result = game.toString();
        String[] details = {"David", "1000", ""};
        boolean actual = containsText(result, details);
        assertTrue(actual);
    }
    
    @Test
    public void warChestWhenNoBattle() {
        int expected = 1000;
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }  
    
    @Test
    public void battleAtSetup() {
        boolean result = game.isBattle(3);
        assertTrue(result);
    }
    
    @Test
    public void allBattleLoadedAtSetup() {
        boolean result = true;
        for (int i = 1; i < 8; i++) {
            result = result && game.isBattle(i);
        }
        assertTrue(result);
    }
    
    @Test
    public void forceInUFFAtSetup() {
        boolean result = game.isInUFFDock("IW1");
        assertTrue(result);
    }
    
    @Test
    public void UFFleetLoadedAtTheBeginning() {
        boolean result = true;
        List<String> forces = new ArrayList<>(Arrays.asList("IW1","WB3","SS2",
                "IW4","WB5","SS6","SS7","WB9","IW10"));
        for (String force : forces) {
            result = result && game.isInUFFDock(force);
        }
        assertTrue(result);
    }
    
    
    @Test
    public void ASFleetEmptyAtTheBeginning() {
        boolean result = true;
        List<String> forces = new ArrayList<>(Arrays.asList("IW1","WB3","SS2",
                "IW4","WB5","SS6","SS7","WB9","IW10"));
        for (String force : forces) {
            result = result && !game.isInASFleet(force);
        }
        assertTrue(result);
    }
    
    
    
    @Test
    public void detailsOfWB3() {
        String str = game.getForceDetails("WB3");
        String[] target = {"WB3","Droop","100","300","In dock","false"};
        boolean result = containsText(str, target);
        assertTrue(result);
    }
    
    @Test
    public void detailsOfSS2() {
        String str = game.getForceDetails("SS2");
        String[] target = {"SS2","Enterprise","200","300","In dock","20","10"};
        boolean result = containsText(str, target);
        assertTrue(result);
    }
    
    @Test
    public void detailsOfIW1() {
        String str = game.getForceDetails("IW1");
        String[] target = {"IW1","Twister","200","200","In dock","10"};
        boolean result = containsText(str, target);
        assertTrue(result);
    }
    
    @Test
    public void detailsOfNonExistantForce() {
        String str = game.getForceDetails("XX3");        
        String[] target = {"No such force"};
        boolean result = containsText(str, target);
        assertTrue(result);
    }
    
    @Test
    public void detailsOfBattle() {
        String str = game.getBattle(2);        
        String[] details = {"2", "Skirmish", "Kardassians", "700", "200", "120"};
        boolean result = containsText(str, details);
        assertTrue(result);
    }
}
