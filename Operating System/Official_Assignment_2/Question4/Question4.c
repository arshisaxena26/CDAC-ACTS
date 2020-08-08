/* Q4. Write a program to implement named pipe (4Marks)
		a) Pass stream of numbers from parent to child(Pass numbers from 1 to 5)
		b) Child should print the numbers on terminal
		c) Use exec to create directory ‘data’ at current location after receiving numbers
*/

#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main()
{
	pid_t pid;

	int ret = mkfifo("mypipe", O_CREAT | 0666);

	if (ret < 0)
	{
		printf("mkfifo command failed\n");
		return -2;
	}

	pid = fork();

	if (pid < 0)
	{
		return -1; // fork failed
	}

	if (pid > 0) //parent
	{
		int num1[]={1,2,3,4,5};
	 	
		int fd = open("mypipe", O_WRONLY);
		
		write(fd, num1, sizeof(num1));
		
		close(fd);

		}
	
	else //child
	{
		int num[5];

		int fd = open("mypipe", O_RDONLY);
		read(fd, num, sizeof(num));
		
		int i;
		printf("Child Process Printing Numbers: ");
		
		for(i=0;i<5;i++)
			printf("%d ", num[i]);
		
		printf("\n");
		close(fd);
		
		execl("data.sh", "data", NULL); //execl() will load data.sh
		}

	}

