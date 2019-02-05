#General 
  Jonah Stegman
  0969112
  This is a program that creates a portfolio using a GUI which allows the user to buy, sell, update, getGain and search stocks and mutual funds 
  using a hashmap and arraylist 

#Assumptions
  for buy if the same stock/mutual fund is bought again the quantity, price and bookvalue is updated

#User Guide
  To run the program goto Porfolio.java fileName and run the program.
  To create a stock/mutual fund the user must enter and symbol, name, quantity, a price the book value is calulated by the program.

#Improvements
  could refactor code by creating more functions

#Testing
Incorrect input for price and amount
 - expected to not allow
Incorrect input for update price
 - expected to not allow 
Incorrect input in the menu
 - expected to not allow
Enter a blank string for symbol and name
 - expected to not allow
Search with Hashmap for keyword
 - expected to return all objects with those keywords
Sell all of an object
 - expected to remove object from arraylist and name from the hashmap
click the buy button on the dropdown
- should go to the buy menu
click the exit button
- should exit the program
click the update button before entering any values
- should not allow you to update anything
- should say nothing has been inputed
try to search with nothing in the array list
- should return a result of nothing matched search results
try and enter a letter instead of a number for price in buy
- should result in a error message saying invalid input
  try and enter a letter instead of a number for price in sell
- should result in a error message saying invalid input
try to go out of bounds in the array in update
- should tell result in a message saying you have reached the begining or end of the
array list
enter a negative price or quantity for sell
- should result in a invalid input message
try to search with no parameters
- should result in nothing matched the search 