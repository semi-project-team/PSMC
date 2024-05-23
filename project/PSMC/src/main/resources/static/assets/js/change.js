document.getElementById("change-password-btn").addEventListener("click", function() {
    var newPassword = document.getElementById("new-password").value;
    var confirmPassword = document.getElementById("confirm-password").value;

    if (newPassword !== confirmPassword) {
        alert("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        return;
    }

    // 비밀번호 변경 로직 추가
    // 예: 서버로 비밀번호 변경 요청을 보내거나, 클라이언트 측에서 비밀번호를 변경하는 등의 동작을 수행할 수 있습니다.
});

document.getElementById("cancel-btn").addEventListener("click", function() {
    // 취소 동작 추가
});

const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql');
const app = express();
const port = 3000;

// 데이터베이스 연결 설정
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'password',
    database: 'your_database_name'
});

db.connect((err) => {
    if (err) throw err;
    console.log('Connected to database');
});

// 미들웨어 설정
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.use(express.static('public'));

// 회원 정보 수정 라우트
app.post('/update-member', (req, res) => {
    const { id, name, year, month, day, gender, phone, email, position } = req.body;
    const birth = `${year}-${month}-${day}`;

    const sql = 'UPDATE members SET name = ?, birth = ?, gender = ?, phone = ?, email = ?, position = ? WHERE id = ?';
    db.query(sql, [name, birth, gender, phone, email, position, id], (err, result) => {
        if (err) throw err;
        res.send('Member information updated');
    });
});

app.listen(port, () => {
    console.log(`Server running on http://localhost:${port}`);
});
