package fr.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Si cette exception se déclenche (et qu'elle n'est capté par personne), c'est SPRING qui va la gérer
// Et si SPRING la gère, il va lire le @ResponseStatus, et va adapter le statut de la réponse HTTP
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FournisseurNotFoundException extends RuntimeException {

}
