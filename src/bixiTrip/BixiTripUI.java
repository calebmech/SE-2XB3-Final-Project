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
import java.awt.event.ActionEvent;

public class BixiTripUI extends JFrame {

	private JPanel contentPane;
	private JTextField statusField;

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
		
		JButton directionsButton = new JButton("Get Directions");
		directionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		directionsButton.setEnabled(false);
		directionsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		directionsButton.setBounds(199, 166, 200, 38);
		contentPane.add(directionsButton);
		
		JComboBox startStationComboBox = new JComboBox();
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
		endStationComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		endStationComboBox.setBounds(176, 115, 404, 38);
		contentPane.add(endStationComboBox);
		
		statusField = new JTextField();
		statusField.setEditable(false);
		statusField.setHorizontalAlignment(SwingConstants.LEFT);
		statusField.setFont(new Font("Tahoma", Font.ITALIC, 16));
		statusField.setBounds(12, 244, 568, 38);
		contentPane.add(statusField);
		statusField.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(12, 217, 568, 14);
		contentPane.add(progressBar);
	}
}
