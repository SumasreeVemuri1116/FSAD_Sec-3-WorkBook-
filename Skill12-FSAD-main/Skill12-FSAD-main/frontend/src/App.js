
import React from "react";
import StudentList from "./components/StudentList";
import AddStudent from "./components/AddStudent";

function App(){
  return(
    <div style={{padding:"20px"}}>
      <h2>Student Management System</h2>
      <AddStudent/>
      <StudentList/>
    </div>
  )
}
export default App;
