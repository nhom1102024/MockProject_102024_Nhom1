api request:
    POST: http://localhost:8080/auth/signin

    body:{
    "email":"user@example.com",
    "password":"password123"
    }
    
    response:{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJkdW5nbGUiLCJpYXQiOjE3MjgwMjkzODMsImV4cCI6MTcyODExNTc4MywiZW1haWwiOiJ1c2VyQGV4YW1wbGUuY29tIn0.g-o5W2sPckrVhNImZyFhEQ9U6mowvx_qxJ2njkN9tc_WBFpJnHAs7rb0Leyel9c1MTH11VGEVJDPVf5l_tOu1g",
    "message": "Login success"
    }