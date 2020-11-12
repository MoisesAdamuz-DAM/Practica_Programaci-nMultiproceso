package es.studium.Ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.TextArea;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame  {
	
	//En estas variables guardaré el Nombre del proceso y el PID del proceso
	String pidJuego = "";
	String pidGestion = "";

	private JPanel contentPane;
	private JTextField txtCMD;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setTitle("Pr\u00E1ctica PSP Tema 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCMD = new JTextField();
		txtCMD.setBounds(21, 22, 124, 20);
		contentPane.add(txtCMD);
		txtCMD.setColumns(10);
		
		/**********************************************************************/
		///////////////////////////////////Text Area///////////////////////////
		/*********************************************************************/
		JTextArea textArea = new JTextArea();
		//textArea.setBounds(21, 53, 211, 184);
		//Añadimos el Scroll al textArea1
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(21, 53, 230, 184);
		//Con setEditable, evitamos que se puedan realizar modificaciones en el textArea, es de solo lectura
		textArea.setEditable(false);
		contentPane.add(sp);
		
		
		
		/*********************************************************************************************/
		///////////////////////Boton Ejecutar/////////////////////////////////////////////////////////
		/*********************************************************************************************/
		JButton btnCMD = new JButton("Ejecutar");
		btnCMD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					//Obtenemos lo que hemos escrito en el txtCMD para poder realizar la ejecución en el botón Ejecutar
					String cmd = txtCMD.getText();
					Process process = Runtime.getRuntime().exec("cmd /c " +cmd);
					//Obtenemos el resultado del cmd y lo guardamos para su lectura
				    InputStreamReader entrada = new InputStreamReader(process.getInputStream());
				    BufferedReader br = new BufferedReader(entrada);
				    String salida = null;
		            //System.out.println("Comando ejecutado Correctamente");
				        //Leemos el contenido obtenido al ejecutar el comando
		            	while ((salida=br.readLine()) != null){
		                	textArea.append(salida+"\n");
		                	//System.out.println(salida);
		                }
		           
				    } 
				catch (IOException ioe) {
					System.out.println (ioe);
				}
			}
			
		});
		btnCMD.setBounds(164, 21, 89, 23);
		contentPane.add(btnCMD);
		
		/***********************************************************/
		/////////////////////Tabla//////////////////////////////////
		/***********************************************************/
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		table.setBounds(289, 178, 124, 78);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		contentPane.add(table);
	
		
		/***********************************************************/
		///////////////BOTON Bloc de Notas//////////////////////////
		/***********************************************************/
		
		JButton btnBlocNotas = new JButton("Bloc de Notas");
		btnBlocNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					//https://stackoverrun.com/es/q/791304
					Process process = Runtime.getRuntime().exec("notepad.exe");
					//Añadimos contenido a la fila
					modelo.addRow(new Object[] {"Bloc de Notas"});
					//System.out.println("Bloc de notas"+"//"+process.pid());
					//Bloqueamos el botón
					btnBlocNotas.setEnabled(false);
					//System.out.println("El Bloc de Notas está abierto");
										
				}
				catch (IOException ex)
				{
					System.out.println("Error");
				}
			}
		});
		btnBlocNotas.setBounds(372, 21, 116, 23);
		contentPane.add(btnBlocNotas);
		
		/**********************************************************/
		/////////////////BOTON Paint///////////////////////////////
		/*********************************************************/
		
		JButton btnPaint = new JButton("Paint");
		btnPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					//https://stackoverrun.com/es/q/791304
					Process process = Runtime.getRuntime().exec("mspaint.exe");
					modelo.addRow(new Object[] {"Paint"});
					//System.out.println("Paint"+"//"+process.pid());
					btnPaint.setEnabled(false);
					//System.out.println("Paint está abierto");	
										
				}
				catch (IOException ex)
				{
					System.out.println("Error");
				}
			}
		});
		btnPaint.setBounds(372, 54, 116, 23);
		contentPane.add(btnPaint);
		
		/******************************************************************/
		///////////////////////////Boton Gestion///////////////////////////
		/******************************************************************/
		
		JButton btnGestion = new JButton("Gesti\u00F3n");
		btnGestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try
				{
					// Ruta y argumentos para lanzar aplicación hija
					String arg1 = "java";/*Estos parámetros son para ejecutar, es como si lo hiciera por cmd*/
					String arg2 = "-jar";
					String arg3 = "C:\\Users\\moise\\Desktop\\crud.jar";
					//Creeamos una tabla de cadenas
					String[] param = { arg1, arg2, arg3 };
					//https://stackoverrun.com/es/q/791304
					Process process = Runtime.getRuntime().exec(param);
					modelo.addRow(new Object[] {"Gestión"});	
					//System.out.println("Gestión"+"//"+process.pid());
					btnGestion.setEnabled(false);
					//System.out.println("El Programa de Gestión está abierto");	
					pidGestion = "Gestión"+"//"+process.pid();
				}
				catch (IOException ex)
				{
					System.out.println("Error");
					ex.fillInStackTrace();
				}
			}
		});
		btnGestion.setBounds(372, 88, 116, 23);
		contentPane.add(btnGestion);
		
		/***************************************************************/
		//////////////////////////////Boton Juego///////////////////////
		/***************************************************************/
		JButton btnJuego = new JButton("Juego");
		btnJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					// Ruta y argumentos para lanzar aplicación hija
					String arg1 = "java";/*Estos parámetros son para ejecutar, es como si lo hiciera por cmd*/
					String arg2 = "-jar";
					String arg3 = "C:\\Users\\moise\\Desktop\\videojuego.jar";
					//Creeamos una tabla de cadenas
					String[] param = { arg1, arg2, arg3 };
					//https://stackoverrun.com/es/q/791304
					Process process = Runtime.getRuntime().exec(param);
					modelo.addRow(new Object[] {"Juego"});
					//System.out.println("Juego"+"//"+process.pid());
					pidJuego = "Juego"+"//"+process.pid();
					//System.out.println(pidJuego);
					btnJuego.setEnabled(false);
					//System.out.println("El Juego está abierto");	
										
				}
				catch (IOException ex)
				{
					System.out.println("Error");
					ex.fillInStackTrace();
				}
			}
		});
		btnJuego.setBounds(372, 122, 116, 23);
		contentPane.add(btnJuego);
	
		
		
		JLabel lblNewLabel = new JLabel("Procesos Activos");
		lblNewLabel.setBounds(289, 153, 109, 14);
		contentPane.add(lblNewLabel);
	
		/***************************************************************/
		/////////////////////////////Boton Terminar//////////////////////
	   /****************************************************************/
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				//En la variable entera guardo la posición de la fila seleccionada
				int index = table.getSelectedRow();
				//El valor de la fila lo convieto en un String || Indicamos que el valor de la columna es 0
				String nombrePrg = table.getValueAt(index, 0).toString();
				if (nombrePrg=="Bloc de Notas") {
					
					try {
						//Ejecuto el cierre de la ventana
						Process cerrarBN = Runtime.getRuntime().exec("cmd /c taskkill /f /im notepad.exe");
						Thread.sleep(100);
						btnBlocNotas.setEnabled(true);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (nombrePrg=="Paint") {
					
					try {
						Process cerrarP = Runtime.getRuntime().exec("cmd /c taskkill /f /im mspaint.exe");
						Thread.sleep(100);
						btnPaint.setEnabled(true);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (nombrePrg=="Gestión") {
					try {
						//Ejecuto el cierre de la ventana, especificando el PID
						Process cerrarG = Runtime.getRuntime().exec("cmd /c taskkill /f /pid "+ pidGestion.split("//")[1]);
						//System.out.println("cmd /c taskkill /f /pid "+ pidGestion.split("//")[1]);
						Thread.sleep(100);
						btnGestion.setEnabled(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (nombrePrg=="Juego") {
					
					try {
						
						Process cerrarJ = Runtime.getRuntime().exec("cmd /c taskkill /f /pid "+ pidJuego.split("//")[1]);
						//System.out.println("cmd /c taskkill /f /pid "+ pidJuego.split("//")[1]);
						Thread.sleep(100);
						btnJuego.setEnabled(true);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				modelo.removeRow(index);
				
				
				
				
  			}
		});
		btnTerminar.setBounds(437, 179, 89, 23);
		contentPane.add(btnTerminar);
		
		
		
	
		
		
		
		
		
		
		
		
		
	
	
	}
}
