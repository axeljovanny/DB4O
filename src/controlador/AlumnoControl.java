
package controlador;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.List;
import modelo.Alumno;

/**
 *
 * @author AxelJovanny
 */
public class AlumnoControl {

    final static String RUTADB4O = System.getProperty("user.home") + "/EscuelaGrupo.db4o";
    ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), RUTADB4O);

    public void agregarAlumno(Alumno alumno) {
        db.store(alumno);
        db.commit();
        db.close();
    }

    public void modificarAlumno(Alumno alumno) {
        db.delete(alumno);
        db.commit();
        db.close();
        db.store(alumno);
        db.commit();
        db.close();
    }

    public void eliminarAlumno(String cveAlu) {
        db.query(new Predicate<Alumno>() {
            @Override
            public boolean match(Alumno et) {
                if (et.getCveAlu().equals(cveAlu)) {
                    db.delete(et);
                }
                return et.getCveAlu().equals(cveAlu);
            }
        });
        db.commit();
        db.close();
    }

    public List<Alumno> verAlumno() {
        List<Alumno> Alumnos;
        Alumnos = db.query(new Predicate<Alumno>() {
            @Override
            public boolean match(Alumno et) {
                return true;
            }
        });
        
        return Alumnos;
        
    }
    public Boolean buscarGrupo(String alumno) {
        Boolean a = TRUE;
        ObjectSet<Alumno> result = db.query(new Predicate<Alumno>() {
            @Override
            public boolean match(Alumno et) {
                return et.getCveAlu().equals(alumno);
            }
        });
        if(result.isEmpty()){
        a = FALSE;
        }
        return a;
   
    }
   public void cerrarBD(){
        db.close();
    }
}
