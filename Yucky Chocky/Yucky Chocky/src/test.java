import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class test extends JPanel implements ActionListener {

	private static final int MAX_Width=10;
	private static final int MAX_Height=10;
	private static JButton[][] buttonGrid= new JButton[MAX_Width][MAX_Height];
	private static JButton[][] buttonGrid2= new JButton[MAX_Width][MAX_Height];
	private static JButton[][] buttonGrid3= new JButton[MAX_Width][MAX_Height];
	public static int row1=4;
	public static int col1=4;
	public static int row2=5;
	public static int col2=5;
	public static int row3=6;
	public static int col3=6;
	public static int c1;
	public static int r1;
	public static int c2;
	public static int r2;
	public static int c3;
	public static int r3;
	public static Random random= new Random();
	public static JPanel BarPanel1;
	public static JPanel BarPanel2;
	public static JPanel BarPanel3;

	public static void main (String[] args) throws InterruptedException {
		
		playgame();
		Thread.sleep(500);
		compTurn();
	}
	
	static void playgame() {
		
		
		
		//Created Frame
		JFrame frame= new JFrame ("Chocolate Bar");
		frame.setSize(new Dimension(500,500));
		
		frame.setVisible(true);
		
		//Welcome Panel
		JPanel welcomePanel= new JPanel(new GridLayout(11,1));
		welcomePanel.setPreferredSize(new Dimension(500,500));
		welcomePanel.setBackground(Color.GREEN);
		
		//welcome message
		JLabel welcome= new JLabel("Let's play.... YUCKY CHOCKY");
		welcomePanel.add(welcome);
		
		//JLabel and textfield for entering rows
		
		
		//JLabel and textfield for entering columns
		
		
		
		//Choosing default options
		JLabel defaultChoice= new JLabel("Please choose a default size");
		welcomePanel.add(defaultChoice);
		frame.add(welcomePanel);
		
		//The three options
		JButton first= new JButton("4X4");
		JButton second= new JButton("5X5");
		JButton third= new JButton("6X6");	
		 
		welcomePanel.add(first);
		welcomePanel.add(second);
		welcomePanel.add(third);
		
		
		
		
		
		
		//Chocolate Panel
		//Drawing chocolate bar
				Color BROWN= new Color(123,63,0);
		
		JPanel BarPanel1 = new JPanel(new GridLayout(row1,col1));
		BarPanel1.setPreferredSize(new Dimension(500,500));
		
		BarPanel1.setBackground(Color.YELLOW);
		BarPanel1.revalidate();

		for(int i=0; i<row1; i++) {
			for (int j=0; j< col1; j++) {
				buttonGrid[i][j]= new JButton();
				buttonGrid[i][j].setBackground(BROWN);
				BarPanel1.add(buttonGrid[i][j]);
			}
		}
		
		//panel2
		JPanel BarPanel2 = new JPanel(new GridLayout(row2,col2));
		BarPanel2.setPreferredSize(new Dimension(500,500));
		
		BarPanel2.setBackground(Color.YELLOW);
	
		
		for(int i=0; i<row2; i++) {
			for (int j=0; j< col2; j++) {
				buttonGrid2[i][j]= new JButton();
				buttonGrid2[i][j].setBackground(BROWN);
				BarPanel2.add(buttonGrid2[i][j]);
			}
		}
		
		
		//panel3
		
		JPanel BarPanel3 = new JPanel(new GridLayout(row3,col3));
		BarPanel3.setPreferredSize(new Dimension(500,500));
		
		BarPanel3.setBackground(Color.YELLOW);
		
		for(int i=0; i<row3; i++) {
			for (int j=0; j< col3; j++) {
				buttonGrid3[i][j]= new JButton();
				buttonGrid3[i][j].setBackground(BROWN);
				BarPanel3.add(buttonGrid3[i][j]);
			}
		}
		
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (first==e.getSource()) {
					
					
				
					frame.remove(welcomePanel);
					frame.add(BarPanel1);
					frame.pack();
					frame.setVisible(true);
				}
			}
		});
		
		second.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (second==e.getSource()) {
					

					
					frame.remove(welcomePanel);
					frame.add(BarPanel2);
					frame.pack();
					frame.setVisible(true);
				}
			}
		});
		
		third.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (third==e.getSource()) {
					
					frame.remove(welcomePanel);
					frame.add(BarPanel3);
					frame.pack();
					frame.setVisible(true);
				}
			}
		});
		
		c1=col1;
		c2=col2;
		c3=col3;
		
		
		
	
		
	
		
		
	
		

		
		
		for(int i=0; i<row1; i++) {
			for (int j=0; j< col1; j++) {
				
				
				buttonGrid[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object o= e.getSource();
						for (int i=0;i<row1; i++) {
							for(int j=0; j<col1; j++) {
						
								if(buttonGrid[i][j]==o) {
									
									
									int column;
									int ROWS;
									if(i==0) {
										c1=j;
										for (j=j; j<row1; j++) {
											i=0;
											buttonGrid[i][j].setEnabled(false);
											buttonGrid[i][j].setBackground(Color.WHITE);
										
										
										for (i=i; i<row1; i++) {
											buttonGrid[i][j].setEnabled(false);
											buttonGrid[i][j].setBackground(Color.WHITE);
											
										}
										}
										
										
										
										
										
										
										
									}//First Row programming
									
									col1=c1;
									if (j==col1-1) {
										for (i=i;i<row1;i++) {
											for(j=0;j<col1; j++) {
												buttonGrid[i][j].setEnabled(false);
												buttonGrid[i][j].setBackground(Color.WHITE);
											}
										}
									}//RIGHT Column programming
									
										
									
									
									
									
									
									
								}//MAIN PROGRAMMING
						
							}
						}
					}
				});
				
				buttonGrid[0][0].setEnabled(false);
				buttonGrid[0][0].setBackground(Color.GREEN);
				
				
			}
		}
		
		for(int i=0; i<row2; i++) {
			for (int j=0; j< col2; j++) {
				
				
				buttonGrid2[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object o= e.getSource();
						for (int i=0;i<row2; i++) {
							for(int j=0; j<col2; j++) {
						
								if(buttonGrid2[i][j]==o) {
									
									
									int column2;
									int ROWS2;
									if(i==0) {
										c2=j;
										for (j=j; j<row2; j++) {
											i=0;
											buttonGrid2[i][j].setEnabled(false);
											buttonGrid2[i][j].setBackground(Color.WHITE);
										
										
										for (i=i; i<row2; i++) {
											buttonGrid2[i][j].setEnabled(false);
											buttonGrid2[i][j].setBackground(Color.WHITE);
											
										}
										}
										
										
										
										
										
										
										
									}//First Row programming
									
									col2=c2;
									if (j==col2-1) {
										for (i=i;i<row2;i++) {
											for(j=0;j<col2; j++) {
												buttonGrid2[i][j].setEnabled(false);
												buttonGrid2[i][j].setBackground(Color.WHITE);
											}
										}
									}//RIGHT Column programming
									
										
									
									
									
									
									
									
								}//MAIN PROGRAMMING
						
							}
						}
					}
				});
				
				buttonGrid2[0][0].setEnabled(false);
				buttonGrid2[0][0].setBackground(Color.GREEN);
				
				
			}
		}
		
		
		for(int i=0; i<row3; i++) {
			for (int j=0; j< col3; j++) {
				
				
				buttonGrid3[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object o= e.getSource();
						for (int i=0;i<row3; i++) {
							for(int j=0; j<col3; j++) {
						
								if(buttonGrid3[i][j]==o) {
									
									
									int column3;
									int ROWS3;
									if(i==0) {
										c3=j;
										for (j=j; j<row3; j++) {
											i=0;
											buttonGrid3[i][j].setEnabled(false);
											buttonGrid3[i][j].setBackground(Color.WHITE);
										
										
										for (i=i; i<row3; i++) {
											buttonGrid3[i][j].setEnabled(false);
											buttonGrid3[i][j].setBackground(Color.WHITE);
											
										}
										}
										
										
										
										
										
										
										
									}//First Row programming
									
									col3=c3;
									if (j==col3-1) {
										for (i=i;i<row3;i++) {
											for(j=0;j<col3; j++) {
												buttonGrid3[i][j].setEnabled(false);
												buttonGrid3[i][j].setBackground(Color.WHITE);
											}
										}
									}//RIGHT Column programming
									
										
									
									
									
									
									
									
								}//MAIN PROGRAMMING
						
							}
						}
					}
				});
				
				buttonGrid3[0][0].setEnabled(false);
				buttonGrid3[0][0].setBackground(Color.GREEN);
				
				
			}
		}
		
	}
	
	public static void compTurn() {
		
		c1=col1;
		c2=col2;
		c3=col3;
		
		
		
		
		for(int i=0; i<row1; i++) {
			for (int j=0; j< col1; j++) {
				
				
				buttonGrid[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int RandI= random.nextInt(row1);
						int RandJ= random.nextInt(col1);
						for (int i=0;i<row1; i++) {
							for(int j=0; j<col1; j++) {
						
								if(buttonGrid[i][j]==buttonGrid[RandI][RandJ]) {
									
									System.out.println("dhukse bhitore");
									
									int column;
									int ROWS;
									if(i==0) {
										c1=j;
										for (j=j; j<row1; j++) {
											i=0;
											buttonGrid[i][j].setEnabled(false);
											buttonGrid[i][j].setBackground(Color.WHITE);
										
										
										for (i=i; i<row1; i++) {
											buttonGrid[i][j].setEnabled(false);
											buttonGrid[i][j].setBackground(Color.WHITE);
											
										}
										}
										
										
										
										
										
										
										
									}//First Row programming
									
									col1=c1;
									if (j==col1-1) {
										for (i=i;i<row1;i++) {
											for(j=0;j<col1; j++) {
												buttonGrid[i][j].setEnabled(false);
												buttonGrid[i][j].setBackground(Color.WHITE);
											}
										}
									}//RIGHT Column programming
									
										
									else {
										RandI= random.nextInt(row1);
										RandJ= random.nextInt(col1);
										
									}
									
									
									
									
									
								}//MAIN PROGRAMMING
						
							}
						}
					}
				});
				
				buttonGrid[0][0].setEnabled(false);
				buttonGrid[0][0].setBackground(Color.GREEN);
				
				
			}
		}
		
		for(int i=0; i<row2; i++) {
			for (int j=0; j< col2; j++) {
				
				
				buttonGrid2[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object o= e.getSource();
						for (int i=0;i<row2; i++) {
							for(int j=0; j<col2; j++) {
						
								if(buttonGrid2[i][j]==o) {
									
									
									int column2;
									int ROWS2;
									if(i==0) {
										c2=j;
										for ( ; j<row2; j++) {
											i=0;
											buttonGrid2[i][j].setEnabled(false);
											buttonGrid2[i][j].setBackground(Color.WHITE);
										
										
										for (i=i; i<row2; i++) {
											buttonGrid2[i][j].setEnabled(false);
											buttonGrid2[i][j].setBackground(Color.WHITE);
											
										}
										}
										
										
										
										
										
										
										
									}//First Row programming
									
									col2=c2;
									if (j==col2-1) {
										for (i=i;i<row2;i++) {
											for(j=0;j<col2; j++) {
												buttonGrid2[i][j].setEnabled(false);
												buttonGrid2[i][j].setBackground(Color.WHITE);
											}
										}
									}//RIGHT Column programming
									
										
									
									
									
									
									
									
								}//MAIN PROGRAMMING
						
							}
						}
					}
				});
				
				buttonGrid2[0][0].setEnabled(false);
				buttonGrid2[0][0].setBackground(Color.GREEN);
				
				
			}
		}
		
		
		for(int i=0; i<row3; i++) {
			for (int j=0; j< col3; j++) {
				
				
				buttonGrid3[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object o= e.getSource();
						for (int i=0;i<row3; i++) {
							for(int j=0; j<col3; j++) {
						
								if(buttonGrid3[i][j]==o) {
									
									
									int column3;
									int ROWS3;
									if(i==0) {
										c3=j;
										for (j=j; j<row3; j++) {
											i=0;
											buttonGrid3[i][j].setEnabled(false);
											buttonGrid3[i][j].setBackground(Color.WHITE);
										
										
										for (i=i; i<row3; i++) {
											buttonGrid3[i][j].setEnabled(false);
											buttonGrid3[i][j].setBackground(Color.WHITE);
											
										}
										}
										
										
										
										
										
										
										
									}//First Row programming
									
									col3=c3;
									if (j==col3-1) {
										for (i=i;i<row3;i++) {
											for(j=0;j<col3; j++) {
												buttonGrid3[i][j].setEnabled(false);
												buttonGrid3[i][j].setBackground(Color.WHITE);
											}
										}
									}//RIGHT Column programming
									
										
									
									
									
									
									
									
								}//MAIN PROGRAMMING
						
							}
						}
					}
				});
				
				buttonGrid3[0][0].setEnabled(false);
				buttonGrid3[0][0].setBackground(Color.GREEN);
				
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
