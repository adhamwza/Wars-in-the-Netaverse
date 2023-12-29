# Wars-in-the-Netaverse

# Project Overview
This project involves implementing the specified WIN interface in an IntelliJ project. The project should exhibit good program design principles, minimizing code duplication, modularization with low coupling and high cohesion, using inheritance and interfaces appropriately, and being reusable and well-documented.

Programming Tasks
# Task 1.0 – Getting Started:

Update Teamwork class details.
Download and save the provided WIN-students project.
Identify and code "back-end" supplier classes, considering inheritance and polymorphism.
Complete the setupForces() and setupBattles() methods in SpaceWars.
# Task 1.1 – Initial Setup:

Code and test "back-end" supplier classes with appropriate fields and methods.
Decide on data storage for forces and battles in SpaceWars.
Declare and create fields in SpaceWars, completing setupForces() and setupBattles() methods.
# Task 1.2 – Producing the WIN System:

Implement functionality specified in the WIN interface within the SpaceWars class.
Do not modify the WIN interface; use private methods in SpaceWars for internal tasks.
Focus on key methods like activateForce() and doBattle().
# Task 1.3 – Design:

Design lower-level supplier classes for detailed system implementation.
Use appropriate classes, inheritance, and polymorphism.
Employ private methods for readability and maintainability.
Avoid direct input/output to/from the user in classes (except GameUI & GameGUI).
Consider using provided enum classes ForceState and BattleType.
# Task 1.4 – Testing:

Utilize testing tools, including the command line GameUI and provided JUnit test suite.
Enhance GameUI by supplying missing code.
Add tests to the test folder to ensure comprehensive testing.
Be aware that extensive JUnit testing will be conducted by the evaluators.
# Task 1.5 – Persistence:

Implement saveGame(), loadGame(), and readBattles() methods in SpaceWars.
Provide a second constructor using battles.txt for loading battle information.
# Task 1.6 – Graphical User Interface (Challenge Task):

Complete the GameGUI class to provide a GUI for players.
Add menu items for listing ASFleet, activating/recalling forces, and listing battles.
Include buttons to view the game state and clear the GUI contents.
