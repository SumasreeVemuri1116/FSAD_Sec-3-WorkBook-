
import React,{useEffect,useState} from "react";
import axios from "axios";

function StudentList(){

 const [students,setStudents]=useState([])

 const loadStudents=()=>{
  axios.get("http://localhost:8080/students")
  .then(res=>{
   setStudents(res.data)
  })
 }

 useEffect(()=>{
   loadStudents()
 },[])

 const deleteStudent=(id)=>{
  axios.delete("http://localhost:8080/students/"+id)
  .then(()=>{
   loadStudents()
  })
 }

 return(
  <div>
   <h3>Student List</h3>
   <table border="1">
    <thead>
     <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Course</th>
      <th>Actions</th>
     </tr>
    </thead>

    <tbody>
     {students.map(s=>(
      <tr key={s.id}>
        <td>{s.id}</td>
        <td>{s.name}</td>
        <td>{s.email}</td>
        <td>{s.course}</td>
        <td>
          <button onClick={()=>deleteStudent(s.id)}>Delete</button>
        </td>
      </tr>
     ))}
    </tbody>
   </table>
  </div>
 )
}
export default StudentList;
