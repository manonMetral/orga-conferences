package planning;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CréneauConférence {

    private LocalDate JOUR_1 = LocalDate.of(2027, 6, 1);
    private LocalDate JOUR_2 = LocalDate.of(2027, 6, 2);
    private static int prochainIdentifiant = 0;

    protected int identifiantCréneau;
    protected LocalDateTime début;
    protected Duration durée;
    protected Salle salle;

    public CréneauConférence(Salle salle) {
        defineCréneauConférence(incrémenteIdCréneau());
        this.salle = salle;
    }

    private int incrémenteIdCréneau() {
        identifiantCréneau = ++prochainIdentifiant;
        return identifiantCréneau;
    }

    private void defineCréneauConférence(int id) {
        if (id == 1) {
            this.début = LocalDateTime.of(JOUR_1, LocalTime.of(9, 0));
            this.durée = Duration.ofHours(2);
        } else if (id == 2) {
            this.début = LocalDateTime.of(JOUR_1, LocalTime.of(11, 0));
            this.durée = Duration.ofHours(1);
        } else if (id == 3) {
            this.début = LocalDateTime.of(JOUR_1, LocalTime.of(14, 0));
            this.durée = Duration.ofHours(1);
        } else if (id == 4) {
            this.début = LocalDateTime.of(JOUR_1, LocalTime.of(15, 0));
            this.durée = Duration.ofHours(2);
        } else if (id == 5) {
            this.début = LocalDateTime.of(JOUR_2, LocalTime.of(9, 0));
            this.durée = Duration.ofHours(2);
        } else if (id == 6) {
            this.début = LocalDateTime.of(JOUR_2, LocalTime.of(11, 0));
            this.durée = Duration.ofHours(1);
        } else if (id == 7) {
            this.début = LocalDateTime.of(JOUR_2, LocalTime.of(14, 0));
            this.durée = Duration.ofHours(1);
        } else if (id == 8) {
            this.début = LocalDateTime.of(JOUR_2, LocalTime.of(15, 0));
            this.durée = Duration.ofHours(2);
        }
    }

    static void réinitialiserCompteurPourTests() {
        prochainIdentifiant = 0;
    }
}
