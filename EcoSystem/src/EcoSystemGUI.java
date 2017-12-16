
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
public class EcoSystemGUI extends JFrame implements ActionListener {

	// Declare variables for labels and buttons
	// variables to be used throughout the class 
	ImagePicture ipBackground, switchOn, switchOff;
	JTextArea outputArea;
	static JTextField emissionNum;
	JScrollPane scrollPanel;
	JButton btnOn, btnOff;
	static int secondsPassed;
	
	

		
	/**
	 * Default Constructor
	 */
	public EcoSystemGUI() {
		super ("Name Here"); // Set the frame's name 
		setSize (1000,600); //set the frames size
		setLayout(null);
		
		//create textfield
		emissionNum = new JTextField("0");

		//create text area
		outputArea = new JTextArea("Transactions");

		//create buttons
		btnOn = new JButton("Turn Light On");
		btnOff = new JButton("Turn Light Off");


		// background picture
		ipBackground = new ImagePicture(new ImageIcon("bgPic.jpg"));
		//switch pic
		switchOn = new ImagePicture(new ImageIcon("switchOn.png"));
		switchOff = new ImagePicture(new ImageIcon("switchOff.png"));

		//add text field
		emissionNum.setBounds(530,160,240,72);
		emissionNum.setFont(new Font("SansSerif", Font.BOLD, 44));
		emissionNum.setEditable(false);
		add(emissionNum);
		
		//add buttons
		btnOn.setBounds(50,340,170,40);
		btnOn.addActionListener(this);
		add(btnOn);
		btnOff.setBounds(50,390,170,40);
		btnOff.addActionListener(this);
		add(btnOff);



		//switch on
		switchOn.setBounds(50,120,200,200);
		add(switchOn);
		switchOn.setVisible(false);

		switchOff.setBounds(50,120,200,200);
		add(switchOff);
		switchOff.setVisible(false);

		//background pic
		ipBackground.setBounds(0,0,1000,600);
		add(ipBackground);


		//shows frame
		setVisible(true);

		//exit button enabled (red)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end default constructor
	
	static Timer myTimer = new Timer();
	static TimerTask task = new TimerTask(){
		public void run() {
			secondsPassed++;
			System.out.println("Seconds Passed: " + secondsPassed);
			emissionNum.setText("" + secondsPassed *10);
			}//end run
		}; //end timer task

	public static void start() {
		myTimer.scheduleAtFixedRate(task,1000,1000);
	}//end start



	/**
	 * 	Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		new EcoSystemGUI();

	}//end main
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		//if view buttons is pressed
		if(e.getSource() == btnOn) {
			EcoSystemGUI.start();
			switchOff.setVisible(false);
			switchOn.setVisible(true);

		}//end if for view button

		//if open button is pressed
		else if (e.getSource() == btnOff) {
			myTimer.cancel();
			switchOn.setVisible(false);
			switchOff.setVisible(true);
		}//end open button

	}//end action performed

}//end class

