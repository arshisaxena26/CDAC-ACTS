/*   Q1. Create 5 children processes from a common parent and ensure that the parent terminates after cleaning all the terminated children using waitpid().

The waitpid() must be called after all the children are created and the parent has completed its work real work,if any. 

You must interpret the exit code of the cleaned-up processes, using waitpid(), in parent process– you must cover all the possible scenarios !!!
*/

#include<stdio.h>
#include<unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
	pid_t pid[5];
	
	int wstatus,i,flag=0;
	
	for(i=0;i<5;i++)
	{
		pid[i]=fork();

		int a= 10;
		
		if(pid[i]<0){
			printf("Process creation failed\n");
		}
		
		if(pid[i]==0)
		{
			printf("this is child %d\n",i+1);
			flag=0;
			sleep(1);
			break;
		}

		if(pid[i]>0)
		{
			flag=1;

		}
	}

	if(flag==1)
		printf("this is parent\n");
	

	 waitpid(-1,&wstatus,0);

     if(wstatus==WEXITED)
		 printf("Wait for children that have terminated\n");
                
		if(WIFEXITED(wstatus))
			printf("Child exited normally\n");
}


