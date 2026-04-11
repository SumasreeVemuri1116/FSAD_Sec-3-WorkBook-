
import React,{useState} from "react";
import axios from "axios";

function AddStudent(){

 const [student,setStudent]=useState({
   name:"",
   email:"",
   course:""
 });

 const handleChange=(e)=>{
   setStudent({...student,[e.target.name]:e.target.value})
 }

 const handleSubmit=(e)=>{
   e.preventDefault();

   axios.post("http://localhost:8080/students",student)
   .then(()=>{
     alert("Student Added");
     setStudent({name:"",email:"",course:""})
   })
 }

 return(
  <form onSubmit={handleSubmit}>
   <h3>Add Student</h3>

   <input name="name" placeholder="Name"
   value={student.name} onChange={handleChange}/>

   <input name="email" placeholder="Email"
   value={student.email} onChange={handleChange}/>

   <input name="course" placeholder="Course"
   value={student.course} onChange={handleChange}/>

   <button type="submit">Add</button>
  </form>
 )
}
export default AddStudent;
