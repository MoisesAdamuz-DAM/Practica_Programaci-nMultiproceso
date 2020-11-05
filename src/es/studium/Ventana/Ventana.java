package es.studium.Ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

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
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(21, 53, 232, 170);
		contentPane.add(txtArea);
		
		JButton btnCMD = new JButton("Ejecutar");
		btnCMD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					
					String cmd = txtCMD.getText();
					Process process = Runtime.getRuntime().exec(cmd);
				    InputStreamReader entrada = new InputStreamReader(process.getInputStream());
				    BufferedReader stdInput = new BufferedReader(entrada);
				    String salida = null;
				    if((salida=stdInput.readLine()) != null){
		            	System.out.println("Comando ejecutado Correctamente");
		            	while ((salida=stdInput.readLine()) != null){
		                	txtArea.setText(salida);;
		                }
		            }else{
		            	System.out.println("No se a producido ninguna salida");
		            }
					
					
				    } 
				catch (IOException ioe) {
					System.out.println (ioe);
				}
			}
			
		});
		btnCMD.setBounds(164, 21, 89, 23);
		contentPane.add(btnCMD);
		
	
		
		
		JTextArea txtProcesos = new JTextArea();
		txtProcesos.setBounds(263, 178, 169, 102);
		txtProcesos.setEditable(false);//solo lectura, evitamos que puedan modificar el textArea
		contentPane.add(txtProcesos);
		
		///////////////BOTON Bloc de Notas//////////////////////////
		
		JButton btnBlocNotas = new JButton("Bloc de Notas");
		btnBlocNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					//https://stackoverrun.com/es/q/791304
					Process process = Runtime.getRuntime().exec("notepad.exe");
					
					
				if(process.isAlive())
				{
				
					txtProcesos.setText("Bloc de Notas"+"\n");
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
				
					txtProcesos.setText("Paint"+"\n");
					System.out.println("El Bloc de Notas está abierto");

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
		
		JButton btnNewButton_3 = new JButton("Gesti\u00F3n");
		btnNewButton_3.setBounds(372, 88, 116, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Juego");
		btnNewButton_4.setBounds(372, 122, 116, 23);
		contentPane.add(btnNewButton_4);
	
		
		
		JButton btnNewButton_5 = new JButton("Terminar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_5.setBounds(437, 179, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Procesos Activos");
		lblNewLabel.setBounds(289, 153, 109, 14);
		contentPane.add(lblNewLabel);
	}
}
