package bixiTrip;

/** 
 * The main UI for BixiTrip. Likely requires WindowBuilder for Eclipse to be installed
 * in order to function properly.
 * 
 * @author Jonathan Janzen
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

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
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class BixiTripUI extends JFrame {

	private JPanel contentPane;
	private JTextField statusField = new JTextField();
	private Boolean isParsed = false;
	private JProgressBar progressBar = new JProgressBar();
	private JButton directionsButton = new JButton("Get Directions");
	private Color bixiRed = new Color(213, 43, 30);

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons\\runningIcon.png"));

		setTitle("BixiTrip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 339);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icons\\logo.png"));
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

		// JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(12, 217, 568, 14);
		progressBar.setForeground(bixiRed);
		contentPane.add(progressBar);

		// JButton directionsButton = new JButton("Get Directions");
		directionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stations stations = Stations.getInstance();
				Station start, end;
				Integer startCode, endCode;
				Trip mainTrip;

				if (startStationComboBox.getSelectedItem() == "" || endStationComboBox.getSelectedItem() == "") {
					statusField.setForeground(new Color(255, 0, 0));
					statusField.setText("One or more selections is incorrect. Please select a start and end station.");
					return;
				}

				start = stations.getStationByIndex(startStationComboBox.getSelectedIndex() - 1);
				end = stations.getStationByIndex(endStationComboBox.getSelectedIndex() - 1);
				mainTrip = new Trip(start, end);
				String url = mainTrip.getUrl();
				statusField.setForeground(new Color(0, 0, 0));
				statusField.setText("Trip from " + start.getName() + " to " + end.getName() + " found.");
				System.out.println(url);
				return;
			}
		});
		directionsButton.setEnabled(false);
		directionsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		directionsButton.setBounds(199, 166, 200, 38);
		contentPane.add(directionsButton);

		// statusField = new JTextField();
		statusField.setEditable(false);
		statusField.setHorizontalAlignment(SwingConstants.CENTER);
		statusField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		statusField.setBounds(12, 244, 568, 38);
		contentPane.add(statusField);
		statusField.setColumns(10);

		// start general main implementation
		String url, stationPath = "stations\\stations_2018.csv", pastTripsPath = "pastTrips";
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
		statusField.setText("Welcome to BixiTrip! Please wait while we import our data.");

		// populate combobox
		ArrayList<Station> stationsList = stations.getStations();

		startStationComboBox.addItem("");
		endStationComboBox.addItem("");
		for (Station element : stationsList) {
			startStationComboBox.addItem(element.getName());
			endStationComboBox.addItem(element.getName());
		}
		startStationComboBox.setEnabled(true);
		endStationComboBox.setEnabled(true);

		// parse data in background
		parse();
	}

	/**
	 * Background task for parsing input data and updating UI accordingly.
	 */
	public void parse() {
		SwingWorker<Boolean, String> worker = new SwingWorker<Boolean, String>() {
			// @Override
			protected Boolean doInBackground() throws Exception {
				String pastTripsPath;
				File pastTripsDir;
				PastTrips pastTrips = new PastTrips();
				pastTrips = pastTrips.getInstance();
				Paths paths = Paths.getInstance();

				// import pastTrips and add them to object
				pastTripsPath = "pastTrips";
				pastTripsDir = new File(pastTripsPath);
				progressBar.setIndeterminate(true);
				try {
					pastTrips = Parser.parsePastTrips(pastTripsPath);
					isParsed = true;
				} catch (Exception f) {
					statusField.setForeground(new Color(255, 0, 0));
					statusField.setText(
							"Past trips directory couldn't be found. Please correct the file path and try again.");
					return false;
				}

				// calculate paths
				try {
					paths.importPastTrips();
				} catch (Exception e) {
					statusField.setForeground(new Color(255, 0, 0));
					statusField.setText("An error occurred during the path conversion. Please try again.");
					return false;
				}

				// update UI to show completion
				progressBar.setIndeterminate(false);
				directionsButton.setEnabled(true);
				statusField.setForeground(new Color(0, 0, 0));
				statusField.setText("Imported successfully. Directions enabled.");
				return true;
			}
		};
		worker.execute();
	}
}
