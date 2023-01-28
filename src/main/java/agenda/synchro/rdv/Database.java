package agenda.synchro.rdv;

import java.util.ArrayList;
import java.util.Arrays;

public class Database {
    public static ArrayList<RDV> list = new ArrayList<>();
    static {
        list.add(new RDV( 0, "Medecin", "2023-01-28", "14:00", "Amiens Hopital"));
        list.add(new RDV( 1, "Coiffeur", "2023-01-28", "10:30", "Coif'Mode"));
        list.add(new RDV( 2, "Soutenance", "2023-01-28", "15:30", "UPJV"));
    }

    public static RDV[] searchByDate(String date) {
        // Initialise un tableau de RDV pour stocker les résultats de la recherche
        RDV[] result = new RDV[list.size()];
        int index = 0;
        // Parcours le tableau de RDV
        for (RDV rdv : list) {
            // Si la date du RDV est égale à la date recherchée
            if (rdv.getDate().equals(date)) {
                // Ajoute le RDV au tableau de résultats
                result[index] = rdv;
                index++;
            }
        }
        // Retourne le tableau de résultats
        return Arrays.copyOf(result, index);
    }

}
