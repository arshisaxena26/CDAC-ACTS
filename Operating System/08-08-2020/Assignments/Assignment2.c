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

#define T_Num 2

void *printTable(void *param);
sem_t s1;

int main()
{
	int num_array[]={2,3};
	
	pthread_t tid[T_Num];
	sem_init(&s1,0,1);
		
	int i;
	for(i=0;i<T_Num;i++)
	{	
		pthread_create(&tid[i], NULL, printTable,&num_array[i]);
//		sleep(1);
		}

	for(i=0;i<T_Num;i++)	
		pthread_join(tid[i],NULL);

	sem_destroy(&s1);
}

void *printTable(void *param)
{
	int i;
	int *num=(int*)param;


	for(i=1;i<=10;i++)
	{
		sem_wait(&s1);
		printf("%d * %d = %d\n",*num,i,((*num)*i));
		sem_post(&s1);
		}
	
	printf("\n");
	pthread_exit(0);
	}

