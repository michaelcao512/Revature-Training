import { useState } from "react";
export default function StateDemoComponent() {
    const [name, setName] = useState("Michael");
    return (
        <>
            <h3>State Demo Component</h3>
            <p>{name}</p>
            <button onClick={() => setName("John")}>Change Name</button>
        </>
    );
}