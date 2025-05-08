********Project Name: **Daily Journal / Notes App** ********

****Overview****
The Daily Journal / Notes App is a full-stack web application designed to help users write, organize,
and manage daily notes or journal entries. Users can create entries using markdown formatting, tag
their notes for easy categorization, and search through them by content, tags, or dates. The
application is focused on simplicity, privacy, and effective journaling.

****Objectives****
• Allow users to securely register and log in to their personal note space.
• Enable users to write and edit markdown-supported journal entries.
• Organize notes using tags.
• Provide search functionality to filter notes by date, tags, or content.
• Offer a clean and distraction-free writing interface.

****User Roles****

**1. User**

• Register and log in securely.
• Create, edit, and delete notes/journal entries.
• Format content using markdown.
• Tag entries and search/filter them.
• View all previous entries in chronological order or by tag.

****Core Features****

**1. Authentication**

• User registration and login using JWT.
• Password encryption (BCrypt or similar).
• Route protection for logged-in users only.

**2. Note Creation & Editing**

• Rich text editor with markdown support.
• Auto-save or manual save option.
• Option to edit/delete existing entries.

**3. Tagging System**

• Add one or more tags per note (e.g., #work, #personal, #ideas).
• Filter notes by tags.

**4. Search & Filter**

• Full-text search by content.
• Filter notes by tag or date range.

**5. Note Organization**

• Display notes in list view with snippet preview.
• Sort by date created or last updated.
• Calendar or timeline view (optional).

****Technology Stack****

• Frontend: React.js, Tailwind CSS, Markdown Editor (e.g., React Markdown, SimpleMDE)
• Backend: Spring Boot (Java), Spring Security
• Authentication: JWT (JSON Web Token)
• Database: PostgreSQL 
• Optional Integrations: Local storage sync (for drafts), dark mode

****API Endpoints****

**Auth**

• POST /api/auth/register – Register new user

• POST /api/auth/login – Authenticate and return JWT

**Notes**

• GET /api/notes – Get all notes for user

• POST /api/notes – Create a new note

• GET /api/notes/{id} – Get single note

• PUT /api/notes/{id} – Update note

• DELETE /api/notes/{id} – Delete note

**Search/Filter**

• GET /api/notes?tag={tag} – Filter notes by tag

• GET /api/notes?dateFrom=...&dateTo=... – Filter by date range

• GET /api/notes/search?q=... – Search notes by content

****Database Schema****

**Users**

• id (UUID)

• name

• email (unique)

• password (hashed)

**Notes**

• id (UUID)

• user_id (foreign key)

• title

• content (markdown supported)

• tags (array of strings or separate relation)

• created_at

• updated_at

****UI Components****

• Login / Register Page

• Dashboard: List of notes with filters

• Note Editor: Markdown input + preview

• Note Detail Page: Full rendered markdown view

• Sidebar: Tag filter, recent notes, search bar

****Success Criteria****

• Users can log in and securely manage their journal entries.

• Markdown rendering and editing work seamlessly.

• Tags and search functionality improve discoverability.

• Mobile-friendly and responsive layout.

• Fast and secure API performance
