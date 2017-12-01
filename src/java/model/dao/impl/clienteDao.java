/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Cliente;
import model.dao.dao;

/**
 *
 * @author PIEROPAN
 */
public class clienteDao extends dao<Cliente, Integer> {

    public Cliente findLogin(String login, String senha) {
        Query q = getConnection().createQuery("select c from Cliente c WHERE c.email = :log and c.senha = :sen");
        q.setParameter("log", login);
        q.setParameter("sen", senha);
        try {
            return (Cliente) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Cliente save(Cliente cli) {
      getConnection();
        try {
            getConnection().getTransaction().begin();
            getConnection().persist(cli);
            getConnection().getTransaction().commit();
        } finally {
            close();
        }
        return cli;
    }

    @Override
    public Cliente findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
