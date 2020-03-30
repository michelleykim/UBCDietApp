# Diet Planner

## "I just want to survive through university"

An example of text with **bold** and *italic* fonts.  
Note that the IntelliJ markdown previewer doesn't seem to render 
the bold and italic fonts correctly but they will appear correctly on GitHub.

### What will the application do?

Major features of the application:
- *Recommends* daily meal plan with menus based on the desired calories intake and budget
- *Recommends* daily meal plan with menus for special cases with dietary restrictions
- *Excludes* specific menus from the plan
- *Saves* daily meal plans to construct customized weekly meal plan

###Who will use it?
My program is targeted towards *UBC students*, 
especially those who live in the student residents without proper cooking equipment.

###Why is this project of interest to you?
As a student living in a first year residence without kitchen, 
I personally have experienced significant hardships managing a healthy diet. 

Not only the nutrition was in concern, but also the budget I had for food is limited, 
leading to unhealthier diet, since cheaper foods usually are not as healthy as high quality foods. 

I found many fellow university students are experiencing similar needs to **balance nutrition and cost**, 
but failing to make a time themselves to invest into it and build a customized meal plan.

Therefore, I decided to build an application that helps 
to minimize the time taken to build a customizable meal plan 
so more students like myself can achieve healthier lifestyle. 

###User Stories
- As a user, I want to be able to manually add a menu to a daily meal plan
- As a user, I want to be able to manually delete a menu from a daily meal plan
- As a user, I want to be able to view the list of menus in a daily meal plan
- As a user, I want to be able to view the total calories and the cost of the daily meal plan
- As a user, I want to be able to select a dietary restriction that exclude menus accordingly
- As a user, I want to be able to save my desired daily calories intake, budget, and dietary restrictions to file
- As a user, I want to be able to optionally load my info when the program starts 

###Instruction for Grader
1. View account information to view the desired calories, budget, and dietary restrictions of the account.
    - The account is automatically set to Desired Daily Calories Intake of 0 cal, budget of $0 and non-vegetarian.
    - User can either click "Load Account information" to load previously saved account information 
    or click "Edit Account Information" to set a new account information. 
    - If the user decides to load the previous account, 
    the account info will load and app will redirect the user to the main window. 
    - If the user decides to manually edit the account information, 
    the user will be redirected to new window where they can type specifics in. 
    The user can click "Done" after finish typing the account information 
    and the app will redirect the user to the Account Information window with updated account information. 
    - User can click "Back" to go back to the main window.
2. The app provides different ways to add Menu to DailyPlan:
    - Click "Generate Meal Plan" button and click "Generate From Scratch" button.
        - This will automatically add Menu to DailyPlan using the current account information.
Window that shows the generated daily plan will pop up and the user can click "Done" to go back to the main page.
    - Click "Generate Meal Plan" button and click "Generate From Scratch" button.
        - This will redirect the user to the page where the user can 
manually input desired calories intake, budget and dietary restrictions to generate meal plan. 
The user can them either click "Done" to get generated daily plan from inputted information 
or click "Back" to go back to page where they can chose to generate meal plan using account or not.
    - Click "Make Own Meal Plan" button and click "Add Menu" button.
        - Once the user clicks "Make Own Meal Plan," the user will see a window with empty panel. 
This is because no menu has been added to the daily plan yet, 
so the user can click "Add Menu" button to manually add desired menu.
Clicking "Add Menu" button will redirect user to a window 
where they can type in menu's name, calories, price and dietary restrictions. 
The user can either click "Done" button to add the typed menu to the list, 
or "Back" button to go back to the previous window where they can chose to add or delete menu.
Once "Done" button is clicked and the menu is added to the list, the user will be redirected to the previous page 
and they will see that the menu they added has been added to the empty panel.
        - From there, user can either add more menu or delete an existing menu by selecting a menu and click "Delete Menu".
When the user is finished customizing menu, they can click "Done" button to see their final daily meal plan. 
        - Also, if the user want to make manual changes to the daily meal plan that they have generated earlier, 
they can also click "Make Own Meal Plan" to make additional changes to the already existing meal plan.
3. Audiovisual component can be found by clicking four buttons in the main page; 
"View Account Information," "Generate Meal Plan," "Make Own Meal Plan," and "Quit".
Clicking each button will make a clicking sound. 
4. To load the state of application from file, the user can click "View Account Information," 
then "Load Account Information" as explained earlier. 
5. The state of application is automatically saved to the file when the user close the app using "Quit" button. 
The state of application will not be saved to the file if the user close the app using default closing operation 
(The red box of X on the top right corner of the app).

###Phase 4: Task 2
Chosen option: Test and design a class that is robust.
The constructor of Menu class throws two exceptions for negative value of calories and price.
The thrown exceptions are caught in DailyPlan class addMenu method. 
Tests for exceptions can be found in MenuTest class.