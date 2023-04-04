package fr.formation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private LocalDate date = LocalDate.now();
    private Client client;
    private List<CommandeDetail> details = new ArrayList<>();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<CommandeDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CommandeDetail> details) {
        this.details = details;
    }

    public Commande(Client client, CommandeDetail detail) {
        this.client = client;
        this.details.add(detail);
    }
}
