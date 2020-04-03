import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;

public class yuckyChocky extends JPanel implements ActionListener {
	public static int row1=4;
	public static int col1=4;
	public static int row2=5;
	public static int col2=5;
	public static int row3=6;
	public static int col3=6;
	public static int currentPlayer=1;
	public static boolean loser= false; 
	static JFrame frame= new JFrame("Yucky Chocky");
	static JPanel welcomePanel= new JPanel(new GridLayout(11,1));
	static JPanel playAgainPanel= new JPanel(new GridLayout(8,1));
	static JPanel BarPanel= new JPanel();
	private static JButton[][] buttonGrid= new JButton[10][10];
	static int i;
	static int j;
	static int tempi;
	static int tempj;
	static int c1;
	static int r1;
	static int c2;
	static int r2;
	static int c3;
	static int r3;
	public static Random random= new Random();
	
	public static JLabel turn= new JLabel("It is your turn!");
	public static JLabel winnerLabel= new JLabel();
	
	public static void main (String[] args) {
		initialise();
		
		
	}
	
	static void initialise(){
		//Created the frame
				
				frame.setSize(new Dimension(500,500));
				frame.setVisible(true);
			
				
				//Welcome Panel
				JPanel welcomePanel= new JPanel(new GridLayout(11,1));
				welcomePanel.setPreferredSize(new Dimension(500,500));
				welcomePanel.setBackground(Color.GREEN);
				
				//welcome message
				JLabel welcome= new JLabel("Let's play.... YUCKY CHOCKY");
				welcomePanel.add(welcome);
				
				//Choosing default options
				JLabel defaultChoice= new JLabel("Please choose a default size");
				welcomePanel.add(defaultChoice);
				frame.add(welcomePanel);
				frame.pack();
				
				
				//The three options
				JButton first= new JButton("4X4");
				JButton second= new JButton("5X5");
				JButton third= new JButton("6X6");
				
				welcomePanel.add(first);
				welcomePanel.add(second);
				welcomePanel.add(third);
				
				first.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (first==e.getSource()) {
							frame.remove(welcomePanel);
							playGame(4,4);
							getLegalMove(1);
						
						}
					}
				});
				
				second.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (second==e.getSource()) {
							frame.remove(welcomePanel);
							playGame(5,5);
							getLegalMove(2);
						}
					}
				});
				
				third.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (third==e.getSource()) {
							frame.remove(welcomePanel);
							playGame(6, 6);
							getLegalMove(3);
						}
					}
				});
				
				
				}
	
	public static void playGame(int row, int col) {
		BarPanel=new JPanel();
		BarPanel.setLayout(new GridLayout(row+1,col));
		BarPanel.setPreferredSize(new Dimension(1500,1000));
		BarPanel.setBackground(Color.YELLOW);
		
		Color BROWN= new Color(123,63,0);
		for(int i=0; i<row; i++) {
			for (int j=0; j< col; j++) {
				buttonGrid[i][j]= new JButton();
				buttonGrid[i][j].setBackground(BROWN);
				BarPanel.add(buttonGrid[i][j]);
			}
		}
		
		buttonGrid[0][0].setBackground(Color.GREEN);
		buttonGrid[0][0].setEnabled(false);
		
		BarPanel.add(turn);
		
		
		frame.add(BarPanel);
		frame.pack();
	
		

		
		playAgainPanel=new JPanel();
		playAgainPanel.setPreferredSize(new Dimension(500,500));	
		playAgainPanel.setBackground(Color.orange);
		playAgainPanel.add(winnerLabel);
		JLabel playagainLabel= new JLabel("Do you want to play again? ");
		playAgainPanel.add(playagainLabel);
		JButton yes= new JButton("yes");
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==yes) {
					frame.remove(playAgainPanel);
					restart();
				}
			}
		});
		playAgainPanel.add(yes);
		JButton no= new JButton("no");
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==no) {
					frame.dispose();
				}
			}
		});
		playAgainPanel.add(no);
		
			
			
			
		
		
		
	}
	
	public static void getLegalMove(int z) {
		
			c1=col1;
			r1=row1;
			
			r2=row2;
			c2=col2;
			
			c3=col3;
			r3=row3;
			
			if(z==1) {
			for(i=0; i<row1; i++) {
				for (j=0; j< col1; j++) {
					buttonGrid[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Object o= e.getSource();
							 
							for(i=0; i<row1; i++) {
								for (j=0; j< col1; j++) {
									if (buttonGrid[i][j]== o) {
										
										if(i==0) {
											c1=j;
											
											
											
											eat(1,i,j);
											
											
											new java.util.Timer().schedule(
													new java.util.TimerTask() {
													@Override	
													public void run() {
														computerTurn(1,r1,c1);
													}
													},1200
													);
								
										}
										col1=c1;
										  
										if(j== col1-1) {
											
											j=0;
											r1=i;
											
											eat(1,i,j);
											
											
										
											new java.util.Timer().schedule(
													new java.util.TimerTask() {
													@Override	
													public void run() {
														computerTurn(1,r1,c1);
													}
													},1200
													);
										}
										
										if (j==0) {
											
											r1=i;
											eat(1,i,j);
											
											
											new java.util.Timer().schedule(
													new java.util.TimerTask() {
													@Override	
													public void run() {
														computerTurn(1,r1,c1);
													}
													},1200
													);
											
										}
										if(i== row1-1) {
											
											i=0;
											
											c1=j;
											eat(1,i,j);
											
											
											new java.util.Timer().schedule(
													new java.util.TimerTask() {
													@Override	
													public void run() {
														computerTurn(1,r1,c1);
													}
													},1200
													);
											
										}
										
										
										
										
										
									}
						
					
								}
							}
						}
					});
				
			 
				}
		
		
			}
			}

			
			
			
			
			
			if(z==2) {
				for(i=0; i<row2; i++) {
					for (j=0; j< col2; j++) {
						buttonGrid[i][j].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Object o= e.getSource();
								 
								for(i=0; i<row2; i++) {
									for (j=0; j< col2; j++) {
										if (buttonGrid[i][j]== o) {
											
											if(i==0) {
												c2=j;
												
												
												
												eat(2,i,j);
												
												
												new java.util.Timer().schedule(
														new java.util.TimerTask() {
														@Override	
														public void run() {
															computerTurn(2,r2,c2);
														}
														},1200
														);
									
											}
											col2=c2;
											  
											if(j== col2-1) {
												
												j=0;
												r2=i;
												
												eat(2,i,j);
												
												
											
												new java.util.Timer().schedule(
														new java.util.TimerTask() {
														@Override	
														public void run() {
															computerTurn(2,r2,c2);
														}
														},1200
														);
											}
											
											if (j==0) {
												
												r2=i;
												eat(2,i,j);
												
												
												new java.util.Timer().schedule(
														new java.util.TimerTask() {
														@Override	
														public void run() {
															computerTurn(2,r2,c2);
														}
														},1200
														);
												
											}
											if(i== row2-1) {
												
												i=0;
												
												c2=j;
												eat(2,i,j);
												
												
												new java.util.Timer().schedule(
														new java.util.TimerTask() {
														@Override	
														public void run() {
															computerTurn(2,r2,c2);
														}
														},1200
														);
												
											}
											
											
											
											
											
										}
							
						
									}
								}
							}
						});
					
				 
					}
			
			
				}
				}

			if(z==3) {
				for(i=0; i<row3; i++) {
					for (j=0; j< col3; j++) {
						buttonGrid[i][j].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Object o= e.getSource();
								 
								for(i=0; i<row3; i++) {
									for (j=0; j< col3; j++) {
										if (buttonGrid[i][j]== o) {
											
											if(i==0) {
												c3=j;
												
												
												
												eat(3,i,j);
												
												
												new java.util.Timer().schedule(
														new java.util.TimerTask() {
														@Override	
														public void run() {
															computerTurn(3,r3,c3);
														}
														},1200
														);
									
											}
											
											  
											if(j== col3-1) {
												
												j=0;
												r3=i;
												
												eat(3,i,j);
												
												
											
												new java.util.Timer().schedule(
														new java.util.TimerTask() {
														@Override	
														public void run() {
															computerTurn(3,r3,c3);
														}
														},1200
														);
											}
											
											if (j==0) {
												
												r3=i;
												eat(3,i,j);
												
												
												new java.util.Timer().schedule(
														new java.util.TimerTask() {
														@Override	
														public void run() {
															computerTurn(3,r3,c3);
														}
														},1200
														);
												
											}
											if(i== row3-1) {
												
												i=0;
												
												c3=j;
												eat(3,i,j);
												
												
												new java.util.Timer().schedule(
														new java.util.TimerTask() {
														@Override	
														public void run() {
															computerTurn(3,r3,c3);
														}
														},1200
														);
												
											}
											
											
											col3=c3;
											
											
										}
							
						
									}
								}
							}
						});
					
				 
					}
			
			
				}
				}
			
		
	}
	
	
				
			
	
	public static void computerTurn(int z,int r1, int c1) {
		 
		if(r1==0) {
			r1=1;
		}
		if(c1==0) {
			c1=1;
		}
		if(r1!=0 && c1!=0) {
			 tempi= random.nextInt(r1);
			 tempj= random.nextInt(c1);
		}
		
		while(tempi==0 && tempj== 0) {
			tempi= random.nextInt(r1);
			 tempj= random.nextInt(c1);
		}
		 
			
		
			 System.out.printf("tempi: %d ... tempj %d\n",tempi,tempj);
			 
			 turn.setText("Computer's move: row "+ tempi + " and column " + tempj + "!! Your turn!");
			 
			 
			 if(z==1) {
			 for(i=tempi; i<row1; i++) {
				for (j=tempj; j< col1; j++) {
					
						if(i==0) {
							c1=j;
							
							
							
							eat(1,i,j);
							return;
				
				
						}
						col1=c1;
						
						if(j== col1-1) {
							j=0;
							r1=i;
							
							eat(1,i,j);
							return;
						}
						if (j==0) {
							
							r1=i;
							eat(1,i,j);
							return;
				
						}
						if(i== row1-1) {

							i=0;
							
							c1=j;
							eat(1,i,j);
							return;
						}
						
						
					}
		
	
				}
			 int count=0;
				for(i=0;i<4;i++) {
					for(j=0;j<4;j++) {
						if(buttonGrid[i][j].isEnabled()==false) {
							count++;
						}
					}
				}
				System.out.println(count);
				if (count== (4*4)) {
					
					frame.remove(BarPanel);
					JLabel lost= new JLabel("You LOST!");
					playAgainPanel.add(lost);
					frame.add(playAgainPanel);
					frame.pack();
				
				
				}
			
			 }
			 
			 if(z==2) {
				 for(i=tempi; i<row2; i++) {
					for (j=tempj; j< col2; j++) {
						
							if(i==0) {
								c2=j;
								
								
								
								eat(2,i,j);
								return;
					
					
							}
							col2=c2;
							
							if(j== col2-1) {
								j=0;
								r2=i;
								
								eat(2,i,j);
								return;
							}
							if (j==0) {
								
								r2=i;
								eat(2,i,j);
								return;
					
							}
							if(i== row2-1) {

								i=0;
								
								c2=j;
								eat(2,i,j);
								return;
							}
							
							
						}
			
		
					}
				 int count=0;
					for(i=0;i<5;i++) {
						for(j=0;j<5;j++) {
							if(buttonGrid[i][j].isEnabled()==false) {
								count++;
							}
						}
					}
					System.out.println(count);
					if (count== (5*5)) {
						
						frame.remove(BarPanel);
						JLabel lost= new JLabel("You LOST!");
						playAgainPanel.add(lost);
						frame.add(playAgainPanel);
						frame.pack();
					
					}
			
				
				 }
			 
			 
			 if(z==3) {
				 for(i=tempi; i<row3; i++) {
					for (j=tempj; j< col3; j++) {
						
							if(i==0) {
								c3=j;
								
								
								
								eat(3,i,j);
								return;
					
					
							}
							col3=c3;
							
							if(j== col3-1) {
								j=0;
								r3=i;
								
								eat(3,i,j);
								return;
							}
							if (j==0) {
								
								r3=i;
								eat(3,i,j);
								return;
					
							}
							if(i== row3-1) {

								i=0;
								
								c3=j;
								eat(3,i,j);
								return;
							}
							
							
						}
			
		
					}
				 int count=0;
					for(i=0;i<6;i++) {
						for(j=0;j<6;j++) {
							if(buttonGrid[i][j].isEnabled()==false) {
								count++;
							}
						}
					}
					System.out.println(count);
					if (count== (6*6)) {
						
						frame.remove(BarPanel);
						JLabel lost= new JLabel("You LOST!");
						playAgainPanel.add(lost);
						frame.add(playAgainPanel);
						frame.pack();
					
					}
			
				
				 }
			 
				
			}
	
	public static void eat(int z,int tempi, int tempj) {
		System.out.printf("%d %d \n",tempi,tempj);
		
			if(z==1) {
			for (j=tempj; j<col1; j++) {
				i=tempi;
				buttonGrid[i][j].setEnabled(false);
				buttonGrid[i][j].setVisible(false);
		
		
				for(i=tempi; i<row1; i++) {
					buttonGrid[i][j].setEnabled(false);
					buttonGrid[i][j].setVisible(false);
				} 
		
			}
			int count=0;
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					if(buttonGrid[i][j].isEnabled()==false) {
						count++;
					}
				}
			}
			if (count== 4*4) {
				frame.remove(BarPanel);
				
				
				JLabel won= new JLabel("You Win!");
				playAgainPanel.add(won);
				frame.add(playAgainPanel);
				frame.pack();
			}
			}
			
			
			if(z==2) {
				for (j=tempj; j<col2; j++) {
					i=tempi;
					buttonGrid[i][j].setEnabled(false);
					buttonGrid[i][j].setVisible(false);
			
			
					for(i=tempi; i<row2; i++) {
						buttonGrid[i][j].setEnabled(false);
						buttonGrid[i][j].setVisible(false);
					} 
			
				}
				int count=0;
				for(i=0;i<5;i++) {
					for(j=0;j<5;j++) {
						if(buttonGrid[i][j].isEnabled()==false) {
							count++;
						}
					}
				}
				
				if (count== (5*5)) {
					
					frame.remove(BarPanel);
					
					
					JLabel won= new JLabel("You Win!");
					playAgainPanel.add(won);
					frame.add(playAgainPanel);
					frame.pack();
				}
				}
			
			
			if(z==3) {
				for (j=tempj; j<col3; j++) {
					i=tempi;
					buttonGrid[i][j].setEnabled(false);
					buttonGrid[i][j].setVisible(false);
			
			
					for(i=tempi; i<row3; i++) {
						buttonGrid[i][j].setEnabled(false);
						buttonGrid[i][j].setVisible(false);
					} 
			
				}
				int count=0;
				for(i=0;i<6;i++) {
					for(j=0;j<6;j++) {
						if(buttonGrid[i][j].isEnabled()==false) {
							count++;
						}
					}
				}
				
				if (count== (6*6)) {
					
					frame.remove(BarPanel);
					
					
					JLabel won= new JLabel("You Win!");
					playAgainPanel.add(won);
					frame.add(playAgainPanel);
					frame.pack();
				}
				}
			
		
		
	}		
	
	public static void restart() {
		frame.dispose();
		row1=4;
		col1=4;
		row2=5;
		col2=5;
		row3=6;
		col3=6;
		main(null);
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}