package simonemanca.dao;

import jakarta.persistence.EntityManager;
import simonemanca.model.Partecipazione;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }

    public Partecipazione findById(Long id) {
        return em.find(Partecipazione.class, id);
    }

    public void update(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.merge(partecipazione);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        Partecipazione partecipazione = findById(id);
        if (partecipazione != null) {
            em.getTransaction().begin();
            em.remove(partecipazione);
            em.getTransaction().commit();
        }
    }
}

