package Sistema_barbearia;

public class Feitos {
    Cliente Cliente;
    Servico servico;
public Feitos(Cliente cliente,Servico servico){ 
    this.Cliente=cliente;
    this.servico=servico;   
} 
public Feitos(){
}   
public Cliente getCliente() {
    return Cliente;
}
public void setCliente(Cliente cliente) {
    Cliente = cliente;
}
public Servico getServico() {
    return servico;
}
public void setServico(Servico servico) {
    this.servico = servico;
}
}