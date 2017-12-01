/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Cliente;
import model.Motorista;
import model.Pedido;
import model.dao.dao;

/**
 *
 * @author PIEROPAN
 */
public class pedidoDao extends dao<Pedido, Integer> {

    @Override
    public Pedido save(Pedido ped) {
        getConnection();
        try {
            getConnection().getTransaction().begin();
            getConnection().persist(ped);
            getConnection().getTransaction().commit();
        } finally {
            close();
        }
        return ped;
    }

    @Override
    public Pedido findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pedido> findAll() {
        getConnection();
        try {
            Query q = getConnection().createQuery("SELECT p FROM Pedido p ORDER BY P.idEntrega DESC");
            return q.getResultList();
        } finally {
            close();
        }
    }

    public List<Pedido> findAllCliente(int id) {
        getConnection();
        try {
            Query q = getConnection().createQuery("SELECT p From Pedido p WHERE p.idCliente.idCliente = :id");
            q.setParameter("id", id);
            return q.getResultList();
        } finally {
            close();
        }
    }
      public List<Pedido> findAllMotorista(int id) {
        getConnection();
        try {
            Query q = getConnection().createQuery("SELECT p From Pedido p WHERE p.idMotorista.idMotorista = :id ORDER BY p.idEntrega DESC");
            q.setParameter("id", id);
            return q.getResultList();
        } finally {
            close();
        }
    }
    public Pedido teste(int idC,int idT){
        Query q = getConnection().createQuery("SELECT SUM(T.preco+C.preco) FROM Tipo t, Cidade c WHERE c.idCidade = :idC and t.idTipo = :idT");
        q.setParameter("idC", idC);
        q.setParameter("idT", idT);
        try {
            return (Pedido) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
     public Pedido edit(Pedido obj) {
        try {
//            Motorista m = new Motorista(Integer.BYTES);
//            obj.setIdMotorista(m);
            getConnection().getTransaction().begin();
            getConnection().merge(obj);
            getConnection().getTransaction().commit();

        } catch (Exception e) {
            getConnection().getTransaction().rollback();
        }
        return obj;
    }
}
