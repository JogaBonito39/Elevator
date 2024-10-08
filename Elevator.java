
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
        int elevator1 = 1;
        int elevator2 = 1;
        

        int tempRequests1 = requests;
        int tempRequests2 = requests;
        int count = 0;
        int i = 0;
        int val = 0;
        int newMinVal=0;
        int[] reqArr = new int[10];
        boolean boolCont = false;
        if (restrictedFloors > 0){
            boolCont = true;
            passcode = Integer.parseInt(args[3]);
            
    
            while (tempRequests2>0){
                tempRequests2= tempRequests2/10;
                count++;
            }
    
            reqArr = new int[count];
            
            while (tempRequests1>0){
                val = tempRequests1%10;
                reqArr[i] = val;
                tempRequests1 = tempRequests1/10;
                i++;
            }
            
            for (int a=0; a<reqArr.length; a++){
                for(int b=0; b<reqArr.length; b++){
                    if (reqArr[b]>reqArr[a]){
                        int temp = reqArr[a];
                        reqArr[a] = reqArr[b];
                        reqArr[b] = temp;
                    }
                }
            }
            
            newMinVal = reqArr[reqArr.length-restrictedFloors];
            
            i = 1;
        }
        else{
            passcode = 0;
            boolCont = false;
        }
            

        while (requests > 0){
            int curReq = requests%10;
            if (curReq >= newMinVal && boolCont){
                String access = "Denied";
                i++;
                if (passcode % floors == curReq || passcode%floors == 0 && curReq == reqArr[reqArr.length-1]){
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
                else if ((elevator1-curReq)*(elevator1-curReq) <= (elevator2-curReq)*(elevator2-curReq)){
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
                else if ((elevator1-curReq)*(elevator1-curReq) <= (elevator2-curReq)*(elevator2-curReq)){
                    System.out.println("1 " + curReq);
                    elevator1 = curReq;
                }
                else{
                    System.out.println("2 " + curReq);
                    elevator2 = curReq;
                }
            }
            requests /= 10;
        }
    }  
}
