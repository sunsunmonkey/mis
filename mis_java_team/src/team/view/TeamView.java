package team.view;

import team.domain.Employee;
import team.domain.Programmer;
import team.service.NameListService;
import team.service.TeamException;
import team.service.TeamService;

public class TeamView {
    private NameListService listSvC = new NameListService();
    private TeamService teamSvc =new TeamService();
    public void enterMainMenu(){
        boolean loopFlag = true;
        char menu = 0;
        while (loopFlag){
            if(menu !='1'){
                listAllEmployees();
            }
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
             menu = TSUtility.readMenuSelection();
            switch (menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit =='Y'){
                        loopFlag =false;
                    }
                    break;

            }
        }
    }
    private void listAllEmployees(){
        System.out.println("---------------------------------开发软件调度---------------------------------\n");
        Employee[] employees=listSvC.getAllEmployees();
//        System.out.println("显示公司所有员工信息");
        if(employees.length==0){
            System.out.println("公司没有任何信息");
        }else {
            System.out.println("ID\t 姓名\t 年龄\t 工资\t 职位\t 状态\t 奖金\t 股票\t 领用设备");
            for (int i = 0;i<employees.length;i++){
                System.out.println(employees[i]);
            }
        }
        System.out.println("------------------------------------------------------------------------");
    }
    private void getTeam(){
        System.out.println("--------------------团队成员列表--------------------");
        Programmer[] team = teamSvc.getTeam();
        if(team.length ==0){
            System.out.println("开发团队目前没有成员！");
        }else {
            System.out.println("TID/ID\t 姓名\t 年龄\t 工资\t 职位\t 奖金\t 股票\n");
            for (int i =0;i<team.length;i++){
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("----------------------------------------------");
    }
    private void addMember(){
        System.out.println("--------------------添加团队成员--------------------");
        System.out.println("请输入要添加的员工ID：");
        int id =TSUtility.readInt();
        try {
            Employee emp = listSvC.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }
    private void deleteMember(){
        System.out.println("--------------------删除团队成员--------------------");
        System.out.print("请输入要删除的员工的TID：");
        int memberId =TSUtility.readInt();
        System.out.println("确认是否删除(Y/N）");
        char isDelete = TSUtility.readConfirmSelection();
        if(isDelete =='N'){
            return;
        }
        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view =new TeamView();
        view.enterMainMenu();

    }
}
