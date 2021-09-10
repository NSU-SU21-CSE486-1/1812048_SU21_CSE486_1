
# Assignment 3
## Lateral Navigation Tabbed View Activity with Room Persistence Library

> The requirements are added in blockquotes.

### The Backend Data Storage
In this app, the backend data storage was done using Room Library for Android. The recommended architecture with dedicated layers for local Room database, Repositories and View Model were implemented as shown in the figure below. Within the Room Database were the Data access object (DAO) classes for each of the entities, the Java classes for defining the entities and AppDatabase abstract class itself which is needed to build our database. 

<img src="https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/images/10-1-c-room-livedata-viewmodel/dg_architecture_summary.png" width ="500"/> 
<a href=https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-4-saving-user-data/lesson-10-storing-data-with-room/10-1-c-room-livedata-viewmodel/10-1-c-room-livedata-viewmodel.html"> Fig: The Architecture Utilized in The App (diagram source: Google)</a>

The app three entities with dedictaed tables in the Room Database for storing the Student Information, Phone list, and University Affilitiation list. A screenshot from App Inspection page of Android Studio is presented below to demonstrate that user information is indeed being persisted in the SQL database. 

<img src = "https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment03/SS/Room.PNG" width="600"/>
                                                                                                                                        
### The Main Tabbed Activity
> Implement lateral navigation (tabbed view) activity for profile implementation page

In the Lateral Navigation Activity, 3 tabs were created and linked with View Pager which include Basic Information Tab, University Affiliation Tab and Phone Information Tab. A submit button is added at the top on the App Bar.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/basicinfo.png" width="300"/>

#### Basic Information Fragment
> First Tab contains basic information about the members. i) Name ii) Date of Birth iii) NID iv) Blood Group

As shown above, the basic information about the user is displayed here, retrieved from internal storage where data was stored when user signed up (Implemented in Assignment 1)

#### University Affiliation Fragment
> Second tab should contain a listview University Affiliations 

Room Library is used for storing university affiliations. Floating Action Button is implemented which inserts a new university affilication to the University Affilication Table of the app database and in subsequent runs the information is retrieved using the View Model for the university affiliation repository.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/unitab.png" width="300"/>

#### Phone Fragment
> Third tab should contain a listview of phone numbers

Room Library is used for storing phone information. Floating Action Button is implemented which inserts a new phone number to the Phone Table of the app database and in subsequent runs the information is retrieved using the View Model for the phone repository.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/phonetab.png" width="300"/>


<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/addphone.png" width="300"/>


### Member Information Recylcerview Activity
>Each entry in the recyclerview contains NID and person name. On tapping an entry in the recyclerview, display the information in a dialogue message

Room Library is used to store different member information. The first time the app is run, new indtances of Student model object is added to the Student Information table of our database, and in subsequent runs, these are loaded along with current user's own information. 

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/memberinfo.png" width="300"/>


<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/SS/dialog.png" width="300"/>
