/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Administrador;
import model.Motorista;
import model.Tipo;
import model.dao.dao;

/**
 *
 * @author PIEROPAN
 */
public class motoristaDao extends dao<Motorista, Integer> {

    @Override
    public Motorista save(Motorista obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Motorista findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Motorista> findAll() {
        getConnection();
        try {
            Query q = getConnection().createNamedQuery("Motorista.findAll");
            return q.getResultList();
        } finally {
            close();
        }
    }
    public Motorista findLogin(String login, String senha) {
        Query q = getConnection().createQuery("select m from Motorista m WHERE m.email = :log and m.senha = :sen");
        q.setParameter("log", login);
        q.setParameter("sen", senha);
        try {
            return (Motorista) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
      public Motorista edit(Motorista obj) {
        try {
            getConnection().getTransaction().begin();
            getConnection().merge(obj);
            getConnection().getTransaction().commit();

        } catch (Exception e) {
            getConnection().getTransaction().rollback();
        }
        return obj;
    }

}
