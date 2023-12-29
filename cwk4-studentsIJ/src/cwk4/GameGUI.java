package cwk4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/10/23
 */
public class GameGUI 
{
    private WIN gp = new SpaceWars("Horatio");
    private JFrame myFrame = new JFrame("Game GUI");

    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton fightBtn = new JButton("Fight");
    private JButton viewstate = new JButton("View State");
    private JButton Clean = new JButton("Clear");
    private JPanel eastPanel = new JPanel();

    
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the Forces menu
        JMenu forcesMenu = new JMenu("Forces");
        menubar.add(forcesMenu);
        
        JMenuItem listForcesItem = new JMenuItem("List All Forces ");
        listForcesItem.addActionListener(new ListForcesHandler());
        forcesMenu.add(listForcesItem);

        JMenuItem listForcesItem2 = new JMenuItem("List All Forces in ASF ");
        listForcesItem2.addActionListener(new ListForcesASFHandler());
        forcesMenu.add(listForcesItem2);

        JMenuItem listForcesItem3 = new JMenuItem("Activate force ");
        listForcesItem3.addActionListener(new activateforce());
        forcesMenu.add(listForcesItem3);

        JMenuItem listForcesItem4 = new JMenuItem("Recall force ");
        listForcesItem4.addActionListener(new recallforce());
        forcesMenu.add(listForcesItem4);

    }
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        myFrame.setLayout(new BorderLayout());
        myFrame.add(listing,BorderLayout.CENTER);
        listing.setVisible(false);
        myFrame.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(fightBtn);
        fightBtn.addActionListener(new FightBtnHandler());
        eastPanel.add(viewstate);
        viewstate.addActionListener(new viewstatus());
        eastPanel.add(Clean);
        Clean.addActionListener(new Cleaning());
        Clean.setVisible(true);
        fightBtn.setVisible(true);
        viewstate.setVisible(true);
        
        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    
    private String fighting(int code)
    {
        switch (code)
        {
            case 0:return "Fight won"; 
            case 1:return "Fight lost as no suitable force available"; 
            case 2:return "Fight lost on battle strength, force destroyed";
            case 3:return "fight is lost and admiral completely defeated ";
        }
        return " no such fight ";
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

    private String recalled()
    {
        return "Force recalled";
    }
    
    private class ListForcesHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getAllForces();
            listing.setText(xx);
            
        }
    }

    private class ListForcesASFHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.getASFleet();
            listing.setText(xx);

        }
    }

    private class activateforce implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int result = -1;
            String inputValue = JOptionPane.showInputDialog("Force Reference ?: ");
            String str = String.valueOf(inputValue);
            result = Integer.parseInt(String.valueOf(gp.activateForce(str)));;
            JOptionPane.showMessageDialog(myFrame,activation(result));

        }
    }

    private class recallforce implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int result = -1;
            String inputValue = JOptionPane.showInputDialog("Force Reference ?: ");
            String str = String.valueOf(inputValue);
            gp.recallForce(str);
            JOptionPane.showMessageDialog(myFrame,recalled());

        }
    }
    
    
    
    private class FightBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String inputValue = JOptionPane.showInputDialog("Fight number ?: ");
            int num = Integer.parseInt(inputValue);
            result = gp.doBattle(num);
            JOptionPane.showMessageDialog(myFrame,fighting(result));    
        }
    }

    private class viewstatus implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.toString();
            listing.setText(xx);
        }
    }

    private class Cleaning implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.selectAll();
            listing.replaceSelection("");
        }
    }
    
 
    
    public static void main(String[] args)
    {

        new GameGUI();
    }
}
   
