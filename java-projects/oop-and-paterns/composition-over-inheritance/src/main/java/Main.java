public class Main {
    public static void main(String[] args){
        Robot laserRobot = new Robot(new LaserAttack());
        Robot peacfulRobot = new Robot(new NoAttack());

        laserRobot.performAttack();
        peacfulRobot.performAttack();
    }
}
