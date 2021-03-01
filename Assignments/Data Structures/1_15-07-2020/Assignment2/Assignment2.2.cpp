/*
Q2.Once #1 is implemented, try out the shared code. Change the type of array from "int" to "bool".
*/

#include <iostream>
using namespace std;

const int MAX_NUMBER=100;

int main()
{
	int numbers[MAX_NUMBER]={0};
	cout<<"Enter a number, enter 0 to end"<<endl;
	int n;
	cin>>n;

	while(n!=0)
	{
		if(numbers[n-1]!=0)
			cout<<"Duplicate number: "<<n<<endl;
		else
			numbers[n-1]=n;
	
		cin>>n;
		}
	cout<<"Unique numbers are:"<<endl;
	for(int i=0;i<MAX_NUMBER;i++)
	{
		if(numbers[i]!=0)
			cout<<numbers[i]<<" ";
		}
	cout<<endl;	
	return 0;	
	}
