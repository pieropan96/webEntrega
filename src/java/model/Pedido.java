/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PIEROPAN
 */
@Entity
@Table(catalog = "webentrega", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdEntrega", query = "SELECT p FROM Pedido p WHERE p.idEntrega = :idEntrega")
    , @NamedQuery(name = "Pedido.findByRua", query = "SELECT p FROM Pedido p WHERE p.rua = :rua")
    , @NamedQuery(name = "Pedido.findByBairro", query = "SELECT p FROM Pedido p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "Pedido.findByNumero", query = "SELECT p FROM Pedido p WHERE p.numero = :numero")
    , @NamedQuery(name = "Pedido.findByCep", query = "SELECT p FROM Pedido p WHERE p.cep = :cep")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrega", nullable = false)
    private Integer idEntrega;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String rua;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String bairro;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String numero;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String cep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntrega")
    private List<Atualizacao> atualizacaoList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo", nullable = false)
    @ManyToOne(optional = false)
    private Tipo idTipo;
    @JoinColumn(name = "id_motorista", referencedColumnName = "id_motorista")
    @ManyToOne
    private Motorista idMotorista;
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade", nullable = false)
    @ManyToOne(optional = false)
    private Cidade idCidade;

    public Pedido() {
    }

    public Pedido(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Pedido(Integer idEntrega, String rua, String bairro, String numero, String cep) {
        this.idEntrega = idEntrega;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
    }

    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
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

    @XmlTransient
    public List<Atualizacao> getAtualizacaoList() {
        return atualizacaoList;
    }

    public void setAtualizacaoList(List<Atualizacao> atualizacaoList) {
        this.atualizacaoList = atualizacaoList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    public Motorista getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(Motorista idMotorista) {
        this.idMotorista = idMotorista;
    }

    public Cidade getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Cidade idCidade) {
        this.idCidade = idCidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrega != null ? idEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idEntrega == null && other.idEntrega != null) || (this.idEntrega != null && !this.idEntrega.equals(other.idEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pedido[ idEntrega=" + idEntrega + " ]";
    }
    
}
