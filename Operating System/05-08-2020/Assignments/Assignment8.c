/* Q8. Write a program to create three threads(One main thread ,other two threads):
        a. Create a global variable ‘count’
        b. Increment ‘count variable in two threads inside loops
        c. Analyze the behaviour(Try Large number if Iterations in threads)
*/

#include<pthread.h>
#include<stdio.h>

int count=0;

void* countInc(void* arg);

int main
{
	int i,ThreadNum=2;

	pthread_t threads[ThreadNum];

	for(i=0;i<ThreadNum;i++)
		pthread_create(&threads[i],NULL,countInc,NULL);

	for(i=0;i<ThreadNum;i++)
		pthread_join(threads[i],NULL);

	printf("Total Count is: %d\n",count);
	}

void* countInc(void* arg)
{
	int i;

	for(i=0;i<10000;i++)
		count++;

	pthread_exit(0);
	}
