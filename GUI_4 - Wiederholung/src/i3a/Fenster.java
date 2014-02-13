package i3a;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class Fenster extends JFrame{

	private static final long serialVersionUID = 1L;
	private Container c;
	private JPanel jpNorth, jpCentre, jpSouth;
	private JButton jbtRot, jbtGelb, jbtBlau;
	private JRadioButton jradioRot, jradioGelb, jradioBlau;
	private JComboBox<String> jcbFarben;
	private JMenuItem jmiBeenden, jmiRot, jmiBlau, jmiGelb;


	public Fenster() {
		this.setTitle("Farbenwahl");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(500, 500);
		this.setSize(400, 400);
		
		initComponents();
		
		plazieren();
		
		initEvents();
		
		this.setVisible(true);		
	}
	
	private void plazieren(){
		c.add(jpNorth,BorderLayout.NORTH);
		c.add(jpCentre,BorderLayout.CENTER);
		c.add(jpSouth,BorderLayout.SOUTH);		
	}
	
	private void initComponents(){
		c = this.getContentPane();
		
		menueHinzuefuegen();
		
		jradioRot = new JRadioButton("Rot");
		jradioGelb = new JRadioButton("Gelb");
		jradioBlau = new JRadioButton("Blau");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jradioBlau);
		bg.add(jradioGelb);
		bg.add(jradioRot);
		
		//JComboBox
		jcbFarben = new JComboBox<>();
		jcbFarben.addItem("Rot");
		jcbFarben.addItem("Gelb");
		jcbFarben.addItem("Blau");
		
		jbtRot = new JButton("Rot");
		jbtGelb = new JButton("Gelb");
		jbtBlau = new JButton("Blau");
		
		jpNorth = new JPanel();
		jpNorth.add(jradioRot);
		jpNorth.add(jradioGelb);
		jpNorth.add(jradioBlau);
		jpNorth.add(jcbFarben);
		
		jpCentre = new JPanel();

		jpSouth = new JPanel();
		jpSouth.add(jbtRot);
		jpSouth.add(jbtGelb);
		jpSouth.add(jbtBlau);
		
	}

	private void menueHinzuefuegen() {
		//JMenü hinzufügen
				JMenuBar jmbMenu = new JMenuBar();
				JMenu jmDatei = new JMenu("Datei");
				JMenu jmBearbeiten = new JMenu("Bearbeiten");
				
				jmiBeenden = new JMenuItem("Beenden");
				jmiGelb = new JMenuItem("Gelb");
				jmiRot = new JMenuItem("Rot");
				jmiBlau = new JMenuItem("Blau");
				
				jmDatei.add(jmiBeenden);
				jmBearbeiten.add(jmiBlau);
				jmBearbeiten.add(jmiGelb);
				jmBearbeiten.add(jmiRot);
				
				jmbMenu.add(jmDatei);
				jmbMenu.add(jmBearbeiten);
				
				this.setJMenuBar(jmbMenu);
				
			//JMenu hinfügen beendet
	}

	private void initEvents(){
		MeinActionListener mal = new MeinActionListener();
		
		jbtRot.addActionListener(mal);
		jbtGelb.addActionListener(mal);
		jbtBlau.addActionListener(mal);
		
		jradioRot.addActionListener(mal);
		jradioGelb.addActionListener(mal);
		jradioBlau.addActionListener(mal);
		
		jcbFarben.addActionListener(mal);
		
		jmiBeenden.addActionListener(mal);
		jmiRot.addActionListener(mal);
		jmiGelb.addActionListener(mal);
		jmiBlau.addActionListener(mal);
	}
	
	private class MeinActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			//e.getActionCommand();	->bekommen des Events in e 
			
			String ActionCommand = e.getActionCommand();
			if(ActionCommand == "comboBoxChanged"){
				ActionCommand=(String)jcbFarben.getSelectedItem();
			}
			
			switch (ActionCommand) {
			case "Rot":
				jpCentre.setBackground(Color.RED);
				jradioRot.setSelected(true);
				jcbFarben.setSelectedItem("Rot");
				break;
			case "Gelb":
				jpCentre.setBackground(Color.YELLOW);
				jradioGelb.setSelected(true);
				jcbFarben.setSelectedItem("Gelb");
				break;
			case "Blau":
				jpCentre.setBackground(Color.BLUE);
				jradioBlau.setSelected(true);
				jcbFarben.setSelectedItem("Blau");
				break;
			case "Beenden":
				//Soll beendet werden
				break;
			}
		}
	}
}

