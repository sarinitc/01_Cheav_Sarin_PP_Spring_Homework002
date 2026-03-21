-- 1. students table
CREATE TABLE students (
                          student_id SERIAL PRIMARY KEY,
                          student_name VARCHAR(100),
                          email VARCHAR(100),
                          phone_number VARCHAR(20)
);

-- 2. instructors table
CREATE TABLE instructors (
                             instructor_id SERIAL PRIMARY KEY,
                             instructor_name VARCHAR(100),
                             email VARCHAR(100)
);

-- 3. courses table
CREATE TABLE courses (
                         course_id SERIAL PRIMARY KEY,
                         course_name VARCHAR(100),
                         description TEXT,
                         instructor_id INT,
                         FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
);

-- 4. student_course (join table)
CREATE TABLE student_course (
                                student_id INT,
                                course_id INT,
                                PRIMARY KEY (student_id, course_id),
                                FOREIGN KEY (student_id) REFERENCES students(student_id),
                                FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
INSERT INTO instructors (instructor_name, email) VALUES
('John Doe', 'john@example.com'),
('Anna Smith', 'anna@example.com');
('Michael Brown', 'michael@example.com'),
('Sophia Johnson', 'sophia@example.com'),
('David Wilson', 'david@example.com'),
('Emma Davis', 'emma@example.com'),
('Daniel Martinez', 'daniel@example.com'),
('Olivia Taylor', 'olivia@example.com'),
('James Anderson', 'james@example.com'),
('Isabella Thomas', 'isabella@example.com');
INSERT INTO courses (course_name, description, instructor_id) VALUES
('Java Programming', 'Learn Java basics', 1),
('Database Systems', 'Learn PostgreSQL', 2);
('Web Development', 'Learn HTML, CSS, JavaScript', 3),
('Spring Boot', 'Build REST APIs with Spring Boot', 4),
('Data Structures', 'Learn fundamental data structures', 5),
('Algorithms', 'Understand algorithm design and analysis', 6),
('Mobile App Development', 'Build Android applications', 7),
('Cloud Computing', 'Introduction to cloud services', 8),
('Software Engineering', 'Learn software development lifecycle', 9),
('Cyber Security', 'Basics of security and protection', 10);
INSERT INTO students (student_name, email, phone_number) VALUES
('Sarin', 'sarin@gmail.com', '012345678'),
('Pojim', 'pojim@gmail.com', '098765432'),
('Dara', 'dara@gmail.com', '011223344'),
('Sokha', 'sokha@gmail.com', '012334455'),
('Vanna', 'vanna@gmail.com', '013445566'),
('Rith', 'rith@gmail.com', '014556677'),
('Chan', 'chan@gmail.com', '015667788'),
('Mony', 'mony@gmail.com', '016778899'),
('Nita', 'nita@gmail.com', '017889900'),
('Kosal', 'kosal@gmail.com', '018990011');

                                                             ('Lymeng', 'lymeng@gmail.com', '011223344');