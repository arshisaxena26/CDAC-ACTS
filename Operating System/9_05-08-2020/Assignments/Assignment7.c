/* Q7. Write a program to create two threads:
        a. First thread will print table of 2
        b. Second thread will print table of 3
        c. Main thread will wait for these thread to join

For Compilation type : gcc -pthread Assignment7.c		
*/

//-------------------METHOD 1----------------------

#include<pthread.h>
#include<stdio.h>

void *Table2(void *param);
void *Table3(void *param);

int main()
{
	pthread_t tid2;
	pthread_t tid3;
	
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	
	pthread_create(&tid2, &attr, Table2, NULL);
	pthread_create(&tid3, &attr, Table3, NULL);
	
	pthread_join(tid2,NULL);
	pthread_join(tid3,NULL);
}

void *Table2(void *param)
{
	int i;
	for(i=1;i<=10;i++)
		printf("2 * %d = %d\n",i,2*i);
		
	printf("\n");	
	sleep(1);
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

//-------------------METHOD 2----------------------
//Removing Redundant Code

#include<pthread.h>
#include<stdio.h>

#define T_Num 2

void *printTable(void *param);

int main()
{
	int num_array[]={2,3};
	
	pthread_t tid[T_Num];
	
	int i;
	for(i=0;i<T_Num;i++)
		pthread_create(&tid[i], NULL, printTable,&num_array[i]);

	for(i=0;i<T_Num;i++)
	{	
		pthread_join(tid[i],NULL);
		sleep(1);
	}
}

void *printTable(void *param)
{
	int i;
	int *num=(int*)param;
	
	for(i=1;i<=10;i++)
		printf("%d * %d = %d\n",*num,i,((*num)*i));
	
	printf("\n");
	
	pthread_exit(0);
	}



