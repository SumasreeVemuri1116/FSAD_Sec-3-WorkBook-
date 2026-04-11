
import React, { useState } from "react";

function StudentManager() {

  const initialStudents = [
    { id: 1, name: "Jaya", course: "Computer Science" },
    { id: 2, name: "Ravi", course: "Data Science" },
    { id: 3, name: "Anita", course: "Artificial Intelligence" },
    { id: 4, name: "Kiran", course: "Cyber Security" },
    { id: 5, name: "Meena", course: "Software Engineering" }
  ];

  const [students, setStudents] = useState(initialStudents);

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({
      ...newStudent,
      [name]: value
    });
  };

  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) return;

    setStudents([...students, newStudent]);

    setNewStudent({
      id: "",
      name: "",
      course: ""
    });
  };

  const deleteStudent = (id) => {
    const updated = students.filter((s) => s.id !== id);
    setStudents(updated);
  };

  return (
    <div>

      <div className="form">
        <input
          type="text"
          placeholder="ID"
          name="id"
          value={newStudent.id}
          onChange={handleChange}
        />

        <input
          type="text"
          placeholder="Name"
          name="name"
          value={newStudent.name}
          onChange={handleChange}
        />

        <input
          type="text"
          placeholder="Course"
          name="course"
          value={newStudent.course}
          onChange={handleChange}
        />

        <button onClick={addStudent}>Add Student</button>
      </div>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button
                    className="delete"
                    onClick={() => deleteStudent(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default StudentManager;
