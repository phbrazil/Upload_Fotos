/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ember.fotos_festa.model.foto;

import com.ember.fotos_festa.model.foto.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Paulo
 */
public class tbFotosJpaController implements Serializable {

    public tbFotosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(tbFotos tbFotos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tbFotos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(tbFotos tbFotos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tbFotos = em.merge(tbFotos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbFotos.getId();
                if (findtbFotos(id) == null) {
                    throw new NonexistentEntityException("The tbFotos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tbFotos tbFotos;
            try {
                tbFotos = em.getReference(tbFotos.class, id);
                tbFotos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbFotos with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbFotos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<tbFotos> findtbFotosEntities() {
        return findtbFotosEntities(true, -1, -1);
    }

    public List<tbFotos> findtbFotosEntities(int maxResults, int firstResult) {
        return findtbFotosEntities(false, maxResults, firstResult);
    }

    private List<tbFotos> findtbFotosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(tbFotos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public tbFotos findtbFotos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(tbFotos.class, id);
        } finally {
            em.close();
        }
    }

    public int gettbFotosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<tbFotos> rt = cq.from(tbFotos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
