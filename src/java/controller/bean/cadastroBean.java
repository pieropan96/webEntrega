/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Cliente;
import model.dao.impl.clienteDao;

/**
 *
 * @author PIEROPAN
 */
@ManagedBean(name = "cadastro")
@RequestScoped
public class cadastroBean {
    private String nome,email,senha,rua,bairro,cep,numero;
    private Cliente cliente; 
    
    public String cadastrar(){
        Cliente c = new Cliente(Integer.SIZE, nome, email, senha, rua, bairro, numero, cep);
        cliente = new clienteDao().save(c);
        return "index";
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
           
}
