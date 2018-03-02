# Quick start with github made for my wonderful team

### Overview
Github is a smart online repository. Think of it like Dropbox, OneDrive or Google Drive except it's made for code. Multiple people can update multiple files at the same time and github is able to merge these changes intelligently without destroying code as long as two people don't mess with the same function. It makes division of labor go by a lot easier. 

You can also pull changes at any time and merge them with what you're working on without destroying your code. This is good for making sure you are always using the most up-to-date version of the code. 

Most people use Github with a command line. In the following I will do my best to provide **simple** steps to help you set up your computer to use Github.

## Getting Started

### 1. Create an account
Make an account on [www.github.com](www.github.com). I recommend using your personal e-mail address so that you can keep it forever.

----------

### 2. Install Git SCM
**2.1** [Download and run git Bash here](https://git-scm.com/downloads)
**2.2** Git SCM includes a bash(unix-ish) terminal for a windows computer. Leave all the defaults selected like so
<br>![default options for Git Bash](/media/git.jpg)<br><br>
**2.3** Choose whatever text editor you are most familiar with. (Vim is worth learning though!)
<br>![Options for editor](/media/bashEditor.png)<br><br>
**2.4** Choose default options for the rest and finish installing.<br> **Do not worry about launching bash yet, we will open it from our desired folder to avoid navigating folders through the command line.

----------

### 3. Create a "gitHub" folder on your C:/ drive for easy access
Create a gitHub folder right in your hard drive on C. This will be good so that it doesn't get lost in your porn. You'll thank me for this later.

----------

### 4. "Clone" the repository
To "clone" a repository means to copy it into your computer. We are going to do this using git.

**4.1** Right click **inside** your github folder and select Git Bash here.
<br>![Git bash here context option](/media/gitBash.png)<br>

**4.2** Copy the [Repository link](https://github.com/martip23/single-cycle-simulator).
<br>![Repository link](/media/copyRepo.png)<br>

**4.3** Type ```git clone <repository link>``` (You can paste into git Bash by using ```Shift+Enter```)
<br>![Git clone example](/media/gitClone.jpg)<br>

**4.4** Take a look inside the gitHub folder. You should now have a folder named after your repository. It will be single-cycle-simulator in this case. 
<br>![cloned folder](/media/clonedFolder.png)<br>

**You will be doing this a lot from now on. You can clone any repository!**

----------

### 5. Make changes!
Go into the single-cycle-simulator folder. You should see a file named usingGithub.md. THAT IS THIS FILE! Woah! Go ahead and go into it and edit the part after the comment that says ```<EDIT AFTER THIS LINE>``` and add your name.
![Edit after screenshot](/media/editAfter.jpg)

[//]: <> (EDIT AFTER THIS LINE)
**Team member 1:** Patrick Martinez

**Team member 2:** 

**Team member 3:**

[//]: <> (DO NOT EDIT AFTER THIS LINE)

----------

### 6. Stage, Commit and Push those changes to the server.