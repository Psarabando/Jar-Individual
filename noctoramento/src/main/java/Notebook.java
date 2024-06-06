import javax.xml.crypto.Data;
import java.util.List;

public class Notebook {

    private Integer id;
    private String numeroSerie;
    private String fabricante;
    private String modelo;
    private Data dtRegistro;
    private InfoNotebook infoNotebook;
    private List<Registro> registros;

    public Notebook(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Data getDtRegistro() {
        return dtRegistro;
    }

    public void setDtRegistro(Data dtRegistro) {
        this.dtRegistro = dtRegistro;
    }

    public InfoNotebook getInfoNotebook() {
        return infoNotebook;
    }

    public void setInfoNotebook(InfoNotebook infoNotebook) {
        this.infoNotebook = infoNotebook;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
