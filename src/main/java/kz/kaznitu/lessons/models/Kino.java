package kz.kaznitu.lessons.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Kino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String strana;
    private String zhanr;
    private Integer god;

    @ManyToMany
    private List<Rejisser> rejissers;
    @ManyToMany
    private List<Actor> actors;



    public Kino() {
        super();
    }

    public Kino(Integer id,String name, String strana, String zhanr, Integer god, List<Actor> actors,List<Rejisser> rejissers) {
        this.id=id;
        this.name = name;
        this.strana = strana;
        this.zhanr = zhanr;
        this.god = god;
        this.actors=actors;
        this.rejissers=rejissers;
    }

    public Kino(String name, String strana, String zhanr, Integer god, List<Actor> actors,List<Rejisser> rejissers) {
        this.name = name;
        this.strana = strana;
        this.zhanr = zhanr;
        this.god = god;
        this.actors=actors;
        this.rejissers=rejissers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrana() {
        return strana;
    }

    public void setStrana(String strana) {
        this.strana = strana;
    }

    public String getZhanr() {
        return zhanr;
    }

    public void setZhanr(String zhanr) {
        this.zhanr = zhanr;
    }


    public Integer getGod() {
        return god;
    }

    public void setGod(Integer god) {
        this.god = god;
    }
    public List<Actor> getActors() {return actors;}

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public boolean hasActor(Actor actor){
        for (Actor containedActor: getActors()){
            if (containedActor.getId()==actor.getId()){
                return true;
            }
        }
        return false;
    }

    public List<Rejisser> getRejissers(){return rejissers;}

    public void setRejissers(List<Rejisser> rejissers) {this.rejissers=rejissers;}

    public boolean hasRejisser(Rejisser rejisser){
        for (Rejisser containedRejisser: getRejissers()){
            if (containedRejisser.getId()==rejisser.getId()){
                return true;
            }
        }
        return false;
    }
}
