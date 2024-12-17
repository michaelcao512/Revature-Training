import { StyledLink } from "../../StyledComponents/StyledComponents";

function LoginPage() {
    return (
        <main>
            <h1>Login Page</h1>


            
            <StyledLink destination="/" text="Home" />
            <StyledLink destination="/register" text="Register" />
        </main>
      );
}

export default LoginPage;