/*
Assignment 2 : Implement search/find functionality in Hash Table implementation using Linear Probing.
*/

#include<iostream>
using namespace std;

struct Bucket
{
	int key;
	bool isEmpty;

	Bucket():isEmpty(true){}
	};

class HashTable
{
	int size;
	Bucket* table;
	public:
	HashTable(int s):size(s)
	{
		table=new Bucket[size];
		}

	int HashTableFun(int n)
	{
		return n%size;
		}

	int ProbeNext(int bucket)
	{
		return (bucket+1)%size;
		}

	void add(int n)
	{
		int bucket=HashTableFun(n);
		
		if(table[bucket].isEmpty==true)
		{
			table[bucket].key=n;
			table[bucket].isEmpty=false;
			}
		else
		{
			if(table[bucket].key==n)
				cout<<"Duplicate element: "<<n<<endl;
			else
				{
					bool done=false;
					do
					{
						bucket=ProbeNext(bucket);

						 if(table[bucket].isEmpty==true)
						{
							table[bucket].key=n;
							table[bucket].isEmpty=false;
							done=true;
							}
						else 
						{	
							if(table[bucket].key==n)
								cout<<"Duplicate element: "<<n<<endl;
						}

						}while(!done);
					}
			}
		}

		void search(int n)
		{
			int bucket=HashTableFun(n);

			if(table[bucket].key==n)
			{
				cout<<"Element Found at bucket: "<<bucket<<endl;
				return;
				}
			bool done=false;	
			do
			{
				bucket=ProbeNext(n);

				if(table[bucket].key==n)
				{
					cout<<"Element Found at bucket: "<<bucket<<endl;
					done=true;
					}
				else 
				{	
					if(table[bucket].isEmpty==true)
					{
						cout<<"Element not found"<<endl;
						done=true;
						return;
						}
				}
					
				}while(!done);
			}

	~HashTable()
	{
		delete[] table;
		}
		
	
	};

int main()
{
	cout<<"Enter a positive number"<<endl;
	int n;
	cin>>n;
	HashTable ht(100);

	while(n>=0)
	{
		ht.add(n);
		cin>>n;
		}
	cout<<"Enter a element to search,press -1 to end"<<endl;
	cin>>n;

	while(n>=0)
	{
		ht.search(n);
		cin>>n;
		}
	return 0;
	}
