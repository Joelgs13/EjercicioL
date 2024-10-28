package Model;

public class DireccionModel {
     String pais;
     String ciudad;
     String calle;
     int numero;

    public DireccionModel( String pais, String ciudad, String calle, int numero) {
        super();
        this.pais = pais;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
    }

    public String getPais() { return pais; }

    public String getCiudad() { return ciudad; }

    public String getCalle() { return calle; }

    public int getNumero() { return numero; }
}
