# 335la2
CSC335 Large Assignment 2

Notes: 
When we stubbed all of our methods in LibrarySetup, we made them return void.
I'm assuming that just means we're going to be printing everything for the user in these methods themselves rather than calling them in MyLibrary and using a return value to form print statements. That's how I went about doing suggest() and search(). We can always tweak format later if we change our minds.

getUnreadBooks() requires checking the read status of each BookRead object in the masterList. Our BookRead class does not have a getter method yet for retrieving that status. If we added one, the code that I put down should work, but it looks like we would be creating an antipattern of using getters for each of our instance variables. In the case of doing this with the Book class it was fine because Book is final. In this case, BookRead is not. Something to think about.

Need to figure out how we are accessing the titles/authors of RatedBookList class. (same reason as above).