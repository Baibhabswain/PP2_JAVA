package chapter13;
class stckx
{
	private final int SIZE = 20;
	private int[] st;
	private int top;
	public stckx()
	{
		st = new int[SIZE];
		top = -1;
	}
	public void push(int j)
	{ st[++top] = j; }
	public int pop()
	{ return st[top--]; }
	public int peek()
	{ return st[top]; }
	public boolean isEmpty() { return (top == -1); }
} 
class Ver
{
	public char label;
	public boolean Visited;
	public Ver(char lab)
	{
		label = lab;
		Visited = false;
	}
} 

class Gr
{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; 	
	private int adjMat[][];
	private int nVerts;
	private StackX theStack;
	
	public Gr()
	{
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++)
			for(int k=0; k<MAX_VERTS; k++)
				adjMat[j][k] = 0;
		theStack = new StackX();
	} 	
	public void addVertex(char lab)
	{
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}

	public void mst()
	{
		vertexList[0].visited = true;
		theStack.push(0);
		while( !theStack.isEmpty() )
		{
			int currentVertex = theStack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if(v == -1)
				theStack.pop();
			else
			{
				vertexList[v].visited = true; 			
				theStack.push(v);
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.print(" ");
			}
		} 
		for(int j=0; j<nVerts; j++)
			vertexList[j].visited = false;
	}
	
	public int getAdjUnvisitedVertex(int v)
	{
		for(int j=0; j<nVerts; j++)
			if(adjMat[v][j]==1 && vertexList[j].visited==false)
				return j;
		return -1;
	}
}

public class MST_NEW {

	public static void main(String args[])
	{
		Gr gr = new Gr();
		gr.addVertex('A');
		gr.addVertex('B');
		gr.addVertex('C');
		gr.addVertex('D');
		gr.addVertex('E');
		gr.addEdge(0, 1);
		gr.addEdge(0, 2);
		gr.addEdge(0, 3);
		gr.addEdge(0, 4);
		gr.addEdge(1, 2);
		gr.addEdge(1, 3);
		gr.addEdge(1, 4);
		gr.addEdge(2, 3);
		gr.addEdge(2, 4);
		gr.addEdge(3, 4);
		System.out.print("Minimum spanning tree: ");
		gr.mst();
		System.out.println();
	}
}

