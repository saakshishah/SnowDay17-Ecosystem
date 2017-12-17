
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * @author Saakshi Shah
 *
 */
public class EcoSystemGUI extends JFrame{

	// Declare variables for labels and buttons
	// variables to be used throughout the class 
	ImagePicture ipBackground, switchOn, switchOff, clean,clean1,dirty1,dirty,black;
	JTextArea outputArea;
	static JTextField emissionNum;
	JScrollPane scrollPanel;
	JButton btnOn, btnOff;
	int buttonStatus;
	Timer timer;
	static int secondsPassed;




	/**
	 * Default Constructor
	 */
	public EcoSystemGUI() {
		super ("Watt a Waste"); // Set the frame's name 
		setSize (1000,600); //set the frames size
		setLayout(null);


		//create textfield
		emissionNum = new JTextField("0");

		//switch pic
		switchOn = new ImagePicture(new ImageIcon("bulbOn.png"));
		switchOff = new ImagePicture(new ImageIcon("bulbOff.png"));
		//clean pics
		clean = new ImagePicture(new ImageIcon("Clean.png")); 
		//clean1
		clean1 = new ImagePicture(new ImageIcon("Clean1.png"));
		//dirty
		dirty = new ImagePicture(new ImageIcon("Dirty.png"));
		//dirty1
		dirty1 = new ImagePicture(new ImageIcon("Dirty1.png"));
		//dirty1
		black = new ImagePicture(new ImageIcon("Black.png"));
		// background picture
		ipBackground = new ImagePicture(new ImageIcon("bgPic1.jpg"));

		//add text field
		emissionNum.setBounds(530,160,240,72);
		emissionNum.setFont(new Font("SansSerif", Font.BOLD, 44));
		emissionNum.setEditable(false);
		add(emissionNum);

		//switch on
		switchOn.setBounds(50,120,256,256);
		add(switchOn);
		switchOn.setVisible(false);

		switchOff.setBounds(50,120,256,256);
		add(switchOff);
		switchOff.setVisible(true);

		//clean
		clean.setBounds(530,270,256,256);
		add(clean);
		clean.setVisible(true);

		//clean
		clean1.setBounds(530,270,256,256);
		add(clean1);
		clean1.setVisible(false);

		//clean
		dirty.setBounds(530,270,256,256);
		add(dirty);
		dirty.setVisible(false);

		//clean
		dirty1.setBounds(530,270,256,256);
		add(dirty1);
		dirty1.setVisible(false);

		//clean
		black.setBounds(530,270,256,256);
		add(black);
		black.setVisible(false);


		//background pic
		ipBackground.setBounds(0,0,1000,600);
		add(ipBackground);


		//shows frame
		setVisible(true);

		//exit button enabled (red)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end default constructor

	public void start() {
		this.timer = new Timer();
		this.timer.scheduleAtFixedRate(new TimerTask(){
			public void run() {
				if(secondsPassed>=0 && secondsPassed <5){	
					clean.setVisible(true);
				}
				else if (secondsPassed>=5 && secondsPassed <10){	
					clean.setVisible(false);
					clean1.setVisible(true);
				}
				else if (secondsPassed>=10 && secondsPassed <15){	
					clean.setVisible(false);
					clean1.setVisible(false);
					dirty.setVisible(true);

				}else if (secondsPassed>=15 && secondsPassed <20){	
					clean.setVisible(false);
					clean1.setVisible(false);
					dirty.setVisible(false);
					dirty1.setVisible(true);
				}else if (secondsPassed>=24 && secondsPassed <30){	
					clean.setVisible(false);
					clean1.setVisible(false);
					dirty.setVisible(false);
					dirty1.setVisible(false);
					black.setVisible(true);
				}
				else if (secondsPassed >=30){
					JOptionPane.showMessageDialog(null, "YOU KILLED THE ECO SYSTEM");
				}
				secondsPassed++;
				System.out.println("Seconds Passed: " + secondsPassed);
				emissionNum.setText("" + secondsPassed *0.00035 *1000);

			}//end run
		} //end timer task
		,1000,1000);
	}//end start

	public void pause() {
		this.timer.cancel();
	}

	public void status (int num){
		buttonStatus = num;
		if (buttonStatus == 1){
			start();
			switchOff.setVisible(false);
			switchOn.setVisible(true);

		}
		else if (buttonStatus == 0){
			pause();
			switchOn.setVisible(false);
			switchOff.setVisible(true);
		}
	}

	/**
	 * 	Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		new EcoSystemGUI();
	}//end main




}//end class

