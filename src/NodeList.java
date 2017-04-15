
public class NodeList<E> {

    private final int GREY = 1;
    private final int WHITE = 0;
    private final int BLACK = 2;

    protected String colour = "";
    protected int d = 0;
    protected int parent = 0;
    private Node start;
    private Node curr;
    private int size;

    public int getSize()
    {
        return size;
    }
    NodeList()
    {
        curr = start = null;
        size = 0;
    }

    public void add(E e)
    {
        Node<E> temp = new Node<E>();
        temp.data = e;
        temp.next = null;
        if(start == null)
        {
            start = temp;
            curr = temp;
            curr.next = null;
            size++;
            return;
        }
        curr.next = temp;
        curr = temp;
        size++;
        curr.next = null;

    }

    public E peek()
    {
        if(start == null)
            return null;
        Node<E> temp = start;
        return temp.data;
    }

    public E remove()
    {

        if(start == null)
        {
            return null;
        }

        Node tempNode=start;
        E tempData = (E) start.data;
        if(start == curr)
        {
            start = curr = null;
            size--;
            return tempData;
        }
        start = start.next;
        size--;
        return tempData;

        /*

        while(tempNode.next != curr)
        {
            tempNode = tempNode.next;

        }
        curr = tempNode;
        return tempData;
        */

    }

    boolean isEmpty()
    {
        if(start == null)
            return true;
        return false;
    }

    public void displayList()
    {
        if(start == null)
            return;
        Node tempNode = start;
        int tempValue;
        while(tempNode != null)
        {
            tempValue = (int)tempNode.data;
            System.out.print((tempValue+1) +"\t");
            tempNode = tempNode.next;
        }
        System.out.println();
    }


    public void toArray(E arr[])
    {
        Node temp = start;
        int i = 0;
        while(temp != null)
        {
            arr[i] = (E)temp.data;
            i++;
            temp = temp.next;
        }
    }




}
