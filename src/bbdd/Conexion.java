package bbdd;

import interfaz_Grafica.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Conexion {

	// driver JDBC
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	// dirección de la BBDD MySQL
	private static final String URL = "jdbc:mysql://localhost:3306/Caca_mapa";
	// usuario y contraseña de acceso a la BD
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";
	Principal ppal = new Principal();
public static int id; 
	
	
	
	public Connection conectar() {
		Connection conexion = null;

		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			System.out.println("Conexión OK");

		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return conexion;
	}

	public boolean RepetirNombre(String nombre, String email) throws SQLException {
		Connection conexion = conectar();

		// Consulta para buscar el nombre y el email en la tabla Usuario
		String consulta = "SELECT * FROM Usuario WHERE nombre = '" + nombre + "' OR email = '" + email + "'";
		Statement statement = conexion.createStatement();
		ResultSet resultSet = statement.executeQuery(consulta);

		// Verificar si se encontraron resultados en la consulta
		boolean existeUsuario = resultSet.next();

		// Cerrar los recursos
		resultSet.close();
		statement.close();
		cerrarConexion(conexion);

		return existeUsuario;
	}

	public void addUsuario(String nombre, String contrasena, String email) throws SQLException {

		if (RepetirNombre(nombre, email)) {
			// El nombre o el email ya existen, mostrar mensaje de error
			JOptionPane.showMessageDialog(null, "El nombre o el email ya existen, por favor elija otro",
					"Registro fallido", JOptionPane.ERROR_MESSAGE);
		} else {
			// El nombre y el email no existen, realizar el registro en la base de datos
			Connection conexion = conectar();
			PreparedStatement statement = conexion.prepareStatement(
					"INSERT INTO Usuario (nombre, email, contrasena) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, nombre);
			statement.setString(2, email);
			statement.setString(3, contrasena);
			
			statement.executeUpdate();
			
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
				id=generatedKeys.getInt(1);   
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				statement.close();
				cerrarConexion(conexion);
				JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Registro exitoso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		
	}

	public boolean ComprobarAcceso(String nombre, String email, String contrasena) throws SQLException {
		Connection conexion = conectar();

		// Consulta para buscar el nombre y el email en la tabla Usuario
		String consulta = "SELECT * FROM Usuario WHERE nombre = '" + nombre + "' AND email = '" + email
				+ "' AND contrasena = '" + contrasena + "'";
		Statement statement = conexion.createStatement();
		ResultSet resultSet = statement.executeQuery(consulta);
		boolean existeUsuario=false;
		if (resultSet.next()) {
			id=resultSet.getInt(1);   
			existeUsuario=true;
			}else {
				id=-1;
			}
		System.out.println(id);
		// Verificar si se encontraron resultados en la consulta
		

		// Cerrar los recursos
		resultSet.close();
		statement.close();
		cerrarConexion(conexion);

		return existeUsuario;
	}

	public void pasarUsuario(String nombre, String contrasena, String email) throws SQLException {
		if (ComprobarAcceso(nombre, email, contrasena)) {
			JOptionPane.showMessageDialog(null, "Acceso correcto", "Correcto", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Acceso incorrecto, verifica tus datos", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void insertEtiquetaPaisCiu(String pais, String ciudad, String etiqueta) throws SQLException {

		Connection conexion = conectar();
		Statement statement = conexion.createStatement();
		String sql = "INSERT INTO Localizacion (pais, ciudad, etiqueta, id_usuario) VALUES ('" + pais  + "', '" + ciudad + "', '" +etiqueta + "', '" + id + "')";

		statement.executeUpdate(sql);
		statement.close();
		cerrarConexion(conexion);
	}

	
	public void insertFechaHora(String fecha, String hora) throws SQLException {
		Connection conexion = conectar();
		Statement statement = conexion.createStatement();
		String sql = "INSERT INTO tiempo (fecha, hora, id_usuario) VALUES ('" + fecha + "', '" + hora + "', '" + id + "')";
		statement.executeUpdate(sql);
		statement.close();
		cerrarConexion(conexion);
	}

	public void insertDescriptPunt(String descripcion, String puntuacion) throws SQLException {
		Connection conexion = conectar();
		Statement statement = conexion.createStatement();
		String sql = "INSERT INTO Puntuacion (descripcion, puntuacion, id_usuario) VALUES ('" +descripcion + "', '" + puntuacion + "', '" + id + "')";
		statement.executeUpdate(sql);
		statement.close();
		cerrarConexion(conexion);
	}

	
	public ArrayList<String[]> MostrarEtiquetaPaisCiu() throws SQLException{
		
		Connection conexion = conectar();
		Statement statement = conexion.createStatement();
		ArrayList<String[]> etiqueta1 =new ArrayList<>();
	
	
		String consulta = "SELECT pais, ciudad, etiqueta FROM Localizacion WHERE id_usuario = '" + id + "'";
		ResultSet resultSet = statement.executeQuery(consulta);
		
		while(resultSet!=null) {
			String[] temporal= new String[3];
			temporal[0]=resultSet.getString("pais");
			temporal[1]=resultSet.getString("ciudad");
			temporal[2]=resultSet.getString("etiqueta");
			etiqueta1.add(temporal);
		}
		statement.close();
		cerrarConexion(conexion);
		return etiqueta1;
	}
	
	public ArrayList<String[]> MostrarFechaHora() throws SQLException{
		Connection conexion = conectar();
		Statement statement = conexion.createStatement();
		ArrayList<String[]> fecha= new ArrayList<>();
		String consulta = "SELECT fecha, hora FROM tiempo WHERE id_usuario = '" + id + "'";
		ResultSet resultSet = statement.executeQuery(consulta);
		
		while(resultSet!=null) {
			String[] temp= new String[2];
			temp[0]=resultSet.getString("fecha");
			temp[1]= resultSet.getString("hora");
			fecha.add(temp);
		}
		statement.close();
		cerrarConexion(conexion);
		return fecha;
	}
	
	
	public ArrayList<String[]> MostrarDescriptPunt() throws SQLException{
		
		Connection conexion = conectar();
		Statement statement = conexion.createStatement();
		ArrayList<String[]> descript= new ArrayList<>();
		String consulta = "SELECT descripcion, puntuacion FROM Puntuacion WHERE id_usuario = '" + id + "'";
		ResultSet resultSet = statement.executeQuery(consulta);
		
		while(resultSet!=null) {
			String[] tem= new String[2];
			tem[0]=resultSet.getString("descripcion");
			tem[1]= resultSet.getString("puntuacion");
			descript.add(tem);
		}
		statement.close();
		cerrarConexion(conexion);
		return descript;
	}
	
	
	
	
	
	
	
	public void cerrarConexion(Connection conection) {
		try {
			// Cierre de la conexión
			conection.close();
		} catch (SQLException e) {
			System.err.println("Se ha producido un error al cerrar la conexión");

		}
	}

}
