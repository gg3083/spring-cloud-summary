## 认证接口 
```
http://localhost:9002/oauth/token?grant_type=password&username=admin&password=123456&scope=all```
请求头 basic auth 加上 user-client  user-secret-8888

```
## 访问
```
http://localhost:9001/get
请求头带上token
```

### 刷新token
```$xslt
http://localhost:9002/oauth/token?grant_type=refresh_token&refresh_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsImp3dC1leHQiOiJKV1Qg5omp5bGV5L-h5oGvIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjM4MTNhZWQ0LWVlMGItNGUzNi1iMTJlLTZiZmYwZjJiOWVmMiIsImV4cCI6MTU4NzM4NDM0NywiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiJiOTNkODM3Mi0yMTJmLTQyZTgtYTg3Ny1lMGMyMDg0ZjdlNDUiLCJjbGllbnRfaWQiOiJ1c2VyLWNsaWVudCJ9.abi2gwwlsa0EZrqbuKFll7Xc4rZTJfmZekftCmjmN4Y&scope=all&client_id=user-client&client_secret=user-secret-8888```
```
https://www.cnblogs.com/fengzheng/p/11724625.html


## 记录
 backend提供登录接口，接口请求认证服务，返回token给前端，然后前端通过token在访问后端服务。