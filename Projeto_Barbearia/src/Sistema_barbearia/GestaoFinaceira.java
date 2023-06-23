package Sistema_barbearia;

import java.util.ArrayList;
public class GestaoFinaceira {
    private double totalComum=0;
    private double  totalMensal=0;
    private double totalEntrada=0;
    ArrayList<Feitos>servicosPrestados = new ArrayList<Feitos>();
    ArrayList<ClienteMensal>pagosPremium= new ArrayList<ClienteMensal>();
    public GestaoFinaceira(){
    }
public void AddServicosPrestados(Feitos feitos){
    servicosPrestados.add(feitos);
}
public void AddClienteMensal(ClienteMensal clientepagos){
    pagosPremium.add(clientepagos);
}
public double somaEntrada(){
    for(int i=0;i<servicosPrestados.size();i++){
        totalComum+=servicosPrestados.get(i).servico.getPreco();
    }
    for(int i=0;i<pagosPremium.size();i++){
        totalMensal+= pagosPremium.get(i).getValorAssinatura();
    }
    return totalEntrada+=totalComum+totalMensal;
}
public ArrayList<Feitos> getServicosPrestados() {
    return servicosPrestados;
}
public void setServicosPrestados(ArrayList<Feitos> servicosPrestados) {
    this.servicosPrestados = servicosPrestados;
}
}