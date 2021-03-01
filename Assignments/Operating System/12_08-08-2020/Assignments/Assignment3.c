/* Q8. Write a program to create three threads(One main thread ,other two threads):
        a. Create a global variable ‘count’
        b. Increment ‘count variable in two threads inside loops
        c. Analyze the behaviour(Try Large number if Iterations in threads)
	d. Implement mutex
*/

#include<pthread.h>
#include<stdio.h>

int count=0;
pthread_mutex_t lock;

void* countInc(void* arg);

int main()
{
	int i,ThreadNum=2;

	pthread_t threads[ThreadNum];

	pthread_mutex_init(&lock, NULL);

	for(i=0;i<ThreadNum;i++)
		pthread_create(&threads[i],NULL,countInc,NULL);

	for(i=0;i<ThreadNum;i++)
		pthread_join(threads[i],NULL);

	printf("Total Count is: %d\n",count);
	
	pthread_mutex_destroy(&lock);

	}

void* countInc(void* arg)
{
	pthread_mutex_lock(&lock);

	int i;

	for(i=0;i<10000;i++)
		count++;

	pthread_mutex_unlock(&lock);
	
	pthread_exit(0);
	}

