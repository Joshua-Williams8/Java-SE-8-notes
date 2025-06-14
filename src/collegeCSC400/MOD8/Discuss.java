package collegeCSC400.MOD8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Discuss {
  public static void main(String[] args) {
    TicketCompare ticketCompare = new TicketCompare();
    PriorityQueue<Ticket> tickets = new PriorityQueue<>(10, ticketCompare);
    tickets.add(new Ticket("John", 70));
    tickets.add(new Ticket("Patrick", 50));
    tickets.add(new Ticket("John", 100));
    tickets.add(new Ticket("Max", 30));
    //John has the highest priority at 1000
    System.out.println(tickets.peek().name);
  }
}

class Ticket {
  //Name on ticket
  public String name;
  //Priority number
  public Integer priority;
  Ticket(String name, Integer priority){
    this.name = name;
    this.priority = priority;
  }
}

//Returns the highest priority
class TicketCompare implements Comparator<Ticket>{
  public int compare(Ticket t1, Ticket t2) {
    return t2.priority.compareTo(t1.priority);
  }
}
