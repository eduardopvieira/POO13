package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.VO.Funcionario;
import model.VO.Gerente;
import model.VO.UsuarioAutenticado;
import view.Telas;

public class MenuOrcamentoController {

    @FXML
    private ImageView botaoBuscarEntreDatas;

    @FXML
    private ImageView botaoBuscarOrcamento;
	
    @FXML
    private Button botaoCadastrarOrcamento;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoGerarRelatorio;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    @FXML
    private TextField buscarOrcamento;
    
    @FXML
    private TableColumn<?, ?> tableColumnCliente;

    @FXML
    private TableColumn<?, ?> tableColumnDataOrc;

    @FXML
    private TableColumn<?, ?> tableColumnIdOrc;

    @FXML
    private TableColumn<?, ?> tableColumnIsPago;

    @FXML
    private TableColumn<?, ?> tableColumnPecaOrc;

    @FXML
    private TableColumn<?, ?> tableColumnPlacaOrc;

    @FXML
    private TableColumn<?, ?> tableColumnPrecoOrc;

    @FXML
    private TableColumn<?, ?> tableColumnServicoOrc;

    @FXML
    private TextField textfieldDataFinal;

    @FXML
    private TextField textfieldDataInicial;

    @FXML
    void buscarEntreDatas(MouseEvent event) {

    }

    @FXML
    void buscarOrcamento(MouseEvent event) {

    }
    
    @FXML
    void irTelaCadastroOrc(ActionEvent event)throws Exception{

    }

    @FXML
    void irTelaGerarRelatorio(ActionEvent event) throws Exception{

    }

    @FXML
    void irTelaLogin(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }

    @FXML
    void irTelaMenuClientes(ActionEvent event)throws Exception {
    	Telas.telaMenuClientes();
    }

    @FXML
    void irTelaMenuPecas(ActionEvent event)throws Exception {
    	Telas.telaMenuPecas();
    }

    @FXML
    void irTelaMenuServicos(ActionEvent event) throws Exception{
    	Gerente ger = UsuarioAutenticado.getGerenteAutenticado();
    	if (ger != null) {
    		Telas.telaMenuServicoGerente(ger);
    	} else {
    		Funcionario func = UsuarioAutenticado.getFuncAutenticado();
    		Telas.telaMenuServicoFuncionario(func);
    	}
    }

}
