1.Write a shell script to rename all files in the current directory with numeric continuous value
  (Warning: Do this in a personal folder. Don't use Home directory) 
  
2. Write a shell script to count words in the given file(pass filename as command line argument. Use wc command).
    If file is not there create it and ask for content of file then save it.

3.Write a script that print environment variable(Print $HOME,$PATH,$SHELL,$HISTORY,$LOGNAME,$TERM)

4.Write a shell script that continuously print the system load and free memory
  (Use free command for free memory and read file /proc/loadavg for system load).
    Print value after 5 sec(Use sleep command)

5.Write a menu driven file manager shell script(Create function for each operation.Use infinite loop):
  a) Create file
  b)Create directory
  c)Delete file
  d)Delete directory
  e)List content of current directory
  f)change directory
  g)cat file content
  h)add content to a file

6.Write a system monitor script to print load average of cpu(Use /proc/loadavg file. Print value continuously every 3 second)
  (If you want to replace current line value you can use the following syntax  echo -ne `command`\\r\\n. 
    Here \r carriage return will move cursor back and -n will not let it add newline)
    
