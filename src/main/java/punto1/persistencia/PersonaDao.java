package punto1.persistencia;

import punto1.modelo.ClaseProxy;
import punto1.modelo.DaoInterface;
import punto1.modelo.Persona;
import punto1.modelo.Telefono;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao implements DaoInterface {

    private Connection conexion() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tp_proxy", "root", "");
    }

    public Persona personaPorId(int id) {

        try (
                Connection conexion = this.conexion();
                PreparedStatement statement = conexion.prepareStatement("SELECT * FROM persona where id = ?");
        ) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Set<Telefono> telefonos = new ClaseProxy(id, this);
            String nombrePersona = null;

            while (result.next()) {
                nombrePersona = result.getString(2);
            }

            return new Persona(id, nombrePersona, telefonos);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Telefono> telefonosPorPersona(int idPersona) {

        try (
                Connection conexion = this.conexion();
                PreparedStatement statement = conexion.prepareStatement("SELECT * FROM telefono where id_persona = ?");
        ) {

            statement.setInt(1, idPersona);
            ResultSet result = statement.executeQuery();
            Set<Telefono> telefonos = new HashSet<Telefono>();

            while (result.next()) {

                telefonos.add(new Telefono(result.getString(2)));
            }


            return telefonos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
