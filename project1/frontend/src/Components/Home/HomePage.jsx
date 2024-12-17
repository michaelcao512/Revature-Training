import { StyledLink } from "../../StyledComponents/StyledComponents";

function HomePage() {
    return ( 
        <main className="home-page">
            <h1>Home Page</h1>
            <StyledLink destination="/register" text="Register" />
            <StyledLink destination="/login" text="Login" />
        </main>
     );
}

export default HomePage;