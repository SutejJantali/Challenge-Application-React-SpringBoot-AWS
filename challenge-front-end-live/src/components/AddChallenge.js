import { useState } from "react";
import axios from "axios";

function AddChallenge({ onChallengeAdded }){
    const [month, setMonth] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = async(e) => {
        e.preventDefault();
        try{
            await axios.post('http://localhost:8080/challenges', {month, description})
            setMonth('');
            setDescription('');
            onChallengeAdded();
        }
        catch(error){
            console.error("Error adding challenges", error);
        }
    };

    return (
       <div className="card shadow-lg border-0 my-5 challenge-card">
    <div className="card-header bg-secondary text-white">
        Add New Challenge
    </div>

    <div className="card-body p-4">
        <form onSubmit={handleSubmit}>
            <div className="mb-4">
                <label htmlFor="month" className="form-label fw-semibold">
                    Month
                </label>
                <input
                    type="text"
                    className="form-control"
                    placeholder="Ex: Jan;"
                    id="month"
                    value={month}
                    onChange={(e) => setMonth(e.target.value)}
                    required
                />
            </div>

            <div className="mb-4">
                <label htmlFor="description" className="form-label fw-semibold">
                    Description
                </label>
                <input
                    type="text"
                    className="form-control"
                    id="description"
                    placeholder="Describe your description"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    required
                />
            </div>

            <button type="submit" className="btn btn-primary w-100">
                Add Challenge
            </button>
        </form>
    </div>
</div>
    );
}

export default AddChallenge;