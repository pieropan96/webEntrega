/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import model.Atualizacao;
import model.Cidade;
import model.Cliente;
import model.Motorista;
import model.Pedido;
import model.Tipo;
import model.dao.impl.atualizacaoDao;
import model.dao.impl.cidadeDao;
import model.dao.impl.motoristaDao;
import model.dao.impl.pedidoDao;
import model.dao.impl.tipoDao;

/**
 *
 * @author PIEROPAN
 */
@ManagedBean(name = "pedido")
@SessionScoped
public class pedidoBean {

    private String preco, prazo, tipo, rua, bairro, numero, cep, mensagem;
    private Pedido pedido;
    private List<Pedido> pedidos;
    private List<Pedido> pedidos2;
    private List<Cidade> cidade;
    private Cidade cid;
    private Tipo t;
    private List<Tipo> tipos;
    private int idTipo, idCidade;
    private List<Motorista> motoristas;
    private double preco2;
    private Motorista motoristaLogado;
    private Boolean condicao = false;
    private String nome, status;
    private List<Atualizacao> listadetualizacoes;
    private Atualizacao atualizacaoes;
    private String local, data, hora;

    public pedidoBean() {
        cidade = new cidadeDao().findAll();
        tipos = new tipoDao().findAll();
        motoristas = new motoristaDao().findAll();
        pedidos2 = pedidos;
    }

    public String calcular() {

        cid = new cidadeDao().findOne(idCidade);
        t = new tipoDao().findOne(idTipo);
        double valor = cid.getPreco() + t.getPreco();
        cid.setPreco(valor);
        mensagem = "O valor é " + cid.getPreco() + " e o prazo " + cid.getPrazo();
        return mensagem;
    }

    public String entrega() {
        Pedido p = new Pedido(Integer.BYTES, rua, bairro, numero, cep);
        p.setIdCliente((Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("clienteLogado"));
        Cidade c = new Cidade();
        c.setIdCidade(idCidade);
        p.setIdCidade(c);
        Tipo t = new Tipo();
        t.setIdTipo(idTipo);
        p.setIdTipo(t);
        pedido = new pedidoDao().save(p);
        return "listapedido";
    }

    public List<Pedido> listarPedidos() {
        Pedido ped = new Pedido();
        ped.setIdCliente((Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("clienteLogado"));
        int id = ped.getIdCliente().getIdCliente();
        listadetualizacoes = new atualizacaoDao().findstatusAll(id);
        pedidos = new pedidoDao().findAllCliente(id);
        return pedidos;
    }

    public String pegar(Pedido p) {
        p.setIdMotorista((Motorista) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("motoristaLogado"));
        int id = p.getIdMotorista().getIdMotorista();
        p.getIdMotorista().setIdMotorista(id);
        new pedidoDao().edit(p);
        return "listapedidos";
    }

    public List<Pedido> Minhasentregas() {
        Pedido p = new Pedido();
        p.setIdMotorista((Motorista) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("motoristaLogado"));
        int id = p.getIdMotorista().getIdMotorista();
        pedidos = new pedidoDao().findAllMotorista(id);
        return pedidos;
    }

    public String lancarAtualizacao(Pedido p) {
        condicao = true;
        Atualizacao atu = new Atualizacao();
        atu.setStatus(status);
        Integer idEntrega = p.getIdEntrega();
        atu.setIdEntrega(p);
        atu.setLocal(local);
        atu.setData(data);
        atu.setHora(hora);
        if (status.equals("Entregue")) {
            pedidos.remove(p);
            pedidos2 = pedidos;
        }

        atualizacaoes = new atualizacaoDao().save(atu);
        status = "";
        local = "";
        data = "";
        hora = "";
        return "listapedido";
    }

    public void verAtualizacao(Pedido p) {
        condicao = true;
        Integer idEntrega = p.getIdEntrega();
        listadetualizacoes = new atualizacaoDao().findstatusAll(idEntrega);
    }

    public List<Pedido> listarPedidosAdm() {
        pedidos = new pedidoDao().findAll();
        return pedidos;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(List<Cidade> cidade) {
        this.cidade = cidade;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public double getPreco2() {
        return preco2;
    }

    public void setPreco2(double preco2) {
        this.preco2 = preco2;
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    public Motorista getMotoristaLogado() {
        return motoristaLogado;
    }

    public void setMotoristaLogado(Motorista motoristaLogado) {
        this.motoristaLogado = motoristaLogado;
    }

    public Boolean getCondicao() {
        return condicao;
    }

    public void setCondicao(Boolean condicao) {
        this.condicao = condicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Atualizacao getAtualizacaoes() {
        return atualizacaoes;
    }

    public void setAtualizacaoes(Atualizacao atualizacaoes) {
        this.atualizacaoes = atualizacaoes;
    }

    public List<Atualizacao> getListadetualizacoes() {
        return listadetualizacoes;
    }

    public void setListadetualizacoes(List<Atualizacao> listadetualizacoes) {
        this.listadetualizacoes = listadetualizacoes;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Cidade getCid() {
        return cid;
    }

    public void setCid(Cidade cid) {
        this.cid = cid;
    }

    public List<Pedido> getPedidos2() {
        return pedidos2;
    }

    public void setPedidos2(List<Pedido> pedidos2) {
        this.pedidos2 = pedidos2;
    }

}
