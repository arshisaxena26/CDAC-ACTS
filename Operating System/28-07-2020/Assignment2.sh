Note:Many operation might not work.Analyze them
1. Create Three level nested directory a,b and c

            ▪ mkdir -p a/b/c

	a)Create at least one hidden file in each directory

	    • touch a/.a.txt a/b/.b.txt a/b/c/.c.txt
	
	b)Create at least one normal text file in each directory
	
	    • touch a/a.txt a/b/b.txt a/b/c/c.txt

	c)Copy c into a

	    • cp -r a/b/c a/

	d)Copy file inside a into b

	    • cp a/a.txt a/b/

2. Change the third level directory c permission to read only

	    • chmod 444 a/b/c

3. Try copying third level c directory to outside of a

	    • cp -r a/b/c ./  : Permission denied

4. Create the directory data inside b

	    • mkdir a/b/data

5. Change the permission of b to read and write only

	        ◦ chmod 666 a/b/

6. Create directory data2 inside b

	    • mkdir a/b/data2  : Permission denied

7. Create data.txt file inside b

	        ◦ touch a/b/data.txt  : Permission denied
8. Rename the second level c to copied_dir

	    • mv a/c a/copied_dir

9. Change permission of copied_dir to only executable

	    • chmod 111 a/copied_dir/

10. Try ls on copied_dir

	    • cd a/copied_dir
	    • ls   : Permission denied

11. Try moving copied_dir to outside of a

	    • mv a/copied_dir ./  : Permission denied

12. Try moving data directory outside of a

	    • mv a/data ./

13. Now change the owner of the directory a to root

	    • sudo chown root a/

14. Change permission of a to read write and executable to only user

   	 • sudo chmod 700 a/

15. Try creating directory sample inside a

	    • mkdir a/sample  : Permission denied

16. Create directory x outside a

	    • mkdir x

17. Try moving x inside a

	    • mv x/ a/  :Permission denied

18. Create directory movies

	        ◦ mkdir movies
19. Add movies to sudo and avahi group

	    • chgrp sudo movies/
	    • sudo chgrp avahi movies/
