package agenda.synchro.service;

import agenda.synchro.rdv.Database;
import agenda.synchro.rdv.RDV;
import com.owlike.genson.Genson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rdv")
public class Service {
    @GET
    @Path("/getid/{idRDV}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRDVbyId(@PathParam("idRDV") int idRDV) {
        System.out.println(Database.list.get(idRDV).toString());
        return Database.list.get(idRDV).toString();
    }

    @GET
    @Path("/getdate/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRDVbyDate(@PathParam("date") String date) {
        JSONArray jsonArray = new JSONArray();
        for (RDV rdv : Database.searchByDate(date)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("idRDV", rdv.getIdRDV());
            jsonObject.put("name", rdv.getName());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllRDV() {
        JSONArray jsonArray = new JSONArray();
        for (RDV rdv : Database.list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("idRDV", rdv.getIdRDV());
            jsonObject.put("name", rdv.getName());
            jsonObject.put("date", rdv.getDate());
            jsonObject.put("time", rdv.getTime());
            jsonObject.put("localisation", rdv.getLocation());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }


    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateRDV(RDV rdv) {
        System.out.println("Receive update for " + rdv);
        Database.list.add(rdv);
        return true;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addRDV(String json) {
        RDV rdv = new Genson().deserialize(json, RDV.class);
        int nb = Database.list.size();
        rdv.setIdRDV(nb);
        System.out.println(rdv);
        Database.list.add(rdv);
        System.out.println(Database.list.get(nb));
        // traitement des données de l'objet RDV (insertion en base de données, par exemple)
        return true;
    }
}
