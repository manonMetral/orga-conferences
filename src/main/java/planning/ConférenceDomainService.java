package planning;

public class ConférenceDomainService {
    /*
        invariant non concurrence des évènements : l'affectation se fait en fonction des créneaux libres
        ajouter un évènement à une conférence, en fonction de son type les créneaux de 1h sont pour les TALK et ceux de 2h sont pour les ateliers
    */
    protected static void affecterEvènementÀConférence(Conférence conférence, Evènement évènement) {
        // Affecter l'évènement à la conférence
        conférence.évènement = évènement;
    }
}
