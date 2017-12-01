/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Motorista.findAll", query = "SELECT m FROM Motorista m")
    , @NamedQuery(name = "Motorista.findByIdMotorista", query = "SELECT m FROM Motorista m WHERE m.idMotorista = :idMotorista")
    , @NamedQuery(name = "Motorista.findByNome", query = "SELECT m FROM Motorista m WHERE m.nome = :nome")
    , @NamedQuery(name = "Motorista.findByEmail", query = "SELECT m FROM Motorista m WHERE m.email = :email")
    , @NamedQuery(name = "Motorista.findBySenha", query = "SELECT m FROM Motorista m WHERE m.senha = :senha")})
public class Motorista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motorista", nullable = false)
    private Integer idMotorista;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String email;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String senha;
    @OneToMany(mappedBy = "idMotorista")
    private List<Pedido> pedidoList;

    public Motorista() {
    }

    public Motorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public Motorista(Integer idMotorista, String nome, String email, String senha) {
        this.idMotorista = idMotorista;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
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

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotorista != null ? idMotorista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motorista)) {
            return false;
        }
        Motorista other = (Motorista) object;
        if ((this.idMotorista == null && other.idMotorista != null) || (this.idMotorista != null && !this.idMotorista.equals(other.idMotorista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Motorista[ idMotorista=" + idMotorista + " ]";
    }
    
}
