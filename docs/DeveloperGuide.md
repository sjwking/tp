# Developer Guide

## Acknowledgements

[Java Standard Library](https://docs.oracle.com/javase/8/docs/api/): Utilized extensively for collections, date
handling, and file operations.

[ANSI Escape Codes](https://en.wikipedia.org/wiki/ANSI_escape_code): Adapted for colored console outputs in Ui.java.

[JUnit 5](https://junit.org/junit5/docs/current/user-guide/): Used for unit testing.

# Design & Implementation

## Architecture

The application follows a modular design:

* **FinTrack (Entry Point)**: Initializes components and manages the application loop.
* **Parser**: Handles user inputs and ensures validation.
* **Commands**: Manages mapping and execution of commands.
* **Expense & ExpenseList**: Data models representing expenses and collections of expenses.
* **Ui**: Provides a consistent user interface through console outputs.

## Classes and Their Responsibilities

* **Commands**:
    * Maps user commands (`add`, `viewmonth`, `history`, `update`, `delete`, `budget`, `recurring`, `category`, `exit`,
      `help`) to their functionalities.
    * Contains methods to handle each user command.
* **Expense**:
    * Represents an expense with `amount` (in cents), `category`, `description`, and `date`.
* **ExpenseList**:
    * Manages lists of regular and recurring expenses.
    * Handles operations such as adding, deleting, updating expenses, and managing budgets.
* **Parser**:
    * Reads and validates user input from the command line.
    * Parses user-provided details into structured data types.
* **Ui**:
    * Facilitates user interaction by displaying prompts, messages, and errors in color-coded formats.

## Product scope

### Target user profile

Young adults who are looking to manage their finances better.

### Value proposition

Manage finances better by tracking expenses and income faster than a GUI driven application.

## User Stories

| Version | As a ... | I want to ...             | So that I can ...                                           |
|---------|----------|---------------------------|-------------------------------------------------------------|
| v1.0    | new user | see usage instructions    | refer to them when I forget how to use the application      |
| v2.0    | user     | find a to-do item by name | locate a to-do without having to go through the entire list |

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

1. **Launching the Application:**
    * Run `FinTrack.main()`.

2. **Adding an Expense:**
    * Type `add`, then input details in the format: `dollars, cents, category index, description, yyyy-MM-dd`

3. **Viewing Monthly Expenses:**
    * Type `viewmonth` to list current month expenses.

4. **Updating an Expense:**
    * Type `update`, follow prompts to specify the expense and new details.

5. **Deleting an Expense:**
    * Type `delete`, follow prompt to specify the expense index.


