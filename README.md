# ⚙️ PhotoCloud Backend

A scalable and secure backend for **PhotoCloud**, designed to handle authentication, image management, cloud storage operations, and API services for the PhotoCloud platform.

This backend powers the frontend by managing users, uploads, authentication, media storage, and database operations through REST APIs.

---

# 🚀 Features

- 🔐 User Authentication & Authorization
- 👤 User Profile Management
- 📤 Image Upload APIs
- ☁️ Cloud Storage Integration
- 🗂️ Image Management System
- 🔒 Secure API Endpoints
- ⚡ Fast & Scalable Backend Architecture
- 🌐 RESTful API Support
- 🧾 Error Handling & Validation
- 🔄 Frontend API Integration

---

# 🛠️ Tech Stack

### Backend Technologies Used

- Node.js / Express.js *(Update if different)*
- MongoDB / Database *(Update if needed)*
- JWT Authentication
- REST API
- Cloudinary / File Upload Service *(if used)*
- dotenv
- bcrypt
- CORS

---

# 📂 Project Structure

```bash
photocloud-backend/
│── config/
│── controllers/
│── middleware/
│── models/
│── routes/
│── uploads/
│── utils/
│── server.js
│── package.json
│── .env
│── README.md
```

---

# ⚙️ Installation & Setup

## 1️⃣ Clone Repository

```bash
git clone https://github.com/Harish-Kumawat/photocloud-backend.git
```

## 2️⃣ Move to Project Folder

```bash
cd photocloud-backend
```

## 3️⃣ Install Dependencies

```bash
npm install
```

---

# 🔑 Environment Variables Setup

Create a `.env` file in the root directory and add:

```env
PORT=5000

MONGO_URI=your_database_url

JWT_SECRET=your_secret_key

CLOUDINARY_CLOUD_NAME=your_cloud_name
CLOUDINARY_API_KEY=your_api_key
CLOUDINARY_API_SECRET=your_api_secret
```

> Replace values according to your backend configuration.

---

# ▶️ Run Project Locally

Start development server:

```bash
npm run dev
```

or

```bash
npm start
```

Server will run at:

```bash
http://localhost:5000
```

---

# 📡 API Endpoints

Example API routes:

### Authentication

```http
POST /api/auth/register
POST /api/auth/login
```

### User

```http
GET /api/user/profile
PUT /api/user/update
```

### Images

```http
POST /api/upload
GET /api/images
DELETE /api/image/:id
```

---

# 🔗 Frontend Connection

Make sure frontend `.env` contains backend API URL:

```env
VITE_API_URL=http://localhost:5000
```

Example production:

```env
VITE_API_URL=https://your-backend-url.com
```

---

# 🌍 Deployment

## Deploy on Render / Railway

### Render Deployment

1. Push backend code to GitHub
2. Login to Render
3. Create **New Web Service**
4. Connect GitHub Repository
5. Add Environment Variables
6. Deploy

### Railway Deployment

1. Push repository to GitHub
2. Open Railway
3. Create Project
4. Deploy Repository
5. Configure `.env` variables

---

# 🧪 Testing APIs

You can test APIs using:

- Postman
- Thunder Client (VS Code)

Example:

```http
GET http://localhost:5000/api/images
```

---

# 📸 Screenshots

Add backend screenshots (optional)

```md
![API Test](./screenshots/api-test.png)
```

---

# 🤝 Contributing

Contributions are welcome!

## Steps

1. Fork repository

2. Create branch

```bash
git checkout -b feature-name
```

3. Commit changes

```bash
git commit -m "Added feature"
```

4. Push branch

```bash
git push origin feature-name
```

5. Open Pull Request

---

# 🐛 Bug Report

Found an issue?

Please create an issue in this repository.

---

# 📜 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

**Harish Kumawat**

GitHub: https://github.com/Harish-Kumawat

---

⭐ If you found this project useful, consider giving it a star!
