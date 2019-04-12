
package controlador;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.List;
import modelo.Alumno;
import modelo.Grupo;

/**
 *
 * @author AxelJovanny
 */
public class GrupoControl {

    final static String RUTADB4O = System.getProperty("user.home") + "/EscuelaGrupo.db4o";
    ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), RUTADB4O);

    public void agregarGrupo(Grupo grupo) {
        db.store(grupo);
        db.commit();
        db.close();
    }

    public void modificarGrupo(Grupo grupo) {
        db.delete(grupo);
        db.commit();
        
        db.store(grupo);
        db.commit();
        db.close();
    }

    public void eliminarGrupo(String grupo) {
         List<Alumno> result;

        result = db.query(new Predicate<Alumno>() {
            @Override
            public boolean match(Alumno et) {
                return et.getCveGru().equals(grupo);
            }
        });

        for (Alumno a : result) {
            db.delete(a);
        }

        db.query(new Predicate<Grupo>() {
            @Override
            public boolean match(Grupo et) {
                if (et.getCveGru().equals(grupo)) {
                    db.delete(et);
                }
                return et.getCveGru().equals(grupo);
            }
        });
        db.commit();
        db.close();
    }

    public List<Grupo> verGrupo() {
        List<Grupo> grupos;
        grupos = db.query(new Predicate<Grupo>() {
            @Override
            public boolean match(Grupo et) {
                return true;
            }
        });
 
        return grupos;
    }
     public Boolean buscarGrupo(String grupo) {
        Boolean a = TRUE;
        ObjectSet<Grupo> result = db.query(new Predicate<Grupo>() {
            @Override
            public boolean match(Grupo et) {
                return et.getCveGru().equals(grupo);
            }
        });
        if(result.isEmpty()){
        a = FALSE;
        }
        return a;
   
    }
    
    public void cerrarDB(){
        db.close();
    }

 
}
