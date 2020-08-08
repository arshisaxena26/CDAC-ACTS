
1.Create directory of your name and then create 4 files inside it named
  a.txt, b.txt, c.txt and d.sh. And change the directory permission to
  only user and also files permission to only user such that

    • mkdir arshi
    • touch arshi/a.txt arshi/b.txt arshi/c.txt arshi/d.sh
    • chmod 700 arshi

    	a)user can read and write the file a.txt and b.txt

    • chmod 600 arshi/a.txt arshi/b.txt

    	b)user can write the file c.txt

    • chmod 200 arshi/c.txt

    	c)user can exectuable the file d.sh.

    • chmod 100 arshi/d.sh

Make Contents of file d.sh:
            	#/bin/sh
            	ls -lh

    • vi d.sh
    • try to save: Permission denied

2.Change the permission of the previous directory to executable only.
   Analyze the output.

    • chmod 100 arshi
    • cd arshi : works
    • ls -l : doesn’t work

3.Change the permission of the previous directory to read only.	
 Analyze the output.

        ◦ chmod 400 arshi
        ◦ cd arshi : Permission denied
        ◦ cat arshi/a.txt :Permission denied
        ◦ ls -l : works

4.Use echo to list the all files of your home directory.

    • cd ~
    • echo *

5.Use echo to list the all files of /etc/ directory

    • cd /etc
    • echo *

6.Use echo to list the all files of /etc/ directory with extension name .conf

    • cd /etc
    • echo *.conf

7.Use echo to append your name to a.txt

    • echo arshi >> a.txt

8.Use echo to list the files of /proc/

    • cd /proc
    • echo *


