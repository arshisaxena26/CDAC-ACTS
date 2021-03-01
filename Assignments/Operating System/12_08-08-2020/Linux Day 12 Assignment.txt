
1. Write a program and do the following :using sigaction API, handle SIGINT, SIGTERM, SIGQUIT,SIGSTOP,SIGTSTP and SIGKILL. Install dummy handlers for the mentioned signals Using sigaction() system call API !!!

2. Write a program to implement an unnamed semaphore on Day9 -7th question.

3. Write a program to implement mutex on Day9-8th question.



Optional:
1.Run the firefox with highest priority.
    • nice -n -20 firefox

2. Run the firefox with lowest priority.
    • renice -n +19 firefox

3. Change the running firefox process priority to 10
    • renice -n +10 firefox

4.Use Grep to find all lines in the current directory starts with ‘a’.
    • ls | grep ^a

5.Use grep to find out all lines starts with ‘a’ and have numbers at second place and ends with txt
    • ls | grep ^a[0-9]*.txt 

6.Use grep to find out all lines start with ‘aaa’ and can’t have numbers in between.
    • ls | grep ^aaa

7.Write a program to create two threads:
	a)Read data from file(Display newly added data on terminal)
	b)Write data to file(Read data from user)
	c)Do this without semaphore first(Analyze the output)
	d)Implement semaphore(Analyze the output)
	e)Now Copy the code and implement mutex(Analyze the output)(Takeout the semaphore  code)
