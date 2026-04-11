
import {useEffect,useState} from "react";
import axios from "axios";

function FakePostList(){

 const [posts,setPosts]=useState([])
 const [filtered,setFiltered]=useState([])
 const [userId,setUserId]=useState("all")

 const fetchData=()=>{
  axios.get("https://dummyjson.com/posts")
  .then(res=>{
    setPosts(res.data.posts)
    setFiltered(res.data.posts)
  })
 }

 useEffect(()=>{
  fetchData()
 },[])

 const handleFilter=(id)=>{
   setUserId(id)
   if(id==="all"){
     setFiltered(posts)
   }else{
     setFiltered(posts.filter(p=>p.userId===Number(id)))
   }
 }

 return(
  <div className="container">
   <h2>Fake API Posts</h2>

   <select value={userId} onChange={(e)=>handleFilter(e.target.value)}>
     <option value="all">All Users</option>
     <option value="1">User 1</option>
     <option value="2">User 2</option>
     <option value="3">User 3</option>
   </select>

   <button onClick={fetchData}>Refresh</button>

   {filtered.map(post=>(
    <div key={post.id} className="card">
      <h4>{post.title}</h4>
      <p>{post.body}</p>
      <p>User: {post.userId}</p>
    </div>
   ))}
  </div>
 )
}
export default FakePostList
