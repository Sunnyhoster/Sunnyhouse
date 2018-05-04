import java.util.*;

class ActivityCompare implements Comparator<Activity> {
    public int compare(Activity one,Activity two){
        if(one.getNum()>two.getNum()){
            return -1;
        }
        else return 1;
    }
}
