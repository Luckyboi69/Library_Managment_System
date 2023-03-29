# Library_Managment_System
A Full Library Managment System Using Java Remote.
Scoop:
Our idea is providing a promising software management system for local library, which will have well-structured architecture, user-friendly GUI, and fine-tuned database. Our perspective is to build a system can execute all library related tasks, in order to diminish the physical interactions with the ordinary library. Our system will be operated and manipulated by library admin and librarian, these two users are responsible for database management and staff management. The main user is the customer who has functionalities as viewing or renting library rooms, in addition to borrowing books by only using the system, moreover, there are authors that make events and publish digital books.

Customer
•	Customer can deposit money into account so he can print documents (when the customer request to print a file the system checks the account balance).
•	The customer can print file by sending a printing request to the library printing system (library printing system is not the same as library management system).
•	The customer can subscribe in the rooms reservation service by adding payment method and information. He can subscribe in three different plans in the room’s subscription serves, each plan allows the customer to rent different room classes (general room, deluxe room, primum room). 
•	The customer can request missing books and the librarian will handle this request.
Librarian
•	The librarian can return rented books to the system (update the data base) after the customer return it to the librarian physically.
•	The librarian can file a report against a customer to suspend the customer account or flag it for a specific reason like corrupting books (each report will add strike to the customer account, if the account has three strikes, the account will be suspended).
•	He can manage the book shelfs and books details, with altering the changes in the database. 
Admin 
•	Admin can view the reports that librarians made, and if he validated a report, the customer account will be strike, when the count strike be more than three the account will be suspended.
•	Admin is responsible for accepting or declining requests from the author.
•	He manages the data of each actor in the system {Customer, Librarian and Author}
Author 
•	Author is a unique user account that can request the library to host an event signature ceremony or to publish a digital book, the requested events and digital books are managed by admin, which means the admin must accept the request in order to be saved and scheduled.
Assumptions:
1.	Our local library has rooms that can be rented for meetings, studying or conferences.
2.	The customer to be able to rent room he must be a subscriber for monthly paid plan.
3.	The librarian is responsible for organizing and manipulation of books.
4.	The librarian should make reports for books status, customer behavior to make an action.
5.	The Administrator is responsible of managing the accounts of customers and librarian. 
6.	There is only one admin for the system.
7.	The librarian is responsible of returning or checking in the rented books to the system.

Constraints:
1.	Customer can rent a book for maximum a week.
2.	Customer can only rent 3 books at a time.
3.	Customer can renew each book only twice. 
4.	Customer must be a subscriber to rent a room.
5.	Admin cannot suspend unflagged accounts.
