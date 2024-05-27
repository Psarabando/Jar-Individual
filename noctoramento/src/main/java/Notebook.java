import java.util.List;

public class Notebook {

    private Integer id;
    private String numeroSerie;
    private String marca;
    private Componente componentes;
    private List<Registro> registros;

    public Notebook(Integer id, String numeroSerie, String marca, Componente componentes, List<Registro> registros) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.componentes = componentes;
        this.registros = registros;
    }

    public void atualizarComponentes(){

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Componente getComponentes() {
        return componentes;
    }

    public void setComponentes(Componente componentes) {
        this.componentes = componentes;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
