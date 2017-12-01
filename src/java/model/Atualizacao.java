/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PIEROPAN
 */
@Entity
@Table(catalog = "webentrega", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atualizacao.findAll", query = "SELECT a FROM Atualizacao a")
    , @NamedQuery(name = "Atualizacao.findByIdAtualizacao", query = "SELECT a FROM Atualizacao a WHERE a.idAtualizacao = :idAtualizacao")
    , @NamedQuery(name = "Atualizacao.findByLocal", query = "SELECT a FROM Atualizacao a WHERE a.local = :local")
    , @NamedQuery(name = "Atualizacao.findByData", query = "SELECT a FROM Atualizacao a WHERE a.data = :data")
    , @NamedQuery(name = "Atualizacao.findByHora", query = "SELECT a FROM Atualizacao a WHERE a.hora = :hora")
    , @NamedQuery(name = "Atualizacao.findByStatus", query = "SELECT a FROM Atualizacao a WHERE a.status = :status")})
public class Atualizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_atualizacao", nullable = false)
    private Integer idAtualizacao;
    @Column(length = 45)
    private String local;
    @Column(length = 45)
    private String data;
    @Column(length = 45)
    private String hora;
    @Column(length = 45)
    private String status;
    @JoinColumn(name = "id_entrega", referencedColumnName = "id_entrega", nullable = false)
    @ManyToOne(optional = false)
    private Pedido idEntrega;

    public Atualizacao() {
    }

    public Atualizacao(Integer idAtualizacao) {
        this.idAtualizacao = idAtualizacao;
    }

    public Integer getIdAtualizacao() {
        return idAtualizacao;
    }

    public void setIdAtualizacao(Integer idAtualizacao) {
        this.idAtualizacao = idAtualizacao;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pedido getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Pedido idEntrega) {
        this.idEntrega = idEntrega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtualizacao != null ? idAtualizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atualizacao)) {
            return false;
        }
        Atualizacao other = (Atualizacao) object;
        if ((this.idAtualizacao == null && other.idAtualizacao != null) || (this.idAtualizacao != null && !this.idAtualizacao.equals(other.idAtualizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Atualizacao[ idAtualizacao=" + idAtualizacao + " ]";
    }
    
}
