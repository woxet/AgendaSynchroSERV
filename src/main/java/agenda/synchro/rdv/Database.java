package agenda.synchro.rdv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Database {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public static ArrayList<RDV> list = new ArrayList<>();
    static {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();

        c.set(Calendar.HOUR_OF_DAY, 16);
        c.set(Calendar.MINUTE, 15);
        Date time = c.getTime();
        list.add(new RDV(0, "Soutenance", date, time, "UPJV"));

        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 15);
        time = c.getTime();
        list.add(new RDV(1, "Medecin", date, time, "Amiens Hopital"));

        c.set(Calendar.HOUR_OF_DAY, 10);
        c.set(Calendar.MINUTE, 45);
        time = c.getTime();
        list.add(new RDV(2, "Dentiste", date, time, "Amiens Clinique"));

        c.set(Calendar.HOUR_OF_DAY, 17);
        c.set(Calendar.MINUTE, 0);
        time = c.getTime();
        list.add(new RDV(3, "Ophtalmologiste", date, time, "Amiens Centre"));

        c.set(Calendar.HOUR_OF_DAY, 8);
        c.set(Calendar.MINUTE, 30);
        time = c.getTime();
        list.add(new RDV(4, "Gynécologue", date, time, "Amiens Hopital"));

        c.set(Calendar.HOUR_OF_DAY, 11);
        c.set(Calendar.MINUTE, 30);;
        time = c.getTime();
        list.add(new RDV(5, "Psychologue", date, time, "Amiens Centre"));

        c.set(Calendar.HOUR_OF_DAY, 15);
        c.set(Calendar.MINUTE, 30);
        time = c.getTime();
        list.add(new RDV(6, "Orthodontiste", date, time, "Amiens Clinique"));

        c.set(Calendar.HOUR_OF_DAY, 12);
        c.set(Calendar.MINUTE, 35);
        time = c.getTime();
        list.add(new RDV(7, "Cardiologue", date, time, "Amiens Hopital"));

        c.set(Calendar.HOUR_OF_DAY, 14);
        c.set(Calendar.MINUTE, 45);
        time = c.getTime();
        list.add(new RDV(8, "Dermatologue", date, time, "Amiens Centre"));

        c.set(Calendar.HOUR_OF_DAY, 11);
        c.set(Calendar.MINUTE, 35);
        time = c.getTime();
        list.add(new RDV(9, "Pédiatre", date, time, "Amiens Clinique"));

        c.set(Calendar.HOUR_OF_DAY, 10);
        c.set(Calendar.MINUTE, 10);
        time = c.getTime();
        list.add(new RDV(10, "Généraliste", date, time, "Amiens Hopital"));
    }

    public static ArrayList<RDV> searchByDate(String date) {
        // Initialise un tableau de RDV pour stocker les résultats de la recherche
        ArrayList<RDV> result = new ArrayList<>();
        // Parcours le tableau de RDV
        for (RDV rdv : list) {
            // Si la date du RDV est égale à la date recherchée
            if (dateFormat.format(rdv.getDate()).equals(date)) {
                // Ajoute le RDV au tableau de résultats
                result.add(rdv);
            }
        }
        sortRDVArrayByTime(result);
        // Retourne le tableau de résultats
        return result;
    }

    public static void sortRDVArrayByTime(ArrayList<RDV> rdvArray) {
        Collections.sort(rdvArray, new Comparator<RDV>() {
            @Override
            public int compare(RDV rdv1, RDV rdv2) {
                //System.out.println(rdv1.getDate() + "  " + rdv2.getDate());
                return rdv1.getTime().compareTo(rdv2.getTime());
            }
        });

    }


}
