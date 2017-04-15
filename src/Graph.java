import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Graph {

	public static NodeList<Integer> graph[];
	public static int SIZE;
	private static int edges,vertices;
	Stack<Integer> stack;
    int DFStime;

	Graph()
	{
		SIZE = 5;
		graph = new NodeList[SIZE];
		int i;
		for(i=0;i<SIZE;i++)
		{
			graph[i] = new NodeList<>();
		}
	}


	Graph(int num)
	{
		SIZE = num;
		graph = new NodeList[SIZE];
		int i;
		for(i=0;i<SIZE;i++)
		{
			graph[i] = new NodeList<>();
		}
	}

	void getSize(int num)
	{
		if(num > SIZE)
			graph = Arrays.copyOf(graph,num);
	}



	public void displayGraph()
	{

		int i = 0;
		System.out.println("Graph Adjacency List..");
		for(i=0;i<SIZE;i++)
		{

			System.out.print((i+1) + " ("+graph[i].colour+"),"+"\t"+" (Parent = "+(graph[i].parent+1)+"), (Distance from source = "+graph[i].d+") :--> ");
			graph[i].displayList();
		}
	}

	public void addEdge(int vertex, int edge)
	{

		if(vertex < 1 || vertex > SIZE)
		{
			System.out.println("Invalid Vertex input");
			return;
		}
		if(edge < 1 || edge > SIZE)
		{
			System.out.println("Invalid edge value ");
			return;
		}
		System.out.println("Adding edge "+edge+" to vertex "+vertex);
		graph[vertex-1].add(Integer.valueOf(edge-1));
	}

	public void inittitalizeDFS(int source) {
	    stack = new Stack<>();
        DFStime = 1;
		int i;
		for (i = 0; i < SIZE; i++) {
			if (i != (source - 1)) {
				graph[i].colour = "WHITE";

			}
			graph[i].parent = graph[i].d = 0;
		}
		int s = source - 1;
		graph[s].colour = "GRAY";
        graph[s].d = 1;


		stack.push(Integer.valueOf(s));

		DFS();
	}
    Scanner globalsc = new Scanner(System.in);

    public void DFS()
	{
	    //globalsc.nextLine();
        //displayGraph();
	    DFStime++;
		if(stack.isEmpty())
		{
			return;
		}
		int temp,size,v;

		temp = (int)stack.peek();
        //graph[temp].d = DFStime;
		size = graph[temp].getSize();

		if(size <= 0)
		{
		    graph[temp].colour = "BLACK";
			stack.pop();
			DFS();
		}
        Integer array[] = new Integer[size];
        graph[temp].toArray(array);
        graph[temp].colour = "GRAY";
        int i;
        for(i=0;i<size;i++)
        {
            v = (int)array[i];
            if(graph[v].colour == "WHITE")
            {
                graph[v].parent = temp;
                graph[v].colour = "GRAY";
                graph[v].d = DFStime;
                stack.push(Integer.valueOf(v));
                DFS();
            }

        }
        graph[temp].colour = "BLACK";
        if(stack.isEmpty()==false)
        stack.pop();
        DFS();
		//stack.pop(Integer.valueOf())




	}

	public void BFS(int source)
	{

		int i = 0;
		for(i=0;i<SIZE;i++)
		{
			if(i != (source-1))
			{
				graph[i].colour = "WHITE";
				graph[i].parent = graph[i].d = 0;
			}
		}

		int s = source-1;
		graph[s].colour = "GRAY";
		graph[s].parent = 0;
		graph[s].d = 0;
		int u,v,size;
		NodeList<Integer> queue = new NodeList<>();
		queue.add(Integer.valueOf(s));
		Scanner sc = new Scanner(System.in);
		while(queue.isEmpty() != true)
		{

			u = (int)queue.remove();
			size = graph[u].getSize();
			Integer array[] = new Integer[size];
			graph[u].toArray(array);
			for(i=0;i<size;i++)
			{
				//sc.nextLine();
				//displayGraph();
				v = (int)array[i];
				NodeList vNode = graph[v];
				if(vNode.colour == "WHITE")
				{
					vNode.colour = "GRAY";
					vNode.d = (graph[u].d) + 1;
					vNode.parent = u;
					graph[v] = vNode;
					queue.add(Integer.valueOf(v));
				}
			}
			graph[u].colour = "BLACK";
		}

	}




}
