import axios from 'axios';
import authHeader from './auth-header';

const api_url = "http://localhost:8080/api/userinfo";

class UserInfoService {

    getUserInfoById(id) {
        return axios.get(api_url + "/" + id, { headers: authHeader() }).then(response => {
            console.log("response: ", response);
            return response.data;
        }).catch(error => {
            console.log("error: ", error);
        });
    }


}

export default new UserInfoService();