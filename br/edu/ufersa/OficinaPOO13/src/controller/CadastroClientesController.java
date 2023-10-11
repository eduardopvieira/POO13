package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import model.VO.Automovel;
import model.VO.Cliente;

public class CadastroClientesController {
	@FXML
    private Button botaoAddVeiculo;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;
    
    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TableColumn<Automovel, Integer> tableColumnAnoAuto;

    @FXML
    private TableColumn<Automovel, String> tableColumnCorAuto;

    @FXML
    private TableColumn<Automovel, Button> tableColumnDeletarAuto;

    @FXML
    private TableColumn<Automovel, Button> tableColumnEditarAuto;

    @FXML
    private TableColumn<Automovel, Integer> tableColumnKMAuto;

    @FXML
    private TableColumn<Automovel, String> tableColumnMarcaAuto;

    @FXML
    private TableColumn<Automovel, String> tableColumnModeloAuto;

    @FXML
    private TableColumn<Automovel, String> tableColumnPlacaAuto;

    @FXML
    void abrirTelaCadastroVeiculo(ActionEvent event) {

    }

    @FXML
    public void cadastrarCliente(ActionEvent event) throws Exception {
    	
    }	

    @FXML
    void cancelarCadastro(ActionEvent event) {

    }
}
