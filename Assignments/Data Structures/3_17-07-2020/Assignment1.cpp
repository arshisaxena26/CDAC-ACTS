/*
Assignment 1 : Implement search/find functionality in Hash Table implementation using Chaining.
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

			void search(int n)
			{
				int bucket=HashTableFun(n);
				if(table[bucket].find(n))
					cout<<"Element Found at bucket: "<<bucket<<endl;
				else
					cout<<"Element not Found"<<endl;
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
	
	cout<<"Enter a element to search,press 0 to end"<<endl;
	cin>>n;

	while(n>0)
	{
		ht.search(n);
		cin>>n;
		}
	return 0;
	}
