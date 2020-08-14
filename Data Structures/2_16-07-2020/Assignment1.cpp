/*
Assignment 1 : Modify HashTable_Basic implementation to support for negative numbers to be stored in Hash Table.
*/

#include<iostream>
#include<cmath>
using namespace std;

const int Size=201; //-100 to 100

struct Bucket
{
	int key;
	bool isEmpty;
	};

Bucket HashTable[Size];

int HashTableFun(int n)
{
	if(n<0)
		return abs(n % Size);
	else
		return n % Size;
	}

int main()
{
	for(int i=0;i<Size;i++)
	{
		HashTable[i].isEmpty=true;
		}

while(1)
{
	cout<<"******Options**********"<<endl<<"1.Insert a number"<<endl<<"2.Exit"<<endl;
	int choice,bucket,n;
	cin>>choice;

	switch(choice)
	{
		case 1:
				{
					cout<<"Number: ";
					cin>>n;
					
					bucket=HashTableFun(n);

					if(HashTable[bucket].isEmpty==true)
					{
						HashTable[bucket].key=n;
						HashTable[bucket].isEmpty=false;
						}
					else
					{
						if(HashTable[bucket].key==n)
							cout<<"Number found at bucket: "<<bucket<<endl;
						else
							cout<<"Collision at bucket: "<<bucket<<endl;
						}
					}
				break;
		case 2:
				return 1;
		}
}
	return 0;
	}
