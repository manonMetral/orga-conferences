package planning;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SalleTest {
    @Test
    void shouldCreateANewSalle() {
        Salle riner = new Salle("Riner");
        assertThat(riner).isNotNull().isInstanceOf(Salle.class);
        assertThat(riner.name).isEqualTo("Riner");
    }

}