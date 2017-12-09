public class Activity {
    private String name;
    private String time;
    private int num;
    private String place;
    private String hostClub;
    private String slogan;
    private String kind;

    public Activity(String name,String time,int num,String place,String hostClub,String slogan,String kind){
        this.name=name;
        this.time=time;
        this.num=num;
        this.place=place;
        this.hostClub=hostClub;
        this.slogan=slogan;
        this.kind=kind;
    }

    public Activity(){
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getNum() {
        return num;
    }

    public String getPlace() {
        return place;
    }

    public String getHostClub() {
        return hostClub;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getKind() {
        return kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setHostClub(String hostClub) {
        this.hostClub = hostClub;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
