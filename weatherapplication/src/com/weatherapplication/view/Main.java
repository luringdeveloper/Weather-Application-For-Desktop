package com.weatherapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					for(int i=0;i<=100;i++) {
						frame.progressBar.setValue(i);
						Thread.sleep(50);
					}
					if(frame.progressBar.getValue()==100) {
						new WeatherApplication().setVisible(true);
						frame.dispose();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(WeatherApplication.class.getResource("/com/weatherapplication/images/appicon.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(514, 480);
		contentPane = new JPanel();
		//contentPane.setBackground(new Color(51, 73, 95));
		contentPane.setBorder(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><img src='https://i.pinimg.com/originals/0e/f3/bb/0ef3bb66d9216fffcea9022628f7bb26.gif' width=514 height=459></html>");
		lblNewLabel.setBorder(null);
		lblNewLabel.setBounds(0, 0, 514, 459);
	
		
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBorderPainted(false);
		progressBar.setStringPainted(true);
		
	
		
		progressBar.setFont(new Font("Times New Roman", Font.BOLD, 15));
	
		progressBar.setForeground(new Color(70, 93, 95));
		progressBar.setBackground(new Color(51, 73, 95));
		progressBar.setBounds(0, 460, 514, 20);
		contentPane.add(progressBar);
	}
}
