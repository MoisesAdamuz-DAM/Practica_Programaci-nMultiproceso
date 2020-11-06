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
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.TextArea;
import javax.swing.JList;
import java.awt.Color;

public class Ventana extends JFrame  {

	private JPanel contentPane;
	private JTextField txtCMD;

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
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(21, 53, 230, 184);
		textArea.setEditable(false);
		contentPane.add(sp);
		
		/*********************************************************************************************/
		///////////////////////Boton Ejecutar/////////////////////////////////////////////////////////
		/*********************************************************************************************/
		JButton btnCMD = new JButton("Ejecutar");
		btnCMD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					
					String cmd = txtCMD.getText();
					Process process = Runtime.getRuntime().exec("cmd /c " +cmd);
				    InputStreamReader entrada = new InputStreamReader(process.getInputStream());
				    BufferedReader br = new BufferedReader(entrada);
				    String salida = null;
				   
		            	System.out.println("Comando ejecutado Correctamente");
		            	while ((salida=br.readLine()) != null){
		                	textArea.append(salida+"\n");;
		                	br.readLine();
		                	System.out.println(salida);
		                }
		           
					
					
				    } 
				catch (IOException ioe) {
					System.out.println (ioe);
				}
			}
			
		});
		btnCMD.setBounds(164, 21, 89, 23);
		contentPane.add(btnCMD);
		
		/****************************************************************************/
		////////////////////////////////Lista////////////////////////////////////////
		/****************************************************************************/
		JList lista = new JList();
		lista.setBounds(289, 170, 138, 110);
		contentPane.add(lista);
		DefaultListModel modelo = new DefaultListModel();
		lista.setModel(modelo);
		//Seleccionamos el elemento de la lista
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
					
					
				if(process.isAlive())
				{
				
					modelo.addElement("Bloc de Notas"+"\n");
					btnBlocNotas.setEnabled(false);
					System.out.println("El Bloc de Notas está abierto");

				}
					
										
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
					
				if(process.isAlive())
				{
				
					modelo.addElement("Paint"+"\n");
					btnPaint.setEnabled(false);
					System.out.println("Paint está abierto");

				}
					
										
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
					
				if(process.isAlive())
				{
				
					modelo.addElement("Gestión"+"\n");
					btnGestion.setEnabled(false);
					System.out.println("El Programa de Gestión está abierto");

				}
					
										
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
					
				if(process.isAlive())
				{
				
					modelo.addElement("Juego"+"\n");
					btnJuego.setEnabled(false);
					System.out.println("El Juego está abierto");

				}
					
										
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
	
		/***************************************************************/
		/////////////////////////////Boton Terminar//////////////////////
		/****************************************************************/
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				
				eliminarNombre(lista.getSelectedIndex());
  			}

			private void eliminarNombre(int indice) {
				// TODO Auto-generated method stub
				if (indice>=0) {
					//getSelectedIndex() retorna la posición del elemento, contando el primero con un índice 0,
                   //este valor es enviado y se usa el método modelo.removeElementAt(indice), para eliminarlo
					  modelo.removeElementAt(indice); 
				}
					  }
				
			
				
			
		});

			
		btnTerminar.setBounds(437, 179, 89, 23);
		contentPane.add(btnTerminar);
		
		JLabel lblNewLabel = new JLabel("Procesos Activos");
		lblNewLabel.setBounds(289, 153, 109, 14);
		contentPane.add(lblNewLabel);
		
	
		
		
		
		
		
		
		
		
		
	
	
	}
}
