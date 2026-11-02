package planning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class PlanningTest {
    // jour 1: Conférence 1 (Créneau 9-11, Evènement= null), Conférence 2 (Créneau 11-12h, Evènement= null), Conférence 3 (Créneau 14-15h, Evènement= null), Conférence 4 (Créneau 15-17h, Evènement= null)
    // jour 2: Conférence 1 (Créneau 9-11, Evènement= null), Conférence 2 (Créneau 11-12h, Evènement= null), Conférence 3 (Créneau 14-15h, Evènement= null), Conférence 4 (Créneau 15-17h, Evènement= null)
    @BeforeEach
    void setUp() {
        CréneauConférence.réinitialiserCompteurPourTests();
    }

    @Test
    void shouldBuildANewPlanning() {
        Planning planning = new Planning();
        assertThat(planning).isNotNull().isInstanceOf(Planning.class);
        assertThat(planning.conférences).isNotNull().hasSize(8);
    }

    @Test
    void shouldFindCréneauLibreForConférence() {
        Planning planning = new Planning();
        Evènement évènementAProgrammer = new Evènement(new Activité(TypeActivité.TALK, "Java Streams"), null);

        Conférence conférenceSélectionnée = planning.sélectionnerCréneauLibrePourEvènement(évènementAProgrammer);
        assertThat(conférenceSélectionnée).isNotNull().isInstanceOf(Conférence.class);
        assertThat(conférenceSélectionnée.évènement).isNull();
        assertThat(conférenceSélectionnée.créneauConférence.durée.toHours()).isEqualTo(1);
        assertThat(conférenceSélectionnée.créneauConférence.début).isNotNull().isEqualTo(LocalDateTime.of(2027, 6, 1, 11, 0));
    }

    @Test
    void shouldAffecterEvènementToConférence() {
        Planning planning = new Planning();
        Evènement évènementAProgrammer = new Evènement(new Activité(TypeActivité.ATELIER, "Cobol"), null);

        Conférence conférenceSélectionnée = planning.sélectionnerCréneauLibrePourEvènement(évènementAProgrammer);
        assertThat(conférenceSélectionnée).isNotNull().isInstanceOf(Conférence.class);
        assertThat(conférenceSélectionnée.évènement).isNull();

        planning.affecterEvènementÀConférence(évènementAProgrammer);
        assertThat(conférenceSélectionnée.évènement).isNotNull().isInstanceOf(Evènement.class);
        assertThat(conférenceSélectionnée.évènement.activité.nom).isEqualTo("Cobol");
        assertThat(conférenceSélectionnée.évènement.activité.type).isEqualTo(TypeActivité.ATELIER);
        assertThat(conférenceSélectionnée.créneauConférence.durée.toHours()).isEqualTo(2);
        assertThat(conférenceSélectionnée.créneauConférence.début).isNotNull().isEqualTo(LocalDateTime.of(2027, 6, 1, 9, 0));
    }

    @Test
    void shouldIndicateWhenPlannngComplet() {
        Planning planning = new Planning();
        Evènement évènementAProgrammer1 = new Evènement(new Activité(TypeActivité.ATELIER, "Cobol"), null);
        Evènement évènementAProgrammer2 = new Evènement(new Activité(TypeActivité.ATELIER, "Java"), null);
        Evènement évènementAProgrammer3 = new Evènement(new Activité(TypeActivité.ATELIER, "Python"), null);
        Evènement évènementAProgrammer4 = new Evènement(new Activité(TypeActivité.ATELIER, "C++"), null);
        Evènement évènementAProgrammer5 = new Evènement(new Activité(TypeActivité.TALK, "JavaScript"), null);
        Evènement évènementAProgrammer6 = new Evènement(new Activité(TypeActivité.TALK, "TypeScript"), null);
        Evènement évènementAProgrammer7 = new Evènement(new Activité(TypeActivité.TALK, "Rust"), null);
        Evènement évènementAProgrammer8 = new Evènement(new Activité(TypeActivité.TALK, "Go"), null);

        planning.affecterEvènementÀConférence(évènementAProgrammer1);
        planning.affecterEvènementÀConférence(évènementAProgrammer2);
        planning.affecterEvènementÀConférence(évènementAProgrammer3);
        planning.affecterEvènementÀConférence(évènementAProgrammer4);
        planning.affecterEvènementÀConférence(évènementAProgrammer5);
        planning.affecterEvènementÀConférence(évènementAProgrammer6);
        planning.affecterEvènementÀConférence(évènementAProgrammer7);
        planning.affecterEvènementÀConférence(évènementAProgrammer8);

        assertThat(planning.isComplete()).isEqualTo(true);
    }
}
