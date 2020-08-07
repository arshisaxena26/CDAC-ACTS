/* Q7. Write a program to create two threads:
        a. First thread will print table of 2
        b. Second thread will print table of 3
        c. Main thread will wait for these thread to join

For Compilation type : gcc -pthread Assignment7.c		
*/

#include<pthread.h>
#include<stdio.h>

void *Table2(void *param);
void *Table3(void *param);

int main()
{
	pthread_t tid;
	
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	
	pthread_create(&tid, &attr, Table2, NULL);
	pthread_create(&tid, &attr, Table3, NULL);
	
	pthread_join(tid,NULL);
}

void *Table2(void *param)
{
	int i;
	for(i=1;i<=10;i++)
		printf("2 * %d = %d\n",i,2*i);
		
	printf("\n");	
	
	pthread_exit(0);
	}

void *Table3(void *param)
{
	int i;
	for(i=1;i<=10;i++)
		printf("3 * %d = %d\n",i,3*i);
		
	printf("\n");	
	
	pthread_exit(0);
	}
