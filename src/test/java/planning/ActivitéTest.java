package planning;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ActivitéTest {

    @Test
    void shouldCreateAnActivité() {
        Activité activité = new Activité(TypeActivité.ATELIER, "jonglage");
        assertThat(activité).isNotNull().isInstanceOf(Activité.class);
        assertThat(activité.type).isEqualTo(TypeActivité.ATELIER);
        assertThat(activité.nom).isEqualTo("jonglage");
    }
}