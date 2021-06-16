package p11_stack_queue.baitap.queueLienKetVong;

/**
 * Link tham khảo " Circular Linked List"
 * https://tutorialspoint.dev/data-structure/queue-data-structure/circular-queue-set-2-circular-linked-list-implementation
 * https://www.geeksforgeeks.org/circular-queue-set-2-circular-linked-list-implementation/
 */
public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;  // được đưa vào đầu tiên
        this.rear = null;  // phần tử được đưa vào cuối của queue
    }


    /**
     * Giải thích enqueue
     *
     * " enQueue ":  là hàm thực hiện chèn 1 phần tử. Trong hàng đợi liên kết vòng , luôn được chèn vào vị trí Rear.Thao tác chèn sẽ gồm các bước sau:
     *
     * B1: Tạo node mới, thêm giá trị vào node
     *
     * B2: Kiểm tra hàng đợi trống hay không. Nếu true thì front = rear = node vừa tạo, nếu false rear = node vừa tạo, và node rear luôn chứa địa chỉ của node front
     *
     * @param data
     */
    public void enQueue(int data) {
        Node newNode = new Node(data);
        /** Giải thích dòng [ Node newNode = new Node(data); ]
            Thay vì khởi tạo data cho newNode như dòng sau:   [ newNode.data = data;]
            Se tao contructor trong Node :
                     public Node(int data) {
                     this.data = data;
                     this.link = null;
                    }
        **/
        if (front == null)
            front = newNode;
        else
            rear.link = newNode;

        rear = newNode;
        rear.link = front;
    }

    /**
     * Giải thích phương thức dequeue
     *
     * " deQueue " : là hàm thực hiện lấy ra 1 phần tử.Trong hàng đợi liên kết vòng, luôn lấy ra vị trị Front.
     *
     * B1: Kiểm tra hàng đợi trống hay không (có nghĩa Front == null)
     *
     * B2: Nếu trống, thì trả về kết quả null, nếu không thực hiện B3
     *
     * B3: Kiểm tra Front == Rear hay không. Nếu true gán Front = Rear = null, nếu không gán Front vào node liền sau, trỏ địa chỉ Front trong node Rear tới node Front mới trỏ.
     *
     *
     * @return
     */
    // Function to delete element from Circular Queue
    public int deQueue()
    {
        if (front == null) {
            System.out.printf("Queue is empty");
            return Integer.MIN_VALUE;
        }

        // If this is the last node to be deleted
        Node newNode = front; // Mặc định newNode là front để xóa
        if (front == rear) {
            front = rear = null;
        }
        else // There are more than one nodes
        {
            front = front.link;
            rear.link = front;
            /**
             * [1]: Front vào node liền sau
             * [2]: Trỏ địa chỉ Front trong node Rear tới node Front mới trỏ.
             */
        }

        return newNode.data;
    }

    // Function displaying the elements of Circular Queue
    public void displayQueue()
    {
        Node newNode = front;
        System.out.printf("\nElements in Circular Queue are: ");
        while (newNode.link != front) {
            System.out.printf("\n%d ", newNode.data);
            newNode = newNode.link;
        }
        System.out.printf("%d", newNode.data);
    }

}


