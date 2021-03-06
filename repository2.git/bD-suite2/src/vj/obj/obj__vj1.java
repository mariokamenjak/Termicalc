package vj.obj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import program.window.BdBrowser;
import program.window.BdNotes;
import program.window.Credits;
import program.window.Image;
import program.window.Mp3;
import program.window.Xuggler_test2;

public class obj__vj1 {
	private static final Logger logger=LoggerFactory.getLogger(obj__vj1.class);
	//Starts the logger
	private JFrame frame;

	final JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					obj__vj1 window = new obj__vj1();
					window.frame.setVisible(true);
					logger.info("Main windows is running!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public obj__vj1() {
		initialize();
	}//Starts the main window

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.DARK_GRAY);
		frame.setTitle("bD suite");
		frame.setBounds(574, 100, 747, 257);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
	//Main window configuration
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		final JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(new GridLayout(10, 0, 0, 0));
		//Panel settings

		//Mp3 button settings
		JButton btnMp3 = new JButton("Mp3");
		btnMp3.setToolTipText("Starts the mp3 player");
		btnMp3.setBackground(SystemColor.window);
		btnMp3.setIcon(new ImageIcon(obj__vj1.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
		btnMp3.setSelectedIcon(null);
		
		btnMp3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				new Thread() {  
	                public void run() {  
	                	Mp3.Mp3run(null);
	                }  
	              }.start(); 
	              //Mp3 player thread
			}
		});
		panel.add(btnMp3);
		//Image button settings
		JButton btnImage = new JButton("Image");
		btnImage.setToolTipText("Starts the image viewer");
		btnImage.setBackground(SystemColor.window);
		btnImage.setIcon(new ImageIcon(obj__vj1.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		btnImage.setSelectedIcon(null);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {  
	                public void run() {  
	                	Image.Imagerun(null);
	                }  
	              }.start(); //Image viewer thread

			}
		});
		panel.add(btnImage);
		//Here starts bD notes
		JButton btnText = new JButton("Text");
		btnText.setToolTipText("Starts BdNotes");
		btnText.setBackground(SystemColor.window);
		btnText.setIcon(new ImageIcon(obj__vj1.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerShuffle.png")));
		btnText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {  
	                public void run() {  
	                	BdNotes.BdNotesrun(null);
	                }  
	              }.start(); //And his own thread
			}
		});
		panel.add(btnText);
		//HTML 3.2 browser
		JButton btnBrowser = new JButton("Browser");
		btnBrowser.setIcon(new ImageIcon(obj__vj1.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerRepeat.png")));
		btnBrowser.setBackground(SystemColor.window);
		btnBrowser.setToolTipText("Starts a web browser with music.com as the default page.");
		btnBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {  
	                public void run() {  
	                	try {
	    					BdBrowser.runBr(null);
	    				} catch (Exception e) {
	    					// TODO Auto-generated catch block
	    					logger.info("Browser ne radi?");
	    					e.printStackTrace();
	    				}
	                }  
	              }.start(); //Browser thread
				
			}
		});
		panel.add(btnBrowser);
		//Video player...that was a tough one.
		JButton btnVideo = new JButton("Video");
		btnVideo.setIcon(new ImageIcon(obj__vj1.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerSkipForward.png")));
		btnVideo.setBackground(SystemColor.window);
		btnVideo.setToolTipText("Starts the video player");
		btnVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {  
	                public void run() {  
	                 Xuggler_test2.runv(null);
	                  }  
	              }.start();  
	              //It has to be in a thread otherwise a heap out of memory exception error will happen...That scared me.
			}
		});
		panel.add(btnVideo);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {  
	                public void run() {  
	                 Credits.runCred(null);
	                  }  
	              }.start(); 
			}
		});
		btnCredits.setIcon(new ImageIcon(obj__vj1.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		btnCredits.setBackground(SystemColor.window);
		panel.add(btnCredits);

		
	}

}
