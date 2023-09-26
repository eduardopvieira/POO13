package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.VO.Funcionario;
import model.VO.Gerente;
import view.HelloFx;
import model.BO.GerenteBO;
import Exceptions.*;

public class FrontController {

    @FXML private Label erroLogin;
    @FXML private Button botaoLogin;
    @FXML private TextField campoUserCPF;
    @FXML private TextField campoUserSenha;
    @FXML private Label loginFalhou;

    @FXML
    public void fazerLogin(ActionEvent event) throws LoginFailedException{
        String cpfText = campoUserCPF.getText();
        String passwordText = campoUserSenha.getText();

            Gerente vo = new Gerente();
            vo.setCPF(cpfText);
            vo.setSenha(passwordText);
            Funcionario vo2 = new Funcionario();
            vo2.setCPF(cpfText);
            vo2.setSenha(passwordText);

            // CUIDADO ---- AO USAR ENTITY AGORA ESTAMOS VALIDANDO 
            // (SetCPF) - Não existe CPF com menos de 11 caracteres
            // (SetSenha) - Senha maior que 3 caracteres

            try {
                GerenteBO gerbo = new GerenteBO();
                Gerente autenticado = gerbo.autenticar(vo);

                if (autenticado != null) {
                    HelloFx.telaPrincipalGerente();
                } 
            } catch (AutenticationException e) { //verificar Funcionário
                try {
                    FuncionarioBo funBo = new FuncionarioBo();
                    Funcionario autenticado2 = funBo.autenticar(vo2);
                    if (autenticado2 != null) {
                        HelloFx.telaClientes();
                    } else throw new AutenticationException("Autenticaçao falhou");
                } catch (AutenticationException e2) {
                    loginFalhou.setVisible(true);
                }
            } else {
            loginFalhou.setVisible(true);
            new LoginFailedException("Login falhou.");
        } 
    }