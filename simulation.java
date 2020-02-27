import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Simulation {

    public static Job getJob(Scanner in) {
        String[] s = in.nextLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        return new Job(a, d);
    }

    public static void main(String[] args) throws IOException {

        Scanner in = null;
        if(args.length < 1) {
            System.out.println("Usage: Simulation <input file>");
            System.exit(1);
        }
        in = new Scanner(new File(args[0]));
        PrintWriter report = new PrintWriter(new FileWriter(args[0]+".rpt"));
        PrintWriter trace = new PrintWriter(new FileWriter(args[0]+".trc"));

        int n, m;
        m = in.nextInt();
        in.nextLine();

        //A: storage                                                                                                            
        //B: backup                                                                                                             
        Queue A = new Queue();
        Queue B = new Queue();
        for(int i = 0; i < m; i++){
            Job one = getJob(in);
            A.enqueue(one);
            B.enqueue(one);
        }

        report.println(m + " Jobs:");
        report.println(A.toString());
        report.println();
        report.println("***********************************************************");

        int currTime = 0, min = Integer.MAX_VALUE, index = 1, maxWait = 0;
        double totalWait = 0, averageWait = 0.00;
        boolean check = false;
        for(n = 1; n <= m - 1; n++) {

            trace.println("*****************************");
            if(n == 1) {
                trace.println(n + " processor:");
            }
            else {
                trace.println(n + " processors:");
            }
            trace.println("*****************************");


            currTime = 0;

            Queue[] Q = new Queue[n + 1];
            Q[0] = A;
            for(int i = 1; i <= n; i++) {
                Q[i] = new Queue();
            }

            A.dequeueAll();
            while(A.length() != m) {
                Job temp = (Job)B.dequeue();
                A.enqueue(temp);
                B.enqueue(temp);
            }

            trace.println("time=" + currTime);
            for(int i = 0; i < Q.length; i++) {
                trace.println(i + ": " + Q[i]);
            }
            trace.println();


            while(A.length() != m || ((Job)A.peek()).getFinish() == -1) {

                for(int i = 1; i < Q.length; i++) {
                    if(!Q[i].isEmpty() && ((Job)Q[i].peek()) != null) {
                        while(!Q[i].isEmpty() && ((Job)Q[i].peek()).getFinish() == currTime) {
                            Job F = (Job)Q[i].dequeue();
                            A.enqueue(F);
                            if(!Q[i].isEmpty() && ((Job)Q[i].peek()) != null) {
                                ((Job)Q[i].peek()).computeFinishTime(currTime);
                            }
                            check = true;
                        }
                    }
                }

                if(!A.isEmpty() && ((Job)A.peek()) != null) {
                    while(!A.isEmpty() && ((Job)A.peek()).getArrival() == currTime) {
                        for(int i = 1; i < Q.length; i++) {
                            if(Q[i].length() < min) {
                                min = Q[i].length();
                                index = i;
                            }
                        }
                        Job S = (Job)A.dequeue();
                        if(Q[index].isEmpty()) {
                            S.computeFinishTime(currTime);

                       }
                        Q[index].enqueue(S);
                        min = Integer.MAX_VALUE;
                        index = 1;
                        check = true;
                    }
                }

                if(check == true){
                    trace.println("time=" + currTime);
                    for(int i = 0; i < Q.length; i++) {
                        trace.println(i + ": " + Q[i]);
                    }
                    trace.println();
                }

                check = false;
                currTime++;

            }
            //end of while loop                                                                                                 
            int len = A.length();
            for(int i = 0; i < len; i++) {
               totalWait += ((Job)A.peek()).getWaitTime();
                if(maxWait < ((Job)A.peek()).getWaitTime()) {
                    maxWait = ((Job)A.peek()).getWaitTime();
                }
                Job temp = (Job)A.dequeue();
                A.enqueue(temp);
            }
            averageWait = (totalWait / m);

            if(n == 1) {
                report.println(n + " processor: " + "totalWait=" + (int)totalWait + ", maxWait=" + maxWait + ", averageWait=" +\
 averageWait);
            }
            else {
                report.println(n + " processors: " + "totalWait=" + (int)totalWait + ", maxWait=" + maxWait + ", averageWait=" \
+ averageWait);
            }
            totalWait = 0;
            maxWait = 0;
            averageWait = 0.00;

            //reset finish times                                                                                                
            A.resetFinishTime();


        }
        //end of for loop                                                                                                       



        //13. close input and output files                                                                                      
        in.close();
        report.close();
        trace.close();


    }
}
