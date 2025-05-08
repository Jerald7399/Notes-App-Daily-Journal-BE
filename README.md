# 📝 Daily Journal / Notes App

A full-stack web application designed for secure, organized, and markdown-supported journaling. Users can create, edit, tag, and search their personal notes — while Admins can moderate content and manage users.

---

## 📌 Overview

The **Daily Journal / Notes App** allows users to:

- Write daily notes or journals with **Markdown formatting**
- Organize entries with **tags**
- **Search and filter** by tags, content, or date
- Enjoy a clean, minimal UI focused on distraction-free writing
- Admins can view and manage all notes and users

---

## 🎯 Objectives

- 🔐 Secure registration and login (JWT)
- ✍️ Markdown-supported journal entries
- 🏷️ Tag-based note organization
- 🔍 Full-text search and filtering
- 🧘 Clean and responsive interface
- 👨‍💼 Admin dashboard for moderation

---

## 👥 User Roles

### 👤 User

- Register & login securely  
- Create, edit, delete notes  
- Format with Markdown  
- Tag and filter entries  
- View entries by tag or date

### 👨‍💼 Admin

- Login with admin credentials  
- View/delete user accounts  
- View/edit/delete any note  
- Access activity logs *(optional)*

---

## 🔐 Authentication

- JWT-based login for both users and admins  
- Role-based access control using **Spring Security**  
- Passwords encrypted using **BCrypt**

---

## 🧰 Technology Stack

| Layer       | Tech                            |
|-------------|----------------------------------|
| Frontend    | React.js, Tailwind CSS           |
| Editor      | React Markdown / UIW MDE         |
| Backend     | Spring Boot, Spring Security     |
| Auth        | JWT (JSON Web Token)             |
| Database    | PostgreSQL                       |
| Optional    | Local storage sync, dark mode    |

---

## 🚀 Core Features

- Rich Markdown editor with preview  
- Tagging system for categorization  
- Search/filter by tag, content, or date  
- Responsive layout for mobile/tablet  
- Admin moderation panel  

---

## 🔗 API Endpoints

### 📥 Auth

- `POST /api/auth/register` – Register new user  
- `POST /api/auth/login` – User login  
- `POST /api/auth/admin-login` – Admin login *(optional)*  

### 📝 Notes

- `GET /api/notes` – Get all user notes  
- `POST /api/notes` – Create new note  
- `GET /api/notes/{id}` – Get single note  
- `PUT /api/notes/{id}` – Update note  
- `DELETE /api/notes/{id}` – Delete note  

### 🔐 Admin

- `GET /api/admin/users` – View all users  
- `DELETE /api/admin/users/{id}` – Delete user  
- `GET /api/admin/notes` – View all notes  
- `DELETE /api/admin/notes/{id}` – Delete any note  
- `PUT /api/admin/notes/{id}` – Edit any note *(optional)*  

---

## 🗂️ Database Schema

### 👤 Users

| Field     | Type   |
|-----------|--------|
| id        | UUID   |
| name      | String |
| email     | String (unique) |
| password  | String (hashed) |
| role      | String (`USER`, `ADMIN`) |

### 📝 Notes

| Field       | Type             |
|-------------|------------------|
| id          | UUID             |
| user_id     | Foreign Key (UUID) |
| title       | String           |
| content     | Markdown (Text)  |
| tags        | Array / Relation |
| created_at  | Timestamp        |
| updated_at  | Timestamp        |

---

## 🧩 UI Components

- Login / Register Pages  
- Dashboard: List + Filters  
- Note Editor: Markdown input + preview  
- Note Detail View  
- Sidebar: Tags + Search  
- Admin Panel: User/note management

---

## ✅ Success Criteria

- JWT-secured user and admin authentication  
- Markdown editing with live preview  
- Tag + date filtering and full-text search  
- Admin control over users and content  
- Fast, responsive, and secure performance

---
