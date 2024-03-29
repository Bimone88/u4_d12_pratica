package simonemanca.dao;

import jakarta.persistence.EntityManager;
import simonemanca.model.Evento;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento findById(Long id) {
        return em.find(Evento.class, id);
    }

    public void update(Evento evento) {
        em.getTransaction().begin();
        em.merge(evento);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        Evento evento = findById(id);
        if (evento != null) {
            em.getTransaction().begin();
            em.remove(evento);
            em.getTransaction().commit();
        }
    }
}

