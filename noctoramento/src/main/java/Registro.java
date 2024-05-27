import java.util.Date;

public class Registro {

    private Integer id;
    private Double usoCpu;
    private Double usoDisco;
    private Double tempoAtividadeDisco;
    private Double usoMemoria;
    private Integer qtdJanelasEmUso;
    private Date dtHoraCaptura;

    public Registro(Integer id, Double usoCpu, Double usoDisco, Double tempoAtividadeDisco, Double usoMemoria, Integer qtdJanelasEmUso, Date dtHoraCaptura) {
        this.id = id;
        this.usoCpu = usoCpu;
        this.usoDisco = usoDisco;
        this.tempoAtividadeDisco = tempoAtividadeDisco;
        this.usoMemoria = usoMemoria;
        this.qtdJanelasEmUso = qtdJanelasEmUso;
        this.dtHoraCaptura = dtHoraCaptura;
    }

    public void capturarDados(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Double usoCpu) {
        this.usoCpu = usoCpu;
    }

    public Double getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(Double usoDisco) {
        this.usoDisco = usoDisco;
    }

    public Double getTempoAtividadeDisco() {
        return tempoAtividadeDisco;
    }

    public void setTempoAtividadeDisco(Double tempoAtividadeDisco) {
        this.tempoAtividadeDisco = tempoAtividadeDisco;
    }

    public Double getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Double usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public Integer getQtdJanelasEmUso() {
        return qtdJanelasEmUso;
    }

    public void setQtdJanelasEmUso(Integer qtdJanelasEmUso) {
        this.qtdJanelasEmUso = qtdJanelasEmUso;
    }

    public Date getDtHoraCaptura() {
        return dtHoraCaptura;
    }

    public void setDtHoraCaptura(Date dtHoraCaptura) {
        this.dtHoraCaptura = dtHoraCaptura;
    }
}
