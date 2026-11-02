package planning;

public class Activité {

    protected TypeActivité type;
    protected String nom;

    public Activité(TypeActivité type, String nom) {
        this.type = type;
        this.nom = nom;
    }
}
