public class Club {
    private String name;
    private String time;
    private String responsiblePerson;
    private String telephone;
    private String email;
    private String member;
    private String activityHold;
    private String information;

    public Club(String name,String time,String responsiblePerson,String telephone,String email,String member,String activityHold,String information){
        this.name=name;
        this.time=time;
        this.responsiblePerson=responsiblePerson;
        this.telephone=telephone;
        this.email=email;
        this.member=member;
        this.activityHold=activityHold;
        this.information=information;
    }

    public Club(){
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getMember() {
        return member;
    }

    public String getActivityHold() {
        return activityHold;
    }

    public String getInformation() {
        return information;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public void setActivityHold(String activityHold) {
        this.activityHold = activityHold;
    }

    public void setInformation(String information){
        this.information=information;
    }

}
