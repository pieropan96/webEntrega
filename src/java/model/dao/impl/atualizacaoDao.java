/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Atualizacao;
import model.dao.dao;

/**
 *
 * @author PIEROPAN
 */
public class atualizacaoDao extends dao<Atualizacao, Integer> {

    @Override
    public Atualizacao save(Atualizacao atu) {
        getConnection();
        try {
            getConnection().getTransaction().begin();
            getConnection().persist(atu);
            getConnection().getTransaction().commit();
        } finally {
            close();
        }
        return atu;
    }

    @Override
    public Atualizacao findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atualizacao> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Atualizacao> findstatusAll(Integer idcliente) {
        getConnection();
        try {
            Query q = getConnection().createQuery("SELECT a from Atualizacao a,Pedido p WHERE a.idEntrega.idEntrega = p.idEntrega AND P.idCliente.idCliente = :idcliente ");
            q.setParameter("idcliente", idcliente);
            return q.getResultList();
        } finally {
            close();
        }
    }

}
