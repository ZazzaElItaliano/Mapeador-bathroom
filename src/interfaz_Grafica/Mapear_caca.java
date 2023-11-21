package interfaz_Grafica;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bbdd.Conexion;


import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mapear_caca extends JPanel {
	private JTextField textField_1;
	private JFormattedTextField dateField;
    private JSpinner hourSpinner;
    private JSpinner minuteSpinner;
    private JSpinner secondSpinner;
    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextArea textArea;
    private JComboBox comboBox;
    Mostrar_Consulta mostrar= new Mostrar_Consulta();
	public Mapear_caca() {
		
		String textoDefecto="Ej: casa, oficina,universidad...";
		String textoDefect1o="Escribe descripción.";
		setLayout(null);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Puntuación a la defecación");
		lblNewLabel_1.setBounds(117, 541, 156, 14);
		add(lblNewLabel_1);
		
		
		 comboBox = new JComboBox();
		comboBox.setBounds(315, 537, 223, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Selecciona una puntuación ","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setMaximumRowCount(10);
		comboBox.setBackground(new Color(70, 130, 180));
		comboBox.setSelectedIndex(0);
		add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Descripción (Max 60 caracteres)\r\n");
		lblNewLabel_2.setBounds(117, 476, 193, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("0 Caracteres");
		lblNewLabel_3.setBounds(453, 503, 85, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Etiqueta");
		lblNewLabel_4.setBounds(117, 410, 46, 14);
		add(lblNewLabel_4);
		
		textField_1 = new JTextField(textoDefecto);
		textField_1.setBounds(315, 407, 223, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Selecciona Sticker");
		lblNewLabel_5.setBounds(117, 350, 96, 14);
		add(lblNewLabel_5);
		
		textArea = new JTextArea();
		textArea.setBounds(315, 450, 223, 67);
		add(textArea);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(426, 313, 89, 67);
		btnNewButton_1.setIcon(new ImageIcon(Mapear_caca.class.getResource("/Imagenes/gordo.png")));
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(533, 313, 96, 67);
		btnNewButton_2.setIcon(new ImageIcon(Mapear_caca.class.getResource("/Imagenes/cacaangel.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(651, 313, 89, 67);
		btnNewButton_3.setIcon(new ImageIcon(Mapear_caca.class.getResource("/Imagenes/arcoiris.png")));
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(877, 313, 89, 67);
		btnNewButton_4.setIcon(new ImageIcon(Mapear_caca.class.getResource("/Imagenes/gafas.png")));
		add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(315, 313, 89, 67);
		btnNewButton.setIcon(new ImageIcon(Mapear_caca.class.getResource("/Imagenes/rollo.png")));
		add(btnNewButton);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBounds(766, 313, 89, 67);
		btnNewButton_5.setIcon(new ImageIcon(Mapear_caca.class.getResource("/Imagenes/loco.png")));
		add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("l");
		lblNewLabel.setBounds(0, 0, 1115, 289);
		lblNewLabel.setIcon(new ImageIcon(Mapear_caca.class.getResource("/Imagenes/mapaampliado.png")));
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(806, 404, 160, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(806, 452, 160, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(806, 493, 160, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(806, 538, 160, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("País\r\n");
		lblNewLabel_6.setBounds(640, 407, 46, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ciudad");
		lblNewLabel_7.setBounds(640, 455, 46, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\tHora \r\n(formato hh/mm)");
		lblNewLabel_8.setBounds(640, 541, 156, 14);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Fecha (formato yy-mm-dd)");
		lblNewLabel_9.setBounds(640, 496, 170, 14);
		add(lblNewLabel_9);
		
		JButton btnNewButton_6 = new JButton("Guardar registros ");
		btnNewButton_6.setBounds(510, 583, 199, 23);
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(989, 451, 89, 23);
		add(btnNewButton_7);
			 
	  
		
		btnNewButton_6 .addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	SaveEtiquePais();
		    	SaveFechaHora();
		    	SaveDescripPoint();
		    	JOptionPane.showMessageDialog(null, "Datos añadidos correctamente");
		    }
		});
		
		
		btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reemplaza el contenido de imagePanel con el nuevo panel
               removeAll();
                add(mostrar);
               revalidate();
                repaint();
            }
        });
        
		
		
		
     
		 textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLabel();
            }

            private void updateLabel() {
            	lblNewLabel_3.setText( textArea.getText().length() + " caracteres");
            	if( textArea.getText().length()>=60) {
            		JOptionPane.showMessageDialog(null, "Has excedido el número máximo de caracteres." + "\n" + "Las cacas no hablan tanto");
            	}
            	
            }
        });
		
		  textField_1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(textField_1.getText().equals(textoDefecto)) {
					textField_1.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().isEmpty()) {
					textField_1.setText(textoDefecto);
				}
				
			}
			  
		  });
		 
		 
	}


protected void setContentPane(Mostrar_Consulta mostrar2) {
		// TODO Auto-generated method stub
		
	}


private void SaveEtiquePais() {
	
	
	String pais=textField.getText();
	String ciudad=textField_2.getText();
	String etiqueta=textField_1 .getText();
	   System.out.println(pais);
	try {
		      Conexion etiqueta1 = new Conexion();
		    etiqueta1.insertEtiquetaPaisCiu(pais, ciudad, etiqueta);
		      
		   } catch (SQLException ex) {
		      JOptionPane.showMessageDialog(this, "Error: ");
		}

	   }
	
	private  void SaveFechaHora() {
		
		String fecha=textField_3.getText();
		String hora=	textField_4.getText();
		   
		try {
			      Conexion horita1 = new Conexion();
			      horita1.insertFechaHora(fecha, hora);
			    
			   } catch (SQLException ex) {
			      
			}
		
	}


      private void SaveDescripPoint() {
	
    	  String descripcion=	textArea.getText();
    	  String puntuacion=(String) comboBox.getSelectedItem();
    	  
    		try {
			      Conexion point = new Conexion();
			      point.insertDescriptPunt(descripcion, puntuacion);
			    
			   } catch (SQLException ex) {
			      
			}
    	  
    	  
}
}














