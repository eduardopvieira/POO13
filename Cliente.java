import java.util.Scanner;

public class Cliente{
  private static int codCliente;
  private String nomeCliente;
  private Endereco enderecoCliente;
  private String cpfCliente;
//  private Veiculo veiculoCliente;

/*==>Constrturores<==*/
  public Cliente(){}
  public Cliente(String nomeCad, Endereco enderecoCad, String cpfCad/*, Veiculo veiculoCad*/){
    this.codCliente++;
    setNome(nomeCad);
    setEndereco(enderecoCad);
    setCPF(cpfCad);
    /*setVeiculo(veiculoCad);*/
  }
/*<========================>*/

/*==>GET/SET (COD)<==
NÃO SE APLICA
<========================>*/

/*==>GET/SET (NOME)<==*/
  public String getNome(){
    return nomeCliente;
  }
  public void setNome(String nomeCad){
    if (nomeCad != null && nomeCad != ""){ /*Verifica se foi passado algo para o nomeCliente*/
      this.nomeCliente = nomeCad;
    } else {
      System.out.println("\nNome não pode estar vazio. Digite o nome novamente: ");
      Scanner scan = new Scanner(System.in);
      String nomeScan = scan.nextLine();
      if (nomeScan != null && nomeScan != ""){
        this.nomeCliente = nomeScan;
      }
    }
    System.out.println("Nome do cliente: "+ nomeCliente);
  }
/*<========================>*/

/*==>GET/SET (ENDEREÇO)<==*/
  public Endereco getEndereco(){
    return enderecoCliente;
  }
  public void setEndereco(Endereco enderecoCad){
    this.enderecoCliente = enderecoCad;
    System.out.println("Endereco atribuido.\n");
  }
/*<========================>*/

/*==>GET/SET (CPF)<==*/
  public String getCPF(){
    return cpfCliente;
  }
  public void setCPF(String cpfCad){
    if (cpfCad != null && cpfCad != ""){ /*Verifica se foi passado algo para o cpfCad*/
      this.cpfCliente = cpfCad;
    } else {
      System.out.println("\nCPF não pode estar vazio. Digite novamente o CPF: ");
      Scanner scan = new Scanner(System.in);
      String cpfScan = scan.nextLine();
      if (cpfScan != null || cpfScan != ""){
        this.cpfCliente = cpfScan;
      }
    }
    System.out.println("CPF do cliente: "+ cpfCliente);
  }
/*<========================>*/

/*==>GET/SET (VEICULO)<==
  public Veiculo getVeiculo(){
    return veiculoCliente;
  }
  public void setVeiculo(veiculoCad){
  this.veiculoCliente = veiculoCad;
}
<========================>*/

/*==>METODO PARA MOSTRAR CLIENTE<==*/
void mostraCliente (){
  System.out.println("\nNome: "+ nomeCliente+"\nCPF: "+ cpfCliente+"\nCod: "+codCliente+"\n");
}
/*<========================>*/

/*==>METODO ALTERAR CLIENTE<==*/
  public void alteraCliente(){
    System.out.println("Editando Cliente");
  }
/*<========================>*/

/*METODO EXCLUIR CLIENTE(ESQUECER)*/
  public void excluiCliente(){
    System.out.println("Confirma esquecimento do cliente? ");
  }
/*<========================>*/

/*==>TESTE DE CLIENTE<==*/
public static void main (String args[]){
  Endereco e = new Endereco("rua foda", "bairro foda", "cep foda", 2469);
  Cliente c1 = new Cliente("Marcos", e,"12365478911");
  c1.mostraCliente();
  Cliente c2 = new Cliente("", e , "");
  c2.mostraCliente();
}
/*<========================>*/
}
