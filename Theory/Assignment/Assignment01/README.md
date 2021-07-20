
<!-- ![alt text](https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/MainActivity.png) -->

# Assignment 1
## UniClubz Sign Up Activities

The requirements are added in blockquotes.

### Main Activity

>Main activity should set the following: Name, Date of Birth, NID, Blood Group


  
Activity to obtain user name, NID, date of birth and Blood Group. Validator Function with Regex is used for Date Validation. Dialog Picker is used for Blood Group for easier picking.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/MainActivity.png" width="300"/>
<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/MainActivity2.png" width="300"/>

### University Affiliation Activity
> When the next button is clicked, the information from the main activity should be displayed. This activity is titled University Affiliation. This activity should set the following:
University name (Use drop down, pre-populated list),
Department (Use drop down, pre-populated list, one for each university),
Student ID,
Study Level (undergraduate / MS / PhD / Post-Doc),


Activity to obtain University name, Student ID, Department and Study Level. Dialog Picker is used for Study Level for easier picking. For University, a drop down is used populated using an existing array of universities. When the user chooses an university the Department Dropdown items change according to the university chosen. By default, the values are set to represent NSU and NSU Departments. If the user selects BRAC then, the departments will change and show BRAC departments.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/Uni1.png" width="300"/>
<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/Uni2.png" width="300"/>
<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/Uni3.png" width="300"/>
<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/Uni4.png" width="300"/>

### Display Info Activity
> When the next button is clicked, display all the information from the main activity and university affiliation activity in a categorical manner. This activity should have a next button.

Activity to display intermediate information obtained so far. List View is used to display the list, which has scroll functionality.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/DisplayInfo1.png" width="300"/>

### Add Phone and Email Activity
> On clicking this second activity, you should open up an activity where email and phone number for the user could be added. 
For quiz 1, assume only one email and phone number needs to be added. 

Activity to get user phone and email. Regex is used for email validation

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/Emailphone.png" width="300"/>

### Final Activity
> On clicking this activity, display all the data in a final activity. 

Activity to display complete information obtained in Sign Up Process. List View is used to display the list, which has scroll functionality.

<img src="https://github.com/NSU-SU21-CSE486-1/1812048_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment01/SS/Final.png" width="300"/>
