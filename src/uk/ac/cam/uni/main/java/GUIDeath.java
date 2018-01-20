package uk.ac.cam.uni.main.java;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUIDeath extends JFrame {
	
	private final String mBatchFile = "wallpaperscheduler.bat";
	private PreviewPanel mPreviewPanel;
	private JTextField mTextField;

	public GUIDeath() {
		super("Here yee Here yee get yo nice wallpapers");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1024, 512);

		add(createInputPanel(), BorderLayout.NORTH);
		add(createPreviewPanel(), BorderLayout.CENTER);
		
		JButton bOK = new JButton("OK");
		bOK.addActionListener(e-> {
			try {
				sendCommand(true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		});
		add(bOK, BorderLayout.SOUTH);
	}


	private void addBorder(JComponent component, String title) {
		Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border tb = BorderFactory.createTitledBorder(etch, title);
		component.setBorder(tb);
	}
	
	private JPanel createInputPanel() {
		JPanel ctrl = new JPanel();
		ctrl.setLayout(new GridLayout(1, 2));

		mTextField = new JTextField(20);
		ctrl.add(mTextField);

		JButton bPreview = new JButton("Preview");
		bPreview.addActionListener(e->{
			try {
				sendCommand(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		ctrl.add(bPreview);
		addBorder(ctrl, "Search for SubReddit");
		return ctrl;
	}

	private JPanel createPreviewPanel() {
		mPreviewPanel = new PreviewPanel();
		addBorder(mPreviewPanel, "Preview");
		return mPreviewPanel;
	}

	public static void main(String[] args) {
		GUIDeath gui = new GUIDeath();
		gui.setVisible(true);
	}
	
	private void sendCommand(boolean send) throws IOException {
		mPreviewPanel.clearPreviewImages();
		String s = "";
		String param1 = send ? "r" : "p";
		String param2 = mTextField.getText();
		Process p = Runtime.getRuntime().exec(mBatchFile + " " + param1 + " " + param2);
		 
	    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    while ((s = stdInput.readLine()) != null) { //print the output from running the command
	        System.out.println(s);
	    }
	    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	    while ((s = stdError.readLine()) != null) { //print any errors
	       System.out.println(s);
	    }
	}

}