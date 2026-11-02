package planning;

import java.util.List;

public class Evènement {
    protected Activité activité;
    protected List<Animateur> animateurs;

    public Evènement(Activité activité, List<Animateur> animateurs) {
        this.activité = activité;
        this.animateurs = animateurs;
    }
}
