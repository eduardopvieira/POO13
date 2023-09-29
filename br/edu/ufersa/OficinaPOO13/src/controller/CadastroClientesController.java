package controller;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.VO.Cliente;
import model.VO.Automovel;

public class CadastroClientesController {
	@FXML
    private Button addVeiculo;

    @FXML
    private TextField anoAuto;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField corAuto;

    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField kmAuto;

    @FXML
    private TextField marcaAuto;

    @FXML
    private TextField modeloAuto;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField placaAuto;

    @FXML
    void cadastrarCliente(ActionEvent event) throws Exception {
    	Cliente c = new Cliente();
    	Automovel a = new Automovel();
    	
    	c.setNome(nomeCliente.getText());
    	c.setCPF(cpfCliente.getText());
    	c.setEndereco(enderecoCliente.getText());
    	
    	a.setModelo(modeloAuto.getText());
    	a.setAno(Integer.parseInt(anoAuto.getText()));
    	a.setMarca(marcaAuto.getText());
    	a.setDono(c);
    	a.setKm(Integer.parseInt(kmAuto.getText()));
    	a.setPlaca(placaAuto.getText());
    	a.setCor(corAuto.getText());
  
    	System.out.println("Cliente: CPF:" + c.getCPF() + " NOME: " + c.getNome() + " ENDERECO: " + c.getEndereco());
    	System.out.println("Auto: MODELO: " + a.getModelo() + " ANO: " + a.getAno() + "MARCA: " + a.getMarca() + " KM: " + a.getKm() + " PLACA: " + a.getPlaca() + " cor:" + a.getCor());
    }	
}
