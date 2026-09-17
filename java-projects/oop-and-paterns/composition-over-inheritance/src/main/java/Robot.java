public class Robot {
    private AttackBehavior attackBehavior;

    public Robot(AttackBehavior attackBehavior){
        this.attackBehavior = attackBehavior;
    }

    public void performAttack() {
        attackBehavior.attack();
    }
}
