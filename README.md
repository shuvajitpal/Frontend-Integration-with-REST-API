# Frontend-Integration-with-REST-API 
## Task Manager (Spring Boot + Frontend)

## What I Built
I built a simple **Task Manager web application** using **Spring Boot** (backend) and plain **HTML, CSS, and JavaScript** (frontend). The app allows users to view a list of tasks and add new tasks dynamically through a REST API.

## Why I Built It
The goal was to learn and practice:
- How to create and expose REST APIs in **Spring Boot**.
- How to consume REST APIs from a **frontend** using JavaScript `fetch()`.
- How to manage frontend and backend together inside a single Spring Boot project.
- Using **STS (Spring Tool Suite for Eclipse)** as an integrated environment for both Java and frontend files.

## How It Works
- **Backend:**  
  - The backend was already written in the same project using Spring Boot.  
  - A `TaskController` exposes REST endpoints (`GET /tasks`, `POST /tasks`) to manage tasks.  
  - Tasks are stored in an in-memory list with fields `id`, `title`, and `description`.  

- **Frontend:**  
  - I just added three files inside `src/main/resources/static/`:  
    - `index.html` → main page with task list and add-task form.  
    - `script.js` → JavaScript logic for calling REST API and updating the DOM dynamically.  
    - `style.css` → styling for a clean and user-friendly UI.  
  - The frontend connects directly to the backend REST endpoints.  

## Running the Project
1. Run the Spring Boot application from STS (Spring Tool Suite for Eclipse).  
2. Open the following URL in your browser:
     Task Manager UI - [http://localhost:8080/index.html](http://localhost:8080/index.html)
You will see the Task Manager UI. Existing tasks are displayed, and new tasks can be added through the form.
