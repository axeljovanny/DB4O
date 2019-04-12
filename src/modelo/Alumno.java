package modelo;
public class Alumno  implements java.io.Serializable {


     private String cveAlu;
     private String nomAlu;
     private byte edaAlu;
     private String cveGru;

    public Alumno() {
    }

    public Alumno(String cveAlu, String nomAlu, byte edaAlu, String cveGru) {
       this.cveAlu = cveAlu;
       this.nomAlu = nomAlu;
       this.edaAlu = edaAlu;
       this.cveGru = cveGru;
    }
   
    public String getCveAlu() {
        return this.cveAlu;
    }
    
    public void setCveAlu(String cveAlu) {
        this.cveAlu = cveAlu;
    }
    public String getNomAlu() {
        return this.nomAlu;
    }
    
    public void setNomAlu(String nomAlu) {
        this.nomAlu = nomAlu;
    }
    public byte getEdaAlu() {
        return this.edaAlu;
    }
    
    public void setEdaAlu(byte edaAlu) {
        this.edaAlu = edaAlu;
    }
    public String getCveGru() {
        return this.cveGru;
    }
    
    public void setCveGru(String cveGru) {
        this.cveGru = cveGru;
    }




}


