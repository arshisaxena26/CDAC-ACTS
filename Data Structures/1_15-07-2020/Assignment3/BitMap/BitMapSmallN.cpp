/*
Q3. Try implementing the array as bit map,instead of array of "int" or "bool".
*/

#include<iostream>
using namespace std;

int main()
{
	unsigned char data=0;
	int n;
	cout<<"Enter a number in the range 1-8, press 0 to exit"<<endl;
	cin>>n;

	unsigned char masks[]={0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80};

	while(n!=0) //n=3
	{
		if(n>8 || n<0)
			cout<<"Number not in range: "<<n<<endl;
		else if(data & masks[n-1]) //n-1=2 //0000 0100
			cout<<"Duplicate Number: "<<n<<endl;
		else
			data=data|masks[n-1];
		
		cin>>n;
		}	
return 0;		
	}
