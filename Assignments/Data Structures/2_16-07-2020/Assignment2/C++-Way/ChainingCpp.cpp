/*
Assignment 2 : 
	HashTable_Basic implementation does not handle collision. 
	Modify the implementation of "Bucket" to handle collision via Chaining. 
	Each Bucket will be implemented as a head node of a linked list. 
	Every time an element is to be stored in the bucket, we will add it as a new node at the beginning of the linked list.
*/

#include<iostream>
using namespace std;

struct Node
{
	int key;
	Node* next;
	};

class BucketList
{
	Node* head;
	public:
		BucketList():head(NULL){}
		
		bool find(int n)
		{
			Node* curr=head;

			while(curr!=NULL)
			{
				if(curr->key==n)
					return true;
				
				curr=curr->next;
				}
			return false;	
			}
		
		void addToList(int n)
		{
			if(find(n))
			{
				cout<<"Duplicate value: "<<n<<endl;
				return;
				}
			Node* newNode=new Node();
			newNode->key=n;
			newNode->next=head;

			head=newNode;
			}

			~BucketList()
			{
				Node* curr=head;
				while(curr!=NULL)
				{
					curr=curr->next; //To keep track of next node. 
					delete[] head;  // If we do this first the we lose track of the list.
					head=curr;
					}
				}
	};

class HashTable
{
	int size;
	BucketList* table;
		public:
			HashTable(int s):size(s)
			{
				table=new BucketList[size];
				}

			int HashTableFun(int n)
			{
				return n%size;
				}
			
			void add(int n)
			{
				int bucket=HashTableFun(n);
				table[bucket].addToList(n);
				}

			~HashTable()
			{
				delete[] table;
				}
	};

int main()
{
	cout<<"Enter a positive number, press 0 to exit"<<endl;
	int n;
	cin>>n;
	HashTable ht(100);

	while(n>0)
	{
		ht.add(n);
		cin>>n;
		}

	return 0;
	}
