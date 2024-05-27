public class Parametros {

    private Integer id;
    private Integer tempoSegCapturaDeDados;
    private Integer tempoSegAlertas;
    private Double urgenteUsoCpu;
    private Double urgenteUsoDisco;
    private Double urgenteUsoMemoriaRam;
    private Double alertaUsoCpu;
    private Double alertaUsoDisco;
    private Double alertaUsoMemoriaRam;

    public Parametros(Integer id, Integer tempoSegCapturaDeDados, Integer tempoSegAlertas, Double urgenteUsoCpu, Double urgenteUsoDisco, Double urgenteUsoMemoriaRam, Double alertaUsoCpu, Double alertaUsoDisco, Double alertaUsoMemoriaRam) {
        this.id = id;
        this.tempoSegCapturaDeDados = tempoSegCapturaDeDados;
        this.tempoSegAlertas = tempoSegAlertas;
        this.urgenteUsoCpu = urgenteUsoCpu;
        this.urgenteUsoDisco = urgenteUsoDisco;
        this.urgenteUsoMemoriaRam = urgenteUsoMemoriaRam;
        this.alertaUsoCpu = alertaUsoCpu;
        this.alertaUsoDisco = alertaUsoDisco;
        this.alertaUsoMemoriaRam = alertaUsoMemoriaRam;
    }

    public void verificarDados(){

    }

    public void alertar(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempoSegCapturaDeDados() {
        return tempoSegCapturaDeDados;
    }

    public void setTempoSegCapturaDeDados(Integer tempoSegCapturaDeDados) {
        this.tempoSegCapturaDeDados = tempoSegCapturaDeDados;
    }

    public Integer getTempoSegAlertas() {
        return tempoSegAlertas;
    }

    public void setTempoSegAlertas(Integer tempoSegAlertas) {
        this.tempoSegAlertas = tempoSegAlertas;
    }

    public Double getUrgenteUsoCpu() {
        return urgenteUsoCpu;
    }

    public void setUrgenteUsoCpu(Double urgenteUsoCpu) {
        this.urgenteUsoCpu = urgenteUsoCpu;
    }

    public Double getUrgenteUsoDisco() {
        return urgenteUsoDisco;
    }

    public void setUrgenteUsoDisco(Double urgenteUsoDisco) {
        this.urgenteUsoDisco = urgenteUsoDisco;
    }

    public Double getUrgenteUsoMemoriaRam() {
        return urgenteUsoMemoriaRam;
    }

    public void setUrgenteUsoMemoriaRam(Double urgenteUsoMemoriaRam) {
        this.urgenteUsoMemoriaRam = urgenteUsoMemoriaRam;
    }

    public Double getAlertaUsoCpu() {
        return alertaUsoCpu;
    }

    public void setAlertaUsoCpu(Double alertaUsoCpu) {
        this.alertaUsoCpu = alertaUsoCpu;
    }

    public Double getAlertaUsoDisco() {
        return alertaUsoDisco;
    }

    public void setAlertaUsoDisco(Double alertaUsoDisco) {
        this.alertaUsoDisco = alertaUsoDisco;
    }

    public Double getAlertaUsoMemoriaRam() {
        return alertaUsoMemoriaRam;
    }

    public void setAlertaUsoMemoriaRam(Double alertaUsoMemoriaRam) {
        this.alertaUsoMemoriaRam = alertaUsoMemoriaRam;
    }
}
