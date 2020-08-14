1.Create a file data.txt

    • touch data.txt

2.Write data to data.txt using redirection operator

    • echo hello > data.txt

3.Analyze the behaviour by writing the data to data.txt multiple times

    • echo hey > data.txt
    • Data Overwritten

4.Append the data to data.txt

    • echo see you >> data.txt

5.Create data2.txt,data3.txt and data4.txt

    • touch data2.txt data3.txt data4.txt

6. Write content to data2.txt,data3.txt and data4.txt using redirection operator

    • echo hello > data2.txt
    • echo hello > data3.txt
    • echo hello > data4.txt

7.Copy content of data2.txt,data3.txt and data4.txt to the data.txt

    • cat data2.txt data3.txt data4.txt > data.txt

8.List the files start with ‘s’ in your home directory using ls

    • ls s*

9.List all files and directories that have four characters in their name

    • ls ????

10.List all files that have any three character in starting but ends with ‘txt’ in home directory

    • ls ???.txt

11.List all files that starts with number in your home directory
    • ls [0-9]* ~/

12.Print HOME variable

    • echo $HOME

13.Print PATH variable

    • echo $PATH

14.Assign string to variable ‘x’. Print it using echo

    • x = “hello”
    • echo $x

15.Check how many shells are in your system

    • cat /etc/shells | wc -l

16.Check which shell is default shell for user

    • grep arshi /etc/passwd | cut -d “/” -f5

17. Login on ssh server test.rebex.net (username=demo ,password=password)

    • ssh demo@test.rebex.net

18.Logout from there(Use this server for 5 minutes. Its for testing purpose)

    • exit

19.Use scp command on your system to copy file readme.txt to your system from the test.rebex.net server.

    • scp demo@test.rebex.net:/readme.txt ./


Optional :
If you do this on your pc:
1.Start ssh server using command sudo systemctl start sshd(if Its not working install openssh server using sudo apt install openssh-server)

    • sudo apt install openssh-server
    • sudo systemctl start sshd
2.Now you can login your using your username@localhost or username@127.0.0.1

    • ssh arshi@localhost
