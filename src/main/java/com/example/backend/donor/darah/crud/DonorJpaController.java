/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.donor.darah.crud;

import com.example.backend.donor.darah.crud.exceptions.NonexistentEntityException;
import com.example.backend.donor.darah.crud.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author pascal
 */
public class DonorJpaController implements Serializable {

    public DonorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.backend_donor.darah.crud_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DonorJpaController() {
    }
    
    

    public void create(Donor donor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(donor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDonor(donor.getNik()) != null) {
                throw new PreexistingEntityException("Donor " + donor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Donor donor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            donor = em.merge(donor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = donor.getNik();
                if (findDonor(id) == null) {
                    throw new NonexistentEntityException("The donor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Donor donor;
            try {
                donor = em.getReference(Donor.class, id);
                donor.getNik();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The donor with id " + id + " no longer exists.", enfe);
            }
            em.remove(donor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Donor> findDonorEntities() {
        return findDonorEntities(true, -1, -1);
    }

    public List<Donor> findDonorEntities(int maxResults, int firstResult) {
        return findDonorEntities(false, maxResults, firstResult);
    }

    private List<Donor> findDonorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Donor.class));
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

    public Donor findDonor(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Donor.class, id);
        } finally {
            em.close();
        }
    }

    public int getDonorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Donor> rt = cq.from(Donor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
