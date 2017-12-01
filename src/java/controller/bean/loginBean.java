/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Administrador;
import model.Cliente;
import model.Motorista;
import model.dao.impl.administradorDao;
import model.dao.impl.clienteDao;
import model.dao.impl.motoristaDao;

/**
 *
 * @author PIEROPAN
 */
@ManagedBean(name = "login")
@SessionScoped

public class loginBean {

    private String email,senhaM, senha,emailM,mensagem, mensagemM;
    private Cliente clienteLogado;
    private Administrador administradorLogado;
    private Motorista motoristaLogado;
    public String logar() {
        clienteLogado = new clienteDao().findLogin(email, senha);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clienteLogado", clienteLogado);
        if (clienteLogado != null) {
            return "home";
        } else {
            mensagem = "Email ou Senha incorreta!";
            return "";
        }
    }
    public String logarAdm(){
        administradorLogado = new administradorDao().findLogin(email, senha);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("administradorLogado", administradorLogado);
        if (administradorLogado != null) {
            return "home";
        } else {
            mensagem = "Email ou Senha incorreta!";
            return "";
        }
    }
      public String logarMotorista(){
        motoristaLogado = new motoristaDao().findLogin(emailM,senhaM);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("motoristaLogado", motoristaLogado);
        if (motoristaLogado != null) {
            return "home";
        } else {
            mensagemM = "Email ou Senha incorreta!";
            return "";
        }
    }
     public String logoff(){
        clienteLogado = null;
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sessao.invalidate();
        return "/index?faces-redirect-true";
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getCliente() {
        return clienteLogado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

    public Administrador getAdministradorLogado() {
        return administradorLogado;
    }

    public void setAdministradorLogado(Administrador administradorLogado) {
        this.administradorLogado = administradorLogado;
    }

    public Motorista getMotoristaLogado() {
        return motoristaLogado;
    }

    public void setMotoristaLogado(Motorista motoristaLogado) {
        this.motoristaLogado = motoristaLogado;
    }

    public String getSenhaM() {
        return senhaM;
    }

    public void setSenhaM(String senhaM) {
        this.senhaM = senhaM;
    }

    public String getEmailM() {
        return emailM;
    }

    public void setEmailM(String emailM) {
        this.emailM = emailM;
    }

    public String getMensagemM() {
        return mensagemM;
    }

    public void setMensagemM(String mensagemM) {
        this.mensagemM = mensagemM;
    }
    
    
}
