package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Grid extends JFrame implements ActionListener{
	
	public JPanel panel = new JPanel();
	public JButton[][] buttons = new JButton[3][3];
	public static int modulus = 0;
	public static int addTie = 0;
	
	public Grid(){
	
    for (int i = 0; i < buttons.length; i++) { 	
    	for (int j = 0; j < buttons[i].length; j++) {
    		buttons[i][j] = new JButton();
    		panel.add(buttons[i][j]);

    		buttons[i][j].setPreferredSize(new Dimension(85, 85));  		
    		buttons[i][j].addActionListener(this);
		}
  
	}
    
    
    panel.setLayout(new GridLayout(3,1));
		
    this.add(panel);
	this.setLayout(new GridLayout(2, 1));
	this.setSize(500, 500);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.setLocationRelativeTo(null);
	this.pack();
	}

	public static boolean switchNum(){
			modulus++;
			return modulus % 2 == 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if(clicked.getText() == ""){
		addTie++;
	    System.out.println(addTie);
		for (int i = 0; i < buttons.length; i++) {		
				if(switchNum() == true){
					clicked.setText("X");
				}else{
					clicked.setText("O");
				}
		  }
		}
		
	    checkWinner();
	    endGame("");
	}
	
	
	public String checkWinner(){
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				
				if(buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText())){
					if(buttons[i][0].getText() == "X"){
						return "X";
					}else if(buttons[i][0].getText() == "O"){
						return "O";
					}
			     }else if(buttons[0][j].getText().equals(buttons[1][j].getText()) && buttons[1][j].getText().equals(buttons[2][j].getText())){
			    	 if(buttons[0][j].getText() == "X"){
							return "X";
						}else if(buttons[0][j].getText() == "O"){
							return "O";
						}
			     }else if(buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) || 
			    		  buttons[2][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[0][2].getText())){
			    	 if(buttons[1][1].getText() == "X"){
							return "X";
						}else if(buttons[1][1].getText() == "O"){
							return "O";
						}
			     }
			}
		}
		return "";
	}
		
	public void enable(){
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j].setEnabled(false);
			}
		}
	}
	
	public void endGame(String getStatus){		
		getStatus = checkWinner();
		if(getStatus.equals("X")){
			System.out.println("X vins!");		
			enable();
		}else if(getStatus.equals("O")){
			System.out.println("O vins!");
			enable();
		}else if(addTie == 9 && getStatus != "O" || addTie == 9 && getStatus != "X"){
			System.out.println("It's a tie!");
			enable();
		}
	}
	
	

}
