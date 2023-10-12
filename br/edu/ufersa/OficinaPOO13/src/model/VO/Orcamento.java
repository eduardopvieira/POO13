package model.VO;

import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
//import java.util.ArrayList;
import java.util.List;


public class Orcamento {

  private int idOrcamento;
  private Cliente clienteOrcamento;
  private Automovel automovelOrcamento;
  private List <Pecas> listaPecas;
  private List <Servico> listaServicos;
  private double totalOrcamento;
  private Date dataOrcamento;
  private boolean isPago; 

  public Orcamento(){}
  public Orcamento(Cliente clienteOrcamento, Automovel automovelOrcamento, Pecas pecasOrcamento, Servico servicoOrcamento){
      
      setClienteOrcamento(clienteOrcamento);
      setAutomovelOrcamento(automovelOrcamento);
      setDataOrcamento(dataOrcamento);
      listaPecas = new ArrayList<Pecas>();
      listaServicos = new ArrayList<Servico>();
      setIsPago(false);
  }
  

//=========================GET LISTA PEÇA E SERVICO============================
 public List<Pecas> getPecas() {
	 return listaPecas;
 }
 
 public List<Servico> getServicos() {
	 return listaServicos;
 }
//=========================ADD E REMOVE PEÇAS E SERVICOS==================================================
 public void addPecas(Pecas peca) {
	 listaPecas.add(peca);
 } 
 
 public void addServico (Servico servico) {
	 listaServicos.add(servico);
 }
 
 public void removePecas(Pecas peca) {
	 listaPecas.remove(peca);
 } 
 
 public void removeServico (Servico servico) {
	 listaServicos.remove(servico);
 }
//=========================== SET E GET TOTAL DO ORÇAMENTO ===========================
public void setTotalOrcamento(Servico s, Pecas p) {
    if (s != null && p != null) {
      this.totalOrcamento = s.getServicoPreco() + p.getPrecoItem();
    } 
}

public double getTotalOrcamento() {return this.totalOrcamento;}
//===========================SET E GET DATA ORCAMENTO=========================================================

public void setDataOrcamento(Date data) {
  this.dataOrcamento = data;
}

public Date getDataOrcamento() {
    return dataOrcamento;    
}
//=========================GET E SET CLIENTE NO ORÇAMENTO==========================================================

  public Cliente getClienteOrcamento(){
    return clienteOrcamento;
  }
  public void setClienteOrcamento(Cliente clienteOrcamento){
    this.clienteOrcamento = clienteOrcamento;
  }
//=========================GET E SET AUTOMOVEL NO ORÇAMENTO========================================
  public Automovel getAutomovelOrcamento(){
    return automovelOrcamento;
  }
  public void setAutomovelOrcamento(Automovel automovelOrcamento){
    this.automovelOrcamento = automovelOrcamento;
    System.out.println("Automovel atribuido.");
  }
//=========================GET E SET ID DO ORÇAMENTO=====================================
 
  public int getIdOrcamento() {return idOrcamento;}

  public void setIdOrcamento(int id) {
	  if (id >= 0) {
		  this.idOrcamento = id;
	  }
  }
 //========================GET E SET ISPAGO===========================================
  
  public boolean getIsPago() {return isPago;}
  
  public void setIsPago(boolean bool) {
	  this.isPago = bool;
  }
  
}