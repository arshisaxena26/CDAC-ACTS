/* Q7. Write a program to create two threads:
        a. First thread will print table of 2
        b. Second thread will print table of 3
        c. Main thread will wait for these thread to join

For Compilation type : gcc -pthread Assignment7.c		
*/

#include<pthread.h>
#include<stdio.h>
#include<errno.h>
#include <semaphore.h>

void *Table2(void *param);
void *Table3(void *param);
sem_t s,s1;

int main()
{
	pthread_t tid2;
	pthread_t tid3;
	
	sem_init(&s,0,0);
	sem_init(&s1,0,0);
	
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	
	pthread_create(&tid2, &attr, Table2, NULL);
	pthread_create(&tid3, &attr, Table3, NULL);
	
	pthread_join(tid2,NULL);
	pthread_join(tid3,NULL);
	
	sem_destroy(&s);
	sem_destroy(&s1);
}

void *Table2(void *param)
{
	int i;
	for(i=1;i<=10;i++)
	{
		printf("2 * %d = %d\n",i,2*i);
		}
	printf("\n");
	
	sem_post(&s);
	
	pthread_exit(0);
	}

void *Table3(void *param)
{
	int i;
	sem_wait(&s);
	for(i=1;i<=10;i++)
	{
		sem_post(&s1);
		printf("3 * %d = %d\n",i,3*i);
		}
	printf("\n");	
	
	pthread_exit(0);
	}
