/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Administrador;
import model.dao.dao;

/**
 *
 * @author PIEROPAN
 */
public class administradorDao extends dao<Administrador, Integer> {

    public Administrador findLogin(String login, String senha) {
        Query q = getConnection().createQuery("select a from Administrador a WHERE a.email = :log and a.senha = :sen");
        q.setParameter("log", login);
        q.setParameter("sen", senha);
        try {
            return (Administrador) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Administrador save(Administrador obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrador findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Administrador> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
