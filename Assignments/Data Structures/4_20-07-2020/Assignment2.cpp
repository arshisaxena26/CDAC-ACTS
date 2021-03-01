/*
Assignment 2
Implement DirectedAdjMatrix class to store directed graph as adjacency matrix.

Implement the two class and member functions (addEdge, print)
*/

#include<iostream>
using namespace std;

class DirectedAdjMatrix
{
	int adjVertices;
	int** matrix;
	public:
	DirectedAdjMatrix(int v):adjVertices(v)
	{
		matrix=new int*[adjVertices];
	
		for(int i=0;i<adjVertices;i++)
		{
			matrix[i]=new int[adjVertices];
		
			for(int j=0;j<adjVertices;j++)
			{
				matrix[i][j]=0;
				}
			}
		}
		
		~DirectedAdjMatrix()
		{
			for(int i=0;i<adjVertices;i++)
			{
				delete[] matrix[i];
				}
			delete[] matrix;	
			}
		
		void addEdge(int v, int u, int w=1)
		{
			matrix[v-1][u-1]=w;
			}
		
		void print()
		{
			for(int i=0;i<adjVertices;i++)
			{
				for(int j=0;j<adjVertices;j++)
				{
					cout<<matrix[i][j]<<" ";
					}
				cout<<endl;	
			}
			cout<<endl;
		}	

	};

int main()
{
	int v=6;
	DirectedAdjMatrix dam(v);

	dam.addEdge(1,2);
	dam.addEdge(1,4);
	dam.addEdge(2,5);
	dam.addEdge(3,5);
	dam.addEdge(3,6);
	dam.addEdge(4,2);
	dam.addEdge(5,4);
	dam.addEdge(6,6);
	
	dam.print();
	return 0;
	}
