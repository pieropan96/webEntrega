/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Cidade;
import model.dao.impl.cidadeDao;

/**
 *
 * @author PIEROPAN
 */
@ManagedBean(name = "cidade")
@ViewScoped
public class cidade {

    private String nome,prazo;
    private double preco;
    private List<Cidade> cidades;

    /**
     * Creates a new instance of cidade
     */
    public cidade() {
        cidades = new cidadeDao().findAll();
    }

    public String cadastrar() {
        Cidade c = new Cidade(Integer.SIZE, nome, preco, prazo);
        new cidadeDao().save(c);
        return "cidade";
    }
    public String apagar(Cidade c)
    {
        new cidadeDao().remover(c);
        return "cidade";
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

}
