
# Assignment 2
## Lateral Navigation Tabbed View Activity

> The requirements are added in blockquotes.

The full walk through of the app implemented for assignement 2 is shown in this GIF.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/uniapp.gif" width="300"/>

### The Main Tabbed Activity
> Implement lateral navigation (tabbed view) activity for profile implementation page

In the Lateral Navigation Activity, 3 tabs were created and linked with View Pager which include Basic Information Tab, University Affiliation Tab and Phone Information Tab. A submit button is added at the top on the App Bar.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/basicinfo.png" width="300"/>

#### Basic Information Fragment
> First Tab contains basic information about the members. i) Name ii) Date of Birth iii) NID iv) Blood Group

As shown above, the basic information about the user is displayed here, retrieved from internal storage where data was stored when user signed up (Implemented in Assignment 1)

#### University Affiliation Fragment
> Second tab should contain a listview University Affiliations 

File Serialization is used for storing university affiliations. Floating Action Button is implemented which adds a new university affilication to the user's list.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/unitab.png" width="300"/>

#### Phone Fragment
> Third tab should contain a listview of phone numbers

File Serialization is used for storing each instance of a phone object. Floating Action Button is implemented to allow adding a new phone to the user's list.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/phonetab.png" width="300"/>


<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/addphone.png" width="300"/>


### Member Information Recylcerview Activity
>Each entry in the recyclerview contains NID and person name. On tapping an entry in the recyclerview, display the information in a dialogue message

File serialization is used to store different member information. The first time the app is run, new isntances of Student model object is added to a file, and in subsequent runs, these are loaded along with current user's own information. 

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/memberinfo.png" width="300"/>


<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/dialog.png" width="300"/>
