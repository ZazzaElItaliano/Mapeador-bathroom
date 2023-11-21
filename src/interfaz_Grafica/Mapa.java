package interfaz_Grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JInternalFrame;

public class Mapa extends JPanel {
	private JTextField textField;
	 private Point initialClick;
	 private Point initialLocation;
	Mapear_caca mapacaca= new Mapear_caca();
	public Mapa() {
		
		setLayout(new BorderLayout());
		
		  ImageIcon imageIcon = new ImageIcon("src/Imagenes/Mapa.png");
		  JPanel imagePanel = new JPanel(null);
		  imagePanel.setForeground(new Color(0, 0, 0));
	        
	        JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
	        internalFrame.setBounds(286, 137, 587, 370);
	        
	        imagePanel.add(internalFrame);
	        internalFrame.getContentPane().setLayout(null);
	        
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(0, 0, 571, 340);
	        internalFrame.getContentPane().add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Aqui mostrar la información del usuario");
	        lblNewLabel.setBounds(67, 30, 428, 269);
	        panel.add(lblNewLabel);
	        internalFrame.setVisible(true);
	        
	        JButton btnNewButton_2 = new JButton("Amigos\r\n");
	        btnNewButton_2.setBounds(584, 44, 89, 23);
	        imagePanel.add(btnNewButton_2);
	        
	        JButton btnNewButton_1 = new JButton("TU\r\n");
	        btnNewButton_1.setBounds(457, 44, 89, 23);
	        imagePanel.add(btnNewButton_1);
	        
	        JButton btn3 = new JButton("\t Establecer  Localizacion");
	        btn3.setForeground(new Color(0, 0, 0));
	        btn3.setFont(new Font("Arial", Font.BOLD, 13));
	        btn3.setBounds(457, 549, 216, 62);
	        btn3.setBorder(new LineBorder(new Color(255, 255, 0), 3, true));
	        btn3.setBackground(new Color(255, 140, 0));
	        imagePanel.add(btn3);
	        
	        btn3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Reemplaza el contenido de imagePanel con el nuevo panel
	               removeAll();
	                add(mapacaca);
	               revalidate();
	                repaint();
	            }
	        });
	        
	        
	      
	        
	        
	        JLabel label = new JLabel(imageIcon);
	        label.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
	        imagePanel.add(label);
	        add(imagePanel, BorderLayout.CENTER);
	        
	      
	        
	        JSeparator separator = new JSeparator();
	        separator.setBounds(504, 91, 1, 2);
	        imagePanel.add(separator);

	        
	        
	        
	        
	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	          
	            	
	            	
	            	
	            	if(!internalFrame.isVisible()) {
	            		internalFrame.setVisible(true);
	            	}else {
	            		internalFrame.setVisible(false);
	            	}
	               
	            }
	        });
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        label.addMouseListener(new MouseAdapter() {
	        	@Override
	            public void mouseEntered(MouseEvent e) {
	        		 label.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(3000, -7, java.awt.Image.SCALE_SMOOTH)));
	        		 label.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        	}
	        	@Override
	            public void mouseExited(MouseEvent e) {
	                // Restablecer la imagen al salir el ratón de ella
	                label.setIcon(imageIcon);
	                label.setCursor(Cursor.getDefaultCursor());
	            }
	        	
	        	
	        	
	        	 @Override
	        	    public void mousePressed(MouseEvent e) {
	        	        initialClick = e.getPoint();
	        	        initialLocation = label.getLocation();
	        	    }

	        	 
	        });
	        
	        label.addMouseMotionListener(new MouseMotionAdapter() {
	            @Override
	            public void mouseDragged(MouseEvent e) {
	                // Actualizar la posición de la imagen según la diferencia entre la posición actual del mouse y la ubicación inicial de la imagen
	                int newX = initialLocation.x + (e.getX() - initialClick.x);
	                int newY = initialLocation.y + (e.getY() - initialClick.y);
	                label.setLocation(newX, newY);
	            }
	        });

	        
	        
	}
}