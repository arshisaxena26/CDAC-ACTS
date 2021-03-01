#include <iostream>
#include <queue>

using namespace std;

class DirectedAdjList {
	struct Node {
		int weight;
		int adjNode;
		struct Node* next;

		Node(int u, int w, Node* n) : adjNode(u), weight(w), next(n) {}
	};

	Node** adjLists;
	int vertexCount;

public:
	DirectedAdjList(int v) : vertexCount(v) {
		adjLists = new Node * [vertexCount];
		for (int i = 0; i < vertexCount; ++i) {
			adjLists[i] = NULL;
		}
	}

	~DirectedAdjList() {
		for (int i = 0; i < vertexCount; ++i) {
			Node* curr = adjLists[i];
			while (curr != NULL) {
				Node* t = curr;
				curr = curr->next;
				delete t;
			}
		}
		delete[] adjLists;
	}

	void addEdge(int u, int v, int w = 1) {
		Node* temp = new Node(v - 1, w, adjLists[u - 1]);
		adjLists[u - 1] = temp;
	}

	void print() {
		for (int i = 0; i < vertexCount; ++i) {
			cout << (i + 1) << " - ";

			for (Node* curr = adjLists[i]; curr != NULL; curr = curr->next) {
				cout << (curr->adjNode + 1) << " ";
			}
			cout <<endl;
		}
	}

	void printDFS(int startVertex)
	{
		bool* isVisited;
		isVisited=new bool[vertexCount];

		for(int i=0;i<vertexCount;i++)
			isVisited[i]=false;
		
		printDFSHelper(startVertex-1,isVisited);
		cout<<endl;
		}

	void printDFSHelper(int startVertex, bool isVisited[])
	{
		if(isVisited[startVertex])
			return;
		

		cout<<startVertex+1<<" ";
		isVisited[startVertex]=true;
		
		Node* temp=adjLists[startVertex];
		while(temp!=NULL)
		{
			printDFSHelper((temp->adjNode),isVisited);
			temp=temp->next;
			}
	}

		void printBFS(int startVertex)
		{
			bool* isVisited;
			isVisited=new bool[vertexCount];

			for(int i=0;i<vertexCount;i++)
				isVisited[i]=false;

			queue<int> q;
			q.push(startVertex);

			while(!q.empty())
			{
				int v=q.front();
				q.pop();

				if(isVisited[v])
					continue;

				cout<<v<<" ";
				isVisited[v]=true;

				Node* temp=adjLists[v-1];
				while(temp!=NULL)
				{
					q.push(temp->adjNode+1);
					temp=temp->next;
					}
				}
				cout<<endl;	
			}
};

int main() {
	int v = 6;
	DirectedAdjList adjList(v);

	adjList.addEdge(1, 4);
	adjList.addEdge(1, 2);
	adjList.addEdge(2, 5);
	adjList.addEdge(3, 5); 
	adjList.addEdge(3, 6);
	adjList.addEdge(4, 2);
	adjList.addEdge(5, 4);
	adjList.addEdge(6, 6);
	
	adjList.print();

	adjList.printDFS(1);

	adjList.printBFS(1);
	return 0;
}
