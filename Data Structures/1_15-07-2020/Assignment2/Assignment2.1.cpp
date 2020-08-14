/*
Q2. Once #1 is implemented, try out the shared code. Change the type of array from "int" to "bool".
*/

#include<iostream>
using namespace std;

const int MAX_NUMBER=100;

int main()
{
	bool numbers[MAX_NUMBER]={false};
	int n;
	cout<<"Enter a number, enter 0 to exit"<<endl;
	cin>>n;

	while(n!=0)
	{
		if(numbers[n-1]!=false)
			cout<<"Duplicate number: "<<n<<endl;
		else
			numbers[n-1]=true;

		cin>>n;	
	}

	cout<<"Unique Numbers entered are:"<<endl;
	for(int i=0;i<MAX_NUMBER;i++)
	{
		if(numbers[i]!=false)
			cout<<i+1<<" ";
		}
	cout<<endl;	
return 0;	
}

