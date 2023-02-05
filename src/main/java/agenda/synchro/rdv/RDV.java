package agenda.synchro.rdv;

import com.owlike.genson.annotation.JsonDateFormat;
import com.owlike.genson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class RDV {

    @JsonProperty("idRDV")
    private int idRDV;

    @JsonProperty("name")
    private String name;

    @JsonProperty("date")
    @JsonDateFormat("yyyy-MM-dd")
    private Date date;

    @JsonProperty("time")
    @JsonDateFormat("HH:mm")
    private Date time;
    @JsonProperty("location")
    private String location;

    public RDV() {
        this.setIdRDV(-1);
        this.setName("unknown");
        this.setDate(null);
        this.setTime(null);
        this.setLocation("unknown");
    }
    public RDV(int idRDV, String name, Date date, Date time, String location){
        this.setIdRDV(idRDV);
        this.setName(name);
        this.setDate(date);
        this.setTime(time);
        this.setLocation(location);
    }

    public RDV(String name, Date date, Date time, String location){
        this.setIdRDV(-1);
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

    public Date getDate() { return this.date; }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() { return this.time; }

    public void setTime(Date time) {
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
        return "{" +
                "\"idRDV\": " + idRDV +
                ", \"name\": \"" + name + '\"' +
                ", \"date\": \"" + Database.dateFormat.format(getDate()) + '\"' +
                ", \"time\": \"" + Database.timeFormat.format(getTime()) + '\"' +
                ", \"location\": \"" + location + '\"' +
                '}';
    }
}