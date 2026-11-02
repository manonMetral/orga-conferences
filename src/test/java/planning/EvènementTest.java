package planning;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EvènementTest {

    @Test
    void shouldCreateAnEvènement() {
        Evènement évènement = new Evènement(new Activité(TypeActivité.TALK, "Java Streams"), List.of(new Animateur("John Doe")));
        assertThat(évènement).isNotNull().isInstanceOf(Evènement.class);
        assertThat(évènement.activité.nom).isNotNull().isEqualTo("Java Streams");
        assertThat(évènement.activité.type).isNotNull().isInstanceOf(TypeActivité.class).isEqualTo(TypeActivité.TALK);
        assertThat(évènement.animateurs).isNotNull().isInstanceOf(List.class).hasSize(1);
    }

}