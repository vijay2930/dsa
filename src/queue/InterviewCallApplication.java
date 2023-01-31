package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InterviewCallApplication {
    Scanner sc;
    Queue<String> interviewQueue;
    String candidate="";
    InterviewCallApplication(){
        sc=new Scanner(System.in);
        interviewQueue = new LinkedList<>();
    }
    public void addInterviewee(){
        System.out.print("Enter the Candidate Name:");
        while(sc.hasNextLine()){
            String name=sc.nextLine();
            interviewQueue.add(name);
            if(name!="")
                break;
        }
        System.out.println("Add Successfully");
    }
    public void viewAllCandidates(){
        System.out.println("Interview queue: " + interviewQueue);
    }
    public void viewInterviewingCandidate(){
        if(candidate=="")
            moveToNextCandidate();
        System.out.println("Interviewing: " + candidate);
    }
    public void moveToNextCandidate(){
        candidate = interviewQueue.poll();
        System.out.println("Changed to Next Candidate");
    }
    public void start(){
        int choice=0;
        while(choice!=5){
            System.out.println("1. Add Interviewee");
            System.out.println("2. View All Candidates");
            System.out.println("3. View Interviewing Candidate");
            System.out.println("4. Move To Next Candidate");
            System.out.println("5. exit");
            System.out.print("Enter your choice:");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    addInterviewee();
                    break;
                case 2:
                    viewAllCandidates();
                    break;
                case 3:
                    viewInterviewingCandidate();
                    break;
                case 4:
                    moveToNextCandidate();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice. Try to enter the valid choice...");
            }
        }
    }
    public static void main(String[] args) {
        InterviewCallApplication b=new InterviewCallApplication();
        b.interviewQueue.add("Siva");
        b.interviewQueue.add("Selvam");
        b.interviewQueue.add("Guru");
        b.interviewQueue.add("Deva");
        b.interviewQueue.add("Danny");
        b.interviewQueue.add("vedhavarsini");
        b.interviewQueue.add("satheesh");
        b.interviewQueue.add("vijay");
        b.start();
    }
}
