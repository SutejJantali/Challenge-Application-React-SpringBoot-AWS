import Challenge from "./Challenge";

function ChallengeList({ challenges }){
    return (
        <>
        {challenges.map(challenge => (
            <Challenge 
            key = {challenge.id}
            challenge = {challenge} />
        ))}
        </>
      
    );
}

export default ChallengeList;