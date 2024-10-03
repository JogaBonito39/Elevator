
/*************************************************************************
 *  Compilation:  javac Elevator.java
 *  Execution:    java Elevator 'number of floors' 'floor requests' 'number of restricted floors' 'optional passcode'
 *
 *
 *************************************************************************/
public class Elevator {
    
    public static void main ( String[] args ) {

        int floors = Integer.parseInt(args[0]);
        int requests = Integer.parseInt(args[1]);
        int restrictedFloors = Integer.parseInt(args[2]);
        int passcode;
        if (restrictedFloors > 0){
            passcode = Integer.parseInt(args[3]);
        }
        else{
            passcode = 0;
        }
            
        int tempRequests = requests;
        int elevator1 = 1;
        int elevator2 = 1;
        int count = 0;
        while (tempRequests > 0){
            tempRequests/=10;
            count++;
        }

    
        while (requests > 0){
            int curReq = requests%10;
            if (count == restrictedFloors && restrictedFloors > 0){
                String access = "Denied";
                if (passcode % floors == curReq || (passcode%floors == 0 && count == restrictedFloors)){
                    access = "Granted";
                }
                else{
                    access = "Denied";
                }
                restrictedFloors--;

                if (elevator1 == elevator2){
                    System.out.println("1 " + curReq);
                    System.out.println(access);
                    elevator1 = curReq;

                }
                else if ((elevator1-curReq)*(elevator1-curReq) < (elevator2-curReq)*(elevator2-curReq)){
                    System.out.println("1 " + curReq);
                    System.out.println(access);
                    elevator1 = curReq;
                }
                else{
                    System.out.println("2 " + curReq);
                    System.out.println(access);
                    elevator2 = curReq;
                }
            }
            else{
                if (elevator1 == elevator2){
                    System.out.println("1 " + curReq);
                    elevator1 = curReq;
                }
                else if ((elevator1-curReq)*(elevator1-curReq) < (elevator2-curReq)*(elevator2-curReq)){
                    System.out.println("1 " + curReq);
                    elevator1 = curReq;
                }
                else{
                    System.out.println("2 " + curReq);
                    elevator2 = curReq;
                }
            }
            requests /= 10;
            count--;
        }
    }  
}
