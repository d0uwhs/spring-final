# 유저 정보 찾기
SELECT *
FROM members
         LEFT JOIN member_roles mr on members.userId = mr.userId
         LEFT JOIN roles r on mr.roleNo = r.roleNo
WHERE username = 'user1';


SELECT username, password, name, r.roleName
FROM members
         LEFT JOIN member_roles mr on members.userId = mr.userId
         LEFT JOIN roles r on mr.roleNo = r.roleNo
WHERE username = 'user100'