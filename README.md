# Assignment 4 - Study Plan Facade

**Student:** Yerkhan Ibragim  
**Group:** SE-2510  
**Course:** Software Design Patterns

## Purpose

This Java console application prepares a study plan using the Facade pattern.
The client calls `createPlan(topic, totalMinutes)` instead of managing four
subsystem classes and passing data between them.

Supported topics: **Java**, **Algorithms**, and **Databases**.
Leading and trailing spaces and letter case are accepted by the facade.
The total study time must be between **30 and 180 minutes**, inclusive.

## How it works

1. `TopicService` checks and normalizes the topic.
2. `ScheduleService` checks the duration and splits it between theory and practice.
3. `MaterialService` selects basic or detailed reading using the topic and theory time.
4. `PracticeService` selects tasks using the topic and practice time.
5. `StudyPlanFacade` returns the complete plan as a string.

Theory receives half the time, rounded down. Practice receives the remaining
minutes, so the two parts always add up to the requested duration.
A theory block of at least 30 minutes receives detailed material.
Each task is assigned 15 minutes. There are three tasks per topic; extra
practice time is reserved for reviewing solutions.
These are simple planning rules for this educational application.

## Pattern roles

| Role | Class | Responsibility |
| --- | --- | --- |
| Client | `Main` | Calls only the facade and displays results or errors |
| Facade | `StudyPlanFacade` | Coordinates the complete planning process |
| Subsystem | `TopicService` | Validates and normalizes a topic |
| Subsystem | `ScheduleService` | Validates duration and allocates time |
| Subsystem | `MaterialService` | Selects reading based on topic and time |
| Subsystem | `PracticeService` | Builds a task list that fits the practice budget |

The facade uses composition. It does not extend the subsystem classes.
Subsystems do not reference the facade and remain directly usable by advanced
clients. For direct calls, use the canonical topic names returned by
`TopicService.validateTopic()`: Java, Algorithms, or Databases.
The demo client creates and uses only `StudyPlanFacade`.

## Clean Code principles

1. **Meaningful names:** `validateTopic`, `calculateTheoryMinutes`, and
   `prepareTasks` clearly describe their actions.
2. **Single Responsibility:** each subsystem owns one responsibility. The
   facade coordinates calls instead of duplicating validation, scheduling,
   material selection, or task selection logic.
3. **Encapsulation:** subsystem fields inside the facade are private. Its public
   API accepts a topic and duration and returns a string, without exposing
   subsystem objects.
4. **Small, focused methods:** `validateTime` and `getTasks` separate supporting
   operations from the main public methods.
5. **Proper error handling:** invalid input throws a meaningful
   `IllegalArgumentException`. The facade stops before returning an incomplete
   plan. `Main` catches the exception for each example, displays the reason,
   and can continue with the next example. Plan creation has no external or
   persistent side effects, so there is no state to roll back on failure.
6. **Named constants:** minimum and maximum study duration, the detailed-reading
   threshold, and time per task are named where their rules are implemented.

## Run in IntelliJ IDEA

1. Create a Java project named `StudyPlan_Facade` and select your JDK.
2. Copy the six `.java` files from `src` into the project's `src` folder.
3. Keep all six files in the same default package.
4. Open `Main.java` and run its `main` method.

No Maven, Gradle, external dependencies, or preview language features are needed.
A JDK, rather than only a JRE, is required for the normal compile commands.

## Run in a terminal

From the project folder:

```text
mkdir out
javac -d out src/*.java
java -cp out Main
```

The program demonstrates two valid plans, an unsupported topic, and an invalid
duration. The last two messages are intentional validation examples.

## Example

```text
=== Study Plan ===
Topic: Java
Total time: 60 minutes
Theory: 30 minutes
Practice: 30 minutes
Material: Read about variables, conditions, loops, and arrays.
Tasks (15 minutes each):
1. Check if a number is even or odd.
2. Find the largest number in an array.
```

## Submission

Upload the source files, this README, and `.gitignore` to your GitHub repository.
Do not commit compiled `.class` files or IDE build folders.
Study Plan is different from the lecture examples (home theater, video
conversion, and restaurant menus). Its uniqueness within your group still
needs to be checked with your classmates.
