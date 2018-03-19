# Quick start with github made for my wonderful team

### Overview
Github is a smart online repository. Think of it like Dropbox, OneDrive or Google Drive except it's made for code. Multiple people can update multiple files at the same time and github is able to merge these changes intelligently without destroying code as long as two people don't mess with the same function. It makes division of labor go by a lot easier. 

You can also pull changes at any time and merge them with what you're working on without destroying your code. This is good for making sure you are always using the most up-to-date version of the code. Github also keeps track of the history of **EVERY** commit meaning that if someone makes a big mistake and destroys everything, we are always able to revert. Github also keeps track of the folders and uploads entire folders instead of using zip files.

Most people use Github with a command line. In the following I will do my best to provide **simple** steps to help you set up your computer to use Github.

## Getting Started

### 1. Create an account
Make an account on [www.github.com](www.github.com). I recommend using your personal e-mail address so that you can keep it forever.

----------

### 2. Install Git SCM
**2.1** [Download and run git Bash here](https://git-scm.com/downloads)<br><br>

**2.2** Git SCM includes a bash(unix-ish) terminal for a windows computer. Leave all the defaults selected like so
<br>![default options for Git Bash](/media/git.jpg)<br><br>
**2.3** Choose whatever text editor you are most familiar with. (Vim is worth learning though!)
<br>![Options for editor](/media/bashEditor.png)<br><br>
**2.4** Choose default options for the rest and finish installing.<br><br> **Do not worry about launching bash yet, we will open bash from our desired folder to avoid navigating folders through the command line.**

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
<br>![Git clone example](/media/gitClone.JPG)<br>

**4.4** Take a look inside the gitHub folder. You should now have a folder named after your repository. It will be single-cycle-simulator in this case. 
<br>![cloned folder](/media/clonedFolder.png)<br>

**You will be doing this a lot from now on. You can clone any repository!**

----------

### 5. Make changes!
Go into the single-cycle-simulator folder. You should see a file named usingGithub.md. THAT IS THIS FILE! Woah! Go ahead and go into it and edit the part after the comment that says ```<!---EDIT AFTER THIS LINE-->``` and add your name.
![Edit after screenshot](/media/editAfter.JPG)

<!--- EDIT AFTER THIS LINE -->
**Team member 1:** Patrick Martinez

**Team member 2:** Mary Gutierrez

**Team member 3:**

<!--- EDIT AFTER THIS LINE -->
Mary Gutierrez

----------

### 6. Stage, Commit and Push those changes to the server.
**6.1** Navigate into the folder that you cloned. (You can use ```ls``` to see all files and folders and ```cd``` to change directory.) (Also, remember you can use ```[tab]``` to auto complete file/folder names)<br>
![Example navigate to repo using ls & cd](/media/navigateToRepo.JPG)<br><br>

**OR** alternatively, you can navigate into the folder in windows explorer and right click to open a Bash window.<br><br>

**6.1** Use ```git add .``` to stage (get ready) the files to which you have made changes. ```add``` is the command to prepare the changes while the ```.``` is a recursive search which will add all changes in all files.<br><br>

**6.2** Use ```git status``` to see which files are ready to commit.<br>
![Example of git add . and git status](/media/gitAddStatus.JPG)<br><br>

**6.3** Use ```git commit -m "INSERT DESCRIPTIVE MESSAGE HERE"``` to commit changes. 

Committing means you want to make a timestamp where you are and save changes. This means you can revert to this time period if you ever need to.
<br><br>
![CMD of commit](/media/commit.JPG)
<br><br>
**IMPORTANT - Since we are working on a team, we should use descriptive commit messages**<br>

- Within quotes you can enter your own commit message that everyone can see when they view your changes.
- Make sure that messages describe what you did.
- It is recommended to make **frequent commits** for example, after every function or comment addition.
- This is recommended so that it can be easy to remove only parts of code if we decide something isn't needed.
- Example of commit messages are ```-m "continuing jump function"``` ```-m "commented code in memory class"``` ```-m "added push function"``` ```-m "Created class for registers"``` ```-m "implemented load/store functions"```
<br><br>
**6.4** Push changes to repository (server)

Once you've committed to your changes, you can use ```git push origin master``` which will push all of your files. You must be connected to the internet for this to work.

![Example of push command on git](/media/push.JPG)

**6.5** You can now view your changes on the github website!


----------

### 7. Pulling the repository (Getting most recent updates)

Anytime you sit back down to continue work, make sure to pull all the recent changes. 

1. Navigate to the repository folder.
2. Use ```git pull``` to pull the most recent changes from the server.
3. Your folder is now updated.
4. You might get ```your folder is already updated``` or some other action going on. Both are normal.

![Example of pull command](/media/pull.JPG)

----------


### 8. If you wish to update your changes to github, just do step 6 again.

You'll get used to it eventually. It now takes me < 10 seconds to upload everything. The best thing is, if you switch machines or want someone else to view your code, just push your changes and clone on another machine. Neat neat neat!