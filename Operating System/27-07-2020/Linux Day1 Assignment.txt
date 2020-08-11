Question-1
Create some files and sub directories.

    • touch file01 file02 file03 file04
    • mkdir dir1 dir2 dir3  

a) display files row wise, column wise, 1 per row

    • Column wise:  ls -C
    • Row wise:  ls -x
    • 1 per row:  ls -1

b) sort the files in ascending, descending order

    1. On the basis of SIZE
        ◦ Ascending:  ls -lSr
        ◦ Descending:  ls -lS

    2. Alphabetically
        ◦ Ascending:  ls -X
        ◦ Descending:  ls -r

c) Create some hidden files and sub directories and display them using “ls -
a”

    • touch .a.txt .b.txt
    • mkdir .hid .hidden
    • ls -a

d) Change time stamp of some files and directories using touch command
and display the files using ls -t ls -rt

    • touch file01 dir1/
    • ls -t
    • ls -rt

e) Recursive display contents of your home directory.

    • cd ~
    • ls -R

f) display all attributes of files and directories using ls -l

    • ls -l

g) display attributes of a directory using ls -ld

    • ls -ld

Question-2.
Create three directory a b and c and create a.txt,b.txt and c.txt
  in each directory respectively and then copy c directory into the a.

    • mkdir a b c
    • touch a/a.txt b/b.txt c/c.txt
    • cp -r c/ a/

Question-3.
Move Directory b to c.

    • mv b/ c/

Question-4
Create alias of ls -lh command to your name.

    • alias arshi = “ls -lh”


Question-5
Change Directory name a to cdac.

    • mv a/ cdac/

Question-6
Create five files file1.txt , file2.txt ,file3.txt file4.txt and
  file5.txt with some text inside it. Search for 's' character
  inside all the files using grep command.
  Also Use cat to view all file content together.

    • cat > file1.txt     
	songs
    • cat > file2.txt     
	stereo hearts
    • cat > file3.txt     
	silence (ft. Khalid)
    • cat > file4.txt     
	stole the show
    • cat > file5.txt     
	so far away
    • grep s file1.txt file2.txt file3.txt file4.txt file5.txt
    • cat file1.txt file2.txt file3.txt file4.txt file5.txt

Question-7
Create file.txt using cat and edit that using nano editor.

    • cat > file.txt
	Fear is the path to the Dark Side --YODA
    • nano file.txt
	Fear is the path to the Dark Side --YODA
	You don’t know the Power of the Dark Side –Darth Vader (ctrl+x)

Question-8
Create 5 empty files using touch command.

    • touch t.txt o.txt u.txt c.txt h.txt

Question-9
Remove previously created directory a , b and c.

    • rm -r cdac/ c/  [a/ was renamed to cdac, b/ was moved inside c/ ]

Question-10
Explore the following commands with various options, refer man pages for
further help a) date b) cal c) bc d) echo e) who f) whoami g) logname g) uname h)
seq i) clear

    • man command [date,cal,bc,etc]

Question-11
Create a file with some content using vi editor

    • vi Afile.txt
	Some Content

a) Display the file using cat command

    • cat Afile.txt

b) Display line no.s along with content

    • cat -n Afile.txt

c) Display the file in reverse order using tac

    • tac Afile.txt

d) Combine multiple files using cat command

    • cat file1.txt >> file2.txt >> file3.txt >> file4.txt >> file5.txt > Afile.txt
    • cat Afile.txt


