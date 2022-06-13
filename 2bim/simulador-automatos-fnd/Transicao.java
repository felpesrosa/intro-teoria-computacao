public class Transicao {
    private String valor;
    private String origem;
    private String destino;

    public Transicao(String origem, String destino, String valor) {
        this.valor = valor;
        this.origem = origem;
        this.destino = destino;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Transicao [origem=" + origem + ", destino=" + destino + ", valor=" + valor + "]";
    }
    
    
}
