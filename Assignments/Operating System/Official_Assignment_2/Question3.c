/* Q3. Write a program to start two threads: (3Marks)
		a) First thread should store elements in the global array (Take integer input from user)	
		b) Second thread should print the whole array in single line(Use sleep to stop this thread for few seconds)
*/

#include<stdio.h>
#include<pthread.h>

#define NUM 5
#define Threads 2

void *storeNprint(void *arg);

int gArray[NUM];

pthread_mutex_t lock;

int main()
{
	pthread_t tid[Threads];
	
	pthread_mutex_init(&lock, NULL);

	int i;
	int sig[]={1,2};

	for(i=0;i<Threads;i++)
		pthread_create(&tid[i],NULL,storeNprint,&sig[i]);

	for(i=0;i<Threads;i++)
		pthread_join(tid[i],NULL);

	pthread_mutex_destroy(&lock);

	}

void *storeNprint(void *arg)
{
	pthread_mutex_lock(&lock);
	int *sig=(int*)arg;

	if(*sig==1)
	{
		printf("Enter %d Numbers\n",NUM);
	
		int i;
		for(i=0;i<NUM;i++)
			scanf("%d",&gArray[i]);
		}
	
	else
	{

		printf("Elements in Array are\n");
		
		int i;
		for(i=0;i<NUM;i++)
			printf("%d ",gArray[i]);
		
		printf("\n");
			}
		pthread_mutex_unlock(&lock);
		pthread_exit(0);
	}


