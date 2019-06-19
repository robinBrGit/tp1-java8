package bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class UtilisateurJava8 extends Utilisateur {
    private LocalDate dateAdhesion;

    public UtilisateurJava8( String prenom,String nom, String date) {
        super(nom, prenom);
        this.dateAdhesion = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UtilisateurJava8{");
        sb.append("dateAdhesion=").append(dateAdhesion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
