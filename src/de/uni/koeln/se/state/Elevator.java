package de.uni.koeln.se.state;


public class Elevator{

    public static int current_Floor=5;
    int dest_Floor;

    private Elv_States State = new Elv_States();

    public Elevator (int dest_floor)
    {
        this.dest_Floor=dest_floor;
        System.out.println("*** Destination floor is: "+ dest_Floor);

        State.Current_State = State.Idle;

        if (current_Floor < dest_Floor){
            go_up();
        }else if (current_Floor > dest_Floor){
            go_down();
        }else if (current_Floor == dest_Floor){
            System.out.print("*** You are already at your destination floor :-)");
        }


    }

    private void arrive_atFloor() {
        System.out.println("*** Arrived at floor "+current_Floor);
        State.Current_State = State.Idle;
    }

    private void go_up(){
        State.Current_State = State.Moving_up;
        current_Floor = current_Floor+1;
        System.out.println(State.Current_State+" heading "+current_Floor);
        if (current_Floor == dest_Floor){
            arrive_atFloor();
        }else go_up();

    }

    private void go_down(){
        State.Current_State = State.Moving_down;
        current_Floor = current_Floor-1;
        System.out.println(State.Current_State+" heading "+current_Floor);
        if (current_Floor == dest_Floor){
            arrive_atFloor();
        }else go_down();
    }

}