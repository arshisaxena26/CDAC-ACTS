/*
Q3. Try implementing the array as bit map,instead of array of "int" or "bool".
*/

#include<iostream>
#include<bitset>
using namespace std;

const int MAX_NUMBER=100;

int main()
{
	bitset<MAX_NUMBER> numbers;
	int n;
	cout<<"Enter a number,enter 0 to exit"<<endl;
	cin>>n;

	while(n!=0)
	{
		if(numbers[n-1]!=0)
			cout<<"Duplicate number: "<<n<<endl;
		else
			numbers[n-1]=1;

		cin>>n;	
		}
	cout<<"Unique numbers are:"<<endl;
	for(int i=0;i<MAX_NUMBER;i++)
	{
		if(numbers[i]!=0)
			cout<<i+1<<" ";
		}
	cout<<endl;	
return 0;
	}
