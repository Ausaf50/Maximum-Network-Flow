
public class MyProg {

    public static void start(String args[])
    {

        System.out.println("Graph : ");
        Graph mygraph = new Graph(5);
        mygraph.addEdge(1,2);
        mygraph.addEdge(1,4);
        mygraph.addEdge(1,3);
        mygraph.addEdge(2,5);
        //mygraph.addEdge(3,6);
        mygraph.addEdge(3,5);
        mygraph.addEdge(4,2);
        //mygraph.addEdge(5,4);


        mygraph.displayGraph();
        System.out.println("\nAfter BFS : ");
        mygraph.BFS(1);
        //System.out.println("\n");
        mygraph.displayGraph();
        System.out.println("\nAfter DFS : ");
        mygraph.inittitalizeDFS(1);
        System.out.println("");
        mygraph.displayGraph();
    }


}
