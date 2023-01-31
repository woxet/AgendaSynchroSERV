package agenda.synchro.rdv;

import agenda.synchro.rdv.RDV;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Database {
    public static ArrayList<RDV> list = new ArrayList<>();
    static {
        Date date = Calendar.getInstance().getTime();

        list.add(new RDV(0, "date avec michel", date, "17:00", "9 3/4"));
        list.add(new RDV(1, "Medecin", date, "09:00", "Amiens Hopital"));
        list.add(new RDV(2, "Dentiste", date, "10:00", "Amiens Clinique"));
        list.add(new RDV(3, "Ophtalmologiste", date, "11:00", "Amiens Centre"));
        list.add(new RDV(4, "Gynécologue", date, "14:00", "Amiens Hopital"));
        list.add(new RDV(5, "Psychologue", date, "15:00", "Amiens Centre"));
        list.add(new RDV(6, "Orthodontiste", date, "16:00", "Amiens Clinique"));
        list.add(new RDV(7, "Cardiologue", date, "09:00", "Amiens Hopital"));
        list.add(new RDV(8, "Dermatologue", date, "10:00", "Amiens Centre"));
        list.add(new RDV(9, "Pédiatre", date, "11:00", "Amiens Clinique"));
        list.add(new RDV(10, "Généraliste", date, "14:00", "Amiens Hopital"));
    }

    public static ArrayList<RDV> searchByDate(String date) {
        // Initialise un tableau de RDV pour stocker les résultats de la recherche
        ArrayList<RDV> result = new ArrayList<>();
        // Parcours le tableau de RDV
        for (RDV rdv : list) {
            // Si la date du RDV est égale à la date recherchée
            if (rdv.getDate().equals(date)) {
                // Ajoute le RDV au tableau de résultats
                result.add(rdv);
            }
        }
        result = sortRDVArrayByTime(result);
        // Retourne le tableau de résultats
        return result;
    }

    public static ArrayList<RDV> sortRDVArrayByTime(ArrayList<RDV> rdvArray) {
        for (int i = 0; i < rdvArray.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < rdvArray.size(); j++) {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                try {
                    Date time1 = format.parse(rdvArray.get(j).getTime());
                    Date time2 = format.parse(rdvArray.get(index).getTime());
                    if (time1.before(time2)) {
                        index = j;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            RDV smallerRDV = rdvArray.get(i);
            rdvArray.set(index, smallerRDV);
            rdvArray.set(i, rdvArray.get(index));
        }
        return rdvArray;
    }

}
