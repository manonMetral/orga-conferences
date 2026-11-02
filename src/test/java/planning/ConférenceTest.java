package planning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConférenceTest {

    @BeforeEach
    void setUp() {
        CréneauConférence.réinitialiserCompteurPourTests();
    }

    @Test
    void shouldCreateANewConference() {
        assertThat(new Conférence(new CréneauConférence(null), null)).isNotNull().isInstanceOf(Conférence.class);
    }
}