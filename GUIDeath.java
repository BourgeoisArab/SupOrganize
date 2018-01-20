package uk.ac.cam.jp775.supo;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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

public class GUIDeath extends JFrame implements ListSelectionListener {
	
	private PreviewPanel previewPanel;
	private JTextField textField;

	public GUIDeath() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1024, 768);

		setLayout(new GridLayout(3, 1));
		add(createInputPanel(), BorderLayout.CENTER);
		add(createPreviewPanel(), BorderLayout.NORTH);
		add(new JButton("OK"), BorderLayout.SOUTH);
	}


	private void addBorder(JComponent component, String title) {
		Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border tb = BorderFactory.createTitledBorder(etch, title);
		component.setBorder(tb);
	}
	
	private JPanel createInputPanel() {
		JPanel ctrl = new JPanel();
		ctrl.setLayout(new GridLayout(1, 2));

		textField = new JTextField(20);
		ctrl.add(textField);

		JButton bPreview = new JButton("Preview");
		ctrl.add(bPreview);
		addBorder(ctrl, "Search for SubReddit");
		return ctrl;
	}

	private JPanel createPreviewPanel() {
		previewPanel = new PreviewPanel();
		addBorder(previewPanel, "Preview");
		return previewPanel;
	}

	private JPanel createControlPanel() {
		JPanel ctrl = new JPanel();
		ctrl.setLayout(new GridLayout(1, 2));

		JButton bPreview = new JButton("Preview");
		bPreview.addActionListener(e -> {});
		JButton bOK = new JButton("OK");
		bOK.addActionListener(e -> {});

		ctrl.add(bPreview);
		ctrl.add(bOK);
		return ctrl;
	}

	public static void main(String[] args) {
		GUIDeath gui = new GUIDeath();
		gui.setVisible(true);
	}


	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}