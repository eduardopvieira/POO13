package model.entity;

import Exceptions.InfoNaoCompativelException;

public class Servico {

	private int idServico;
	private String servicoNome, servicoDescricao;
	private double servicoPreco;

  public Servico(){}

  public Servico(int idServico, String servicoNome, String servicoDescricao, double servicoPreco) throws InfoNaoCompativelException{
    setIdServico(idServico);
    setServicoNome(servicoNome);
    setServicoDescricao(servicoDescricao);
    setServicoPreco(servicoPreco);
    
  }

//get id:
public int getIdServico() {
  return idServico;
}

public void setIdServico(int l) {
  if(l > 0)
    this.idServico = l;
  else
    this.idServico = 0;
}

/*==>GET/SET (servicoNome)<==*/
  public String getServicoNome(){
    return servicoNome;
  }
  public void setServicoNome(String servicoNome) throws InfoNaoCompativelException{
    if (servicoNome != null && servicoNome != ""){ /*Verifica se foi passado algo para o servicoNome*/
      this.servicoNome = servicoNome;
    } else {
          throw new InfoNaoCompativelException("Nome de serviço invalido.");
      }
}

/*==>GET/SET (servicoDescricao)<==*/

  public String getServicoDescricao(){
    return servicoDescricao;
  }
  public void setServicoDescricao(String servicoDescricao) throws InfoNaoCompativelException {
    if (servicoDescricao != null && servicoDescricao != ""){ /*Verifica se foi passado algo para o servicoDescricao*/
      this.servicoDescricao = servicoDescricao;
    } else {
        throw new InfoNaoCompativelException("Descrição do serviço incompativel.");
      }
    }
/*<========================>*/

/*==>GET/SET (servico)<==*/
  public double getServicoPreco(){
    return servicoPreco;
  }

  public void setServicoPreco(double servicoPreco)throws InfoNaoCompativelException{
    if (servicoPreco >= 0){
      this.servicoPreco = servicoPreco;
    } else {
        throw new InfoNaoCompativelException("Preço do serviço incompativel.");
      }
    }
  }


