package planning;

import java.util.List;

public class Planning {
    private final int NOMBRE_DE_CONFERENCES = 8;
    protected List<Conférence> conférences;

    public Planning() {
        this.conférences = List.of(
                new Conférence(new CréneauConférence(null), null), new Conférence(new CréneauConférence(null), null), new Conférence(new CréneauConférence(null), null), new Conférence(new CréneauConférence(null), null),
                new Conférence(new CréneauConférence(null), null), new Conférence(new CréneauConférence(null), null), new Conférence(new CréneauConférence(null), null), new Conférence(new CréneauConférence(null), null)
        );
    }

    // appeler domainService pour changer le planning

    protected void affecterEvènementÀConférence(Evènement évènement) {
        Conférence conférenceSélectionnée = sélectionnerCréneauLibrePourEvènement(évènement);
        if (conférenceSélectionnée == null) {
            throw new IllegalStateException("Aucun créneau libre correspondant à la durée de l'évènement n'est disponible.");
        }
        ConférenceDomainService.affecterEvènementÀConférence(conférenceSélectionnée, évènement);
    }

    // sélectionner une conférence sans évènement et avec un créneau libre correspondant à la durée de l'évènement
    protected Conférence sélectionnerCréneauLibrePourEvènement(Evènement évènement) {
        List<Conférence> conférencesCorrespondantes = conférences.stream()
            .filter(conférence -> conférence.évènement == null)
            .filter(conférence -> filterByDuration(évènement, conférence))
            .toList();

        for (Conférence conférence : conférencesCorrespondantes) {
            if (conférence.évènement == null) {
                return conférence;
            }
        }
        return null;
    }

    private static boolean filterByDuration(Evènement évènement, Conférence conférence) {
        if (évènement.activité.type == TypeActivité.ATELIER) {
            return conférence.créneauConférence.durée.toHours() == 2;
        } else if (évènement.activité.type == TypeActivité.TALK) {
            return conférence.créneauConférence.durée.toHours() == 1;
        }
        return false;
    }

    public boolean isComplete() {
        return conférences.stream().allMatch(conférence -> conférence.évènement != null);
    }
}
