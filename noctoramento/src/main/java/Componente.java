public class Componente {

    private Integer id;
    private String fabricante;
    private String modelo;
    private String sistemaOperacional;
    private String processador;
    private Double capacidadeMaxCpu;
    private Double maxDisco;
    private Double maxMemoriaRam;

    public Componente(Integer id, String fabricante, String modelo, String sistemaOperacional, String processador, Double capacidadeMaxCpu, Double maxDisco, Double maxMemoriaRam) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.sistemaOperacional = sistemaOperacional;
        this.processador = processador;
        this.capacidadeMaxCpu = capacidadeMaxCpu;
        this.maxDisco = maxDisco;
        this.maxMemoriaRam = maxMemoriaRam;
    }

    public void atualizarComponentes(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public Double getCapacidadeMaxCpu() {
        return capacidadeMaxCpu;
    }

    public void setCapacidadeMaxCpu(Double capacidadeMaxCpu) {
        this.capacidadeMaxCpu = capacidadeMaxCpu;
    }

    public Double getMaxDisco() {
        return maxDisco;
    }

    public void setMaxDisco(Double maxDisco) {
        this.maxDisco = maxDisco;
    }

    public Double getMaxMemoriaRam() {
        return maxMemoriaRam;
    }

    public void setMaxMemoriaRam(Double maxMemoriaRam) {
        this.maxMemoriaRam = maxMemoriaRam;
    }
}
