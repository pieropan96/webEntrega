/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PIEROPAN
 */
public abstract class dao<C, k> {

    private EntityManagerFactory emf;
    private EntityManager em;

    public dao() {
        emf = Persistence.createEntityManagerFactory("webEntregaPU");
        em = emf.createEntityManager();
    }

    public void close() {
        if (em.isOpen()) {
            em.close();;
            emf.close();
        }
    }

    public EntityManager getConnection() {
        return em;
    }

    public abstract C save(C obj);
    public abstract C findOne(k key);
    public abstract List<C> findAll();

}
