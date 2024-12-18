import Typography  from "@mui/material/Typography";
import { StyledCard, StyledLink, StyledStack} from "../../StyledComponents/StyledComponents";
import RegistrationForm from "./RegistrationForm";
import { Box } from "@mui/material";
import UserService from "../../Services/user.service";

function RegistrationContainer() {

    const handleClick = () => {
        
        UserService.getAllUsers()
            .then(response => {
                console.log("response: ", response);
            })
            .catch(error => {
                console.log("error: ", error);
            });
    }
    return ( 
        <StyledStack>
            <StyledCard>
                <Typography variant="h3">Registration Page</Typography>
                <RegistrationForm />
                
                <Box sx={{}} >
                    <StyledLink destination="/" text="Home"/>
                    <StyledLink destination="/login" text="Login" />
                </Box>         
                
            <button onClick={handleClick}>Click Me</button>

            </StyledCard>

        </StyledStack>
     );
}

export default RegistrationContainer;