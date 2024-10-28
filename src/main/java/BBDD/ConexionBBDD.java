package BBDD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase para gestionar la conexión a la base de datos MariaDB.
 * Es responsable de establecer, mantener y cerrar la conexión
 * con la base de datos, y de cargar las configuraciones necesarias
 * desde un archivo de propiedades.
 */
public class ConexionBBDD {

    /** Conexión activa a la base de datos. */
    private static Connection connection;

    /**
     * Constructor que establece la conexión con la base de datos.
     * Carga las propiedades de usuario y contraseña desde el archivo
     * de configuración `bbdd.properties` y establece la conexión
     * a la base de datos MariaDB usando los parámetros especificados.
     *
     * @throws SQLException si ocurre un error al establecer la conexión
     *                      (por ejemplo, si la base de datos no está disponible
     *                      o las credenciales son incorrectas).
     */
    public ConexionBBDD() throws SQLException {
        Properties connConfig = loadProperties();
        String url=connConfig.getProperty("dburl");
        connection = DriverManager.getConnection(url, connConfig);
        connection.setAutoCommit(true);
    }

    /**
     * Devuelve la conexión activa a la base de datos.
     *
     * @return La conexión activa a la base de datos.
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * Cierra la conexión activa con la base de datos.
     *
     * @return La conexión cerrada, útil en otros procesos si se requiere.
     * @throws SQLException si ocurre un error al cerrar la conexión,
     *                      por ejemplo, si la conexión ya está cerrada.
     */
    public Connection CloseConexion() throws SQLException {
        connection.close(); // Cierra la conexión
        return connection;
    }

    /**
     * Carga las propiedades de configuración desde el archivo `bbdd.properties`.
     * Este archivo debe contener la configuración de idioma u otras configuraciones
     * necesarias para la base de datos.
     *
     * @return Un objeto {@link Properties} con las configuraciones cargadas, o
     *         {@code null} si ocurre un error al leer el archivo.
     */
    public static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("configuration.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}