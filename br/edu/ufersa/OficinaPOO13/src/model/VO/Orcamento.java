package model.VO;

import java.util.Date;
//import java.util.List;
//import java.util.ArrayList;


public class Orcamento {

  private int idOrcamento;
  private Cliente clienteOrcamento;
  private Automovel automovelOrcamento;
  private Pecas pecasOrcamento;
  private Servico servicoOrcamento;
  private double totalOrcamento;
  private Date dataOrcamento;

  public Orcamento(){}
  public Orcamento(Cliente clienteOrcamento, Automovel automovelOrcamento, Pecas pecasOrcamento, Servico servicoOrcamento){
      
      setClienteOrcamento(clienteOrcamento);
      setAutomovelOrcamento(automovelOrcamento);
      setPecasOrcamento(pecasOrcamento);
      setServicoOrcamento(servicoOrcamento);;
      setDataOrcamento(dataOrcamento);
  }
  


public void setTotalOrcamento(Servico s, Pecas p) {
    if (s != null && p != null) {
      this.totalOrcamento = s.getServicoPreco() + p.getPrecoItem();
    } 
}

public double getTotalOrcamento() {return this.totalOrcamento;}

public void setPecasOrcamento (Pecas p) {
  if (p != null) {
    this.pecasOrcamento = p;
  }
}

public Pecas getPecasOrcamento() {
    return pecasOrcamento;
}

public void setDataOrcamento(Date data) {
  this.dataOrcamento = data;
}

public Date getDataOrcamento() {
    return dataOrcamento;    
}

public int getIdOrcamento() {return idOrcamento;}

/*==>GET/SET clienteOrcamento<==*/
  public Cliente getClienteOrcamento(){
    return clienteOrcamento;
  }
  public void setClienteOrcamento(Cliente clienteOrcamento){
    this.clienteOrcamento = clienteOrcamento;
  }
/*<========================>*/

/*==>GET/SET automovelCliente<==*/
  public Automovel getAutomovelOrcamento(){
    return automovelOrcamento;
  }
  public void setAutomovelOrcamento(Automovel automovelOrcamento){
    this.automovelOrcamento = automovelOrcamento;
    System.out.println("Automovel atribuido.");
  }


/*==>GET/SET<==*/
  public Servico getServicoOrcamento(){
    return servicoOrcamento;
  }
  public void setServicoOrcamento(Servico servicoOrcamento){
    this.servicoOrcamento = servicoOrcamento;
  }


  public void addPeca(Pecas peca) {

  }
/*  public List<Pecas> getPecasOrcamento(){
    return pecasOrcamento;
  }
  public void setPecasOrcamento(List<Pecas> pecasOrcamento){
    this.pecasOrcamento = pecasOrcamento;
    System.out.println("Pecas atribuidos.");
  }
*/

/*public void addPecas(Pecas peca) {
    if (peca != null) {
      this.pecasOrcamento.add(peca);
    }
}

public void addServicos(Servico serv) {
    if (serv != null) {
      this.servicoOrcamento.add(serv);
    }
}*/

}