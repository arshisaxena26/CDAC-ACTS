/*
Q1. Implement the solution for the problem using Linked List approach. 
	In linked list, we will store a number, as we read from it (if it is not present in the list). 
	Every number we read from stream, we search in linked list to find if it is duplicate or not.
*/

#include<iostream>
using namespace std;

struct Node
{
	int data;
	Node* next;
	};

class LinkedList
{
	private:
		Node *head, *tail;
	public:
		LinkedList()
		{
			head=NULL;
			tail=NULL;
			}

	void checkNum(int n)
	{
		Node *curNode=head;
		bool flag=false;

		while(curNode!=NULL)
		{
			if(curNode->data==n)
			{
				cout<<"Duplicate Number: "<<n<<endl;
				flag=true;
				break;
				}				
			curNode=curNode->next;
			}

		if(flag==false)
			addNode(n);
		}

	void addNode(int n)
	{
		Node *tmp=new Node();
		tmp->data=n;
		tmp->next=NULL;

		if(head==NULL)
		{
			head=tmp;
			tail=tmp;
			}
		else
		{
			tail->next=tmp;
			tail=tail->next;
			}
		}
	
	void Display()
	{
		Node *curNode=head;
		while(curNode!=NULL)
		{
			cout<<curNode->data<<" ";
			curNode=curNode->next;
			}
		cout<<endl;	
		}

	};

int main()
{
	cout<<"Enter a number, enter 0 to exit"<<endl;
	int n;
	cin>>n;
	
	LinkedList obj;
	
	while(n!=0)
	{
		obj.checkNum(n);
		cin>>n;
		}
	obj.Display();	
	return 0;
	}
