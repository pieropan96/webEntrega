/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Cidade;
import model.Pedido;
import model.dao.dao;

/**
 *
 * @author PIEROPAN
 */
public class cidadeDao extends dao<Cidade, Integer> {

    @Override
    public Cidade save(Cidade obj) {
        getConnection();
        try {
            getConnection().getTransaction().begin();
            getConnection().persist(obj);
            getConnection().getTransaction().commit();
        } finally {
            close();
        }
        return obj;
    }

    @Override
    public Cidade findOne(Integer key) {
        Query q = getConnection().createQuery("SELECT c FROM Cidade c WHERE c.idCidade = :key");
        q.setParameter("key", key);
        try {
            return (Cidade) q.getSingleResult();
        } finally {
            close();
        }
    }

    @Override
    public List<Cidade> findAll() {
        getConnection();
        try {
            Query q = getConnection().createNamedQuery("Cidade.findAll");
            return q.getResultList();
        } finally {
            close();
        }
    }

    public void remover(Cidade c) {
        getConnection();
        try {
            getConnection().getTransaction().begin();
            getConnection().remove(getConnection().merge(c));
            getConnection().getTransaction().commit();
        } finally {
            close();
        }
    }
}
