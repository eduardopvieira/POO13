package controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.CadastradoBO;
import model.VO.Cadastrado;
import view.Telas;

public class TodosCadastradosController {

    @FXML
    private Button botaoCadastroFunc;

    @FXML
    private Button botaoClientesOrcs;

    @FXML
    private Button botaoSair;

    
    @FXML private TableView<Cadastrado> tableviewClientes = new TableView<>();
    @FXML private TableColumn<Cadastrado, String> tableColumnCPF = new TableColumn<>("CPF");
    @FXML private TableColumn<Cadastrado, String> tableColumnNome = new TableColumn<>("Nome");
    @FXML private TableColumn<Cadastrado, String> tableColumnEndereco = new TableColumn<>("Endereço");
    @FXML private TableColumn<Cadastrado, String> tableColumnFuncao = new TableColumn<>("Função");

    @SuppressWarnings("unchecked")
	@FXML
    public void initialize() {
    	CadastradoBO caBO = new CadastradoBO();
    	
        tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tableColumnFuncao.setCellValueFactory(new PropertyValueFactory<>("funcao"));

        tableviewClientes.getColumns().addAll(tableColumnCPF, tableColumnNome, tableColumnEndereco, tableColumnFuncao);

        try {
            List<Cadastrado> listaCadastrados = caBO.listar();
            tableviewClientes.getItems().addAll(listaCadastrados);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    void irTelaCadastroFunc(ActionEvent event) {
    	
    }

    @FXML
    void irTelaClientesOrcs(ActionEvent event) {

    }

    @FXML
    void trocarParaTelaLogin(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }

}
