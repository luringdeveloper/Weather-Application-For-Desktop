package com.weatherapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.joda.time.DateTime;

import com.weatherapplication.control.WeatherApiDataController;
import com.weatherapplication.model.JodaTime;
import com.weatherapplication.model.WeatherModelClass;
import com.weatherapplication.utility.ImageResizer;
import com.weatherapplication.utility.RoundJTextField;
import com.weatherapplication.utility.RoundedPanel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;

public class WeatherApplication extends JFrame {

	private JPanel contentPane;
	private JTextField searchOption;
	private JLabel applicationName;
	private JTextField temperature;
	private JTextField day;
	private JTextField date;
	private JTextField city;
	private JTextField weatherType;
	private JLabel backgroundLabel;
	private JLabel minimizeButton;
	private JLabel exitButton;
	private JLabel weatherImage;
	private JLabel precipitationinfo;
	private JLabel humidityinfo;

	int x, y;
	private JTextField txtc;
	private JLabel winddirectionlabel;
	private WeatherApiDataController w = new WeatherApiDataController();
	private WeatherModelClass wm;
	private JTextField errormsg;
	private JLabel uvinfo;
	private JLabel visibilityinfo;
	private JLabel winddinfo;
	private JLabel winddegreeinfo;
	private JLabel cloudcoverinfo;
	private JLabel feelslikelabel;
	private JLabel feelinfo;
	private JLabel windInfo;
	private JLabel pressureinfo;
	private void defaultcity(String city) {

		try {
			errormsg.setText("");
			wm = w.weatherApiLogicView(city);
			// back ground
			if (wm.getCurrent().getIs_day().equals("yes")) {
				backgroundLabel.setIcon(ImageResizer.resize(
						new ImageIcon(
								WeatherApplication.class.getResource("/com/weatherapplication/images/dayback.jpg")),
						514, 480));
			} else if (wm.getCurrent().getIs_day().equals("no")) {
				backgroundLabel.setIcon(ImageResizer.resize(
						new ImageIcon(
								WeatherApplication.class.getResource("/com/weatherapplication/images/nightback.jpg")),
						514, 480));
			}
			
			
			JodaTime jt = new JodaTime();
			date.setText(String.valueOf(jt.getDay()) + " " + jt.getMonth() + " " + String.valueOf(jt.getYear()));
			day.setText(jt.dayOfWeek());
			
			temperature.setText(String.valueOf(wm.getCurrent().getTemperature()));
			precipitationinfo.setText(String.valueOf(wm.getCurrent().getPrecip()) + "% ");
			humidityinfo.setText(String.valueOf(wm.getCurrent().getHumidity()) + "% ");
			windInfo.setText(String.valueOf(wm.getCurrent().getWind_speed()) + " km/h ");
			String wtype[] = wm.getCurrent().getWeather_descriptions();
			weatherType.setText(wtype[0]);
			WeatherApplication.this.city.setText(wm.getLocation().getName() + ", " + wm.getLocation().getRegion() + ", "
					+ wm.getLocation().getCountry());
			pressureinfo.setText(String.valueOf(wm.getCurrent().getPressure()) + " mb ");
			visibilityinfo.setText(String.valueOf(wm.getCurrent().getVisibility()) + " Km ");
			winddinfo.setText(wm.getRequest().getLanguage()+" ");
			cloudcoverinfo.setText(String.valueOf(wm.getCurrent().getCloudcover()) + " % ");
			winddinfo.setText(wm.getCurrent().getWind_dir()+" ");
			winddegreeinfo.setText(String.valueOf(wm.getCurrent().getWind_degree()) + "° ");
			uvinfo.setText(String.valueOf(wm.getCurrent().getUv_index())+" ");
			feelinfo.setText(String.valueOf(wm.getCurrent().getFeelslike()) + "°C ");

		
			
		
			// night images similer
			if (wtype[0].equalsIgnoreCase("Intermittent Clouds")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("no")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Intermittent Clouds night.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("no")) {

				weatherImage
						.setIcon(ImageResizer.resize(
								new ImageIcon(WeatherApplication.class
										.getResource("/com/weatherapplication/images/Mostly Cloudy night.png")),
								101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy with Flurries ")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("no")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Mostly Cloudy with Flurries night.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy with Showers")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("no")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Mostly Cloudy with Showers night.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy with Snow night")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("no")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Mostly Cloudy with Snow night.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy with Thunderstorm")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("no")) {

				weatherImage
						.setIcon(ImageResizer.resize(
								new ImageIcon(WeatherApplication.class.getResource(
										"/com/weatherapplication/images/Mostly Cloudy with Thunderstorm night.png")),
								101, 73));
			}

			// day images similer
			if (wtype[0].equalsIgnoreCase("Intermittent Clouds")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("yes")) {

				weatherImage
						.setIcon(ImageResizer.resize(
								new ImageIcon(WeatherApplication.class
										.getResource("/com/weatherapplication/images/Intermittent Clouds.png")),
								101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("yes")) {

				weatherImage
						.setIcon(
								ImageResizer.resize(
										new ImageIcon(WeatherApplication.class
												.getResource("/com/weatherapplication/images/Mostly Cloudy.png")),
										101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy with Flurries ")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("yes")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Mostly Cloudy with Flurries.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy with Showers")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("yes")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Mostly Cloudy with Showers.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy with Snow night")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("yes")) {

				weatherImage
						.setIcon(ImageResizer.resize(
								new ImageIcon(WeatherApplication.class
										.getResource("/com/weatherapplication/images/Mostly Cloudy with Snow.png")),
								101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Cloudy with Thunderstorm")
					&& (wm.getCurrent().getIs_day()).equalsIgnoreCase("yes")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Mostly Cloudy with Thunderstorm.png")),
						101, 73));
			}

			// same image
			else if (wtype[0].equalsIgnoreCase("Clear")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Clear.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Cloudy")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(
								WeatherApplication.class.getResource("/com/weatherapplication/images/Cloudy.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Cold")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Cold.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Dreary") || wtype[0].equalsIgnoreCase("Overcast")) {

				weatherImage
						.setIcon(ImageResizer.resize(
								new ImageIcon(WeatherApplication.class
										.getResource("/com/weatherapplication/images/Dreary (Overcast).png")),
								101, 73));
			} else if (wtype[0].equalsIgnoreCase("Flurries")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(
								WeatherApplication.class.getResource("/com/weatherapplication/images/Flurries.png")),
						101, 73));
			}

			else if (wtype[0].equalsIgnoreCase("Fog") || wtype[0].equalsIgnoreCase("Shallow Fog")
					|| wtype[0].equalsIgnoreCase("mist") || wtype[0].equalsIgnoreCase("Smoke")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Fog.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Freezing Rain")) {

				weatherImage
						.setIcon(
								ImageResizer.resize(
										new ImageIcon(WeatherApplication.class
												.getResource("/com/weatherapplication/images/Freezing Rain.png")),
										101, 73));
			} else if (wtype[0].equalsIgnoreCase("Haze") && (wm.getCurrent().getIs_day()).equalsIgnoreCase("no")) {

				weatherImage
						.setIcon(
								ImageResizer.resize(
										new ImageIcon(WeatherApplication.class
												.getResource("/com/weatherapplication/images/hazy Moonlight.png")),
										101, 73));
			} else if (wtype[0].equalsIgnoreCase("Haze") && (wm.getCurrent().getIs_day()).equalsIgnoreCase("yes")) {

				weatherImage
						.setIcon(
								ImageResizer.resize(
										new ImageIcon(WeatherApplication.class
												.getResource("/com/weatherapplication/images/hazy Sunshine.png")),
										101, 73));
			} else if (wtype[0].equalsIgnoreCase("Hot")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Hot.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Ice")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Ice.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Clear")) {

				weatherImage
						.setIcon(
								ImageResizer.resize(
										new ImageIcon(WeatherApplication.class
												.getResource("/com/weatherapplication/images/Mostly Clear.png")),
										101, 73));
			} else if (wtype[0].equalsIgnoreCase("Mostly Sunny")) {

				weatherImage
						.setIcon(
								ImageResizer.resize(
										new ImageIcon(WeatherApplication.class
												.getResource("/com/weatherapplication/images/Mostly Sunny.png")),
										101, 73));
			} else if (wtype[0].equalsIgnoreCase("Partly Cloudy with Showers")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Partly Cloudy with Showers.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Partly Cloudy with Thunderstorm")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Partly Cloudy with T-Storms.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Partly Cloudy")) {

				weatherImage
						.setIcon(
								ImageResizer.resize(
										new ImageIcon(WeatherApplication.class
												.getResource("/com/weatherapplication/images/Partly Cloudy.png")),
										101, 73));
			} else if (wtype[0].equalsIgnoreCase("Partly Sunny with Flurries")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Partly Sunny with Flurries.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Partly Sunny with Showers")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Partly Sunny with Showers.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Partly Sunny with Thunderstorm")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class
								.getResource("/com/weatherapplication/images/Partly Sunny with T-Storms.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Partly Sunny")) {

				weatherImage
						.setIcon(
								ImageResizer.resize(
										new ImageIcon(WeatherApplication.class
												.getResource("/com/weatherapplication/images/Partly Sunny.png")),
										101, 73));
			} else if (wtype[0].equalsIgnoreCase("Rain and Snow")) {

				weatherImage
						.setIcon(
								ImageResizer.resize(
										new ImageIcon(WeatherApplication.class
												.getResource("/com/weatherapplication/images/Rain and Snow.png")),
										101, 73));
			} else if (wtype[0].equalsIgnoreCase("Rain") || wtype[0].equalsIgnoreCase("Moderate or heavy rain shower")
					|| wtype[0].equalsIgnoreCase("Moderate rain")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Rain.png")),
						101, 73));
			}

			else if (wtype[0].equalsIgnoreCase("Showers") || (wtype[0].equalsIgnoreCase("Light Rain"))
					|| (wtype[0].equalsIgnoreCase("Light rain shower"))
					|| wtype[0].equalsIgnoreCase("Light Rain, Mist")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(
								WeatherApplication.class.getResource("/com/weatherapplication/images/Showers.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Sleet") || wtype[0].equalsIgnoreCase("Blizzard")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Sleet.png")),
						101, 73));
			}

			else if (wtype[0].equalsIgnoreCase("Snow") || wtype[0].equalsIgnoreCase("Patchy heavy snow")
					|| wtype[0].equalsIgnoreCase("heavy snow")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Snow.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Sunny")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Sunny.png")),
						101, 73));
				
			} else if (wtype[0].equalsIgnoreCase("Thunderstorm") || wtype[0].equalsIgnoreCase("Thunderstorm, Rain With Thunderstorm")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(
								WeatherApplication.class.getResource("/com/weatherapplication/images/T-Storms.png")),
						101, 73));
			} else if (wtype[0].equalsIgnoreCase("Windy")) {

				weatherImage.setIcon(ImageResizer.resize(
						new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/Windy.png")),
						101, 73));
			}

		} catch (UnrecognizedPropertyException e) {
			errormsg.setText("Location Not Found");
		} catch (IOException e) {
			errormsg.setText("Server Not Found");
		}catch (Exception e) {
			errormsg.setText("Currently Server not Found. Try After Some Time " );
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherApplication frame = new WeatherApplication();
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
	public WeatherApplication() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 480);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(WeatherApplication.class.getResource("/com/weatherapplication/images/appicon.png")));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(0.2f, 0.2f, 0.2f, 0.3f));

		titleBar.setBounds(0, 0, 514, 26);
		contentPane.add(titleBar);
		titleBar.setLayout(null);

		applicationName = new JLabel("Weather Application");
		applicationName.setForeground(new Color(0, 139, 139));
		applicationName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		applicationName.setHorizontalAlignment(SwingConstants.CENTER);
		applicationName.setBounds(0, 0, 138, 25);
		titleBar.add(applicationName);

		minimizeButton = new JLabel("-");
		minimizeButton.setForeground(Color.WHITE);
		minimizeButton.setBackground(new Color(88, 101, 111));
		minimizeButton.setOpaque(true);
		minimizeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		minimizeButton.setFont(new Font("Segoe Print", Font.BOLD, 15));
		minimizeButton.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeButton.setBounds(442, 0, 30, 26);
		titleBar.add(minimizeButton);

		exitButton = new JLabel("X");
		exitButton.setForeground(Color.WHITE);
		exitButton.setOpaque(true);
		exitButton.setBackground(new Color(88, 101, 111));
		exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		exitButton.setFont(new Font("Segoe Print", Font.BOLD, 15));
		exitButton.setHorizontalAlignment(SwingConstants.CENTER);
		exitButton.setBounds(478, 0, 36, 26);
		titleBar.add(exitButton);

		searchOption = new RoundJTextField(30);
		searchOption.setFont(new Font("Times New Roman", Font.BOLD, 15));
		searchOption.setBackground(Color.DARK_GRAY);
		searchOption.setForeground(Color.white);
		searchOption.setBounds(20, 37, 427, 34);
		searchOption.setHorizontalAlignment(SwingConstants.CENTER);
		searchOption.setCaretColor(Color.white);

		contentPane.add(searchOption);
		searchOption.setColumns(10);

		JLabel searchIcon = new JLabel("");
		

		searchIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchIcon.setIcon(ImageResizer.resize(
				new ImageIcon(WeatherApplication.class.getResource("/com/weatherapplication/images/searchIcon.png")),
				29, 26));
		contentPane.add(searchIcon);
		searchIcon.setBounds(457, 40, 29, 26);
		contentPane.add(searchIcon);

		day = new JTextField();
		day.setHorizontalAlignment(SwingConstants.CENTER);
		day.setBorder(null);
		day.setOpaque(false);
		day.setForeground(Color.WHITE);
		day.setFont(new Font("Times New Roman", Font.BOLD, 25));
		day.setEditable(false);
		day.setBounds(10, 82, 494, 26);
		contentPane.add(day);
		day.setColumns(10);

		date = new JTextField();
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setBorder(null);
		date.setOpaque(false);
		date.setForeground(Color.WHITE);
		date.setFont(new Font("Times New Roman", Font.BOLD, 15));
		date.setEditable(false);
		date.setColumns(10);
		date.setBounds(10, 109, 494, 26);
		contentPane.add(date);

		city = new JTextField();
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setForeground(Color.WHITE);
		city.setBorder(null);
		city.setOpaque(false);
		city.setFont(new Font("Times New Roman", Font.BOLD, 12));
		city.setEditable(false);
		city.setColumns(10);
		city.setBounds(10, 135, 494, 26);
		contentPane.add(city);

		JPanel weatherInformation = new RoundedPanel();
		weatherInformation.setBackground(new Color(0.2f, 0.2f, 0.2f, 0.4f));
		weatherInformation.setForeground(Color.BLACK);
		weatherInformation.setBounds(45, 338, 422, 130);
		contentPane.add(weatherInformation);
		weatherInformation.setLayout(null);

		JLabel precipitationLabel = new JLabel("Precipitation");
		precipitationLabel.setForeground(Color.WHITE);
		precipitationLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		precipitationLabel.setBounds(33, 11, 105, 14);
		weatherInformation.add(precipitationLabel);

		JLabel humidityLabel = new JLabel("Humidity");
		humidityLabel.setForeground(Color.WHITE);
		humidityLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		humidityLabel.setBounds(33, 33, 105, 14);
		weatherInformation.add(humidityLabel);

		JLabel windLabel = new JLabel("Wind");
		windLabel.setForeground(Color.WHITE);
		windLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		windLabel.setBounds(33, 58, 66, 14);
		weatherInformation.add(windLabel);

		JLabel pressurelabel = new JLabel("Pressure");
		pressurelabel.setForeground(Color.WHITE);
		pressurelabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pressurelabel.setBounds(33, 83, 83, 14);
		weatherInformation.add(pressurelabel);

		JLabel visibiltylabel = new JLabel("Visibilty");
		visibiltylabel.setForeground(Color.WHITE);
		visibiltylabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		visibiltylabel.setBounds(230, 11, 134, 14);
		weatherInformation.add(visibiltylabel);

		JLabel uvIndexlabel = new JLabel("UV index");
		uvIndexlabel.setForeground(Color.WHITE);
		uvIndexlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		uvIndexlabel.setBounds(33, 108, 105, 14);
		weatherInformation.add(uvIndexlabel);

		JLabel cloudcoverlabel = new JLabel("Cloud Cover");
		cloudcoverlabel.setForeground(Color.WHITE);
		cloudcoverlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cloudcoverlabel.setBounds(230, 83, 134, 14);
		weatherInformation.add(cloudcoverlabel);

		JLabel winddegreelabel = new JLabel("Wind Degree");
		winddegreelabel.setForeground(Color.WHITE);
		winddegreelabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		winddegreelabel.setBounds(230, 61, 105, 18);
		weatherInformation.add(winddegreelabel);

		winddirectionlabel = new JLabel("Wind Direction");
		winddirectionlabel.setForeground(Color.WHITE);
		winddirectionlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		winddirectionlabel.setBounds(230, 36, 105, 14);
		weatherInformation.add(winddirectionlabel);
		
		precipitationinfo = new JLabel();
		precipitationinfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		precipitationinfo.setForeground(Color.WHITE);
		precipitationinfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		precipitationinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		precipitationinfo.setBounds(153, 11, 67, 14);
		weatherInformation.add(precipitationinfo);
		
		humidityinfo = new JLabel();
		humidityinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		humidityinfo.setForeground(Color.WHITE);
		humidityinfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		humidityinfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		humidityinfo.setBounds(153, 34, 67, 14);
		weatherInformation.add(humidityinfo);
		
		windInfo = new JLabel();
		windInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		windInfo.setForeground(Color.WHITE);
		windInfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		windInfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		windInfo.setBounds(153, 59, 67, 14);
		weatherInformation.add(windInfo);
		
		 pressureinfo = new JLabel();
		pressureinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		pressureinfo.setForeground(Color.WHITE);
		pressureinfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pressureinfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		pressureinfo.setBounds(153, 84, 67, 14);
		weatherInformation.add(pressureinfo);
		
		uvinfo = new JLabel();
		uvinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		uvinfo.setForeground(Color.WHITE);
		uvinfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		uvinfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		uvinfo.setBounds(153, 109, 67, 14);
		weatherInformation.add(uvinfo);
		
		visibilityinfo = new JLabel();
		visibilityinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		visibilityinfo.setForeground(Color.WHITE);
		visibilityinfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		visibilityinfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		visibilityinfo.setBounds(345, 11, 67, 14);
		weatherInformation.add(visibilityinfo);
		
		winddinfo = new JLabel();
		winddinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		winddinfo.setForeground(Color.WHITE);
		winddinfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		winddinfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		winddinfo.setBounds(345, 34, 67, 14);
		weatherInformation.add(winddinfo);
		
		winddegreeinfo = new JLabel();
		winddegreeinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		winddegreeinfo.setForeground(Color.WHITE);
		winddegreeinfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		winddegreeinfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		winddegreeinfo.setBounds(345, 59, 67, 14);
		weatherInformation.add(winddegreeinfo);
		
		cloudcoverinfo = new JLabel();
		cloudcoverinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		cloudcoverinfo.setForeground(Color.WHITE);
		cloudcoverinfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cloudcoverinfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		cloudcoverinfo.setBounds(345, 84, 67, 14);
		weatherInformation.add(cloudcoverinfo);
		
		feelslikelabel = new JLabel("Feelslike");
		feelslikelabel.setForeground(Color.WHITE);
		feelslikelabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		feelslikelabel.setBounds(230, 108, 105, 14);
		weatherInformation.add(feelslikelabel);
		
		feelinfo = new JLabel();
		feelinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		feelinfo.setForeground(Color.WHITE);
		feelinfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		feelinfo.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(95, 158, 160)));
		feelinfo.setBounds(345, 109, 67, 14);
		weatherInformation.add(feelinfo);

		weatherImage = new JLabel("");
		weatherImage.setBorder(null);
		weatherImage.setBounds(203, 176, 101, 73);
		contentPane.add(weatherImage);

		weatherType = new JTextField();
		weatherType.setBorder(null);
		weatherType.setOpaque(false);
		weatherType.setForeground(Color.WHITE);
		weatherType.setHorizontalAlignment(SwingConstants.CENTER);
		weatherType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		weatherType.setEditable(false);
		weatherType.setBounds(10, 301, 494, 26);
		contentPane.add(weatherType);
		weatherType.setColumns(10);

		temperature = new JTextField();
		temperature.setForeground(Color.WHITE);
		temperature.setHorizontalAlignment(SwingConstants.CENTER);
		temperature.setOpaque(false);
		temperature.setFont(new Font("Times New Roman", Font.BOLD, 60));
		temperature.setBounds(217, 238, 75, 73);
		contentPane.add(temperature);
		temperature.setEditable(false);
		temperature.setBorder(null);
		temperature.setColumns(10);

		txtc = new JTextField();
		txtc.setBorder(null);
		txtc.setOpaque(false);
		txtc.setEditable(false);
		txtc.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtc.setForeground(Color.WHITE);
		txtc.setText("\u00B0C");
		txtc.setBounds(281, 238, 75, 56);
		contentPane.add(txtc);
		txtc.setColumns(10);

		errormsg = new JTextField();
		errormsg.setForeground(Color.RED);
		errormsg.setOpaque(false);
		errormsg.setHorizontalAlignment(SwingConstants.CENTER);
		errormsg.setBorder(null);
		errormsg.setEditable(false);
		errormsg.setFont(new Font("Times New Roman", Font.BOLD, 12));
		errormsg.setBounds(10, 156, 494, 20);
		contentPane.add(errormsg);
		errormsg.setColumns(10);

		backgroundLabel = new JLabel("");

		backgroundLabel.setBounds(0, 0, 514, 480);
		contentPane.add(backgroundLabel);
		defaultcity("Delhi");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setBackground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setBackground(new Color(88, 101, 111));
			}
		});

		minimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				minimizeButton.setBackground(Color.darkGray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				minimizeButton.setBackground(new Color(88, 101, 111));

			}
		});

		titleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		titleBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx - x, yy - y);
			}
		});

		searchIcon.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				defaultcity(searchOption.getText());

			}
		});
		searchOption.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					defaultcity(searchOption.getText());
				}
			}
		});

	}
}
