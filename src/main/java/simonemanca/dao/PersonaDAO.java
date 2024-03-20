package simonemanca.dao;

import jakarta.persistence.EntityManager;
import simonemanca.model.Persona;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public Persona findById(Long id) {
        return em.find(Persona.class, id);
    }

    public void update(Persona persona) {
        em.getTransaction().begin();
        em.merge(persona);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        Persona persona = findById(id);
        if (persona != null) {
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();
        }
    }
}


