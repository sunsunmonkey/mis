package team.service;
//员工状态
public class Status {
   private final String NAME;
   private Status(String name){
       this.NAME =name;
   }


    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
