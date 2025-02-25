package org.firstinspires.ftc.teamcode.additional.Actions;

import org.firstinspires.ftc.teamcode.additional.DataPackages.BigRobotArmData;

public class PickupThePixelAction implements IAction {
    BigRobotArmData armData;
    boolean pickupRight;
    boolean pickupLeft;
    boolean isFinished;
    double rightTarget;
    double leftTarget;
    public PickupThePixelAction(BigRobotArmData armData, boolean pickupRight, boolean pickupLeft) {
        this.armData = armData;
        this.pickupRight = pickupRight;
        this.pickupLeft = pickupLeft;
        rightTarget = armData.getClawServoRight().getPosition();
        leftTarget = armData.getClawServoLeft().getPosition();
    }

    @Override
    public void start() {
        if(pickupRight) {
            rightTarget = 0;
            armData.getClawServoRight().setPosition(rightTarget);

        }
        if(pickupLeft) {
            leftTarget = 1;
            armData.getClawServoLeft().setPosition(leftTarget);
        }
    }

    @Override
    public void update() {
        if(!isFinished) return;
        if((armData.getClawServoLeft().getPosition() == leftTarget) && (armData.getClawServoRight().getPosition() == rightTarget))
            isFinished = true;
    }

    @Override
    public boolean isOver() {
        return isFinished;
    }
}
