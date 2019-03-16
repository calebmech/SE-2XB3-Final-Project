package bixiTrip;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BixiTripUI extends JFrame {

	private JPanel contentPane;
	private static JTextField statusField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BixiTripUI frame = new BixiTripUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public BixiTripUI() {
		setTitle("BixiTrip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 339);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BixiTrip");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(2, 2, 590, 38);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel);
		
		JComboBox startStationComboBox = new JComboBox();
		startStationComboBox.setEnabled(false);
		startStationComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		startStationComboBox.setBounds(176, 53, 404, 38);
		contentPane.add(startStationComboBox);
		
		JLabel lblStartStation = new JLabel("Start Station:");
		lblStartStation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblStartStation.setBounds(22, 54, 142, 37);
		contentPane.add(lblStartStation);
		
		JLabel lblEndStation = new JLabel("End Station:");
		lblEndStation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEndStation.setBounds(22, 115, 142, 37);
		contentPane.add(lblEndStation);
		
		JComboBox endStationComboBox = new JComboBox();
		endStationComboBox.setEnabled(false);
		endStationComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		endStationComboBox.setBounds(176, 115, 404, 38);
		contentPane.add(endStationComboBox);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(12, 217, 568, 14);
		contentPane.add(progressBar);
		
		JButton directionsButton = new JButton("Get Directions");
		directionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pastTripsPath;
				File pastTripsDir;
				PastTrips pastTrips;
				Station start, end;
				Integer startCode, endCode;
				Trip mainTrip;
				
				pastTrips = new PastTrips();
				pastTrips = pastTrips.getInstance();
				
				if (startStationComboBox.getSelectedItem() == "" || endStationComboBox.getSelectedItem() == "") {
					statusField.setForeground(new Color(255, 0, 0));
					statusField.setText("One or more selections is incorrect. Please select a start and end station.");
					return;
				}
				statusField.setForeground(new Color(0, 0, 0));
				statusField.setText("Parsing past trips...");
				progressBar.setIndeterminate(true);
				
				pastTripsPath = "pastTrips";
				pastTripsDir = new File(pastTripsPath);
				try {
					pastTrips = Parser.parsePastTrips(pastTripsPath);
				} catch (Exception f) {
					statusField.setForeground(new Color(255, 0, 0));
					statusField.setText("Past trips directory couldn't be found. Please correct the file path and try again.");
					return;
				}
				//progressBar.setIndeterminate(false);
			}
		});
		directionsButton.setEnabled(false);
		directionsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		directionsButton.setBounds(199, 166, 200, 38);
		contentPane.add(directionsButton);
		
		statusField = new JTextField();
		statusField.setEditable(false);
		statusField.setHorizontalAlignment(SwingConstants.CENTER);
		statusField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		statusField.setBounds(12, 244, 568, 38);
		contentPane.add(statusField);
		statusField.setColumns(10);
		
		//start general main implementation
		String url, stationPath = "stations\\stations_2018.csv", pastTripsPath = "pastTrips";
		Paths paths;
		File stationFile, pastTripsDir;
		
		// initialize PastTrips and Stations abstract objects
		Stations stations = new Stations();
		PastTrips pastTrips = new PastTrips();
		
		stationFile = new File(stationPath);
		if (!stationFile.exists()) {
			statusField.setForeground(new Color(255, 0, 0));
			statusField.setText("Stations file could not be found. Please correct the file path and try again.");
			return;
		}
		stations = Parser.parseStations(stationPath);
		statusField.setText("Welcome to BixiTrip! Please select your starting and ending locations.");
		
		//populate combobox
		ArrayList<Station> stationsList = stations.getStations();
		startStationComboBox.setEnabled(true);
		endStationComboBox.setEnabled(true);
		
		startStationComboBox.addItem("");
		endStationComboBox.addItem("");
		for (Station element : stationsList) {
			startStationComboBox.addItem(element.getName());
			endStationComboBox.addItem(element.getName());
		}
		directionsButton.setEnabled(true);
	}
}
