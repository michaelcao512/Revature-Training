import withFancyText from "./withFancyText";
function TextComponent() {
    return ( 
        <p>Hello Fancy Text.</p>
     );
}


export default withFancyText(TextComponent);