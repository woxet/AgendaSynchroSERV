package agenda.synchro.service;

import agenda.synchro.rdv.Database;
import agenda.synchro.rdv.RDV;
import com.owlike.genson.Genson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.crypto.Data;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;

@Path("/rdv")
public class Service {
    @GET
    @Path("/getid/{idRDV}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRDVbyId(@PathParam("idRDV") int idRDV) {
        System.out.println("GET ID " + idRDV + " : " + Database.list.get(idRDV).toString());
        return Database.list.get(idRDV).toString();
    }

    @GET
    @Path("/getdate/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRDVbyDate(@PathParam("date") String date) {
        JSONArray jsonArray = new JSONArray();
        System.out.println("GET DATE " + date);

        for (RDV rdv : Database.searchByDate(date)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("idRDV", rdv.getIdRDV());
            jsonObject.put("name", rdv.getName());
            jsonObject.put("time", Database.timeFormat.format(rdv.getTime()));
            jsonArray.put(jsonObject);
        }
        System.out.println("GET DATE SEND : " + jsonArray);

        return jsonArray.toString();
    }

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllRDV() {
        System.out.println("GET ALL");

        return Database.list.toString();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateRDV(RDV json) {
        System.out.println("UPDATE");

        System.out.println("UPDATE : " + json.toString());

        System.out.println("UPDATE : Done");

        return true;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addRDV(RDV json) {
        //RDV rdv = new Genson().deserialize(json, RDV.class);
        System.out.println("ADD : " + json);

        // traitement des données de l'objet RDV
        int index = Database.list.size();
        json.setIdRDV(index);
        System.out.println(json);
        Database.list.add(json);
        System.out.println(Database.list.get(index));
        System.out.println("ADD : Done");
        return true;
    }

    @GET
    @Path("/delete/{idRDV}")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteRDV(@PathParam("idRDV") int idRDV){
        System.out.println("DELETE : " + idRDV);

        int indexToRemove = -1;
        for (int i = 0; i < Database.list.size(); i++) {
            if (Database.list.get(i).getIdRDV() == idRDV) {
                indexToRemove = i;
                break;
            }
        }
        System.out.println("DELETE : " + Database.list.get(indexToRemove).toString());
        if (indexToRemove != -1) {
            //Database.list.remove(indexToRemove);
            for (int i = indexToRemove; i < Database.list.size() - 1; i++) {
                Database.list.get(i + 1).setIdRDV(i);
                Database.list.set(i, Database.list.get(i + 1));
            }
            Database.list.remove(Database.list.size()-1);
            System.out.println("DELETE : Done");
        }
        return true;
    }
}
