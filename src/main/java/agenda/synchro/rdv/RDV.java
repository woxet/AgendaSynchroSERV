package agenda.synchro.rdv;

import com.owlike.genson.Genson;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RDV {
    private int idRDV;
    private String name;
    private Date date;
    private String time;
    private String location;

    public RDV(int idRDV, String name, Date date, String time, String location){
        this.setIdRDV(idRDV);
        this.setName(name);
        this.setDate(date);
        this.setTime(time);
        this.setLocation(location);
    }

    public RDV(String name, Date date, String time, String location){
        this.setName(name);
        this.setDate(date);
        this.setTime(time);
        this.setLocation(location);
    }

    public RDV(int idRDV, String name){
        this.idRDV = idRDV;
        this.name = name;
    }

    public int getIdRDV() {return idRDV;}

    public void setIdRDV(int idRDV) {
        this.idRDV = idRDV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("DATE : "+  dateFormat.format(this.date));
        return dateFormat.format(this.date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "{" +
                "\"idRDV\": " + idRDV +
                ", \"name\": \"" + name + '\"' +
                ", \"date\": \"" + getDate() + '\"' +
                ", \"time\": \"" + time + '\"' +
                ", \"location\": \"" + location + '\"' +
                '}';
    }
}