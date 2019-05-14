import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.awt.event.*; // Needed for ActionListener and ActionEvent
import javax.swing.*;    // Needed for JFrame and JButton
import java.lang.String;

public class boardGame extends JFrame implements ActionListener {
  
  // initializing the Jlabels
  JLabel Row = new JLabel("ROW: ");
  JLabel rLabel = new JLabel(" ");
  JLabel Col = new JLabel("COL: ");
  JLabel cLabel = new JLabel(" ");
  JLabel label3 = new JLabel("Moves: ");
  JLabel mLabel = new JLabel(" ");
  
  //initializing other variables
  private int index;  
  private int moves = 0;  
  private Color[] colors;
  
  // This stores all buttons
  JButton[][] buttons = new JButton[5][5];
  String[] buttonLabels = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
  
  public boardGame(String title) {
    super(title);
    setLayout(null);

    //initializing the variables
    index = 0;
    Color[] colors = new Color[4]; 

    //Initialize the values of the array
    colors[0] = Color.red;
    colors[1] = Color.blue;
    colors[2] = Color.yellow;
    colors[3] = Color.green;
    
    //for loop for making the Jbuttons
    for(int row=0; row<5; row++) {
        for (int col=0; col<5; col++) {
            buttons[row][col] = new JButton(buttonLabels[row*5+col]);
            buttons[row][col].setLocation(10+col*55, 10+row*55);
            buttons[row][col].setSize(50,50);
            buttons[row][col].addActionListener(this);
            
            buttons[row][col].setBackground(colors[new Random().nextInt(4)]);
            
            add(buttons[row][col]);
        }
    }
    
    //labels
    Row.setLocation(10,280);
    Row.setSize(100,100);
    add(Row);
    
    rLabel.setLocation(45, 280);
    rLabel.setSize(100,100);
    add(rLabel);
    
    Col.setLocation(10,260);
    Col.setSize(100,100);
    add(Col);
    
    cLabel.setLocation(45, 260);
    cLabel.setSize(100,100);
    add(cLabel);
           
    label3.setLocation(80,260);
    label3.setSize(100,100);
    add(label3);
        
    mLabel.setLocation(125, 260);
    mLabel.setSize(100,100);
    add(mLabel);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(305,395);
  }
  
  
  // This is the single event handler for all the buttons
  public void actionPerformed(ActionEvent e) {
    JButton selectedBtn = (JButton) e.getSource();
    
    for (int row = 0; row < buttons.length; row++) {
      for (int col = 0; col < buttons[row].length; col++) {
        if (buttons[row][col] == selectedBtn) {
          moves++; //incrementing the moves
          
          //setText method to show the moves, rows and columns on the Jpanel
          mLabel.setText(Integer.toString(moves));
          cLabel.setText(Integer.toString(col+1));
          rLabel.setText(Integer.toString(row+1));
        }
      }
    }
  } 

  public static void main(String args[]) {
    boardGame frame = new boardGame("The Board Game");
    frame.setVisible(true);  
  }
}