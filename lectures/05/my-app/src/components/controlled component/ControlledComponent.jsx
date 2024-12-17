import { useState } from "react";

    // Create a component with a textbox and a paragraph. 
    // Whatever is typed in the textbox is displayed in the paragraph.
function ControlledComponent() {

    const [text, setText] = useState("");
    return ( 
        <>
            <input type="text" value={text} onChange={(e) => setText(e.target.value)} />
            <p>{text}</p>
        </>
     );
}

export default ControlledComponent;