package simonemanca.dao;

import jakarta.persistence.EntityManager;
import simonemanca.model.Location;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    public Location findById(Long id) {
        return em.find(Location.class, id);
    }

    public void update(Location location) {
        em.getTransaction().begin();
        em.merge(location);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        Location location = findById(id);
        if (location != null) {
            em.getTransaction().begin();
            em.remove(location);
            em.getTransaction().commit();
        }
    }
}
