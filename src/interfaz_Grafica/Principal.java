package interfaz_Grafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.Conexion;


import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Principal extends JFrame {
	Mapear_caca mapear2=new Mapear_caca();
	Mapa mapa1=new Mapa();
	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Principal() {
		int ancho=1115, alto=660;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ancho,alto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setLocationRelativeTo(null);
		
		ImageIcon imagen=new ImageIcon("src/Imagenes/login.png");
		ImageIcon imagen1=new ImageIcon("src/Imagenes/radioboton.png");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("         Soy una caca mapeada");
		rdbtnNewRadioButton.setBounds(523, 374, 238, 29);
		rdbtnNewRadioButton.setIcon(imagen1);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton boton1 = new JButton("Acceder");
;
		boton1.setBounds(627, 429, 134, 23);
		contentPane.add(boton1);
		
		JButton btnNewButton = new JButton("Registrar usuario");
		btnNewButton.setBounds(421, 429, 145, 23);
		contentPane.add(btnNewButton);
		
			
		
		  
		btnNewButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            
	        	 String email=	textField .getText();
	 			String contrasena=passwordField.getText();
	 			String nombre=textField_1.getText();
	 			
	 			
	 			
	 			
	 			
	 				if(nombre.isEmpty() || email.isEmpty()  ||  contrasena.isEmpty()){
	 				boton1.setEnabled(true);	 
	 				
	 				 JOptionPane.showMessageDialog(null, "Verifica que has rellenado los tres campos");
	 				 } else if(	passwordField.getText().length()<=5){
	 						boton1.setEnabled(true);
	 					JOptionPane.showMessageDialog(null, "Contraseña demasiado corta. Por favor usa al menos 8 caracteres)");
	 				 
	 				 }else {
	 					
	 				saveUsuario();
	 					
	 				 }
	 				
	 				
	 				
	 		
	        	 
	         }
	      });
		
	
		
		
		lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(421, 335, 92, 14);
		contentPane.add(lblNewLabel_2);
		
	
		
		 
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(421, 246, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(421, 288, 65, 14);
		contentPane.add(lblNewLabel);
		JLabel label=new JLabel(imagen);
		 label.setBounds(1, 1, imagen.getIconWidth(), imagen.getIconHeight());
		    contentPane.add(label);
		    setResizable(true);	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(523, 285, 238, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(523, 243, 238, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(523, 332, 238, 20);
		contentPane.add(passwordField);
		
	
		
		
		
		
		

	getContentPane().add(mapa1);
	
	
	
	boton1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String email=	textField .getText();
 			String contrasena=passwordField.getText();
 			String nombre=textField_1.getText();
			
 			 if (email.isEmpty() || contrasena.isEmpty() || nombre.isEmpty()) {
 	            boton1.setEnabled(true);
 	            JOptionPane.showMessageDialog(null, "Verifica que has rellenado los tres campos");
 	        } else {
 	            Conexion usuario = new Conexion();
 	            boolean accesoCorrecto;
				try {
					accesoCorrecto = usuario.ComprobarAcceso(nombre, email, contrasena);
				
				
					if (accesoCorrecto) {
 	                if (rdbtnNewRadioButton.isSelected()) {
 	                    boton1.setEnabled(true);
 	                    setContentPane(mapa1);
 	                    revalidate();
 	                    repaint();
 	                } else {
 	                    JOptionPane.showMessageDialog(null, "Debes seleccionar que eres una caca mapeada para seguir");
 	                }
 	            } else {
 	                JOptionPane.showMessageDialog(null, "Acceso incorrecto, verifica tus datos", "Error", JOptionPane.ERROR_MESSAGE);
 	            }
				
			} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

 	          
 	        }
 	    }
 	});
	
	
	}
	
	
	private void saveUsuario() {
		String nombre=textField_1.getText();
		String email=	textField .getText();
		String contrasena=passwordField.getText();
		
		

		
			
		
		   try {
			      Conexion usuario = new Conexion();
			        usuario.addUsuario(nombre,contrasena,email);
			      
			   } catch (SQLException ex) {
				   ex.printStackTrace();
			      JOptionPane.showMessageDialog(this, "Error: ");
			}

		   }
		
	 
	private void checkUsuario() {
		
		String nombre=textField_1.getText();
		String email=	textField .getText();
		String contrasena=passwordField.getText();
		   try {
			      Conexion usuario = new Conexion();
			      usuario.pasarUsuario(nombre, contrasena, email);
			      
			   } catch (SQLException ex) {
				   ex.printStackTrace();
			      JOptionPane.showMessageDialog(this, "Error: ");
			}
	}

		
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	
		Conexion conexion = new Conexion();
		Connection cn = null;
		
		
		cn = conexion.conectar();
	
	}

	public JTextField retornar() {
		return textField;
	}
	
}
