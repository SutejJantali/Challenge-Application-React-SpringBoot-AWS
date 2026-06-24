import { useEffect, useState } from 'react';
import './App.css';
import ChallengeList from './components/ChallengeList';
import axios from 'axios';
import AddChallenge from './components/AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  const [challenges, setChallenges] = useState([]);

  useEffect(() => {
    fetchChallenges();
  } , []);
   
  const fetchChallenges = async() => {
      try {
        const response = await axios.get('http://localhost:8080/challenges');
        console.log(response);
        setChallenges(response.data);
      } catch (error){
        console.error("Error fetching challenges: ", error);
      }
    };

  const handleChallengeAdded = () => {
    fetchChallenges();
  }

  return (
    <div className="container mt-5">
      <h2 className='text-center mb-4'>Monthly Challenges App</h2>
      <AddChallenge onChallengeAdded = { handleChallengeAdded }/>
      <ChallengeList challenges={ challenges } />
    </div>
  );
}

export default App;