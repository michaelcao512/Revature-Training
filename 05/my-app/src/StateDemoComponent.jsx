import { useState } from "react";
export default function StateDemoComponent() {
    const [name, setName] = useState("Michael");
    return (
        <>
            <h1>State Demo Component</h1>
            <p>{name}</p>
            <button onClick={() => setName("John")}>Change Name</button>
        </>
    );
}