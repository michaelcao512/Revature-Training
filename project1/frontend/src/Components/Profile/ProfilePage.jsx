import { useEffect, useState } from "react";
import UserInfoService from "../../Services/userinfo.service";

function ProfilePage() {


    const [userInfo, setUserInfo] = useState({});
    useEffect(() => {
        const u = JSON.parse(localStorage.getItem('user'));
        if (!u) {
            window.location.href = "/login";
        }

        UserInfoService.getUserInfoById(u.accountId).then(response => {
            response.username = u.username;
            response.email = u.email;
            setUserInfo(response);
        }).catch(error => {
            console.log("error: ", error);
        });


    }, []);

    return ( 
        <>
            <h1>Profile Page</h1>
            <p>Username: {userInfo.username}</p>
            <p>Email: {userInfo.email}</p>
            <p>First Name: {userInfo.firstName}</p>
            <p>Last Name: {userInfo.lastName}</p>
            <p>Gender: {userInfo.gender}</p>
            
        </>
     );
}

export default ProfilePage;