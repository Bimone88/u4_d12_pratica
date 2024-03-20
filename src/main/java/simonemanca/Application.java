package simonemanca;

import simonemanca.dao.*;
import simonemanca.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventiPU");
        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDao = new EventoDAO(em);
        PersonaDAO personaDao = new PersonaDAO(em);
        LocationDAO locationDao = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO(em);

        Location location = new Location("Arena di Verona", "Verona");
        locationDao.save(location);

        Evento evento = new Evento("Concerto Rock", new Date(), "Evento di musica rock all'aperto", TipoEvento.PUBBLICO, 500, location);
        eventoDao.save(evento);

        Persona persona = new Persona("Mario", "Rossi", "mario.rossi@example.com", new Date(), 'M');
        personaDao.save(persona);

        Partecipazione partecipazione = new Partecipazione(persona, evento, "CONFERMATA");
        partecipazioneDao.save(partecipazione);

        // Dimostrazione del recupero di un evento e delle sue relazioni
        Evento eventoRecuperato = eventoDao.findById(evento.getId());
        System.out.println("Evento recuperato: " + eventoRecuperato);

        Persona personaRecuperata = personaDao.findById(persona.getId());
        System.out.println("Persona recuperata: " + personaRecuperata);

        Location locationRecuperata = locationDao.findById(location.getId());
        System.out.println("Location recuperata: " + locationRecuperata);

        Partecipazione partecipazioneRecuperata = partecipazioneDao.findById(partecipazione.getId());
        System.out.println("Partecipazione recuperata: " + partecipazioneRecuperata);

        em.close();
        emf.close();
    }
}




