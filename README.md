# JobPortal Project

The **JobPortal** project is a web application designed to connect job seekers with recruiters, offering features like job posting, job application, saving jobs, and profile management. Built with **Spring Boot** and **Spring Security**, the app provides user authentication, custom roles, and file handling for resumes and profile photos.

---

## Table of Contents
1. [Features](#features)
2. [Architecture](#architecture)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Endpoints](#endpoints)
6. [Entities and Services](#entities-and-services)
7. [Contributing](#contributing)
---

## Features

- **User Authentication**: Custom authentication with Spring Security, supporting roles for job seekers and recruiters.
- **Profile Management**:
  - **Job Seekers**: Manage personal details, upload resumes, and add skills.
  - **Recruiters**: Create and manage profiles with company details.
- **Job Post Management**:
  - Post, edit, and delete job listings.
  - Advanced job search with filters by location, employment type, and keywords.
- **Job Application and Saving**:
  - Job seekers can apply to jobs and save listings for later viewing.
  - Recruiters can view applications and candidate profiles.

---

## Architecture

### Main Components

The project uses a multi-layered architecture with controllers, services, and repositories.

1. **Controllers**: Handle HTTP requests and responses.
2. **Services**: Contain business logic.
3. **Repositories**: Manage data persistence.

### UML Diagram Overview

The UML diagram represents relationships between classes and entities, including:

- **Entities**: Core data models (e.g., `JobSeekerProfile`, `JobPostActivity`, `Users`).
- **Controllers**: Control interactions with job postings and profiles (e.g., `JobPostActivityController`, `JobSeekerProfileController`).
- **Services**: Manage business logic for job postings, applications, profiles, and authentication.
- **Repositories**: Handle data operations (e.g., `JobPostActivityRepository`, `JobSeekerSaveRepository`).

---

## Installation

1. **Clone the Repository**:
   - Go to https://github.com/Gegcuk/JobPortal, and clone the repository to your local machine.
   
2. **Set up the Database**: Configure your database connection in `application.properties`.

---

## Usage

### Basic Workflow

1. **User Registration**:
   - Users can register as either a **Job Seeker** or a **Recruiter**.
   - Registered users can log in and access job seeker or recruiter-specific functionalities.

2. **Profile Management**:
   - Job Seekers can upload resumes and add skills to their profiles.
   - Recruiters can add company details and upload profile photos.

3. **Job Management**:
   - Recruiters can post job openings and view candidate applications.
   - Job Seekers can apply to jobs and save job listings for future reference.

---

## Endpoints

### Authentication and Profile Endpoints

| Endpoint                         | Description                                     |
|----------------------------------|-------------------------------------------------|
| `/register`                      | Register as a new user (Job Seeker or Recruiter)|
| `/login`                         | Log in to the application                       |
| `/logout`                        | Log out from the session                        |

### Job Posting and Application Endpoints

| Endpoint                         | Description                                     |
|----------------------------------|-------------------------------------------------|
| `/jobs/add`                      | Create a new job post (Recruiter only)          |
| `/jobs/search`                   | Search job listings with various filters        |
| `/jobs/apply`                    | Apply to a job (Job Seekers only)               |
| `/jobs/save`                     | Save job listings for later (Job Seekers only)  |

---

## Entities and Services

### Entities

1. **Users**: Represents users with fields for email, password, user type, and status.
2. **JobSeekerProfile**: Contains job seeker details, including `resume`, `skills`, `workAuthorization`, and `profilePhoto`.
3. **RecruiterProfile**: Stores recruiter-specific information such as `company` and `profilePhoto`.
4. **JobPostActivity**: Represents job listings with fields for job title, description, location, and type.
5. **Skills**: Represents individual skills for job seekers, including attributes like `name`, `experienceLevel`, and `yearsOfExperience`.
6. **JobSeekerApply**: Manages job applications, linking job seekers with job postings.
7. **JobSeekerSave**: Allows job seekers to save job listings.
8. **UsersType**: Defines user types (Job Seeker or Recruiter) with associated attributes.
9. **RecruiterJobsDto**: Holds data for recruiter job listings and associated candidate counts.

### Services

1. **UsersService**: Manages user operations such as registration, login, and profile retrieval based on roles.
2. **JobPostActivityService**: Handles job post creation, updates, searches, and specific recruiter-related job posts.
3. **JobSeekerApplyService**: Manages job applications, retrieving applied jobs for a user and candidates for a job.
4. **JobSeekerSaveService**: Allows job seekers to save job listings for future reference.
5. **JobSeekerProfileService**: Manages job seeker profile details, including adding new profiles and uploading resumes.
6. **RecruiterProfileService**: Handles recruiter profiles, allowing recruiters to manage job posts and view candidate applications.
7. **FileUploadUtil** and **FileDownloadUtil**: Support file handling for uploading and downloading resumes and profile photos.

## Contributing

We welcome pull requests and issues. For major changes, please open an issue to discuss what you would like to change.
