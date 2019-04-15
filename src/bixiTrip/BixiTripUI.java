package bixiTrip;

/** 
 * BixiTrip main with user interface, version 1.1.1. Works the same as the BixiTrip class, but does not require
 * input arguments
 * 
 * @author Jonathan Janzen
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class BixiTripUI extends JFrame {

	private JPanel contentPane;
	private JTextField statusField = new JTextField();
	private JProgressBar progressBar = new JProgressBar();
	private JButton directionsButton = new JButton("Get Directions");
	private static Color bixiRed = new Color(213, 43, 30), error = new Color(255, 0, 0);
	private ArrayList<Station> stationsList;

	/**
	 * Launch the application.
	 * 
	 * @param args Input arguments
	 */
	public static void main(String[] args) {
		javax.swing.UIManager.put("ProgressBar.selectionBackground", Color.black);
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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons\\runningIcon.png"));

		setTitle("BixiTrip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 339);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icons\\logo2.png"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(2, 2, 679, 38);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel);

		JComboBox startStationComboBox = new JComboBox();
		startStationComboBox.setEnabled(false);
		startStationComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		startStationComboBox.setBounds(176, 53, 493, 38);
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
		endStationComboBox.setBounds(176, 115, 493, 38);
		contentPane.add(endStationComboBox);

		// JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(12, 217, 657, 14);
		progressBar.setForeground(bixiRed);
		contentPane.add(progressBar);

		// JButton directionsButton = new JButton("Get Directions");
		directionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stations stations = Stations.getInstance();
				int startCode, endCode;
				Station start, end;
				Trip mainTrip;

				// check that two stations have been selected
				if (startStationComboBox.getSelectedItem() == "" || endStationComboBox.getSelectedItem() == "") {
					statusField.setForeground(error);
					statusField.setText("One or more selections are incorrect. Please select a start and end station.");
					return;
				}

				// check that each station is unique
				if (startStationComboBox.getSelectedIndex() == endStationComboBox.getSelectedIndex()) {
					statusField.setForeground(error);
					statusField.setText("Start and Destination cannot be the same station.");
					return;
				}

				// find start and end code for stations
				startCode = stationsList.get(startStationComboBox.getSelectedIndex() - 1).getCode();
				start = stations.getStationByCode(startCode);
				endCode = stationsList.get(endStationComboBox.getSelectedIndex() - 1).getCode();
				end = stations.getStationByCode(endCode);

				// create trip
				mainTrip = new Trip(start, end);
				String url = mainTrip.getUrl();
				statusField.setForeground(Color.black);
				statusField.setText("Trip from " + start.getName() + " to " + end.getName() + " found.");

				// open URL in default browser
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (Exception f) {
						f.printStackTrace();
						return;
					}
				}
				return;
			}
		});
		directionsButton.setEnabled(false);
		directionsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		directionsButton.setBounds(259, 166, 200, 38);
		contentPane.add(directionsButton);

		// statusField = new JTextField();
		statusField.setEditable(false);
		statusField.setHorizontalAlignment(SwingConstants.CENTER);
		statusField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		statusField.setBounds(12, 244, 657, 38);
		contentPane.add(statusField);
		statusField.setColumns(10);

		// start station import
		String stationPath = "stations\\stations_2018.csv", pastTripsPath = "pastTrips";
		File stationFile;

		// initialize PastTrips and Stations abstract objects
		Stations stations = new Stations();
		PastTrips pastTrips = new PastTrips();

		stationFile = new File(stationPath);
		if (!stationFile.exists()) {
			statusField.setForeground(error);
			statusField.setText("Stations file could not be found. Please correct the file path and try again.");
			return;
		}
		try {
			stations = Parser.parseStations(stationPath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		statusField.setText("Welcome to BixiTrip! Please wait while we import our data.");

		// populate combobox
		stationsList = algs.StationsMergesort.sortByName(stations.getStations());

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
				progressBar.setStringPainted(true);
				try {
					progressBar.setString("Parsing past trips...");
					pastTrips = Parser.parsePastTrips(pastTripsPath);
				} catch (Exception f) {
					progressBar.setStringPainted(false);
					progressBar.setIndeterminate(false);
					statusField.setForeground(error);
					statusField.setText(
							"Past trips directory couldn't be found. Please correct the file path and try again.");
					return false;
				}

				// calculate paths
				try {
					progressBar.setString("Creating paths...");
					paths.importPastTrips();
				} catch (Exception e) {
					progressBar.setStringPainted(false);
					progressBar.setIndeterminate(false);
					statusField.setForeground(error);
					statusField.setText("An error occurred during the path conversion. Please try again.");
					return false;
				}

				// update UI to show completion
				progressBar.setIndeterminate(false);
				progressBar.setString("");
				progressBar.setStringPainted(false);
				directionsButton.setEnabled(true);
				statusField.setForeground(new Color(0, 0, 0));
				statusField.setText("Imported successfully. Directions enabled.");
				return true;
			}
		};
		worker.execute();
	}
}
