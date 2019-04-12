package modelo;

public class Grupo  implements java.io.Serializable {


     private String cveGru;
     private String nomGru;

    public Grupo() {
    }

    public Grupo(String cveGru, String nomGru) {
       this.cveGru = cveGru;
       this.nomGru = nomGru;
    }
   
    public String getCveGru() {
        return this.cveGru;
    }
    
    public void setCveGru(String cveGru) {
        this.cveGru = cveGru;
    }
    public String getNomGru() {
        return this.nomGru;
    }
    
    public void setNomGru(String nomGru) {
        this.nomGru = nomGru;
    }




}


