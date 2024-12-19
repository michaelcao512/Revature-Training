import axios from 'axios';
import authHeader from './auth-header';

const api_url = "http://localhost:8080/api/account";

class UserService {

    getAllUsers() {
        return axios.get(api_url, { headers: authHeader() }).then(response => {
            console.log("response: ", response);
            return response.data;
        }).catch(error => {
            console.log("error: ", error);
        });
    }

    getUserById(id) {
        return axios.get(api_url + "/" + id, { headers: authHeader() }).then(response => {
            console.log("response: ", response);
            return response.data;
        }).catch(error => {
            console.log("error: ", error);
        });
    }


}

export default new UserService();