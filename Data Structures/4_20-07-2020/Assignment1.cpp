/*
Assignment 1
Implement AdjList class to store undirected graph as adjacency list.
Implement the two class and member functions (addEdge, print) 
*/

#include<iostream>
using namespace std;

class AdjList
{
	struct Node
	{
		int ver;
		int weight;
		Node* next;

		Node(int u, int w, Node* n):ver(u),weight(w),next(n){}
		};

	Node** adjLists;
	int adjVert;
	public:
	AdjList(int v):adjVert(v)
	{
		adjLists= new Node*[adjVert];
		for(int i=0;i<adjVert;i++)
		{
			adjLists[i]=NULL;
			}
		}

	void addEdge(int v,int u,int w=1)
	{
		Node* temp1=new Node(v,w,adjLists[u-1]);
		adjLists[u-1]=temp1;

		Node* temp2=new Node(u,w,adjLists[v-1]);
		adjLists[v-1]=temp2;
		}

	void print()
	{
		for(int i=0;i<adjVert;i++)
		{
			cout<<i+1<<" - ";

			for(Node* curr=adjLists[i]; curr!=0; curr=curr->next)
			{
				cout<<(curr->ver)<<" ";
				}
			cout<<endl;	
		}

		cout<<endl;
		}

		~AdjList()
		{
			for(int i=0;i<adjVert;i++)
			{
				Node* curr=adjLists[i];
				while(curr!=NULL)
				{
					Node* t=curr;
					curr=curr->next;
					delete[] t;
					}
				}
				delete[] adjLists;
			}
	};
int main()
{
	int v=5;
	AdjList al(v);

	al.addEdge(1,2);
	al.addEdge(2,3);
	al.addEdge(3,4);
	al.addEdge(4,5);
	al.addEdge(5,1);
	al.addEdge(2,4);
	al.addEdge(2,5);

	al.print();
	return 0;
	}
