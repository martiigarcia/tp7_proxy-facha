package punto1.modelo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClaseProxy implements Set<Telefono> {

    private final Set<Telefono> telefonos;
    private final int idPersona;
    private DaoInterface daoInterface;

    public ClaseProxy(int idPersona, DaoInterface daoInterface) {
        this.idPersona = idPersona;
        telefonos = new HashSet<>();
        this.daoInterface = daoInterface;
    }

    private Set<Telefono> obtenerTelefonos() {
        if (telefonos.isEmpty()) //puedo usar este metodo o tendria que haber una condicion distinta? tipo un int, un == null o algo asi?
            this.telefonos.addAll(daoInterface.telefonosPorPersona(idPersona));
        return telefonos;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return obtenerTelefonos().toArray(a);
    }

    @Override
    public int size() {
        return obtenerTelefonos().size();
    }

    @Override
    public boolean isEmpty() {
        return obtenerTelefonos().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return obtenerTelefonos().contains(o);
    }

    @Override
    public Iterator<Telefono> iterator() {
        return obtenerTelefonos().iterator();
    }

    @Override
    public Object[] toArray() {
        return obtenerTelefonos().toArray();
    }

    @Override
    public boolean add(Telefono telefono) {
        return obtenerTelefonos().add(telefono);
    }

    @Override
    public boolean remove(Object o) {
        return obtenerTelefonos().remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return obtenerTelefonos().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Telefono> c) {
        return obtenerTelefonos().addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return obtenerTelefonos().retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return obtenerTelefonos().retainAll(c);
    }

    @Override
    public void clear() {
        obtenerTelefonos().clear();
    }

}