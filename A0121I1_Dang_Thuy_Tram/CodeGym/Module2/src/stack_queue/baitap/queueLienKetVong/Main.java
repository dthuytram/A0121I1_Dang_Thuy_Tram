package stack_queue.baitap.queueLienKetVong;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enQueue(14);
        queue.enQueue(22);
        queue.enQueue(-6);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(9);
        queue.enQueue(20);

        System.out.print("Queue: ");
        queue.displayQueue();

        System.out.println("Dequeue: " + queue.deQueue());

        System.out.print("Queue after dequeue: ");
        queue.displayQueue();

    }

}
