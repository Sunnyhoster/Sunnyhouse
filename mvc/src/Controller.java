import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
//import java.io.File;
import java.util.*;
//import java.util.Scanner;

public class Controller {
    //private static Scanner in = new Scanner(System.in);

    public List<Activity> setActivityList() {
        List<Activity> activityList = new ArrayList<Activity>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("./acts.csv"), "GBK"));
            String line = null;
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String strings[] = line.split(",");
                Activity activity = new Activity();
                activity.setName(strings[0]);
                activity.setTime(strings[1]);
                activity.setNum(Integer.parseInt(strings[2]));
                activity.setPlace(strings[3]);
                activity.setHostClub(strings[4]);
                activity.setSlogan(strings[5]);
                activity.setKind(strings[6]);
                activityList.add(activity);
            }
            bufferedReader.close();
        } catch (
                IOException e)

        {
            e.printStackTrace();
        } finally

        {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return activityList;
    }

    public void printActivityName(List<Activity> a){
        ListIterator<Activity> listlter = a.listIterator();
        while (listlter.hasNext()) {
            Activity act = (Activity) listlter.next();
            //System.out.println(act.getName() + " " + act.getTime() + " " + act.getNum() + " " + act.getPlace() + " " + act.getHostClub() + " " + act.getSlogan() + " " + act.getKind());
            System.out.println(act.getName());
        }
    }

    public void searchActivity(List<Activity> a,String actName){
        ListIterator<Activity> listlter = a.listIterator();
        int judge=0;
        while (listlter.hasNext()) {
            Activity act = (Activity) listlter.next();
            if (act.getName().equals(actName)) {
                System.out.println(act.getName() + " " + act.getTime() + " " + act.getNum() + " " + act.getPlace() + " " + act.getHostClub() + " " + act.getSlogan() + " " + act.getKind());
                judge=1;
            }
        }
        if(judge==0){
            System.out.println("未找到");
        }
    }

    public void searchActivityAccordingToTime(List<Activity> a,String actTimeFrom,String actTimeTo){
        ListIterator<Activity> listlter = a.listIterator();
        while (listlter.hasNext()) {
            Activity act = (Activity) listlter.next();
            if (act.getTime().compareTo(actTimeFrom)>=0&&act.getTime().compareTo(actTimeTo)<=0) {
                System.out.println(act.getName() + " " + act.getTime() + " " + act.getNum() + " " + act.getPlace() + " " + act.getHostClub() + " " + act.getSlogan() + " " + act.getKind());
            }
        }
    }

    public void searchActivityAccordingToClub(List<Activity> a,String cluName){
        ListIterator<Activity> listlter = a.listIterator();
        while (listlter.hasNext()) {
            Activity act = (Activity) listlter.next();
            if (act.getHostClub().equals(cluName)) {
                System.out.println(act.getName() + " " + act.getTime() + " " + act.getNum() + " " + act.getPlace() + " " + act.getHostClub() + " " + act.getSlogan() + " " + act.getKind());
            }
        }
    }

    public List<Club> setClubList() {
        ///ActivityList activityList1 = new ActivityList();
        List<Club> clubList = new ArrayList<Club>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("./社团表.csv"), "utf-8"));
            String line = null;
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String strings[] = line.split(",");
                Club club = new Club();
                club.setName(strings[0]);
                club.setTime(strings[1]);
                club.setResponsiblePerson(strings[2]);
                club.setTelephone(strings[3]);
                club.setEmail(strings[4]);
                club.setMember(strings[5]);
                club.setActivityHold(strings[6]);
                club.setInformation(strings[7]);
                clubList.add(club);
            }
            bufferedReader.close();
        } catch (
                IOException e)

        {
            e.printStackTrace();
        } finally

        {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        ListIterator<Club> listlter = clubList.listIterator();
//        while (listlter.hasNext()) {
//            Club clu = (Club) listlter.next();
//            System.out.println(clu.getName() + " " + clu.getTime() + " " + clu.getResponsiblePerson() + " " + clu.getTelephone() + " " + clu.getEmail() + " " + clu.getMember() + " " + clu.getActivityHold() + " " + clu.getInformation());
//        }
        return clubList;
    }

    public void printClubName(List<Club> a){
        ListIterator<Club> listlter = a.listIterator();
        while (listlter.hasNext()) {
            Club clu = (Club) listlter.next();
            //System.out.println(act.getName() + " " + act.getTime() + " " + act.getNum() + " " + act.getPlace() + " " + act.getHostClub() + " " + act.getSlogan() + " " + act.getKind());
            System.out.println(clu.getName());
        }
    }

    public void searchClub(List<Club> a,String clubName){
        ListIterator<Club> listlter = a.listIterator();
        int judge=0;
        while (listlter.hasNext()) {
            Club clu = (Club) listlter.next();
            if (clu.getName().equals(clubName)) {
                System.out.println(clu.getName() + " " + clu.getTime() + " " + clu.getResponsiblePerson() + " " + clu.getTelephone() + " " + clu.getEmail() + " " + clu.getMember() + " " + clu.getActivityHold() + " " + clu.getInformation());
                //System.out.println(act.getName() + " " + act.getTime() + " " + act.getNum() + " " + act.getPlace() + " " + act.getHostClub() + " " + act.getSlogan() + " " + act.getKind());
                judge=1;
            }
        }
        if(judge==0){
            System.out.println("未找到");
        }
    }

    public void sortActivityAccordingToNum(List<Activity> a){
        ActivityCompare activityCompare=new ActivityCompare();
        Collections.sort(a,activityCompare);
        ListIterator<Activity> listlter = a.listIterator();
        while (listlter.hasNext()) {
            Activity act = (Activity) listlter.next();
            System.out.println(act.getName() + " " + act.getTime() + " " + act.getNum() + " " + act.getPlace() + " " + act.getHostClub() + " " + act.getSlogan() + " " + act.getKind());
        }
    }
}
