/*
Q3. Try implementing the array as bit map,instead of array of "int" or "bool".
*/
#include<iostream>
using namespace std;

int main()
{
	unsigned char data[13]={0};
	int n;
	unsigned char masks[]={0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80};

	cout<<"Enter number between 1-100,press 0 to exit"<<endl;
	cin>>n;

	while(n!=0)
	{
		if(n<0 || n>100)
			cout<<"Number not in range: "<<n<<endl;
		else if( (data[n/10]) & masks[(n%10)-1])
			cout<<"Duplicate number: "<<n<<endl;
		else
			data[n/10]=data[n/10] | masks[(n%10)-1];

		cin>>n;
		}
	return 0;
	}
