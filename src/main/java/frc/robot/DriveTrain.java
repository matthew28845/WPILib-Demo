package frc.robot;

//Imports everything neccesary for the code to work. 
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class DriveTrain {
    //Sets up the Xbox Controller. 
    private XboxController _xBox = new XboxController(0);

//Sets up the Talons. 
Talon talonZero = new Talon(0);
Talon talonOne = new Talon(1);
Talon talonTwo = new Talon(2);
Talon talonThree = new Talon(3);

//Sets up the Talons into pairs, which makes control easier. 
SpeedControllerGroup left = new SpeedControllerGroup(talonZero, talonTwo);
SpeedControllerGroup right = new SpeedControllerGroup(talonOne, talonThree);

//Sets up the drive train. 
DifferentialDrive driveTrain = new DifferentialDrive(left, right);

public void teleopPeriodic() {
//Gets the values of the Xbox's analog sticks, and sets them to two variables: speed and heading. 
double speed = (_xBox.getY(GenericHID.Hand.kLeft))*-1;
double heading = (_xBox.getX(GenericHID.Hand.kRight));
//Lets the robot actually drive, and use the Xbox controller for speed and heading. 
driveTrain.arcadeDrive(speed, heading);
}

}