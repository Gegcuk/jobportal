# JobPortal

JobPortal is a web application designed for connecting job seekers with recruiters. It provides a streamlined platform for job seekers to create profiles, upload resumes, and apply for job listings. Recruiters can post job openings, manage applicants, and maintain their professional profiles. This project is implemented with Spring Boot and utilizes robust security measures to manage user roles and access.

## Features

### User Authentication and Authorization
- Implemented secure user authentication with role-based access control.
- Supports login and logout with a custom authentication success handler.
- User roles are defined as either Job Seeker or Recruiter, each with specific permissions and access.

### User Registration with Profile Setup
- Users can register as Job Seekers or Recruiters, each with customized registration forms and profiles.
- `JobSeekerProfile` includes personal details, work authorization status, employment type, and file uploads for profile photo and resume.
- `RecruiterProfile` includes recruiter-specific fields such as company name, location, and profile photo upload.
- Skills entity allows job seekers to showcase specific skills, including experience level and years of experience.

### Profile Management for Job Seekers and Recruiters
- Job seekers can create and edit profiles with the ability to upload a profile photo and resume.
- Job seekers can display their skills within their profiles, enhancing visibility to recruiters.
- Recruiters can manage their profiles and update profile photos for professional presentation.

### Job Posting and Management
- Recruiters can create job postings, detailing job requirements, location, and other key information.
- The application supports viewing and editing job postings, enabling recruiters to manage job listings effectively.
- `RecruiterJobsDto` and `IRecruiterJobs` interface offer streamlined job posting and candidate tracking features.

### Job Application Management for Job Seekers
- Job seekers can view job postings and apply directly through their profiles.
- Application data is stored and managed, providing an organized view of job applications for both job seekers and recruiters.

### Dynamic Content Management
- Integrated `FileUploadUtil` to manage and organize uploaded profile photos and resumes in the specified directory structure.
- Resource handling is configured via `MvcConfig` for efficient access to stored assets.

## Project Structure

- **Entities**: `Users`, `UsersType`, `JobSeekerProfile`, `RecruiterProfile`, `JobPostActivity`, `Skills`, and others that form the core database structure.
- **Controllers**: `JobSeekerProfileController`, `RecruiterProfileController`, `JobPostActivityController`, among others, handling various endpoints for profile and job post management.
- **Services**: Service interfaces and implementations (`JobSeekerProfileService`, `JobPostActivityService`, etc.) managing business logic and interactions with repositories.
- **Repositories**: Repository interfaces for CRUD operations on all primary entities.

## Technologies Used
- **Spring Boot** - Backend framework
- **Spring Security** - Authentication and role management
- **Hibernate** - ORM for database interactions
- **Thymeleaf** - Templating engine for HTML views
- **Bootstrap** - Styling for responsive layouts
- **JavaScript & jQuery** - Frontend interactions
