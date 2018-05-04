import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner in = new Scanner(System.in);
        String index;
        List<Activity> a = new ArrayList<Activity>();
        List<Club> c = new ArrayList<Club>();

        while (true) {
            System.out.println("1.主界面  2.后台界面");
            index=in.nextLine();
            a = controller.setActivityList();
            c = controller.setClubList();
            if (index.equals("1")) {
                controller.printActivityName(a);
                controller.printClubName(c);
                System.out.println("1.查找社团  2.查找活动");
                index = in.nextLine();
                if (index.equals("1")) {
                    System.out.println("请输入社团名：");
                    controller.searchClub(c, in.nextLine());
                } else if (index.equals("2")) {
                    System.out.println("1.按活动名查找  2.按时间范围查找  3.按涉及的社团查找");
                    index = in.nextLine();
                    if (index.equals("1")) {
                        System.out.println("请输入活动名：");
                        index = in.nextLine();
                        controller.searchActivity(a, index);
                    } else if (index.equals("2")) {
                        System.out.println("请输入起始时间，如2017.2.9：");
                        index = in.nextLine();
                        System.out.println("请输入截止时间，如2017.3.9：");
                        controller.searchActivityAccordingToTime(a, index, in.nextLine());
                    } else if (index.equals("3")) {
                        System.out.println("请输入涉及的社团名称");
                        controller.searchActivityAccordingToClub(a, in.nextLine());
                    }
                }
            } else if (index.equals("2")) {
                System.out.println("按照人数给社团排序如下：");
                controller.sortActivityAccordingToNum(a);
            }
        }
    }
}