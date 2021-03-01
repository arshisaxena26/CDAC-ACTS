/*
Assignment 2 : 
	HashTable_Basic implementation does not handle collision. 
	Modify the implementation of "Bucket" to handle collision via Chaining. 
	Each Bucket will be implemented as a head node of a linked list. 
	Every time an element is to be stored in the bucket, we will add it as a new node at the beginning of the linked list.
*/

#include<iostream>
using namespace std;

const int SIZE=100;

struct Node
{
	int key;
	Node* next;
	};

struct Bucket
{
	Node* head;
	};

Bucket HashTable[SIZE];

int HashTableFun(int n)
{
	return n%SIZE;
	}

bool find(Node* head, int n)
{
	Node* current=head;

	while(current!=NULL)
	{
		if(current->key==n)
			return true;
		
		current=current->next;
		}
	return false;
	}

void addToList(Node* &head,int n)
{
	if(find(head,n))
	{
		cout<<"Duplicate value: "<<n<<endl;
		return;
	}	
		Node* newNode= new Node();
		newNode->key=n;
		newNode->next=head;

		head=newNode;
	}

int main()
{
	cout<<"Enter a positive number,press 0 to exit"<<endl;
	int n,bucket;
	cin>>n;

	for(int i=0;i<SIZE;i++)
	{
		HashTable[i].head=NULL;
		}

	while(n>0)
	{
		bucket=HashTableFun(n);

		addToList(HashTable[bucket].head,n);
		cin>>n;
		}
	return 0;
	}
