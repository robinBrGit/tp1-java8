package bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class UtilisateurJava7 extends Utilisateur {
    private Calendar dateAdhesion;

    public UtilisateurJava7(String prenom,String nom,String date) throws ParseException {
        super(nom, prenom);
        dateAdhesion = new GregorianCalendar();
        Date sDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        this.dateAdhesion.setTime(sDate);
    }

    public Calendar getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(Calendar dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        final StringBuilder sb = new StringBuilder("UtilisateurJava7{");
        sb.append("dateAdhesion=").append(dateFormat.format(dateAdhesion.getTime()));
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
