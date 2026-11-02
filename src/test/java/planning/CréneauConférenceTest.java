package planning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class CréneauConférenceTest {

    @BeforeEach
    void setUp() {
        CréneauConférence.réinitialiserCompteurPourTests();
    }

    @Test
    void shouldCreateANewCreneauConférence() {
        CréneauConférence créneauConférence = new CréneauConférence(null);
        assertThat(créneauConférence).isNotNull().isInstanceOf(CréneauConférence.class);
        assertThat(créneauConférence.identifiantCréneau).isEqualTo(1);
        assertThat(créneauConférence.début).isNotNull().isEqualTo(LocalDateTime.of(2027, 6, 1, 9, 0));
        assertThat(créneauConférence.durée).isEqualTo(Duration.ofHours(2));
        assertThat(créneauConférence.salle).isNull();
    }

    @Test
    void shouldCreateAllCréneauConférenceForPlanning() {
        CréneauConférence créneauConférence1 = new CréneauConférence(null);
        CréneauConférence créneauConférence2 = new CréneauConférence(null);
        CréneauConférence créneauConférence3 = new CréneauConférence(null);
        CréneauConférence créneauConférence4 = new CréneauConférence(null);
        CréneauConférence créneauConférence5 = new CréneauConférence(null);
        CréneauConférence créneauConférence6 = new CréneauConférence(null);
        CréneauConférence créneauConférence7 = new CréneauConférence(null);
        CréneauConférence créneauConférence8 = new CréneauConférence(null);

        assertThat(créneauConférence1.identifiantCréneau).isEqualTo(1);
        assertThat(créneauConférence2.identifiantCréneau).isEqualTo(2);
        assertThat(créneauConférence3.identifiantCréneau).isEqualTo(3);
        assertThat(créneauConférence4.identifiantCréneau).isEqualTo(4);
        assertThat(créneauConférence5.identifiantCréneau).isEqualTo(5);
        assertThat(créneauConférence6.identifiantCréneau).isEqualTo(6);
        assertThat(créneauConférence7.identifiantCréneau).isEqualTo(7);
        assertThat(créneauConférence8.identifiantCréneau).isEqualTo(8);
    }

}