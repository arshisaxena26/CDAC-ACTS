/* Q2. Write a program to copy your name,prn,phone no from one process to another process using
    named pipe. (copy from parent process  to child process)
*/


#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

typedef struct info{
	char name[50];
	char prn[11];
	char phone[10];
}info;


void get_data(int fo,void* buf){
   	read(fo,buf,sizeof(info));
   	
   	
}

void write_line(int fd,void* data){
	write(fd,data,sizeof(info));
   	write(fd,"\n",1);
   	
}

int main()
{
	pid_t pid;
    int res;
      
    res = mkfifo("myfifo" , O_CREAT | 0777);
    
	if(res < 0)
    {
        printf("Failed to create pipe");
        return -2;
    }

	pid = fork();

	if (pid < 0)
	{
		return -1; // fork failed
	}

	if (pid == 0) //child
	{
    	int fo = open("myfifo",O_RDONLY);
    
    	char name1[50],prn1[11],phone1[10];

   		info buf;

   		get_data(fo,&buf);
		
		printf("\nDisplaying Data Received from Parent Process\n");
   		printf("%s\n",buf.name);
   		printf("%s\n",buf.prn);
   		printf("%s\n",buf.phone);
    
		close(fo);
	}

	else //parent
	{		
		char name2[50],prn2[11],phone2[10];

    	int fd = open("myfifo", O_WRONLY | O_APPEND);
   	
		info details;
		
		printf("Enter Name,PRN and Phone Number\n");
		scanf("%s%s%s",details.name,details.prn,details.phone);
  	
  		write_line(fd,&details);
  	
    	close(fd);
	}

	return 0;
}
