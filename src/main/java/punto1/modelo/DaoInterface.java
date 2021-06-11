package punto1.modelo;

import java.util.Set;

public interface DaoInterface {

    //recupera una persona segun su id
    Persona personaPorId(int id);

    //recupera los telefonos de una persona segun el id de la misma
    Set<Telefono> telefonosPorPersona(int idPersona);
}
