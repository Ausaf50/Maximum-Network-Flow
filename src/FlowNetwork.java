
public class FlowNetwork {

    public static NodeList<Integer> network[];
    int SIZE;


    FlowNetwork()
    {
        SIZE = 5;
        network = new NodeList[SIZE];
        int i;
        for(i=0;i<SIZE;i++)
        {
            network[i] = new NodeList<>();
        }
    }

    FlowNetwork(int size)
    {
        SIZE = size;
        network = new NodeList[SIZE];
        int i;
        for(i=0;i<SIZE;i++)
        {
            network[i] = new NodeList<>();
        }
    }


}
