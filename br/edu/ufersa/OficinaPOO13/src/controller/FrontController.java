package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.VO.Funcionario;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FrontController {

    @FXML
    private Button botaoLogin;

    @FXML
    private TextField campoUserCPF;

    @FXML
    private TextField campoUserSenha;

    @FXML
    private Label erroAut;
    
    @FXML
    private TextField botaoBuscar;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private ImageView botaoDeletar;

    @FXML
    private ImageView botaoEditar;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    @FXML
    private Label estoquePeca;

    @FXML
    private Label fabricantePeca;

    @FXML
    private Label headerNomeFunc;

    @FXML
    private Label nomePeca;

    @FXML
    private Rectangle nomeServiço;

    @FXML
    private Label precoPeca;
    
    
    @FXML
    public void autenticar(ActionEvent event) throws Exception{
		Funcionario funcVO = new Funcionario();
		funcVO.setCPF(campoUserCPF.getText());
		funcVO.setSenha(campoUserSenha.getText());
		System.out.println("O CPF do funcionario é " + funcVO.getCPF() + " e a senha é " + funcVO.getSenha());
    }
    
    

}
