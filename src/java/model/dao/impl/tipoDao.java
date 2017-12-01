/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Administrador;
import model.Tipo;
import model.dao.dao;

/**
 *
 * @author PIEROPAN
 */
public class tipoDao extends dao<Tipo, Integer> {

    @Override
    public Tipo save(Tipo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tipo findOne(Integer key) {
        Query q = getConnection().createQuery("SELECT t FROM Tipo t WHERE t.idTipo = :key");
        q.setParameter("key", key);
        try {
            return (Tipo) q.getSingleResult();
        } finally {
            close();
        }
    }

    @Override
    public List<Tipo> findAll() {
        getConnection();
        try {
            Query q = getConnection().createNamedQuery("Tipo.findAll");
            return q.getResultList();
        } finally {
            close();
        }
    }

    public Tipo findComparar(int id) {
        Query q = getConnection().createQuery("select t from Tipo t WHERE t.idTipo = :id");
        q.setParameter("id", id);
        try {
            return (Tipo) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
