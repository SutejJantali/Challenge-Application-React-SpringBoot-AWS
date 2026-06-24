function Challenge({ challenge }){
    // console.log(challenge);
    return (
    <div className="border rounded p-3 mb-3 bg-light">
        <h5 className="fw-bold text-dark">
            {challenge.month}
        </h5>
        <p className="text-muted mb-0">
            {challenge.description}
        </p>
    </div>
    );
}

export default Challenge;